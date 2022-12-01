import time
import numpy as np
import struct
from smbus2 import SMBus
from database import db_init, db_write_data, db_write_image
from camera import capture_image
from classifier import*

database = db_init()
addr_1 = 0x54
addr_2 = 0x55
bus = SMBus(0)


# Path to store images
camera_1_path = '/home/pi/Desktop/Stored_Image/Camera_1/image1.jpg'
camera_2_path = '/home/pi/Desktop/Stored_Image/Camera_2/image2.jpg'
camera_3_path = '/home/pi/Desktop/Stored_Image/Camera_3/image3.jpg'
camera_4_path = '/home/pi/Desktop/Stored_Image/Camera_4/image4.jpg'


image_mcu = "MCU 1"
image_camera = "Camera 1"
test_path = "/home/pi/Downloads/Tomato_Yellow_Leaf_Curl_0030.JPG"

mcu = "MCU Test"
sensor_number = "1"
############### DEMO Camera 1 ###################
while 1:
    # Camera 1
    # Take image
    capture_image(1, camera_1_path)
    # Classify
    model_state = classify_spinach(camera_1_path)
    print(model_state)
    # Send image
    db_write_image(database, image_mcu, image_camera, camera_1_path)
    db_write_data(database, mcu, "Camera States", "State 1", model_state)
    if (model_state == "Yellow Leaf Curl"):
        bus.write_byte(addr_1, 0x10)
        
    # Camera 2
    # Take image
    capture_image(2, camera_2_path)
    # Classify
    model_state = classify_spinach(camera_2_path)
    print(model_state)
    if (model_state == "Yellow Leaf Curl"):
        bus.write_byte(addr_1, 0x10)
    # Send image
    db_write_image(database, image_mcu, image_camera, camera_2_path)
    db_write_data(database, mcu, "Camera States", "State 2", model_state)
    
    # Camera 3
    # Take image
    capture_image(3, camera_3_path)
    # Classify
    model_state = classify_spinach(camera_3_path)
    print(model_state)
    if (model_state == "Le"):
        #bus.write_byte(addr_2, 0x10)
    # Send image
    db_write_image(database, image_mcu, image_camera, camera_3_path)
    db_write_data(database, mcu, "Camera States", "State 3", model_state)
    
    # Camera 4
    # Take image
    capture_image(4, camera_4_path)
    # Classify
    model_state = classify_spinach(camera_4_path)
    print(model_state)
    if (model_state == "Yellow Leaf Curl"):
        #bus.write_byte(addr_2, 0x10)
    # Send image
    db_write_image(database, image_mcu, image_camera, camera_3_path)
    db_write_data(database, mcu, "Camera States", "State 4", model_state)
    
    
    # Request Data
    bus.write_byte(addr_1, 0x20)
    time.sleep(0.1)
    
    # Data Requested is 24 bytes
    # Each 4 bytes is one data entry to represent float value in hex. Total amount of data is 6 sensor readings
    # When data is transmitted, LSB is shown first and MSB shown last
    request_data = bus.read_i2c_block_data(addr,0, 24)
    request_data = np.array(request_data)
    request_data = np.flip(request_data)
    time.sleep(2)
    
    # Since data is fliped the order of data pushed to database is:
    # Water Flow, Water Level, Humidity, Temperature, Carbon Dioxide, Oxygen
    # From the MCU side the data pushed to Raspberry Pi is:
    # Oxygen, Carbon Dioxide, Temperature, Humidity, Water Level, Water Flow
    database_list = ["Water Flow", "Water Level", "Humidity", "Temperature", "Carbon Dioxide", "Oxygen"]
    for i in range(6):
        hex_list = request_data[i*4:4*(i+1)]
        #print("Hex List: " + str(hex_list))
        hex_string = str(format(hex_list[0], '02x')) + str(format(hex_list[1], '02x')) + str(format(hex_list[2], '02x')) + str(format(hex_list[3], '02x'))
        #print("Hex String: " + str(hex_string))
        float_val = struct.unpack('!f', bytes.fromhex(hex_string))[0]
        
        # Get current time
        send_data = list(time.localtime())
        # Assign last element in list since tm_isdst is not needed
        send_data[-1] = float_val
        db_write_data(database, mcu, database_list[i], sensor_number, send_data)
        print(database_list[i] + ": " + str(float_val))
        
    
    time.sleep(4)
    


#send_data = list(time.localtime())
#send_data[-1] = 50

#db_write_data(database, mcu, sensor, sensor_number, send_data)

#capture_image(4, camera_4_path)

