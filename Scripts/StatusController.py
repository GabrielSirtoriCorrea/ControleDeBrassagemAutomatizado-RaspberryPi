import json
from time import sleep

path = '../status.json'

def readStatus():
    file = open(path, 'r')
    sleep(0.25)
    return json.load(file)

def writeStatus(tank, target, value):
    status = readStatus()
    sleep(0.25)
    if tank == None:
        status[target] = value
    else:
        status[tank][target] = value
    file = open(path, 'w')
    json.dump(status, file)

def resetStatus():
    defaultStatus = {'BrewStatus':'Pausado','Tank3':{'Temperature':0,'NextProcess':False,'Hops':[0,0,0],'BoilTime':0,'SetPoint':0,'Resistence':False,'HopAlert':False},'Tank2':{'ClarificationTime':0,'Motor':False,'NextProcess':False},'BrewMode':'Automatic','Tank1':{'Ramps':[[0,0],[0,0]],'MaltAlert':False,'Temperature':0,'Motor':False,'NextProcess':False,'SetPoint':0,'ActualRamp':0,'Resistence':False},'Bomb':False}
    file = open(path, 'w')
    json.dump(defaultStatus, file)
    sleep(0.25)
