/*******************************************************************************
  Main Source File

  Company:
    Microchip Technology Inc.

  File Name:
    main.c

  Summary:
    This file contains the "main" function for a project.

  Description:
    This file contains the "main" function for a project.  The
    "main" function calls the "SYS_Initialize" function to initialize the state
    machines of all modules in the system
 *******************************************************************************/

// *****************************************************************************
// *****************************************************************************
// Section: Included Files
// *****************************************************************************
// *****************************************************************************

#include <stddef.h>                     // Defines NULL
#include <stdbool.h>                    // Defines true
#include <stdlib.h>                     // Defines EXIT_FAILURE
#include "definitions.h"                // SYS function 
#include <stdio.h>
#include <string.h>

//Test message buffers
char helloBuffer[] = "Hello World\n\r";
char msgBuffer[200];


//I2C oxygen sensor
#define ADDRESS_0   0x70
#define ADDRESS_1   0x71
#define ADDRESS_2   0x72
#define ADDRESS_3   0x73  ///< iic slave Address select
#define OCOUNT      100   ///< oxygen Count Value
#define OXYGEN_DATA_REGISTER 0x03   ///< register for oxygen data
#define USER_SET_REGISTER    0x08   ///< register for users to configure key value manually
#define AUTUAL_SET_REGISTER  0x09   ///< register that automatically configure key value
#define GET_KEY_REGISTER     0x0A   ///< register for obtaining key value


//I2C temp/humidity sensor
#define ERROR_I2C_TIMEOUT                     998
#define ERROR_BAD_CRC                         999
#define SHT20_I2C_ADDR                        0x40

#define TRIGGER_TEMP_MEASURE_HOLD             0xE3
#define TRIGGER_HUMD_MEASURE_HOLD             0xE5
#define TRIGGER_TEMP_MEASURE_NOHOLD           0xF3
#define TRIGGER_HUMD_MEASURE_NOHOLD           0xF5
#define WRITE_USER_REG                        0xE6
#define READ_USER_REG                         0xE7
#define SOFT_RESET                            0xFE
#define USER_REGISTER_RESOLUTION_MASK         0x81
#define USER_REGISTER_RESOLUTION_RH12_TEMP14  0x00
#define USER_REGISTER_RESOLUTION_RH8_TEMP12   0x01
#define USER_REGISTER_RESOLUTION_RH10_TEMP13  0x80
#define USER_REGISTER_RESOLUTION_RH11_TEMP11  0x81
#define USER_REGISTER_END_OF_BATTERY          0x40
#define USER_REGISTER_HEATER_ENABLED          0x04
#define USER_REGISTER_DISABLE_OTP_RELOAD      0x02

#define MAX_WAIT                              100
#define DELAY_INTERVAL                        10
#define SHIFTED_DIVISOR                       0x988000
#define MAX_COUNTER                           (MAX_WAIT/DELAY_INTERVAL)




//water flow sensor global variables
uint16_t water_rate = 0.0;
float water_flow = 0;
float water_convert = 31.0;


//Oxygen sensor global variables
float o2val = 0;

/* Function:
    void fan_switch()

  Summary:
    Toggles GPIO pin RPE9 on and off for 1 second. Returns the state of the fan.

  Remarks:
    The GPIO pin needs to be assigned in Harmony 3.
 *Tools -> Harmony 3 configurator
 *In Harmony 3 configurator, Tools -> Pin Configuration -> Pin Table -> Scroll down to GPIO
 *-> Find an available pin number from the altium schematic -> Scroll right and find the pin on the Pin Table
 *-> Pin Settings -> Find the pin and select Direction (TRIS) to Out
*/

int fan_switch(){
    GPIO_RE9_Toggle(); //toggles pin RPE9
    CORETIMER_DelayMs(1000);
    return GPIO_RE9_Get();
}

/* Function:
    void solenoid_switch()

  Summary:
    Toggles GPIO pin RPA9 on and off for 1 second. Returns the state of the solenoid.

  Remarks:
    The GPIO pin needs to be assigned in Harmony 3.
 *Tools -> Harmony 3 configurator
 *In Harmony 3 configurator, Tools -> Pin Configuration -> Pin Table -> Scroll down to GPIO
 *-> Find an available pin number from the altium schematic -> Scroll right and find the pin on the Pin Table
 *-> Pin Settings -> Find the pin and select Direction (TRIS) to Out
*/

int solenoid_switch(){
    GPIO_RA9_Toggle(); //toggles pin RPE9
    CORETIMER_DelayMs(1000);
    return GPIO_RA9_Get();
}



