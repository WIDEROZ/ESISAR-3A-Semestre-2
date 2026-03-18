# Exercice III - Push-Pull
## I. Préliminaire
### 1.
$$\boxed{V_{be_{1}} = V_{be_{3}}}$$
$$\beta_{1} = \frac{i_{c_{1}}}{i_{b_{1}}} = \frac{i_{c_{3}} + i_{c_{4}}}{i_{b_{3}}} = \beta_{3} + \beta_{4} \frac{i_{b_{4}}}{i_{b_{3}}} = \beta_{3} + \beta_{4} \frac{i_{c_{3}}}{i_{b_{3}}} = \beta_{3}(1+\beta_{4})$$
Ainsi, 
$$\boxed{\beta_{1} = \beta_{3}(1+\beta_{4}) = 1050}$$
Schéma : VOIR TEL

#### Petits signaux $T_{3}$ et $T_{4}$
Schéma : VOIR TEL
On cherche l'impédance d'entrée de $T_{1}$ : 
$$r_{be_{1}}= \frac{\tilde{V}_{be_{1}}}{\tilde i_{be_{1}}} = \frac{\tilde V_{be_{3}}}{\tilde i_{b_{3}}} = r_{be_{3}}$$


#### Pourquoi la résistance de $100 \Omega$
On considère que le transistor est ON : le courant de la resistance est de $6mA$  (avec $V_{be_{4}} = 0.7 \, V$ et $I_{E_{3}} = 2\, A$) et $i_{b_{4}} = 100 \, mA$ on néglige donc la resistance pour la suite. 
Cela permet de dévier le courant lorsque $T_{2}$ est OFF


La tension de jonction diminue de $2 \, mV$ pour chaque degré Celsius de plus. 

#### Point de repos de $T_{1}$ et $T_{2}$
Schéma : remplacement des transistors par des transistors équivalents. 

On cherche le Point : $(i_{c_{0}}, V_{ce_{0}})$ avec $V_{e} = 0$ : 
La tension de repos de $T_{1}$ est alors de $V_{cc}$
La tension de repos de $T_{2}$ est alors de $-V_{cc}$

Pour les deux transistors : $V_{be} < 0$ Donc les transistors sont OFF ainsi, $i_{c_{0}} = 0$

## II - Etude statique et Dynamique
#### Calculer $A_{V}, A_{I}$
$$A_{V} = \frac{V_{s}}{V_{e}} $$