import glob

class TemperatureSensors:
    def __init__(self):
        self.SENSORS_BASE_DIR = '/sys/bus/w1/devices'

        self.DEVICE_1_FOLDER = glob.glob(SENSORS_BASE_DIR + '28*')[0]
        self.DEVICE_1_FILE = DEVICE_1_FOLDER + '/w1_slave'

        self.DEVICE_2_FOLDER = glob.glob(SENSORS_BASE_DIR + '28*')[1]
        self.DEVICE_2_FILE = DEVICE_2_FOLDER + '/w1_slave'

    def getTank1Sensor(self):
        try:
            f = open(self.DEVICE_1_FILE, 'r')
            lines = f.readlines()
            f.close()
            address, temp = lines[1].split('t=')
        except:
            pass

        return temp/1000

    def getTank3Sensor(self):
        try:
            f = open(self.DEVICE_2_FILE, 'r')
            lines = f.readlines()
            f.close()
            address, temp = lines[1].split('t=')
        except:
            pass

        return temp/1000

