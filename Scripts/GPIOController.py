from RPi import GPIO
from gpiozero import Buzzer
import os
from time import sleep

class GPIOController:
    def __init__(self):
        self.BOMB = 19
        self.MOTOR_1 = 13
        self.MOTOR_2 = 6
        self.RESISTENCE_1 = 5
        self.RESISTENCE_2 = 11
        self.BUZZER = 22

        GPIO.cleanup()
        os.system('modprobe w1-gpio')
        os.system('modprobe w1-therm')
        GPIO.setmode(GPIO.BCM)

        GPIO.setup(self.BOMB, GPIO.OUT)
        GPIO.setup(self.MOTOR_1, GPIO.OUT)
        GPIO.setup(self.MOTOR_2, GPIO.OUT)
        GPIO.setup(self.RESISTENCE_1, GPIO.OUT)
        GPIO.setup(self.RESISTENCE_2, GPIO.OUT)
        self.buzzer = Buzzer(self.BUZZER)
    
    def setBomb(self, value):
        if value == True:
            GPIO.output(self.BOMB, GPIO.HIGH)
        else:
            GPIO.output(self.BOMB, GPIO.LOW)
    
    def setMotor1(self, value):
        if value == True:
            GPIO.output(self.MOTOR_1, GPIO.HIGH)
        else:
            GPIO.output(self.MOTOR_1, GPIO.LOW)

    def setMotor2(self, value):
        if value == True:
            GPIO.output(self.MOTOR_2, GPIO.HIGH)
        else:
            GPIO.output(self.MOTOR_2, GPIO.LOW)

    def setResistence1(self, value):
        if value == True:
            GPIO.output(self.RESISTENCE_1, GPIO.HIGH)
        else:
            GPIO.output(self.RESISTENCE_1, GPIO.LOW)

    def setResistence2(self, value):
        if value == True:
            GPIO.output(self.RESISTENCE_2, GPIO.HIGH)
        else:
            GPIO.output(self.RESISTENCE_2, GPIO.LOW)
        
    def buzzerBeep(self, secs):
        self.buzzer.on()
        sleep(secs)
        self.buzzer.off()
