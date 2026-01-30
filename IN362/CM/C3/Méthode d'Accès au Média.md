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
- Utilisation de code (chipping sequence), leur somme deux à deux doit être nulle et être reconnus par le récepteur. 
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
- rien : il envoie $0$

De même pour $B$ et $C$.
Pour retrouver si $A$ envoie $0$ $1$ ou rien on fait un produit de convolution avec un autre signal :
$$A * B = \sum_{i \in [\![1, 4]\!]}(a_{i} - b_{i})a_{i}$$








## 2. Méthode d'allocation dynamique