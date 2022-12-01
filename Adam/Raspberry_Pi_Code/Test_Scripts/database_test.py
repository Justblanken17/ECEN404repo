import os
import configparser
import pyrebase
import numpy as np

path = "/home/pi/Desktop/Project/"
name = "db.ini"

def get_path(path):
  for root, dirs, files in os.walk(path):
    for file in files:
      if file.endswith('.ini'):
        filename = os.path.join(root, file)

  return filename

def db_init():
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

  return config

def db_write(config, mcu, sensor_type, sensor_number, x, y):
    #firebase = pyrebase.initialize_app(config)
    #db = firebase.storage()
    #db.child("MCU 1").child("Images").put("/home/pi/Desktop/spiderman.jpg")
    for idx, i in enumerate(x):
      firebase = pyrebase.initialize_app(config)
      db = firebase.database()
      new_ref = db.child("MCU 1").child("Carbon Dioxide").child("Sensor 2")
      data = {
          "time": int(x[idx]),
          "concentration": float(y[idx])
          }
      new_ref.push(data)
   #   data = {
    #      'time': x[idx],
     #     'concentration': y[idx]
      #    }
      

database = db_init()
mcu = "MCU 1"
sensor = "Oxygen"
sensor_number = "Sensor 1"

x = np.arange(0, 120, 1)
y = np.random.uniform(low=20.2, high=20.6, size=120)
db_write(database, mcu, sensor, sensor_number, x, y)