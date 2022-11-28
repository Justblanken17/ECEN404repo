#include "definitions.h"
#include "device.h"

int getCarbonDioxideData(void) {
    //unsigned char address = xFE\x44\x00\x08\x02\x9F\x25;      //// HOW DO I DO HEX STRINGS
    // Talk to CO2 Device
    uint8_t address1 = 0xFE;
    UART1_WriteByte(address1);
    uint8_t address2 = 0x44;
    UART1_WriteByte(address2);
    uint8_t address3 = 0x00;
    UART1_WriteByte(address3);
    uint8_t address4 = 0x08;
    UART1_WriteByte(address4);
    uint8_t address5 = 0x02;
    UART1_WriteByte(address5);
    uint8_t address6 = 0x9F;
    UART1_WriteByte(address6);
    uint8_t address7 = 0x25;
    UART1_WriteByte(address7);
    // Pause for 1s
    CORETIMER_DelayMs(1000);
    uint8_t rxdata[10] = {0};
    rxdata[0] = UART1_ReadByte();
    rxdata[1] = UART1_ReadByte();
    rxdata[2] = UART1_ReadByte();
    rxdata[3] = UART1_ReadByte();
    rxdata[4] = UART1_ReadByte();
    rxdata[5] = UART1_ReadByte();
    rxdata[6] = UART1_ReadByte();
    return (((int) rxdata[3]*256) + (int) rxdata[4]);    
}
