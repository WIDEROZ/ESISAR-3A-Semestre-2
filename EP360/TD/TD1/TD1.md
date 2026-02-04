# Filtres Actifs
## Exercice 1
EXCAL 1
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
On pose : $\omega_{d}=  \frac{1}{R_{2}C}$ et $\omega_{n} = \frac{1}{(R_{1}+R_{2})C} = \frac{\omega_{d}}{10}$ alors, 
$$\boxed{T(p) =  \frac{\frac{p}{\omega_{n}}+1}{1+\frac{p}{\omega_{d}}}}$$


#### 2. Conditions limites
$$T(0) = 1 \text{ et } T(p) \underset{p \to + \infty}{\sim} \frac{R_{1}+R_{2}}{R_{2}}$$

#### 3. Diagramme de Bode
EXCAL 2 : Diagramme asymptotique
$$G_{dB} = 20 \log(\left| T(p)\right|) = 20\log\left( \left| 1+ \frac{p}{\omega_{n}}\right| \right)  - 20 \log\left( \left| 1+ \frac{p}{\omega_{d}}\right| \right)$$
$$\varphi(\omega) = \arg\left( \frac{p}{\omega_{n}}+1 \right) - \arg\left( \frac{p}{\omega_{d}}+1 \right) = \arctan\left( \frac{\omega}{\omega_{n}} \right) - \arctan\left( \frac{\omega}{\omega_{d}} \right)$$

#### 4. 
$$G_{db}\left( \frac{\omega_{d}+\omega_{n}}{2} \right) = 10\log\left( \frac{{1+\left( \frac{\omega_{d}}{2\omega_{n}} + \frac{1}{2} \right)^{2}}}{{1+ \left( \frac{\omega_{n}}{2\omega_{d}} + \frac{1}{2} \right)^{2}}} \right)$$
Ainsi, 
$$G_{db}\left( \frac{\omega_{d}+\omega_{n}}{2} \right) = 10\log\left( \frac{1+(5.5)^{2}}{1+\left( \frac{11}{20} \right)^{2}} \right)$$
or : 
$$T(p) \underset{p \to + \infty}{\sim} \frac{R_{1}+R_{2}}{R_{2}} = 10 \text{ et } \omega_{d} - \omega_{n} = 9\omega_{n}$$
Alors, la pente est de : 
$$\sqrt{10^{2}+(9\omega_{n})^{2}}$$
Donc, comme $G_{dB}(\omega_{n}) = 0$ on a l'expression du bode asymptotique entre $\omega_{n}$ et $\omega_{d}$ : etc ...
$$G_{db, ass}(\omega_{n}) = \sqrt{10^{2}+(9\omega_{n})^{2}\, }\omega_{n}+C$$


# Exercice 2
EXCAL 3
## 1.
$$V_{5} = V_{AM} = Z_{5} i_{2} = Z_{AM} i_{e}$$
$$Z_{AM} = Z_{5} \frac{i_{2}}{i_{e}} = Z_{5} \frac{i_{4} + i_{1}}{i_{e}} = Z_{5} \frac{i_{4}+i_{e}+i_{3}}{i_{e}} = Z_{5} \left( 1+\frac{i_{4}}{i_{e}} + \frac{i_{3}}{i_{e}} \right)$$
$$0 = Z_{3}i_{1} + Z_{4}i_{2} \text{ et } 0 = Z_{1}i_{e} + Z_{2} i_{1}$$
Alors, 
$$i_{e}=\frac{Z_{4}Z_{2}}{Z_{1}Z_{3}}i_{2}$$
Ainsi, 
$$\boxed{Z_{AM} = \frac{Z_{1}Z_{3}Z_{5}}{Z_{2}Z_{4}}}$$

## 2.
On pose $Z_{2} = Z_{3} = R$, Trouver les autres résistancecs 