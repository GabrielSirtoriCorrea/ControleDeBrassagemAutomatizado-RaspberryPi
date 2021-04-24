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
    tempTank1, tempTank3, lastTempTank1, lastTempTank3 = (0,0,0,0)
    while True:
        try:
            tempTank1 = int(temperatureSensors.getTank1Sensor())
            tempTank3 = int(temperatureSensors.getTank3Sensor())
            if tempTank1 != lastTempTank1:
                StatusController.writeStatus('Tank1', 'Temperature', temperatureSensors.getTank1Sensor())
            
            if tempTank3 != lastTempTank3:
                StatusController.writeStatus('Tank3', 'Temperature', temperatureSensors.getTank3Sensor())

            lastTempTank1 = tempTank1
            lastTempTank3 = tempTank3

            gpioController.setBomb(StatusController.readStatus()['Bomb'])
            gpioController.setMotor1(StatusController.readStatus()['Tank1']['Motor'])
            gpioController.setMotor2(StatusController.readStatus()['Tank2']['Motor'])
            gpioController.setResistence1(StatusController.readStatus()['Tank1']['Resistence'])
            gpioController.setResistence2(StatusController.readStatus()['Tank3']['Resistence'])
            print(tempTank1)
            print(tempTank3)
        except:
            pass

def brew():
    while True:
        try:
            sleep(1)
            print('Lendo Status')
            status =  StatusController.readStatus()
            if status['BrewStatus'] ==  'Em andamento' and status['BrewMode'] == 'Automatic':
                StatusController.writeStatus('Tank1', 'Motor', True)
                print('Motor 1 ligado')
                temperature  =  status['Tank1']['Temperature']
                setPoint = status['Tank1']['SetPoint']

                while temperature +1 < setPoint:
                    print('Setpoint')
                    StatusController.writeStatus('Tank1', 'Resistence', True)
                    sleep(0.5)
                    temperature  =  StatusController.readStatus()['Tank1']['Temperature']
                    
                StatusController.writeStatus('Tank1', 'Resistence', False)
                sleep(0.5)
                StatusController.writeStatus('Tank1', 'MaltAlert', True)
                print('Adicionar malte')
                sleep(0.5)
                StatusController.writeStatus('Tank1', 'MaltAlert', False)
                sleep(0.5)

                actualRamp = 1
                for malt in status['Tank1']['Ramps']:
                    print('Rampa ', actualRamp)
                    StatusController.writeStatus('Tank1', 'ActualRamp', actualRamp)
                    sleep(0.5)
                    StatusController.writeStatus('Tank1', 'SetPoint', malt[0])
                    sleep(0.5)
                    temperature  =  StatusController.readStatus()['Tank1']['Temperature']
                    setPoint = malt[0]
                    endTime = time() + malt[1]*60

                    while time() < endTime:
                        if temperature < setPoint:
                            StatusController.writeStatus('Tank1', 'Resistence', True)
                        else:
                            StatusController.writeStatus('Tank1', 'Resistence', False)

                            temperature = StatusController.readStatus()['Tank1']['Temperature']

                    actualRamp+=1

                StatusController.writeStatus('Tank1', 'Motor', False)
                StatusController.writeStatus('Tank1', 'NextProcess', True)
                StatusController.writeStatus(None, 'Bomb', True)
                print('Bomba Ligada')
                print('Proximo processo')
                sleep(0.35)
                StatusController.writeStatus('Tank1', 'NextProcess', False)

                StatusController.writeStatus('Tank2', 'Motor', True)
                print('Motor 2 ligado, Clarificação')
                sleep(StatusController.readStatus()['Tank2']['ClarificationTime']*60)
                StatusController.writeStatus('Tank2', 'NextProcess', True)
                print('Proximo processo')
                sleep(0.5)
                StatusController.writeStatus('Tank2', 'NextProcess', False)

                status = StatusController.readStatus()
                print('status atual: ', status)
                temperature  =  status['Tank3']['Temperature']
                setPoint = status['Tank3']['SetPoint']
                boilTime = time() + (status['Tank3']['BoilTime']*60)
                clock = time()
                hops = status['Tank3']['Hops']

                while time() < boilTime:
                    print(hops)
                    if temperature + 2 < setPoint:
                        StatusController.writeStatus('Tank3', 'Resistence', True)
                    else:
                        StatusController.writeStatus('Tank3', 'Resistence', False)

                    if len(hops) != 0 and time() >= clock + (hops[0]*60):
                        hops.pop(0)
                        print('Adicionar Lupulo')
                        StatusController.writeStatus('Tank3', 'HopAlert', True)
                        sleep(0.4)
                        StatusController.writeStatus('Tank3', 'HopAlert', False)
                
                StatusController.writeStatus('Tank3', 'NextProcess', True)
                print('Proximo processo')
                StatusController.writeStatus(None, 'BrewStatus', 'Pausado')
                sleep(0.5)
                StatusController.writeStatus('Tank3', 'NextProcess', False)
                sleep(15)
        
        except:
            pass

StatusController.resetStatus()
Thread(target=statusSync).start()
Thread(target=startInterface).start()
Thread(target=brew).start()

