# Filtres Actifs
## Exercice 1
### I - Bode
#### 1. Fonction de transfert
On a une rétroaction négative alors $\varepsilon=0$ donc : 
$$u_{R_{2}} + u_{c} = V_{1}$$
Donc par la loi d'ohm : 
$$\begin{cases}
V_{2}=\left( R_{1}+R_{2}+\frac{1}{Cp} \right)i \\
V_{1}=\left(R_{2}+\frac{1}{Cp} \right)i
\end{cases}$$
Ainsi,
$$T(p) = \frac{R_{1}+R_{2}+\frac{1}{C p}}{R_{2} + \frac{1}{C p}} = \frac{Cp(R_{1}+R_{2})+1}{1+R_{2}Cp}$$
Avec $p=j\omega$.
Forme canonique : 
On pose : $\omega_{d}=  \frac{1}{R_{2}C}$ alors, 
$$T(p) =  \frac{+1}{}$$

#### 2. Conditions limites
$$T(0) = 1 \text{ et } T(p) \underset{p \to + \infty}{\sim} \frac{R_{1}+R_{2}}{R_{2}}$$
