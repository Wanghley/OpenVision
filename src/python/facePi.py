# AUTHORS: Eric Loges Binsfeld, Wanghley Soares Martins
# Based in the https://cdn.instructables.com/ORIG/FYD/LHQ7/JLWKQJXX/FYDLHQ7JLWKQJXX.py code
# OpenSource Software
# Be free to use and distribuite, but remember to give recognition to the author 


#import all the required modules
import numpy as np
#import serial
import time
from time import sleep
import sys
import cv2

#GPIO
import RPi.GPIO as GPIO

#
GPIO.setmode(GPIO.BOARD)
GPIO.setup(11, GPIO.OUT)
GPIO.setup(12, GPIO.OUT)

#A - vertical
pwma=GPIO.PWM(11, 50)
pwma.start(0)

#B - horizontal
pwmb=GPIO.PWM(12, 50)
pwmb.start(0)

#anguloA
def SetAngleA(angle):
        duty = angle / 18 + 2
        GPIO.output(11, True)
        pwma.ChangeDutyCycle(duty)
        sleep(0.1)
	GPIO.output(11, False)
        pwma.ChangeDutyCycle(0)

#anguloB
def SetAngleB(angle):
        duty = angle / 18 + 2
        GPIO.output(12, True)
        pwmb.ChangeDutyCycle(duty)
        sleep(0.1)
	GPIO.output(12, False)
        pwmb.ChangeDutyCycle(0)
#servoA #Base #vertical
SetAngleA(160) #160 = centro #100 = MaxCima #180 = MaxBaixo
servoA = 140

#servoB #braco #horizontal
SetAngleB(110) #110 = centro #160 = MaxEsquerda #40 = MaxDireita
servoB = 110


#sys.path.append('/usr/local/lib/python2.7/site-packages')
#Setup Communication path for arduino (In place of 'COM5' (windows) or ''/dev/tty.usbmodemxxx' (mac) put the port to which your arduino is connected)
#arduino = serial.Serial(port='/dev/ttyUSB0', baudrate=9600)
#time.sleep(2)
#print("Connected to Arduino...")

#importing the Haarcascade for face detection
face_cascade = cv2.CascadeClassifier('haarcascade frontalface.xml')

#To capture the video stream from webcam.
cap = cv2.VideoCapture(0)
print("Getting camera image...")

#Read the captured image, convert it to Gray image and find faces
while 1:
    ret, img = cap.read()
    img = cv2.flip(img, 1)
    cv2.namedWindow('OpenVision v0.0.2', cv2.WINDOW_NORMAL)
    #cv2.resizeWindow('img', 500,500)
    cv2.line(img,(500,250),(0,250),(0,255,0),1)
    cv2.line(img,(250,0),(250,500),(0,255,0),1)
    cv2.circle(img, (250, 250), 5, (255, 255, 255), -1)

    cv2.circle(img, (640, 250), 5, (255, 255, 255), -1)

    gray  = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.3)

#detect the face and make a rectangle around it.
    for (x,y,w,h) in faces:
        cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),5)
        roi_gray  = gray[y:y+h, x:x+w]
        roi_color = img[y:y+h, x:x+w]

        arr = {y:y+h, x:x+w}
        print (arr)

        print ('X :' +str(x))
        print ('Y :'+str(y))
        print ('x+w :' +str(x+w))
        print ('y+h :' +str(y+h))

# Center of roi (Rectangle)
        xx = int((x+(x+h)/2))
        yy = int((y+(y+w)/2))
        xx = xx
        print (xx)
        print (yy)
        center = (xx,yy)
	#tamanho total 500 x 640 #centro = 250 x 320
	if xx > 420:
		servoB = servoB + 1
		SetAngleB(servoB)
		sleep(0.5)
	if xx < 220:
		servoB = servoB - 1
		SetAngleB(servoB)
		sleep(0.5)
	if yy > 350:
		servoA = servoA + 1
		SetAngleA(servoA)
		sleep(0.5)
	if yy < 150:
		servoA = servoA - 1
		SetAngleA(servoA)
		sleep(0.5)

# sending data to arduino
#        print("Center of Rectangle is :", center)
#        data = "X{0:d}Y{1:d}Z".format(xx, yy)
#        print ("output = '" +data+ "'")
        ##arduino.write(data.encode())
        ##time.sleep(0.5)

#Display the stream.
    cv2.imshow('OpenVision v0.0.2',img)

#Hit 'Esc' to terminate execution
    k = cv2.waitKey(30) & 0xff
    if k == 27:
       pwma.stop()
       pwmb.stop()
       GPIO.cleanup()
       break
