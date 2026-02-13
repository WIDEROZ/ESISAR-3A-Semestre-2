# Exercice $2$
$100 Mbit.s^{-1}$
On veut charger ce réseau a $p=1000$ trames par secondes

La probabilité que $k$ trames soient générés par l'ensemble des stations présentes pendant une durée $T$ est : 
$$\mathbb{P}(X = k) = \frac{(pT)^{k}}{k!} e^{ -pT }$$

#### Question $1$
Trame maximale ethernet : $1518 o$
$$D = \frac{1.518 \times 8}{100 \, 000} = 121.14\times 10^{-6} s = 1.158 \, \mu s$$
$$d = 1000D = 0.121 = 12\%$$

#### Question $5$
$T=\frac{l}{v_{p}}$ 
$$\mathbb{P}(X\geq2) = \sum_{k = 2}^{+ \infty}\frac{(pT)^{k}}{k!} e^{ -pT }$$
