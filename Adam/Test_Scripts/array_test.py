import numpy as np
import struct


# This is to test and validate that the array can be converted into hext and concatenated so that it can be converted to a float variable
# Array below is sample data collected from the serial_test.py script

#list = [51, 51, 203, 65,]
#list = [51, 51, 203, 65, 0, 0, 26, 66, 205, 204, 36, 66, 0, 0, 70, 66, 51, 51, 179, 65, 205, 204, 226, 66, 154, 26, 26, 26]
list = [0, 0, 128, 63, 0, 0, 0, 0, 205, 204, 36, 66, 0, 0, 70, 66, 51, 51, 179, 65, 205, 204, 226, 66, 142, 14, 14, 14]




print(list)
print('\n')

list1 = np.array(list)
list1 = np.flip(list1)
print(list1)
for i in range(6):
    print(i)
    hex_list = list1[i*4:4*(i+1)]
    print("Hex List: " + str(hex_list))
    hex_string = str(format(hex_list[0], '02x')) + str(format(hex_list[1], '02x')) + str(format(hex_list[2], '02x')) + str(format(hex_list[3], '02x'))
    print("Hex String: " + str(hex_string))
    float_val = struct.unpack('!f', bytes.fromhex(hex_string))[0]
    #print("Float Value: " + str(round(float_val, 5)))
    print("Float Value: " + str(round(float_val, 8)))
    
    