/* Function:
    void readFlash()

  Summary:
 * For Oxygen Sensor

  Remarks:
   
*/

float key = 0.0;
float oxygenData[OCOUNT] = {0.0};

void readFlash(uint16_t addr) {          // Updated
    static uint8_t value = 0;

    static uint8_t temp_key_register = GET_KEY_REGISTER;
    I2C1_WriteRead(addr, &temp_key_register, 1, &value, 1);
    CORETIMER_DelayMs(100);

    if (value == 0) {
        key = 20.9 / 120.0;
    }
    else {
        key = ((float) value) / 1000.0;
    }
}

/* Function:
    void calibrate()

  Summary:
 * For oxygen sensor
  Remarks:
   
*/
void calibrate(float vol, float mv, uint16_t addr) {       // FIX THIS TO WORK
    uint8_t keyValue = vol * 10;
    if(mv < 0.000001 && mv > (-0.000001) ) {

        static uint8_t temp_user_reg = USER_SET_REGISTER;
        I2C1_Write(ADDRESS_3, &temp_user_reg, sizeof(temp_user_reg));
        I2C1_Write(ADDRESS_3, &keyValue, sizeof(keyValue));     // Verify if this is right

    }
    else {
        keyValue = (vol / mv) * 1000;

        static uint8_t temp_actual_reg = AUTUAL_SET_REGISTER;
        I2C1_Write(ADDRESS_3, &temp_actual_reg, sizeof(temp_actual_reg));
        I2C1_Write(ADDRESS_3, &keyValue, sizeof(keyValue));

    }
}
/* Function:
    void getAverageNum()

  Summary:
 * Gets the average of the raw oxygen data to eliminate noise
  Remarks:
   
*/

float getAverageNum(float bArray[], uint8_t len) {
    uint8_t i = 0;
    double bTemp = 0;
    for (i = 0; i < len; i++) {
        bTemp += bArray[i];
    }
    return bTemp / ((float) len);
}

/* Function:
    void getOxygenData()

  Summary:
 * Returns oxygen data
  Remarks:
   
*/
float getOxygenData(uint8_t collectNum, uint16_t addr) {
    uint8_t rxbuf[10] = {0};
    static uint8_t i = 0, j = 0;
    readFlash(addr);
    CORETIMER_DelayMs(500);

    if (collectNum > 0) {
        for (j = collectNum - 1; j > 0; j--) {
            oxygenData[j] = oxygenData[j-1];
        }

        static uint8_t temp_oxygen_reg = OXYGEN_DATA_REGISTER;
        I2C1_WriteRead(addr, &temp_oxygen_reg, 1, &rxbuf[0], 3);
        while (I2C1_IsBusy())
        {
            // DO NOTHING...
        }
        oxygenData[0] = ((key) * (((float) rxbuf[0]) + ((float) rxbuf[1] / 10) + ((float) rxbuf[2] / 100)));
        char testBuf[100];
        sprintf(testBuf, "%x, %x, %x", rxbuf[0], rxbuf[1], rxbuf[2]);
        UART3_Write(&testBuf, strlen(testBuf));
        if (i < collectNum) {
            i++;
        }
        
        return getAverageNum(oxygenData, i);
    }
    else {
        return -1.0;
    }

}


/* Function:
    void Timer2_Handler()

  Summary:
 * Counts to 1000 milliseconds and counts pulses from the water flow sensor.
  Remarks:
   
*/
void Timer2_Handler(uint32_t status, uintptr_t context)
{
    static uint16_t counter = 0;
    counter++;

    if (counter > 999)
    {
        water_rate = TMR3;
        TMR3 = 0x0000;
        counter = 0;
        water_flow = water_rate/water_convert;
    }

}


int co2_val = 0;
/* Function:
    void getCarbonDioxideData()

  Summary:
 * Reads Carbon Dioxide data from sensor.
  Remarks:
   
*/
float getCarbonDioxideData(void) {

    uint8_t address1 = 0xFE;
    UART2_WriteByte(address1);
    uint8_t address2 = 0x44;

    UART2_WriteByte(address2);
    uint8_t address3 = 0x00;

    UART2_WriteByte(address3);
    uint8_t address4 = 0x08;

    UART2_WriteByte(address4);
    uint8_t address5 = 0x02;

    UART2_WriteByte(address5);
    uint8_t address6 = 0x9F;

    UART2_WriteByte(address6);
    uint8_t address7 = 0x25;

    UART2_WriteByte(address7);

    uint8_t rxdata[10] = {0};
    rxdata[0] = UART2_ReadByte();
    CORETIMER_DelayMs(100);
    rxdata[1] = UART2_ReadByte();
    CORETIMER_DelayMs(100);
    rxdata[2] = UART2_ReadByte();
    CORETIMER_DelayMs(100);
    rxdata[3] = UART2_ReadByte();
    CORETIMER_DelayMs(100);
    rxdata[4] = UART2_ReadByte();
    CORETIMER_DelayMs(100);
    rxdata[5] = UART2_ReadByte();
    CORETIMER_DelayMs(100);
    rxdata[6] = UART2_ReadByte();
    CORETIMER_DelayMs(100);
//    char buffer[200];

    float return_val = ((int) rxdata[3]*256 + (int) rxdata[4]);
    return_val = return_val * (100.0/2000.0);
//    sprintf(buffer, "CO2 Value: %f percent\n\r", return_val);
//    UART3_Write(&buffer, strlen(buffer));
    return return_val;
        
}



