/* 
 * File:   oxygen_sensor.c
 * Author: Adam Pameron
 *
 * Created on October 24, 2022, 3:00 PM
 */

#include "device.h"
#include "definitions.h"                // SYS function prototypes
#include "oxygen_sensor.h"

float key = 0.0;
float oxygenData[OCOUNT] = {0.0};


// *****************************************************************************
/* Function:
    void readFlash(uint16_t addr)

  Summary:
    Uses the I2C peripheral to communicate to the oxygen sensor and retrieve
    the key value to be used in calculating the oxygen concentration.

  Description:
    This function communicates to the DFRobot Gravity: Electromechanical
    Oxygen Sensor using I2C to send a command to return a value to the
    key register for it to be used is calculating the oxygen concentration.

  Parameters:
    uint16_t addr: I2C Address of DFRobot Oxygen Sensor.

  Returns:
    None.
*/
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

// *****************************************************************************
/* Function:
    void calibrate(float vol, float mv, uint16_t addr)

  Summary:
    Uses the I2C peripheral to communicate to the oxygen sensor and
    calibrate it with the current oxygen concentration in the air.

  Description:
    This function communicates to the DFRobot Gravity: Electromechanical
    Oxygen Sensor using I2C to send the current oxygen concentration in the
    air to calibrate the sensor.

  Parameters:
    float vol: Current oxygen concentration of oxygen in the air.
    float mv: Value marked on the sensor. Initialized to 0.
    uint16_t addr: I2C Address of DFRobot Oxygen Sensor.

  Returns:
    None.
*/
void calibrate(float vol, float mv, uint16_t addr) {
    uint8_t keyValue = vol * 10;
    if(mv < 0.000001 && mv > (-0.000001) ) {
               
        static uint8_t temp_user_reg = USER_SET_REGISTER;
        I2C1_Write(ADDRESS_3, &temp_user_reg, 1);
        I2C1_Write(ADDRESS_3, &keyValue, 1);
        
    }
    else {
        keyValue = (vol / mv) * 1000;
        
        static uint8_t temp_actual_reg = AUTUAL_SET_REGISTER;
        I2C1_Write(ADDRESS_3, &temp_actual_reg, 1);
        I2C1_Write(ADDRESS_3, &keyValue, 1);

        
    }
}


// *****************************************************************************
/* Function:
    float getAverageNum(float bArray[], uint8_t len)

  Summary:
    Calculates the average oxygen concentration.

  Description:
    This function calculates the average oxygen concentration based on the
    passed length and raw oxygen concentration array.

  Parameters:
    float bArray[]: Raw oxygen concentration collected.
    float len: Length of array to perform averaging.
    uint16_t addr: I2C Address of DFRobot Oxygen Sensor.

  Returns:
    Average oxygen concentration.
*/
float getAverageNum(float bArray[], uint8_t len) {
    uint8_t i = 0;
    double bTemp = 0;
    for (i = 0; i < len; i++) {
        bTemp += bArray[i];
    }
    return bTemp / ((float) len);
}

// *****************************************************************************
/* Function:
    float getOxygenData(uint16_t addr, uint8_t collectNum)

  Summary:
    Calculates the average oxygen concentration.

  Description:
    This function communicates to the DFRobot Gravity: Electromechanical
    Oxygen Sensor using I2C to send a command to the sensor so that the sensor
    sends back raw oxygen concentration. The 3 bytes of retrieved data and key
    is used to calculate the raw oxygen concentration.

  Parameters:
    uint16_t addr: I2C Address of DFRobot Oxygen Sensor.
    uint8_t len: Number of oxygen samples to collect.

  Returns:
    Average oxygen concentration collected.
*/
float getOxygenData(uint16_t addr, uint8_t collectNum) {
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

        if (i < collectNum) {
            i++;
        }
        
        return getAverageNum(oxygenData, i);    
    }
    else {
        return -1.0;
    }
    
} 
