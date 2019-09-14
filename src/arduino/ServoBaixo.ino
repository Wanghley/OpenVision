#include <Servo.h>

Servo servo_6;
int angMax = 180;//180 servo de baixo
int angMin = 90;//90 servo de baixo
int angMed = 135;
void setup()
{
  pinMode(13, OUTPUT);
  servo_6.attach(6);
  //ang = 0;
  servo_6.write(135);
  Serial.begin(9600);
}

void loop()
{
  //servo_6.write(0);
  //delay(1000); // Delay a little bit to improve simulation performance
  //ang = ang + 10;
  for(int i = angMed;i<angMax;i++){
    Serial.println(i);
    servo_6.write(i);
    delay(10);
  }
  delay(2000);
  for(int i = angMax;i>=angMed;i--){
    Serial.println(i);
    servo_6.write(i);
    delay(10);
  }
  delay(2000);
  for(int i = angMed;i>=angMin;i--){
    Serial.println(i);
    servo_6.write(i);
    delay(10);
  }
  delay(2000);
  for(int i = angMin;i<=angMed;i++){
    Serial.println(i);
    servo_6.write(i);
    delay(10);
  }
}