//temp humidity sensor
/* Function:
    uint8_t checkCRC()

  Summary:
 * Error checking function for temp/humidity sensor
  Remarks:
   
*/

uint8_t checkCRC(uint16_t message_from_sensor, uint8_t check_value_from_sensor) {
    uint32_t remainder = (uint32_t)message_from_sensor << 8;
    remainder |= check_value_from_sensor;
    uint32_t divisor = (uint32_t) SHIFTED_DIVISOR;
    int i = 0;
    for(i = 0; i < 16; i++) {
        if(remainder & (uint32_t)1 << (23 - i)) {
            remainder ^= divisor;
        }
        divisor >>= 1;
    }
    
    return (uint8_t) remainder;
}

/* Function:
    void readFlash()

  Summary:

  Remarks:
   
*/
uint16_t readValue(uint8_t cmd) {
    uint8_t tempRead[3] = {0};
    I2C1_Write(SHT20_I2C_ADDR, &cmd, 1);
//    CORETIMER_DelayMs(100);
    CORETIMER_DelayMs(200);
    I2C1_Read(SHT20_I2C_ADDR, &tempRead[0], 3);

    while (I2C1_IsBusy())
    {
        // DO NOTHING...
    }
    uint8_t msb = tempRead[0];
    uint8_t lsb = tempRead[1];
    uint8_t checksum = tempRead[2];

    uint16_t rawValue = ((uint16_t) msb << 8) | (uint16_t) lsb;
    if(checkCRC(rawValue, checksum) != 0) {
        return (ERROR_BAD_CRC);
    }
    return rawValue & 0xFFFC;
}

float readTemperature(void) {
    uint16_t rawTemperature = readValue(TRIGGER_TEMP_MEASURE_NOHOLD);
    char readBuf[200];
    if (rawTemperature == ERROR_I2C_TIMEOUT || rawTemperature == ERROR_BAD_CRC) {
        UART3_Write(&helloBuffer, strlen(helloBuffer));
        return rawTemperature;
    }
    float tempTemperature = rawTemperature * (175.72 / 65536.0);
    float realTemperature =  tempTemperature - 46.85;
    sprintf(readBuf, "Real Temperature: %f C\n\r", realTemperature);
    UART3_Write(&readBuf, strlen(readBuf));
    return realTemperature;
}

float readHumidity(void) {
    uint16_t rawHumidity = readValue(TRIGGER_HUMD_MEASURE_NOHOLD);
    if (rawHumidity == ERROR_I2C_TIMEOUT || rawHumidity == ERROR_BAD_CRC) {
        return rawHumidity;
    }
    float tempRH = rawHumidity * (125.0 / 65536.0);
    float rh = tempRH - 6.0;
    char humidBuf[200];
    sprintf(humidBuf, "Relative Humidity: %f%c\n\r", rh, 37);
    UART3_Write(&humidBuf, strlen(humidBuf));
    return (rh);
}

float collectedData[20] = {0.0};
bool data_request1 = false;
uint8_t globalPtr = 0;
uint8_t pos = 0;
bool APP_I2C_CALLBACK(I2C_SLAVE_TRANSFER_EVENT event, uintptr_t contextHandle) {
    bool isSuccess = true;
    uint8_t read_val = 0;

    switch(event)
    {
        case I2C_SLAVE_TRANSFER_EVENT_ADDR_MATCH:
            globalPtr = 0;
            pos = 0;
            break;

        case I2C_SLAVE_TRANSFER_EVENT_RX_READY:
            read_val = I2C2_ReadByte();
            if (read_val == 0x10) { // Move solenoid
            }
            else if (read_val == 0x20) {
                data_request1 = true;
            }
            break;

        case I2C_SLAVE_TRANSFER_EVENT_TX_READY:
            if (data_request1 == true) {
                if (pos == 4) {
                    pos = 0;
                    globalPtr++;
                }
                I2C2_WriteByte(*((unsigned char*) &collectedData[globalPtr] + pos));
                pos++;
                UART6_Write(&helloBuffer, strlen(helloBuffer));

            }
            if (globalPtr == 6) {
                data_request1 = false;
            }
            break;

        default:
            break;
    }

    return isSuccess;

}

