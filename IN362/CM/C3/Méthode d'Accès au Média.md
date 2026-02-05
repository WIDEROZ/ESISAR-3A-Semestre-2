# I. Différentes méthodes d'allocation
## 1. Méthode d'allocation statique
- On répartit un nombre de ressources fixes pour les stations

### a. TMDA - Time division Access
- (AMRT Accès Multiple à Répartition Temporelle)
- L'accès est réparti avec des tranches de temps égal et on assigne une machine à un slot de temps

### b. FDMA - Frequency Division Multiple Access
- (AMRF Accès Multiple à Répartition Fréquentielle)
- La bande passante est découpée en sous-bandes 
- Une sous fréquence est affectée de manière exclusive à une machine


### c. CDMA - Code Division Multiple Access
- Toutes les stations peuvent émettre en même temps sur l'ensemble du media (fréquence)
- Utilisation de code (chipping sequence), ils doivent être orthogonaux entre eux et être reconnus par le récepteur. 
- Les envois en donnés doivent être synchronisés

###### Exemple
Code des machines : 
$$\begin{cases}
A = \{ -1, 1, 1, -1 \} \\
B = \{ 1, -1, 1, -1 \} \\
C = \{ 1, 1, -1, -1 \}
\end{cases}$$

Si $A$ veut envoyer :
- bit $1$ : alors il envoie son code
- bit $0$ : il envoie l'opposé de son code
- rien : il envoie $\{ 0, 0, 0, 0 \}$

De même pour $B$ et $C$.
Pour retrouver si $A$ envoie $0$ $1$ ou rien on fait un produit de convolution avec un autre signal :
$$A * B = \sum_{i \in [\![1, 4]\!]}(a_{i} - b_{i})a_{i} = \begin{cases}
0 & \text{si il n'y a pas de signal envoyé} \\
\geq 0& \text{si A à envoyé 1} \\
\leq 0& \text{si A à envoyé 0}
\end{cases}$$



## 2. Méthode d'allocation dynamique
Diapo 19-27

### b. CSMA - Carrier Sense Multiple Access
#### CSMA $p$-persistant
On vérifie si le canal est libre si oui la machine émet avec une probabilité de $p$, si elle n'a pas décidé d'émettre alors on attend un slot de temps et on vérifie si le canal est occupé.
![[Pasted image 20260130121036.png]]


#### CSMA/CD (Collision detection)
- $1$-persistant
- Détecte les collision
- Le média doit écouter en même temps d'émettre
Principe d'Ethernet : IEEE $802.3$
![[Pasted image 20260205110531.png]]
###### Backoff (Binary Exponential Backoff ou truncated BEB)
- Tire un numéro $N$ entre $0$ et $2^{k-1}$ avec $k$ le nombre de transmissions échoués puis au bout $N$ intervalles de temps la machine émet.

#### CSMA/CA (Collision Avoidance)
- $p$-persistant
- $p = \frac{1}{n-1}$ 