/* 
 * File:   water_flow_sensor.c
 * Author: Adam Pameron and Andrew Yang
 *
 * Created on October 24, 2022, 3:00 PM
 */

#include "device.h"
#include "definitions.h"                // SYS function prototypes
#include "water_flow_sensor.h"

uint16_t water_rate = 0.0;
float water_convert = 31.0
float water_flow = 0.0;
// *****************************************************************************
/* Function:
    void Flow_Handler(uint32_t status, uintptr_t context)

  Summary:
    Calculates the water flow rate based using the timer interrupt.

  Description:
    This function utilized the Timer interrupt to count the number of times
    the Hall Effect Sensor has activated and calculate the flow rate every 
    second.

  Parameters:
    uint32_t status: Interrupt status callback handler.
    uintptr_t context: Interrupt context callback handler.

  Returns:
    None.
*/
void Flow_Handler(uint32_t status, uintptr_t context)
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
