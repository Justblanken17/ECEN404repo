import os

# Commands to isolate each cameras
camera_1 = 'i2cset -y 10 0x24 0x24 0x02'
camera_2 = 'i2cset -y 10 0x24 0x24 0x12'
camera_3 = 'i2cset -y 10 0x24 0x24 0x22'
camera_4 = 'i2cset -y 10 0x24 0x24 0x32'

# Command to take a photo
camera_capture = 'libcamera-still -n -o'

# Take an image depending on the camera passed into the function
def capture_image(camera_number, save_path):
    if (camera_number == 1):
        print("Selecting Camera 1")
        os.system(camera_1)
        os.system(camera_capture + save_path)
        print("Saved Camera 1 Image")
    elif (camera_number == 2):
        print("Selecting Camera 2")
        os.system(camera_2)
        os.system(camera_capture + save_path)
        print("Saved Camera 2 Image")
    elif (camera_number == 3):
        print("Selecting Camera 3")
        os.system(camera_3)
        os.system(camera_capture + save_path)
        print("Saved Camera 3 Image")
    elif (camera_number == 4):
        print("Selecting Camera 4")
        os.system(camera_4)
        os.system(camera_capture + save_path)
        print("Saved Camera 4 Image")
        