from smbus2 import SMBus
import time

addr = 0x55
bus = SMBus(0)

#bus.pec = 1
while 1:
    bus.write_byte(addr, 0x20)
    time.sleep(0.1)
    #b = bus.read_byte_data(addr, 2)
    b = bus.read_i2c_block_data(addr,0, 24)
    print(b)
    
    print("Here")
    time.sleep(1)
    
