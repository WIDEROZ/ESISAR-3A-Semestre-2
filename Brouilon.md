Hello everyone!
I want to connect 2 cameras on my Raspberry pi 5, the first one is working well (imx219) but i have an issue with the second imx296 camera
Here is my setup :
- Raspberry Pi 5 16Go
- Ubuntu Desktop 24.04.3 LTS downloaded with the raspberry Pi download imager (for raspberry with 4Gb+)
- 6.8.0-1044-raspi
- imx296 Global Shutter


Here is the kernel messages :
[code]
dmesg | grep imx296

[/code]

Here is the I2C bus scan :
[code] 
i2cdetect -y 10

[/code]
Here is the list of cameras recognized by libcamera : 
[code]
rpicam-still --list-cameras

[/code]