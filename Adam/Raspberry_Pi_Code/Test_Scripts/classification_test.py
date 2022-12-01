import os
import cv2
import numpy as np
from PIL import Image
import tensorflow as tf
from tensorflow.keras.preprocessing import image
from tensorflow import keras


camera_1 = 'i2cset -y 10 0x24 0x24 0x02'
camera_2 = 'i2cset -y 10 0x24 0x24 0x12'
camera_3 = 'i2cset -y 10 0x24 0x24 0x22'
camera_4 = 'i2cset -y 10 0x24 0x24 0x32'

camera_capture = 'libcamera-still -n -o'

camera_1_path = '/home/pi/Desktop/Project_1/camera_1_photos/image1.jpg'
camera_2_path = '/home/pi/Desktop/Project_1/camera_2_photos/image2.jpg'
camera_3_path = '/home/pi/Desktop/Project_1/camera_3_photos/image3.jpg'
camera_4_path = '/home/pi/Desktop/Project_1/camera_4_photos/image4.jpg'

states = ["Healthy", "Yellow Leaf Curl"]
print("Selecting Camera 1")

model = keras.models.load_model('/home/pi/Desktop/Project_1/model/best-model-kfold-4.h5')

os.system(camera_1)
os.system(camera_capture + camera_1_path)

frame = cv2.imread(camera_1_path)
model_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
model_frame = cv2.resize(model_frame, (256,256), interpolation=cv2.INTER_AREA)

model_frame = np.array(model_frame)
model_frame = np.expand_dims(model_frame, axis=0)
model_frame = model_frame / 255.

print(model_frame.shape)

y_pred = model.predict(model_frame, verbose=0)

print(y_pred)
print(states[int(round(y_pred[0][0]))])
#print("Sending Image and State of Camera 1")
#firebase = pyrebase.initialize_app(config)
#db = firebase.storage()
#db.child("MCU 1").child("Camera 1").child("Images").put('/home/pi/Downloads/Tomato_Healthy.JPG')
#print("Sent")
print("\n\n")



#print("Selecting Camera 2")
#os.system(camera_1)
#os.system(camera_capture + camera_1_path)

#frame = cv2.imread('/home/pi/Downloads/Tomato_Yellow_Leaf_Curl.JPG')
#model_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
#model_frame = cv2.resize(model_frame, (256,256), interpolation=cv2.INTER_AREA)

#model_frame = np.array(model_frame)
#model_frame = np.expand_dims(model_frame, axis=0)
#model_frame = model_frame / 255.

#print(model_frame.shape)

#y_pred = model.predict(model_frame, verbose=0)

#print(y_pred)
#print(states[int(round(y_pred[0][0]))])
#print("Sending Image and State of Camera 2")

#firebase = pyrebase.initialize_app(config)
#db = firebase.storage()
#db.child("MCU 1").child("Camera 2").child("Images").put('/home/pi/Downloads/Tomato_Yellow_Leaf_Curl.JPG')
print("Sent")
print("\n\n")


