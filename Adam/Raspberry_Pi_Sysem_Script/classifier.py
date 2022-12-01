import cv2
import numpy as np
from PIL import Image
import tensorflow as tf
from tensorflow.keras.preprocessing import image
from tensorflow import keras

baby_spinach_model = "/home/pi/Desktop/Project_1/model/best-model-kfold-4.h5"
oyster_mushroom_model = ""

baby_spinach_states = ["Healthy", "Yellow Leaf Curl"]
oyster_mushroom_states = ["Healthy", "Bacterial Spot"]

# Classify using baby spinach model
def classify_spinach(image):
    print(image)
    model = keras.models.load_model(baby_spinach_model)

    frame = cv2.imread(image)
    model_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    model_frame = cv2.resize(model_frame, (256,256), interpolation=cv2.INTER_AREA)

    model_frame = np.array(model_frame)
    model_frame = np.expand_dims(model_frame, axis=0)
    model_frame = model_frame / 255.

    #print(model_frame.shape)

    y_pred = model.predict(model_frame, verbose=0)

    print(y_pred)
    pred_state = baby_spinach_states[int(round(y_pred[0][0]))]
    print(pred_state)
    print(int(round(y_pred[0][0])))
    
    return int(round(y_pred[0][0]))

# Classify using oyster mushroom model
def classify_oyster_mushroom(image):
    model = keras.models.load_model(oyster_mushroom_model)

    frame = cv2.imread(image)
    model_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    model_frame = cv2.resize(model_frame, (256,256), interpolation=cv2.INTER_AREA)

    model_frame = np.array(model_frame)
    model_frame = np.expand_dims(model_frame, axis=0)
    model_frame = model_frame / 255.

    #print(model_frame.shape)

    y_pred = model.predict(model_frame, verbose=0)

    print(y_pred)
    pred_state = oyster_mushroom_states[int(round(y_pred[0][0]))]
    print(pred_state)
    print(int(round(y_pred[0][0])))
    
    return int(round(y_pred[0][0]))
    
