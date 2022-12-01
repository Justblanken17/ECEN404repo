import os
import configparser
import pyrebase
import numpy as np

path = "/home/pi/Desktop/Demo"
name = "db.ini"

# Gets the db.ini file to use for the database initialization
def get_path(path):
  for root, dirs, files in os.walk(path):
    for file in files:
      if file.endswith('.ini'):
        filename = os.path.join(root, file)

  return filename

# Initialize database using the config db.ini
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

# Send collected images to Firebase Storage
def db_write_image(config, mcu, camera, path):
    firebase = pyrebase.initialize_app(config)
    db = firebase.storage()
    db.child(mcu).child(camera).child("Images").put(path)
    
# Send collected data to Firebase Realtime Database
def db_write_data(config, mcu, sensor_type, sensor_number, data):
    firebase = pyrebase.initialize_app(config)
    db = firebase.database()
    ref = db.child(mcu).child(sensor_type).child(sensor_number)
    data = {
        "2-Year": int(data[0]),
        "3-Month": int(data[1]),
        "4-Day": int(data[2]),
        "5-Hour": int(data[3]),
        "6-Minute": int(data[4]),
        "7-Seconds": int(data[5]),
        "8-Day_of_the_Week": int(data[6]),
        "9-Day_of_the_Year": int(data[7]),
        "1-Concentration": float(data[8])
        }
    ref.push(data)
    