int main(void) {
SYS_Initialize( NULL );
//change back to i2c2
I2C2_CallbackRegister(APP_I2C_CALLBACK, 0);
TMR3_Initialize();
TMR2_Initialize();
TMR2_CallbackRegister(Timer2_Handler, 0);
TMR2_Start();
TMR3_Start();
CORETIMER_Initialize();
CORETIMER_Start();
I2C1_Initialize();

TMR3 = 0x0000;
TMR2_InterruptEnable();

GPIO_RE9_Set();
CORETIMER_DelayMs(1000);
GPIO_RE9_Clear();

GPIO_RA9_Set();
CORETIMER_DelayMs(1000);
GPIO_RA9_Clear();

while(true){


    //switch the fan on/off
    sprintf(msgBuffer, "Turning fan on \n\r");
    UART3_Write(&msgBuffer, strlen(msgBuffer)); //unmapped this pin
    GPIO_RE9_Toggle();
    CORETIMER_DelayMs(10); //wait 1 second


    
    sprintf(msgBuffer, "Turning solenoid on \n\r");
    UART3_Write(&msgBuffer, strlen(msgBuffer));
    GPIO_RA9_Toggle();  //
    CORETIMER_DelayMs(2000); //wait 1 second
    
    sprintf(msgBuffer, "Turning fan off \n\r");
    UART3_Write(&msgBuffer, strlen(msgBuffer));
    GPIO_RE9_Toggle();
    CORETIMER_DelayMs(10); //wait 1 second
    
    sprintf(msgBuffer, "Turning solenoid off \n\r");
    UART3_Write(&msgBuffer, strlen(msgBuffer));
    GPIO_RA9_Toggle();
    
    
    
    collectedData[0] = getOxygenData(10, ADDRESS_3);
    char o2Buf[100];
    sprintf(o2Buf, "Oxygen Concentration: %f\n\r", collectedData[0]);
    UART3_Write(&o2Buf, strlen(o2Buf));
    
    collectedData[1] = getCarbonDioxideData();
    char co2Buf[100];
    sprintf(co2Buf, "Carbon Dioxide Concentration: %f\n\r", collectedData[1]);
    UART3_Write(&co2Buf, strlen(co2Buf));
    
    collectedData[2] = readTemperature();
    
    collectedData[3] = readHumidity();
    
    if(GPIO_RB6_Get()==1){
        collectedData[4]=0;
    }
    else{
        collectedData[4]=1;
    }
    char waterLevBuf[100];
    sprintf(waterLevBuf, "Water Level: %f\n\r", collectedData[4]);
    UART3_Write(&waterLevBuf, strlen(waterLevBuf));
    
    collectedData[5] = water_flow;
    char waterFlowBuf[100];
    sprintf(waterFlowBuf, "Water Flow: %f\n\r", collectedData[5]);
    UART3_Write(&waterFlowBuf, strlen(waterFlowBuf));
    

    
    sprintf(msgBuffer, "\n\r");
    UART3_Write(&msgBuffer, strlen(msgBuffer));
    
//    
    CORETIMER_DelayMs(1000); //wait 1 second
//    
//    char o2buf[100];
//    sprintf(o2buf, "Oxygen Buffer: %f%c\n\r", o2val, 37);
//    UART3_Write(&o2buf, strlen(o2buf));
    
    //water level sensor
    //if GPIO_RB6_Get = 1, then there is no water
    //if GPIO_RB6_Get = 0, then there is water
    
//    if(GPIO_RB6_Get()==1){
//        sprintf(msgBuffer, "Low Water!!\n\r");
//        UART3_Write(&msgBuffer, strlen(msgBuffer)); 
//    }

    //    getCarbonDioxideData();

    
//    return_val = return_val * (100.0/2000.0);
//    sprintf(buffer, "CO2 Value: %f percent\n\r", return_val);
//    UART3_Write(&buffer, strlen(buffer));

    
    
    
    
//    char waterBuf[100];
//    sprintf(waterBuf, "Water Freq: %f L/min\n\r", water_flow);
//    UART3_Write(&waterBuf, strlen(waterBuf));
    }
}


/*******************************************************************************
 End of File
*/

