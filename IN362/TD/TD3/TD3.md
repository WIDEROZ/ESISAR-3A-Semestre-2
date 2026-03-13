# Exercice 1
$$0x200 \leq 0x 600$$
Ainsi c'est une trame Ethernet $\boxed{\text{IEEE }802.3}$

# Exercice 2
#### Question 1
S1, S2, S3 : Switchs
A, B, C, D : Machines

#### Question 2
B, C, D

##### S1 
| Machine | Mac               | Interface |
| ------- | ----------------- | --------- |
| A       | 34:67:BE:62:82:10 | seg1      |
| B       |                   | seg2      |
| D       |                   | seg2      |

##### S2
| Machine | Mac               | Interface |
| ------- | ----------------- | --------- |
| A       | 34:67:BE:62:82:10 | seg2      |
| B       |                   | seg3      |
| C       |                   | seg4      |
| D       |                   | seg4      |

##### S3
| Machine | Mac               | Interface |
| ------- | ----------------- | --------- |
| A       | 34:67:BE:62:82:10 | seg4      |
| C       |                   | seg5      |
| D       |                   | seg6      |

#### Question 3
01.02.03.04.05.06
OR $01_{10} = 0000 \, 0001$ 
Alors, comme le dernier bit est égal à $1$, la trame est envoyé à un groupe de machines (multicast)
De plus, l'avant dernier bit est nul donc l'adresse MAC est universelle (ie elle est extérieure au réseau)

Ainsi ni B, C ou D ne recevra la trame

#### Question 4
Sur le segment $2$ ou tous les autres segments autres que $1$ qui ne sont pas visibles sur le schéma. 

#### Question 5
Toutes les trames adressés à $A$, vont passer par le segment $1$ (via le S1) jusqu'à ce que la machine $A$ envoie une trame qui va être reçue par S3 et donc qui va mettre à jour sa table. De même pour les autres switch lorsqu'une trame passent par ceux-ci.

# Exercice 3
| Trame     | Qui reçoit      | Insertion dans le tableau VLAN? | Nature de l’insertion (qui est inséré,<br>sur quelle interface) |
| --------- | --------------- | ------------------------------- | --------------------------------------------------------------- |
| $A \to B$ | $F, E, I, G, B$ | Oui                             | A sur interface $1$, Bleu                                       |
| $B \to A$ | $A$             | Oui                             | $B$ sur interface $3$, Bleu                                     |
| $I\to A$  | $E, F, G$       | Oui                             | $I$ sur interface $4$, Vert                                     |
| $G \to I$ | $I$             | Oui                             | $G$ sur interface $7$, Vert                                     |
| $H \to C$ | $A, B, C, D, L$ | Oui                             | $H$ sur interface $8$, Bleu                                     |
| $C \to A$ | $A$             | Oui                             | $C$ sur interface $5$, Bleu                                     |
| $J \to B$ | $K$             | Oui                             | $J$ sur interface $9$, orange                                   |
| $J \to K$ | $K$             | Non                             |                                                                 |
| $F \to E$ | $E, I, G$       | Oui                             | $F$ sur interface $12$, Vert                                    |
| $G \to F$ | $F$             | Non                             |                                                                 |

##### Table de commutation VLAN
Table Bleue : 

| Adresse | Interface |
| ------- | --------- |
| A       | 1         |
| B       | 3         |
| H       | 8         |
| C       | 5         |

Table Verte :

| Adresse | Interface |
| ------- | --------- |
| I       | 4         |
| G       | 7         |
| F       | 12        |

Table Orange :

| Adresse | Interface |
| ------- | --------- |
| J       | 9         |

##### Si $H$ n'est pas dans le même VLAN que $F$

| Trame                                        | Qui reçoit      | Insertion dans le tableau VLAN? | Nature de l’insertion (qui est inséré,<br>sur quelle interface) |
| -------------------------------------------- | --------------- | ------------------------------- | --------------------------------------------------------------- |
| $H (\text{as } G)$<br>$\to \text{Broadcast}$ | $A, B, C, D, L$ | Oui                             | $G$ sur l'interface $8$, Bleu                                   |
| $F \to G$                                    | $G$             | Non                             |                                                                 |


##### Si $H$ est dans le même VLAN que $F$

| Trame                                        | Qui reçoit         | Insertion dans le tableau VLAN? | Nature de l’insertion (qui est inséré,<br>sur quelle interface) |
| -------------------------------------------- | ------------------ | ------------------------------- | --------------------------------------------------------------- |
| $H (\text{as } G)$<br>$\to \text{Broadcast}$ | $E, G, F$          | Oui                             | $G$ sur l'interface $4$, Vert                                   |
| $F \to G$                                    | $H (\text{as } G)$ | Non                             |                                                                 |

#### Communications VLAN entre deux switches
##### On double le nombre de stations
Il faut donc réserver une interface pour la communication VLAN entre chaque switch. 
C'est sécurisé car c'est une communication de niveau $2$ uniquement entre deux switches. 


##### Ajout etiquette
Le switch ajoute quelques octets pour indiquer a l'autre switch dans quel VLAN il est. 



