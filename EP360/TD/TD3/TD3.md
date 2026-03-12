# Amplificateurs linéaires de puissance
## Exercice 2
### I. Amplificateur I
#### Conditions d'études dynamiques
On néglige les capacités de liaisons,
À la fréquence d'usage de $V_{e_{1}}(t)$ l'impédance de $\left| Z_{c}\right|$ est négligeable devant les autres impédances. 

#### Schémas
##### Exercice


##### Petits signaux
![[Pasted image 20260311110702.png]]

#### Donner l'expression de l'amplitude petits signaux
On applique la loi d'ohm (et la loi des mailles pour la troisième) : 
$$\begin{cases}
V_{e_{1}}(t) = R_{BE}i_{b} + R_{E}i_{E} \\
V_{s_{1}}(t) = -R_{c}\beta i_{b} \\
i_{E} = i_{b} + i_{c} \Leftrightarrow i_{E} = (\beta +1)i_{b}
\end{cases}$$
Alors, 
$$\boxed{A_{1} = \frac{V_{s_{1}}(t)}{V_{e_{1}}(t)} = -\frac{R_{c} \beta}{R_{BE} + R_{E}(\beta+1)}}$$
#### Impédance d'entrée
$$R_{in} = \frac{V_{e_{1}}}{i_{e}} $$
Alors, 
$$Y_{in} = \frac{i_{1} + i_{2} + i_{b} }{V_{e}} = \frac{1}{R_{1}} + \frac{1}{R_{2}} + \frac{i_{b}}{V_{e}}$$

$$Y_{in} = \frac{R_{1}+R_{2}}{R_{1}R_{2}} + \frac{1}{R_{be} + (\beta+1) R_{E}}$$

$$\boxed{R_{in} \approx 1.2 \, k\Omega}$$

#### Impédance de sortie
$$R_{out} = \frac{V_{s_{1}}}{i_{out}}$$
On considère maintenant que $i_{out} \neq 0$, 
Alors, on calcule l'impédance de sortie lorsque la source $V_{e_{1}}(t)$ est éteinte, on attaque par la sortie.

On applique la loi des mailles sur celle de $R_{BE}$, $R_{E}$ et $R_{2}$

Alors, 
$$R_{BE}i_{b} + (\beta +1) i_{b} R_{E} = 0$$
On a : 
$$\beta i_{b} = 0$$
Donc le générateur de courant est eteint Ainsi :
$$\boxed{R_{C} = R_{out}}$$

#### Calcul de la fréquence de coupure à $-3dB$
![[Pasted image 20260311114357.png]]

On a transformé l'ampli en filtre RC :
$$\boxed{H(p) = \frac{V_{1}}{V_{e_{1}}} = \frac{R_{in}}{R_{in} + \frac{1}{p C_{1}}} = \frac{\frac{p}{\omega_{0}}}{1+\frac{p}{\omega_{0}}} \text{ avec }\omega_{0} = \frac{1}{R_{in}C_{1}} }$$

$$\left| H(\omega)\right| = \frac{\frac{\omega}{\omega_{0}}}{\sqrt{1+ \left( \frac{\omega}{\omega_{0}} \right)^{2}}}$$
Alors, 
$$\frac{1}{\sqrt{2}} = \frac{\frac{\omega_{c}}{\omega_{0}}}{\sqrt{1+ \left( \frac{\omega_{c}}{\omega_{0}} \right)^{2}}}$$
$$\boxed{\omega_{c} = \omega_{0}}$$


### II. Amplificateur II
Complément d'énoncé : 
On considère que $R_{u}$ est débranché pour tous les calculs. 

#### Amplification
$$A_{1} = \frac{V_{s_{2}}}{V_{e_{2}}} $$
$$\begin{cases}
V_{s_{2}} = R_{E}i_{b}(\beta+1) \\
V_{e_{1}} = R_{BE}i_{b} + i_{b}(\beta+1)R_{E}
\end{cases}$$
Ainsi, 
$$\boxed{A_{1} = \frac{R_{e}(\beta+1)}{R_{BE} + (\beta+1)R_{E}}}$$

#### Impédance d'entrée
$$R_{in} = \frac{V_{e_{2}}}{i_{e}}$$
$$Y_{in}= \frac{}{V_{e_{2}}}$$