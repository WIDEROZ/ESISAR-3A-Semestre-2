#### Question 1

$$\begin{cases}
\text{lo} &: \text{00:00:00:00:00:00} \\
\text{eth0}& : \text{a0:f3:c1:10:87:73} \\
\text{eth1} &: \text{00:10:18:4e:71:9e} \\
\text{eth2} &: \text{8c:ec:4b:bc:08:b5}
\end{cases}$$
#### Question 2
A faire en root
La commande pour configurer l'interface :
```bash
ifdown eth0
```
- Si `eth0` avait une **IP statique** définie dans `/etc/network/interfaces`, cette IP est libérée.
- Si `eth0` utilisait **DHCP**, la commande peut envoyer un signal pour libérer l'adresse IP

La commande pour rendre l'interface up est : 
```bash
ip link set dev eth1 up
```
La commande pour obtenir une adresse IP sur eth1 : 
```bash
dhcpcd -4 -n eth1
```
- `-4` : ipv4
- `-n` : Ne configure pas les routes

##### Question 3
Routeur, 
$$\text{192.168.130.254} \text{ et } \text{4e:9e:12:8b:6f:9b}$$

#### Question 4
eth1 permet d’accéder à l'équipement qui accède internet
$$\begin{cases}
\text{eth1} &: \text{00:10:18:4e:71:9e} & \text{192.168.130.132}
\end{cases}$$

#### Question 5
Groupe 6

# Manipulation 1
#### Question 1
Niveau 1
Le prof est pas sur le même sous réseau

#### Question 2
On met notre adresse ip en statique
```bash
ip link set dev eth0 up
ip addr add dev eth0 192.168.2.6/24
```


#### Question 3
![[Pasted image 20260402172255.png]]
Le checksum manquait

#### Question 4
```bash
ethtool -K eth0 rx-fcs
```
rx : recevoir
fcs : frame check sequence


C'est la carte réseau qui gérait le ckecksum


#### Question 5.1
Oui, car on est sur un hub.

#### Question 5.2
On reçoit des broadcast de type Etheret DIX V2
Ping : $8$

On reçoit les checksum faux car notre carte ne vérifie pas le checksum. 

Erreur : 
FCS incorrect

#### Question 8
FCS incorrect
eth.check_fcs = TRUE

#### Question 9
Elle permet de voir les paquets 


```bash
netstat -in
```

RX-OK = 70776
RX-ERR = 1474
Nombre de paquets

2 % d'erreur

#### Question 10
ché pas

#### Question 12
La carte eth doit être dans un mode spécial (listening).

# Manipulation 2
#### Question 1
Non, car le switch va jeter les messages qui ne nous sont pas adressés. 

#### Question 2
Oui
#### Question 3
Le switch jette les paquets fcs error. 9

#### Question 4
NON car il les jette
Le mode est en store and forward

#### Question 5
Non

#### Question 6
Oui on voit que ça
$$\text{MAC : 9c:4e:20:9e:ed:82}$$

# Manipulation 3
#### Question 1
Non, on ne peut pas communiquer avec le prof. On doit placer le port de sortie du switch sur le même VLAN que celui du port dirigé vers la machine pour pouvoir communiquer avec le prof.

# Manipulations 4

