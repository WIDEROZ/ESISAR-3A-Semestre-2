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
Si on était sur un hub, on aurait probablement vu les communications de quelques adresses dans notre réseau qui ne nous sont pas destinés seulement, 