# Exercice 1
## I. Préliminaires
#### a.
Push-pull
#### b.
Non inverseur

#### c.
$$A = \frac{V_{2}}{V_{1}}$$
Rétroaction négative : $V_{1} = V^{-}$, 
Pour $T_{1}$ :
$$i_{c} = \beta i_{b} \text{ or } i_c = i_{e}-i_{b} \Leftrightarrow i_{e} = (\beta+1)i_{b} \approx \beta i_{b}$$
Pour $T_{2}$ :
$$i_{c} = i_{e} + i_{b} \Leftrightarrow i_{e} \approx \beta i_{b}$$

$$i_{e_{1}} + i_{e_{2}} = i_{2} = 2\beta i_{out}$$


# Exerice 2
### 1. Filtre
#### a.
$$Z_{eq_{i}} = \frac{R_{i}}{pR_{i}C_{i}+1}$$
$$T(p) = \frac{Z_{eq_{2}}}{Z_{eq_{1}}+Z_{eq_{2}}} = \frac{\frac{1}{Z_{eq_{1}}}}{\frac{1}{Z_{eq_{1}}}+\frac{1}{Z_{eq_{2}}}} = \frac{1}{R_{1}}\frac{1+R_{1}C_{1}p}{2+p(R_{1}C_{1}+R_{2}C_{2})}$$
Ainsi, 
$$\boxed{T(p) = \frac{1}{2} \frac{1+R_{1}C_{1}p}{1+\frac{R_{1}C_{1}+R_{2}C_{2}}{2}p}}$$
$$\boxed{\omega_{1}=\frac{1}{R_{1}C_{1}} \text{ et } \omega_{2} = \frac{2}{R_{1}C_{1}+R_{2}C_{2}} \text{ et } T_{0} = \frac{1}{2}}$$

#### b.
$$\boxed{G_{0} = 20\log(T_{0}) = -20\log(2)}$$
$$\boxed{G_{inf} \sim_{p \to \infty} 20\log\left( \frac{T_{0}\omega_{2}}{\omega_{1}} \right) = 20(\log(T_{0}) - 1) = -20(\log(2)+1)}$$

$$\boxed{G_{db} = 20\log(T_{0}) + 10\log\left( \frac{1+\left( \frac{\omega}{\omega_{1}} \right)^{2}}{1+\left( \frac{\omega}{\omega_{2}} \right)^{2}} \right)}$$
$$\boxed{G_{db}(\omega) = 20\log\left( T_{0} \frac{\omega_{2}}{\omega_{1}} \right) + 10 \log\left(  \frac{\omega_{1}^{2} + \omega^{2}}{\omega_{2}^{2}+\omega^{2}} \right)}$$
$$= 20\log\left( T_{0} \right) + 10 \log\left( 1+ \left( \frac{\omega}{10\omega_{2}} \right)^{2} \right) - 10 \log\left( 1+\left( \frac{\omega}{\omega_{2}} \right)^{2} \right)$$
### 2. Passe tout
#### a.
$$\omega_{1}=\omega_{2}$$

#### b.
$$T_{0} = \frac{1}{k}$$

#### c.
$$R_{1}C_{1}=\frac{1}{\omega_{1}} = \frac{1}{\omega_{2}} = \frac{C_{1}+C_{2}}{R_{1}+R_{2}}R_{1}R_{2}$$
$$\frac{R_{1}+R_{2}}{R_{2}}-1 = \frac{C_{2}}{C_{1}}$$

$$R_{1}C_{1} = T_{0}(C_{1}+C_{2}) \Leftrightarrow R_{1} = T_{0}\left( 1+\frac{C_{2}}{C_{1}} \right)$$
$$\Leftrightarrow R_{1}R_{2} = T_{0}(R_{1}+R_{2})$$
Ainsi : 
$$\boxed{R_{1} = \frac{T_{0}R_{2}}{R_{2}-T_{0}}}$$

# III - Explications
#### a.
$$Z_{in}$$