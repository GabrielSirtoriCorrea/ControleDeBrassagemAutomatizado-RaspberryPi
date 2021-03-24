import json

path = './status.json'

def readStatus():
    file = open(path, 'r')
    return json.load(file)

def writeStatus(tank, target, value):
    status = readStatus()
    if tank == None:
        status[target] = value
    else:
        status[tank][target] = value
    file = open(path, 'w')
    json.dump(status, file)

