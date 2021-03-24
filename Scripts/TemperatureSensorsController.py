import glob, os

class TemperatureSensors:
    def __init__(self):
        os.system('modprobe w1-gpio')
        os.system('modprobe w1-therm')

        self.SENSORS_BASE_DIR = '/sys/bus/w1/devices'

        self.DEVICE_1_FOLDER = glob.glob(self.SENSORS_BASE_DIR + '28*')[0]
        self.DEVICE_1_FILE = self.DEVICE_1_FOLDER + '/w1_slave'

        self.DEVICE_2_FOLDER = glob.glob(self.SENSORS_BASE_DIR + '28*')[1]
        self.DEVICE_2_FILE = self.DEVICE_2_FOLDER + '/w1_slave'

    def getTank1Sensor(self):
        try:
            f = open(self.DEVICE_1_FILE, 'r')
            lines = f.readlines()
            f.close()
            address, temp = lines[1].split('t=')
        except:
            pass

        return round(int(temp/1000),1)

    def getTank3Sensor(self):
        try:
            f = open(self.DEVICE_2_FILE, 'r')
            lines = f.readlines()
            f.close()
            address, temp = lines[1].split('t=')
        except:
            pass

        return round(int(temp/1000),1)

