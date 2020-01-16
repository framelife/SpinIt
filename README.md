


# Description
This is an android application that decides what food place you should go to by "Spinning a wheel" based off of certain parameters such as food preference, dietary preference, current location, and radius of travel. With some extra nifty features such as a chat room capability to "Spin" with your friends. This application utilizes the Yelp API, to find the food places given the certain parameters, and Firebase Database/Authentication, to help us deal with multiple users and chat room function.

# How to install and use?
### 1. Install Android Studio<br />
Follow the instructions here to install android studio on your machine: https://developer.android.com/studio/install
### 2. Clone the repository onto your machine
### 3. Open Android Studio and install an emulator<br />
Follow the instruction here to install the emulator on android studio: https://developer.android.com/studio/run/emulator<br />
The configuration that we used to test and develop this application was a "Pixel 3 XL API 24" and the android version that we are using is "Android 7.0"
### 4. Close Android Studio and Open Project<br />
To close Android Studio, you go to the top left corner and click on File > Close Project, then click on "Open an existing Android Studio Project" and find the cloned git repository.

### 5. Running the application<br />
To tun the application, you must go to the top right part of the window and it should have a place that says "app" on a drop down menu, if there isn't change it to "app". Then next to that should be the emulation device, pick you emulation device, for us that emulation device is "Pixel 3 XL API 24". Then next to that button you can click the play button and that should first boot up your emulation device and if there is an error saying there is no emulation device, click the play button again and then it should install and run.

### 6. Inside the application<br />
* Go ahead and register in yourself and then you should be logged in and in the dashboard
* You have to be able to set your preferences before you can even spin, so go into the preference, and allow for your location to work
(this may cause problems because its an emulation device, to solve this you have to go onto the maps application on your device and direct yourself somewhere using your current location, that should set googleplex as your current location, due to the device being an emulator) 
* Then after you set your food + dietary preference, go ahead and click set location, it will prompt you to input a radius and you can click done. 
* Now you're ready to spin. Click the back button and you will find yourself in the dashboard. From there click on Spin.
* Places should display on a stack and a spinner, click Spin when you are ready. Once the Spin is complete, you may accept or just click out. If you do accept it will take you back to the dashboard to do other things.

# Testing Files
The directory that these files are under is:
cs130/app/src/test/java/com/example/SpinIt/ for junit tests
cs130/app/src/androidTest/java/com/example/SpinIt/ for an instrumented test
