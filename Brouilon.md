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

[    0.020619] /axi/pcie@120000/rp1/i2c@80000/imx296@1a: Fixed dependency cycle(s) with /axi/pcie@120000/rp1/csi@128000  
[    0.020749] /axi/pcie@120000/rp1/csi@128000: Fixed dependency cycle(s) with /axi/pcie@120000/rp1/i2c@80000/imx296@1a  
[    0.021320] /axi/pcie@120000/rp1/i2c@80000/imx296@1a: Fixed dependency cycle(s) with /axi/pcie@120000/rp1/csi@128000  
[    0.021453] /axi/pcie@120000/rp1/csi@128000: Fixed dependency cycle(s) with /axi/pcie@120000/rp1/i2c@80000/imx296@1a  
[    0.706022] /axi/pcie@120000/rp1/i2c@80000/imx296@1a: Fixed dependency cycle(s) with /axi/pcie@120000/rp1/csi@128000  
[    0.708695] /axi/pcie@120000/rp1/i2c@80000/imx296@1a: Fixed dependency cycle(s) with /axi/pcie@120000/rp1/csi@128000  
[    0.708719] /axi/pcie@120000/rp1/csi@128000: Fixed dependency cycle(s) with /axi/pcie@120000/rp1/i2c@80000/imx296@1a  
[    4.363150] rp1-cfe 1f00128000.csi: found subdevice /axi/pcie@120000/rp1/i2c@80000/imx296@1a  
[    5.857869] imx296 11-0064: 8-bit write to 0x3000 failed: -110  
[    5.857877] imx296 11-0064: failed to get sensor out of standby (-110)  

[    5.858437] imx296: probe of 11-0064 failed with error -110
[/code]

Here is the I2C bus scan :
[code] 
i2cdetect -y 10

     0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f  
00:                         -- -- -- -- -- -- -- --  
10: UU -- -- -- -- -- -- -- -- -- -- -- -- -- -- --  
20: -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --  
30: -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --  
40: -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --  
50: -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --  
60: -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --  
70: -- -- -- -- -- -- -- --
[/code]
Here is the list of cameras recognized by libcamera : 
[code]
rpicam-still --list-cameras

Available cameras  
-----------------  
0 : imx219 [3280x2464 10-bit RGGB] (/base/axi/pcie@120000/rp1/i2c@88000/imx219@10)  
    Modes: 'SRGGB10_CSI2P' : 640x480 [103.33 fps - (1000, 752)/1280x960 crop]  
                             1640x1232 [41.85 fps - (0, 0)/3280x2464 crop]  
                             1920x1080 [47.57 fps - (680, 152)/1920x2160 crop]  
                             3280x2464 [21.19 fps - (0, 0)/3280x2464 crop]  
           'SRGGB8' : 640x480 [103.33 fps - (1000, 752)/1280x960 crop]  
                      1640x1232 [41.85 fps - (0, 0)/3280x2464 crop]  
                      1920x1080 [47.57 fps - (680, 152)/1920x2160 crop]  
                      3280x2464 [21.19 fps - (0, 0)/3280x2464 crop]
[/code]