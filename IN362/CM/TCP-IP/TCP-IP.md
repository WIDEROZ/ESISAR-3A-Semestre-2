#### D

| 1   | (2, 9) |
| --- | ------ |
| 2   | -      |
| 3   | (2, 8) |
| 4   | (2, 8) |

#### R


| Réseaux | Prochain pas | Interface |
| ------- | ------------ | --------- |
| 1       | -            | r1        |
| 2       | -            | r2        |
| 3       | (2, 8)       | r2        |
| 4       | (2, 8)       | r2        |

#### A
| Réseaux | Prochain pas |
| ------- | ------------ |
| 1       | -            |
| 2       | (1, 9)       |
| 3       | (1, 9)       |
| 4       | (1, 9)       |

### Address resolution protocol (ARP)
"WHO_HAS (1, 9)" Sur l'adresse de broadcast. 
Le frérot qui a l'adresse lui répond

L'info est placé dans le cache de l'ARP

### RFC5735
#### Loopback
$$127.0.0.0/8$$

#### IP Locales
$$\begin{cases}
10.0.0.0/8 \\
172.16.0.0/12 \\
192.168.0.0/16
\end{cases}$$

#### Multicast
$$224.0.0.0/4$$

#### Cas particuliers
$$\begin{cases}
0.0.0.0&\text{Adresse non définie} \\
255.255.255.255&\text{Broadcast} \\
169.254.0.0/16&\text{DHCP ne fonctionne pas}
\end{cases}$$

### Trame Ethernet
![[Pasted image 20260402172255.png]]

#### 802.3
Si le type est inférieure à : $1500_{2}=5DC_{16}$ c'est une trame 802.3 (indique la longueur des donnés) 

#### Ethernet II
Si le type est supérieur à : $1536_{2} = 600_{16}$ c'est une trame Ethernet II (désigne alors le type)
- $0800_{16}$ : IPV4
- $0806_{16}$ : ARP (Adress Resolution protocol)
- $8035_{16}$ : RARP (reverse ARP)
- $86DD_{16}$ : IPV6

| Hexadecimal | Protocol                          |
| ----------- | --------------------------------- |
| $0800$      | IPV4                              |
| $0806$      | ARP (Address Resolution Protocol) |
| $8035$      | RARP (Reverse ARP)                |
| $86DD$      | IPV6                              |

##### En tête IPV4
![[Pasted image 20260402171058.png]]
