#include <SoftwareSerial.h>
SoftwareSerial Bluetooth(2,3);

char c=' ';
void setup() 
{
  Serial.begin(9600);
  Serial.println("ready");
  Bluetooth.begin(9600);
}

void loop() 
{
  if(Bluetooth.available())
  {
    c=Bluetooth.read();
    Serial.write(c);
  }
  if(Serial.available())
  {
    c=Serial.read();
    Bluetooth.write(c);
  }
}
