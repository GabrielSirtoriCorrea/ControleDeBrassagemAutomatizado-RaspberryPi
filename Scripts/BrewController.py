from threading import Thread
import glob, os
from time import sleep, time
from TemperatureSensorsController import TemperatureSensors
import StatusController
from GPIOController import GPIOController

temperatureSensors = TemperatureSensors()
gpioController = GPIOController()

def startInterface():
    os.system('java -jar ../Interface/dist/Interface.jar')

def statusSync():
    while True:
        StatusController.writeStatus('Tank1', 'Temperature', temperatureSensors.getTank1Sensor())
        StatusController.writeStatus('Tank3', 'Temperature', temperatureSensors.getTank3Sensor())

        gpioController.setBomb(StatusController.readStatus()['Bomb'])
        gpioController.setMotor1(StatusController.readStatus()['Tank1']['Motor'])
        gpioController.setMotor2(StatusController.readStatus()['Tank2']['Motor'])
        gpioController.setResistence1(StatusController.readStatus()['Tank1']['Resistence'])
        gpioController.setResistence2(StatusController.readStatus()['Tank3']['Resistence'])
        print(temperatureSensors.getTank1Sensor())

def brew():
    status =  StatusController.readStatus()
    if status['BrewStatus'] ==  'Em andamento' and status['BrewMode'] == 'Automatic':
        StatusController.writeStatus('Tank1', 'Motor', True)
        temperature  =  status['Tank1']['Temperature']
        setPoint = status['Tank1']['setPoint']

        while temperature < setPoint:
            if setPoint - 3 <=  temperature:
                StatusController.writeStatus('Tank1', 'Resistence', True)
                sleep(15)
                StatusController.writeStatus('Tank1', 'Resistence', False)
                sleep(15)
            else:
                StatusController.writeStatus('Tank1', 'Resistence', True)

            temperature  =  StatusController.readStatus()['Tank1']['Temperature']
            
        StatusController.writeStatus('Tank1', 'Resistence', False)
        StatusController.writeStatus('Tank1', 'MaltAlert', True)
        sleep(15)

        actualRamp = 1
        for malt in status['Tank1', 'Ramps']:
            StatusController.writeStatus('Tank1', 'ActualRamp', actualRamp)
            StatusController.writeStatus('Tank1', 'setPoint', malt[0])
            temperature  =  StatusController.readStatus()['Tank1']['Temperature']
            setPoint = malt[0]
            endTime = time() + malt[1]*60

            while time() < endTime:
                if temperature < setPoint:
                    if setPoint - 3 <=  temperature:
                        StatusController.writeStatus('Tank1', 'Resistence', True)
                        sleep(15)
                        StatusController.writeStatus('Tank1', 'Resistence', False)
                        sleep(15)
                    else:
                        StatusController.writeStatus('Tank1', 'Resistence', True)
                else:
                    StatusController.writeStatus('Tank1', 'Resistence', False)

                    temperature  =  StatusController.readStatus()['Tank1']['Temperature']

            actualRamp+=1

        StatusController.writeStatus('Tank1', 'NextProcess', True)
        StatusController.writeStatus('Tank1', 'Bomb', True)
        sleep(15)

        StatusController.writeStatus('Tank2', 'Motor', True)
        sleep(StatusController.readStatus()['Tank2']['ClarificationTime'])
        StatusController.writeStatus('Tank2', 'NextProcess', True)
        sleep(15)

        status = StatusController.readStatus()

        temperature  =  status['Tank3']['Temperature']
        setPoint = status['Tank3']['setPoint']
        boilTime = time() + status['Tank3']['BoilTime']

        while time() < boilTime:
            for hopTime in status['Tank3']['Hops']:
                if temperature < setPoint:
                    StatusController.writeStatus('Tank3', 'Resistence', True)
                else:
                    StatusController.writeStatus('Tank3', 'Resistence', False)

                

                temperature  =  StatusController.readStatus()['Tank3']['Temperature']

Thread(target=statusSync).start()
Thread(target=startInterface).start()
Thread(target=brew).start()

