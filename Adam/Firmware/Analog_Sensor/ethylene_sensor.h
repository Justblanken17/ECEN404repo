/* 
 * File:   ethylene_sensor.h
 * Author: Adam Pameron
 *
 * Created on October 24, 2022, 3:00 PM
 */

#ifndef ETHYLENE_SENSOR_H
#define	ETHYLENE_SENSOR_H

#include "device.h"

#ifdef	__cplusplus
extern "C" {
#endif

void ethylene_initialize(void);
int getEthyleneData(void);


#ifdef	__cplusplus
}
#endif

#endif	/* ETHYLENE_SENSOR_H */

