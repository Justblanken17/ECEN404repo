/* 
 * File:   temperature_humidity_sensor.c
 * Author: Adam Pameron
 *
 * Created on October 24, 2022, 3:00 PM
 */

#include "device.h"
#include "definitions.h"                // SYS function prototypes
#include "temperature_humidity_sensor.h"

// *****************************************************************************
/* Function:
    void setResolution(uint8_t resolution)

  Summary:
    Adjusts resolution of SHT20 Temperature and Humidity Sensor using the
    I2C Peripheral.

  Description:
    This function communicates to the SHT20 Temperature and Humidity Sensor to
    send a command to adjust the sensor's resolution.

  Parameters:
    uint8_t resolution: Adjusted resolution for sensor. All resolution values
    are stored in temperature_humidity_sensor.h.

  Returns:
    None.
*/
void setResolution(uint8_t resolution) {
    uint8_t temp_read_user_reg = READ_USER_REG;
    uint8_t temp_write_user_reg = WRITE_USER_REG;
    uint8_t read_resolution = 0;
    
    I2C1_WriteRead(SHT20_I2C_ADDR, &temp_read_user_reg, 1, &read_resolution, 1);
    
    read_resolution &= 0b01111110;
    resolution &= 0b10000001;
    read_resolution |= resolution;
    
    I2C1_Write(SHT20_I2C_ADDR, &temp_write_user_reg, 1);
    I2C1_Write(SHT20_I2C_ADDR, &read_resolution, 1);
    
}


// *****************************************************************************
/* Function:
    uint8_t checkCRC(uint16_t message_from_sensor, uint8_t check_value_from_sensor)

  Summary:
    Checks whether the retrieved sensor data did no have bit errors.

  Description:
    This function checks whether the first two bytes of data collected from the
    sensor is intact and did not have any bit errors.

  Parameters:
    uint16_t message_from_sensor: MSB and LSB temperature/humidity reading of
    SHT20 sensor.
    uint8_t check_value_from_sensor: Checksum value returned from sensor.

  Returns:
    Returns sensor original sensor reading if there are no bit errors.
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

// *****************************************************************************
/* Function:
    uint16_t readValue(uint8_t cmd)

  Summary:
    Collects temperature and humidity values using the I2C peripheral and
    verifies if there are any bit errors.

  Description:
    This function communicates to the SHT20 Temperature and Humidity Sensor to
    collect readings for temperature and humidity based on the function command
    sent to the sensor. The retrieved sensor reading is verified with any bit
    errors in case the retrieved data is incorrect.

  Parameters:
    uint8_t cmd: Command request either temperature or humidity reading.

  Returns:
    Temperature or Humidity reading.
*/
uint16_t readValue(uint8_t cmd) {
    uint8_t tempRead[3] = {0};
    I2C1_Write(SHT20_I2C_ADDR, &cmd, 1);
    CORETIMER_DelayMs(200);
    CORETIMER_DelayMs(DELAY_INTERVAL);
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

// *****************************************************************************
/* Function:
   float readTemperature(void)

  Summary:
    Collects temperature values using the I2C peripheral. 

  Description:
    This function communicates to the SHT20 Temperature and Humidity Sensor to
    collect readings for temperature using the readValue function.

  Parameters:
    None.

  Returns:
    Temperature reading.
*/
float readTemperature(void) {
    uint16_t rawTemperature = readValue(TRIGGER_TEMP_MEASURE_NOHOLD);
    char readBuf[100];
    if (rawTemperature == ERROR_I2C_TIMEOUT || rawTemperature == ERROR_BAD_CRC) {
        return rawTemperature;
    }
    float tempTemperature = rawTemperature * (175.72 / 65536.0);
    float realTemperature =  tempTemperature - 46.85;
    sprintf(readBuf, "Real Temperature: %f\n\r", realTemperature);
    UART6_Write(&readBuf, strlen(readBuf));
    return (realTemperature);
}

// *****************************************************************************
/* Function:
   float readHumidity(void)

  Summary:
    Collects humidity values using the I2C peripheral. 

  Description:
    This function communicates to the SHT20 Temperature and Humidity Sensor to
    collect readings for humidity using the readValue function.

  Parameters:
    None.

  Returns:
    Temperature reading.
*/
float readHumidity(void) {
    uint16_t rawHumidity = readValue(TRIGGER_HUMD_MEASURE_NOHOLD);
    if (rawHumidity == ERROR_I2C_TIMEOUT || rawHumidity == ERROR_BAD_CRC) {
        return rawHumidity;
    }
    float tempRH = rawHumidity * (125.0 / 65536.0);
    float rh = tempRH - 6.0;
    char humidBuf[100];
    sprintf(humidBuf, "Raw Humidity: %f\n\r", rh);
    UART6_Write(&humidBuf, strlen(humidBuf));
    return (rh);
}
