# Premières manipulations
#### Interface lo
C'est une interface virtuelle (localhost se sert de ce device) qui permet à la machine de communiquer avec elle même. 

#### Interface eth0
Adresse MAC : a0:f3:c1:10:87:73

# Observations de protocoles ethernet
#### 1.
Norme Ethernet $2$
$14$ octets au début de la trame
et $IEEE$ 802.3
$14$ octets au début de la trame et $8$ octets a la fin

#### 2.
C'est le nombre d'octets des informations des couches supérieures. 

#### 3.
C'est la couche liaison, le protocole se nomme logical link Control

#### 4.
Les protocoles propriétaires sont les trames qui contiennent un OUI (Organisation Unique Identifier) et un PID (Protocol Identifier) 

### Ethernet commuté ou pas commuté
#### 5.
Si on était sur un hub, on aurait probablement vu les communications de quelques adresses dans notre réseau qui ne nous sont pas destinés seulement il n'y en a aucune, soit on a pas eu de chance, soit on est dans la configuration $C$ (Machines connecté a des switch uniquement)

#### 6.
On remarque que on est en full duplex on ne peut donc pas être connecté directement à un hub

#### 7.
On est la couche liaison au maximum dans la salle de TP. 

# Observations de protocoles IP
#### Adresse ip eth0
192.168.130.6

#### 8.
On utilise un protocole réseau : Internet Protocol Version 4
Ainsi on passe donc par un routeur. 

#### 9.
$$\boxed{\begin{array}{c}
\boxed{\begin{array}{c}
\boxed{\begin{array}{c}
\boxed{\begin{array}{c}
\text{ICMP - Internet Control}  \\
\text{Message Protocol (couche donnés)}
\end{array}} \\
\text{IPV4 (couche réseau)}
\end{array}} \\
\text{Ethernet II (couche liaison)}
\end{array}} \\
\text{98 Bytes (Couche physique)}
\end{array}}$$

On a $20$ octets pour $1$ Adresse (on a deux adresses)

#### 10.
Oui 

### 11.
Routeur entre les salles : 192.168.130.213
Routeur internet (par défaut) : 192.168.130.254

#### 12.
L'adresse MAC est celle du routeur internet de l'école

# Bases de donnés publiques
#### 13.