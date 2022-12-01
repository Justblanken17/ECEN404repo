/* 
 * File:   oxygen_sensor.h
 * Author: Adam Pameron
 *
 * Created on October 24, 2022, 3:00 PM
 */

#ifndef __OXYGEN_SENSOR_H__
#define	__OXYGEN_SENSOR_H__

#include "device.h"

#ifdef	__cplusplus
extern "C" {
#endif

#define ADDRESS_0   0x70
#define ADDRESS_1   0x71
#define ADDRESS_2   0x72
#define ADDRESS_3   0x73  ///< iic slave Address select
#define OCOUNT      100   ///< oxygen Count Value
#define OXYGEN_DATA_REGISTER 0x03   ///< register for oxygen data
#define USER_SET_REGISTER    0x08   ///< register for users to configure key value manually
#define AUTUAL_SET_REGISTER  0x09   ///< register that automatically configure key value
#define GET_KEY_REGISTER     0x0A   ///< register for obtaining key value

//struct oxygen {
//    float key;
//    float oxygenData[OCOUNT];        
//};

//typedef struct
//{
//    float oxygenData[OCOUNT] = {0.0};
//} oxygenData;
//
//typedef struct
//{
//    float key = 0.0;
//} key;
    
float getOxygenData(uint16_t addr, uint8_t collectNum);
void calibrate(float vol, float mv, uint16_t addr);
extern float key;
extern float oxygenData[OCOUNT];
void readFlash(uint16_t addr);
float getAverageNum(float bArray[], uint8_t len);
    


#ifdef	__cplusplus
}
#endif

#endif	/* OXYGEN_SENSOR_H */

