import serial
import time
import matplotlib.pyplot as plt

# This script is to test and validate UART communication in the Raspberry Pi.
# This was used to collect data from the carbon dioxide sensor  

ser = serial.Serial("/dev/ttyS0",baudrate =9600,timeout = .5)
ser.flushInput()
time.sleep(1)

co2_array = []
for i in range(20):
    ser.flushInput()
    ser.write(b"\xFE\x44\x00\x08\x02\x9F\x25")
    time.sleep(1)

    resp = ser.read(7)
    print(f"Resp: {resp}")
    print(f"Length: {len(resp)}")
    print(f"Resp [0]: {hex(resp[0])}")
    print(f"Resp [1]: {hex(resp[1])}")
    print(f"Resp [2]: {hex(resp[2])}")
    print(f"Resp [3]: {hex(resp[3])}")
    print(f"Resp [5]: {hex(resp[5])}")
    print(f"Resp [6]: {hex(resp[6])}")
    
    resp = ser.read(1)
    print(resp)
    print(hex(resp[0]))
    print('\n')
    resp = ser.read(1)
    print(resp)
    print(hex(resp[0]))
    print('\n')
    resp = ser.read(1)
    print(resp)
    print(hex(resp[0]))
    print('\n')
    resp = ser.read(1)
    print(resp)
    print(hex(resp[0]))
    print('\n')
    resp = ser.read(1)
    print(resp)
    print(hex(resp[0]))
    print('\n')
    resp = ser.read(1)
    print(resp)
    print(hex(resp[0]))
    print('\n')
    resp = ser.read(1)
    print(resp)
    print(hex(resp[0]))
    print('\n')
    
    
    high = resp[3]
    low = resp[4]
    co2 = (high*256) + low
    print(co2)
    co2_array.append(co2)
    time.sleep(3)
    