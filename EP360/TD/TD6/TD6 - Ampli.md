# Exercice 1
## I - Pré-étude
$$R_{3} = 0 \Rightarrow V_{s} = \frac{R_{2}}{R_{1}+R_{2}}(V_{s}-V_{e})$$
Ainsi, 
$$\boxed{A_{0} = \frac{V_{s}}{V_{e}} = -\frac{R_{2}}{R_{1}}}$$


## II - Étude
$$V_{1} = \frac{R_{4}}{R_{3}+R_{4}}V_{s}$$
Alors, 
$$V_{1} = -R_{2}i_{1} \Leftrightarrow V_{1} = \frac{-R_{2}}{R_{1}} V_{e}$$
Or $R_{4}$ et $R_{2}$ sont en parallèles : 
Donc en posant : 
$$R_{24} = \frac{R_{2}R_{4}}{R_{2}+R_{4}}$$
On a : 
$${\frac{V_{s}}{V_{e}} = A_{0}\frac{R_{3}+R_{24}}{R_{24}}}$$
Ainsi, 
$$\boxed{\frac{V_{s}}{V_{e} } = A_{0} \frac{R_{2}R_{3}+R_{2}R_{4}+R_{3}R_{4}}{R_{2}R_{4}}}$$

# Exercice 2
## 1.
Ponts diviseurs de tension : 
$$V_{e}-V_{3} = \frac{R_{1}}{R_{1} + \frac{1}{pC}}(V_{e}-V_{s})$$
$$V_{3}=\frac{R_{3}}{R_{2}+R_{3}}V_{e}$$


Alors : 
$$\left( \frac{R_{1}+\frac{1}{pC} }{R_{1}}\left( 1-\frac{R_{3}}{R_{12}+R_{3}} \right)-1 \right) V_{e} = -V_{s}$$
Donc, 
$$\frac{V_{s}}{V_{e}} =  1-\left( 1+\frac{1}{pR_{1}C} \right)\left( 1-\frac{R_{3}}{R_{2}+R_{3}} \right) $$
Alors, 
$$\frac{R_{3}}{(R_{2}+R_{3})pR_{12}C}-\frac{1}{pR_{1}C}+\frac{R_{3}}{R_{2}+R_{3}}$$
$$= -\frac{1}{pR_{1}C}\left(1- \frac{R_{3}}{R_{2}+R_{3}} -p\frac{R_{1}CR_{3}}{R_{2}+R_{3}}\right)$$
Ainsi : 
$${ T(p) = -\frac{1}{pR_{1}C}\left(\frac{R_{2}}{R_{2}+R_{3}} -p\frac{R_{1}CR_{3}}{R_{2}+R_{3}}\right)}$$
$$\boxed{T(p) = - \frac{R_{2}}{R_{1}(R_{2}+R_{3})p}\left( 1-\frac{R_{1}R_{3}}{R_{2}}Cp \right)}$$
$$\boxed{\omega_{1} = \frac{R_{2}}{R_{1}(R_{2}+R_{3})C} \text{ et } \omega_{2} = \frac{R_{2}}{R_{1}R_{3}C}}$$
$$\boxed{\omega_{1} > \omega_{2}}$$

$$T(j\omega) = \frac{\omega_{2}}{\omega_{1}} + j\frac{\omega_{2}}{\omega}$$
Alors, 
$$\boxed{\left| T\right| = \omega_{2}\sqrt{\frac{1}{\omega_{1}^{2}} + \frac{1}{\omega^{2}}}}$$
$$\boxed{\arg(T(j\omega)) = \arctan\left( \frac{\omega_{1}}{\omega} \right)}$$

# Exercice 3
Dans le cas ou $V_{2}=0$ : 
Pont diviseur de tension :
$$V_{3} = \frac{Z_{2}}{Z_{1}+Z_{2}}V_{1}$$
Avec $Z_{2} = \frac{1}{pC}$ alors, 
$$\boxed{A_{1} = \frac{1}{pR_{1}C+1}}$$

On a : 
$$A_{2} = $$