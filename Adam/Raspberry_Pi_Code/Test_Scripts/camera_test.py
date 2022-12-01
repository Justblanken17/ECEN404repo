import time
import os
from time import sleep
import configparser
import pyrebase
import cv2
import numpy
from PIL import Image

camera_1 = 'i2cset -y 10 0x24 0x24 0x02'
camera_2 = 'i2cset -y 10 0x24 0x24 0x12'
camera_3 = 'i2cset -y 10 0x24 0x24 0x22'
camera_4 = 'i2cset -y 10 0x24 0x24 0x32'

camera_capture = 'libcamera-still -n -o'

camera_1_path = ' /home/pi/Desktop/Project/camera_1_photos/image1.jpg'
camera_2_path = ' /home/pi/Desktop/Project/camera_2_photos/image2.jpg'
camera_3_path = ' /home/pi/Desktop/Project/camera_3_photos/image3.jpg'
camera_4_path = ' /home/pi/Desktop/Project/camera_4_photos/image4.jpg'

path = "/home/pi/Desktop/Project/"
name = "db.ini"

def get_path(path):
  for root, dirs, files in os.walk(path):
    for file in files:
      if file.endswith('.ini'):
        filename = os.path.join(root, file)

  return filename

config_file_path = get_path(path)
config = configparser.ConfigParser()
config.read(config_file_path)
database = config['database']
  
config = {
"apiKey": database['api'],
"authDomain": database['domain'],
"databaseURL": database['url'],
"storageBucket": database['bucket']
}

states = ["Healthy", "Yellow Leaf Curl"]
print("Selecting Camera 1")

os.system(camera_1)
os.system(camera_capture + camera_1_path)

frame = cv2.imread(camera_1_path)
model_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
model_frame = Image.fromarray(model_frame)
model_frame = model_frame.resize((256,256))
model_frame = image.img_to_array(model_frame)
model_frame = np.expand_dims(model_frame, axis=0)

y_pred = model.predic(model_frame)


print(states[int(round(y_pred[0][0]))])


firebase = pyrebase.initialize_app(config)
db = firebase.storage()
db.child("MCU 1").child("Camera 1").child("Images").put('/home/pi/Desktop/Project/camera_1_photos/image1.jpg')

print("Saved Camera 1 Image")

sleep(5)

print("Selecting Camera 2")

os.system(camera_2)
os.system(camera_capture + camera_2_path)

firebase = pyrebase.initialize_app(config)
db = firebase.storage()
db.child("MCU 1").child("Camera 2").child("Images").put('/home/pi/Desktop/Project/camera_2_photos/image2.jpg')

print("Saved Camera 2 Image")

sleep(5)


#print("Selecting Camera 3")

#os.system(camera_3)
#os.system(camera_capture + camera_3_path)

#firebase = pyrebase.initialize_app(config)
#db = firebase.storage()
#db.child("MCU 1").child("Camera 3").child("Images").put('/home/pi/Desktop/Project/camera_3_photos/image3.jpg')

#print("Saved Camera 3 Image")

#sleep(5)

#print("Selecting Camera 4")

os.system(camera_4)
os.system(camera_capture + camera_4_path)

firebase = pyrebase.initialize_app(config)
db = firebase.storage()
db.child("MCU 1").child("Camera 4").child("Images").put('/home/pi/Desktop/Project/camera_4_photos/image4.jpg')

print("Saved Camera 4 Image")




