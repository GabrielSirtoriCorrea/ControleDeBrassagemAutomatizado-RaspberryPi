from threading import Thread
import glob, TemperatureSensorsController, GPIOController, StatusController

temperatureSensors = TemperatureSensorsController.TemperatureSensors()
gpioController = GPIOController()

def statusSync():   
    StatusController.writeStatus('Tank1', 'Temperature', temperatureSensors.getTank1Sensor())
    StatusController.writeStatus('Tank3', 'Temperature', temperatureSensors.getTank3Sensor())

    gpioController.setBomb(StatusController.readStatus()['Bomb'])
    gpioController.setMotor1(StatusController.readStatus()['Tank1']['Motor'])
    gpioController.setMotor2(StatusController.readStatus()['Tank2']['Motor'])
    gpioController.setResistence1(StatusController.readStatus()['Tank1']['Resistence'])
    gpioController.setResistence2(StatusController.readStatus()['Tank3']['Resistence'])

Thread(target=statusSync).start()

'''def abc():
    while True:
        print("abc")

def xyz():
    while True:
        print("xyz")

Thread(target=abc).start()'''