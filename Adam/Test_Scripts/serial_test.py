from smbus2 import SMBus
import time

# This script is to test and validate that serial communication thought I2C is capable with the Raspberry Pi.
# The Pi requests 24 bytes of data since there are 6 sensor reading and each are divided into 4 bytes in order to show
# the float representation of the data.
addr = 0x55
bus = SMBus(0)


while 1:
    bus.write_byte(addr, 0x20)
    time.sleep(0.1)

    b = bus.read_i2c_block_data(addr,0, 24)
    print(b)
    
    print("\n")
    time.sleep(1)
    
