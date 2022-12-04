The idrectories stord here is the abstracted code for the MCU Firmware, Rsapberry Pi, Jupyter Notebook for training the binarry classifiers, and testing scripts for individual and system functionality.


## FIRMWARE ##

Each of the folders in the Firmware directory corresponds to the source and header file for each sensor.

## MACHINE_LEARNING ##

The folders store the jupyter nnotebooks that creates the data augmentation, train dataset, train csv, test dataset, model training.

## Test_SCRIPTS ##

The python scripts here test the individual functionlity for of the system process to request i2c data, send data to database, classify, control cameras. etc.

## Running the system ##

Assuming that the system being used is the current image of the pi used, the following steps must be followed. In order to run main.py, the pi needs to have in its own sandbox i.e. virtual environment since Tensorflow has dependancies that affect the pi from running.

To activate the virtual environment:

cd Desktop/Project

source env/bin/activate

Adter it is activated mode back to the home directory and head to the test directory which is currently named Project_1:

cd ~
cd Desktop/Project_1

Run the serial_test script ot make sure that the serial data and serial clock line is intact and can receive data from the MCU:
python serial_test.py

Once it is verified and the corect values are being received, then head back to the home directory and proceed to the Demo directory:
cd ~
cd Demo

Run the main.py script so that it will constantly classify, retrieve data, and send data:
python main.py

## NOTE: ##
If a different database is used, you must change the db.ini file so that it can push data to the correct database. This was abstracted for ease of use in future changes of the database.
