# ECEN404repo
reposit

Below Will detail what the Growable Space Habitat is, where to find files in this repo, as well as the deliverables at the end of 404:

What is the Growable Space Habitat and our part in it? 

The Growable Space Habitat is a self-sustaining enclosure that is capable of keeping track of its health as well as make adjustments when needed. The Power Management
System is capable of supplying power to the MCU and AI/Data Processing systems while charging the battery and protecting it at the same time. The MCU system houses all of
the peripherals in the system such as sensors, fans, solenoids that monitor the habitat. The AI/Data Processing system is capable of classifying if plants within the 
system are healthy through 2 machine learning (ML) models. All of the data that s collected from the MCU, is then sent to the pi to be processed, which can send commands
to the MCU to adapt the habitat, ie, turn on the fan or solenoid etc. Everything that is sent to the pi and stored is then pushed to our User Interface System. 
The User Interface system takes the data that was pushed into the database and displays it on an app for the user to view. Data that can be viewed in the app include 
the different MCU boards, and for each of the boards, sensor data can be seen on graphs as well as historical data. The user can also see the images that the camera has
taken as well as if the plant is in a healthy state or not. 


Our Deliverables for 404: 
1. User Interface:
    a. Be able to update real time photos and any of the sensor data on to graphs and display images through the app on the phone from 2 MCU boards
    b. firebase database communication with pi to receive data then send to the app for viewing.

2. AI/Data Processing:
     a. Working tomato leaf data set to be able to classify healthy or not
     b. working bell pepper leaf data set to be able to classify healthy or not (was not required but was completed for supplemental material)
     c. communicates with MCU as well as database

3. MCU:
     a. Control of O2, Temp/Humidity, CO2, Liquid Level, Water Flow, solenoid, fan. (for analog, the joystick is good enough for validation, since we do not have controlled substances of any of the analog sensor gases, as well as the voltage output that we get on the ethylene being good enough validation for the Analog type)
     b. Communicate all of the collected data from the mcu to the Pi
     c. Control other peripherals (solenoid and fan).(solenoid "clicking" is sufficient since there are not valves to "open/close" and fan being controlled on/off)

4. Power Management System  
     a. Provide power to the Pi and MCU systems
     b. Charge battery at same time that it is discharging (sun will not be out so power supply will mimic the solar panel) through the board and the controller.
     c. Protect the battery
     d. Monitoring was not able to work, talked it over with our sponsor Dr. Rising and she is aware and okay with it being passed down to the next ECEN team working on the project. The cell monitor is now an optional piece to this subsystem. 

5. Github Repository:
    a. Everything related to the project including schematics, designs, datasheets etc
    b. detailed write ups containing the purpose of each of the subsystems
    c. detailed description of the progress that was made and what needs to be done for the next team, also possible steps that they should take (advice).
   d. Shared with Rohith, Dr. Lusher and Dr. Rising


How to navigate through our repo: 

In our Repo, the 4 of us have our own folders that have specific titles to make it easy to navigate. 
All datasheets, test scripts, altium designs and everything else related to the project is in this repo.

Thanks!


