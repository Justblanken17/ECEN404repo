/* 
 * File:   water_flow_sensor.h
 * Author: Adam Pameron and Andrew Yang
 *
 * Created on October 24, 2022, 3:00 PM
 */

#ifndef WATER_FLOW_SENSOR_H
#define	WATER_FLOW_SENSOR_H

#include "device.h"

#ifdef	__cplusplus
extern "C" {
#endif

extern uint16_t water_rate;
extern float water_flow;
extern float water_convert;
void Flow_Handler(uint32_t status, uintptr_t context);


#ifdef	__cplusplus
}
#endif

#endif	/* WATER_FLOW_SENSOR_H */

