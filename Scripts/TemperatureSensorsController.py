import glob

class TemperatureSensors:
    def __init__(self):
        self.SENSORS_BASE_DIR = '/sys/bus/w1/devices'

        self.DEVICE_1_FOLDER = glob.glob(self.SENSORS_BASE_DIR + '28*')[0]
        self.DEVICE_1_FILE = self.DEVICE_1_FOLDER + '/w1_slave'

        self.DEVICE_2_FOLDER = glob.glob(self.SENSORS_BASE_DIR + '28*')[1]
        self.DEVICE_2_FILE = self.DEVICE_2_FOLDER + '/w1_slave'

    def getTank1Sensor(self):
        try:
            self.f = open(self.DEVICE_1_FILE, 'r')
            self.lines = f.readlines()
            self.f.close()
            self.address, self.temp = lines[1].split('t=')
        except:
            pass

        return self.temp/1000

    def getTank3Sensor(self):
        try:
            self.f = open(self.DEVICE_2_FILE, 'r')
            self.lines = f.readlines()
            self.f.close()
            self.address, self.temp = lines[1].split('t=')
        except:
            pass

        return self.temp/1000

