
#### Donnés
On a un retard max de $15$ ms et et un retard min (min????) de $20$ ms alors le retard total est de $L = 35$ms
$$M_{\varphi} \geq 45° \text{ et } M_{M}  \geq 0.5 \text{ et } M_{r} = 3 \times L$$
Avec $L$ le retard total. 
___
$$\left| C(p)\right| \leq N_{\max} = 5$$
#### Tests a faire selon le cahier des charges
###### a. On traite la commande
On applique un échelon de température $Y_{C}(t)$ en commande avant $F$ puis on regarde la sortie $Y(t)$

###### b. On traite $P_{u}$ et $P_{y}$
$C$ doit contenir un intégrateur
Le gain statique de $F$ doit être égal à $1$
Si on applique un échelon de température $Y_{C}(t)$ en commande avant $F$ et que l'on regarde la sortie $Y(t)$, la différence : $Y_{c}(t)- Y(t)\underset{}{\longrightarrow} 0$.

###### c. On traite le bruit
$$\left| C(p)\right| \leq_{\omega \to \infty} N_{\max} = \frac{\left| U_{b}\right|}{\left| P_{b}\right|} = \frac{0.5}{0.1} = 5$$
$$Y_{C} = cte \underset{}{\longrightarrow} \text{mesure de } \left| U_{b}\right| $$

###### d. On traite $P_{y}$
Diagramme de Bode, Nyquist, Black-Nichols sur le calculateur

###### e. On traite $P_{u}$
On fais un échelon sur $P_{u}$ et on regarde la sortie $Y_{C}(t)= cte$ 
$$\min \left|\left| \frac{Y}{P_{u}} \right|\right|_{H_{2}} $$


# 20/03
$$H(p) = \frac{B(p)}{A(p)} = \frac{4.6}{p+2}$$
$$C(p) = \frac{R(p)}{S(p)} = \frac{r_{0}+r_{1}p}{p}$$
De plus dans le cours : 
$$D(p) =A(p)S(p) + B(p) R(p)$$
$$D(p) = (p+2)p + 4.6(r_{0}+r_{1}p)$$
$$D(p) = p^{2} + (2+4.6r_{0})p + 4.6r_{1}$$
Or : 
$$D_{désiré} (p) = (p+\omega_{0})^{2} = p^{2} + 2\omega_{0}p + \omega_{0}^{2}$$
Alors, 
$$r_{0} = \frac{2\omega_{0} -2}{4.6} \text{ et } r_{1} = \frac{\omega_{0}^{2}}{4.6}$$

Si $r_{0}=5$ alors, $\omega_{0} =12.5 \text{ rad.s}^{-1}$
Ainsi, 
$$r_{1} = 34$$

3.95



# 17-04
$$H_{BOZ}(p) = \frac{1-e^{ -pT_{e} }}{p}$$
$$H(p) = \frac{G}{\tau p+1}$$
Alors, 
$$H(p)H_{BOZ}(p) = G\frac{1-e^{ -pT_{e} }}{p(1+\tau p)}$$
Alors, 
$$H(z) = G \mathcal{Z}\left( \frac{1-e^{ -pT_{e} }}{p(1+\tau p)} \right) = G (1-z^{-1}) \mathcal{Z}\left( \frac{1}{p(1+\tau p)} \right)$$
comme : 
$$\frac{1}{p(1+\tau p)} = \frac1p - \frac{1}{\frac{1}{\tau}+p}$$
On a : 
$$\mathcal{Z}\left( \frac{1}{p(1+\tau p)} \right) = \frac{1}{1-z^{-1}}-\frac{1}{1-e^{ -\frac{T_{e}}{\tau} }z^{-1} }$$
$$ = \frac{1-e^{ -\frac{T_{e}}{\tau} }z^{-1} - (1-z^{-1})}{(1-z^{-1})\left( 1-e^{ -\frac{T_{e}}{\tau} }z^{-1} \right)} = \frac{\left( 1-e^{ -\frac{T_{e}}{\tau} } \right)z^{-1}}{(1-z^{-1})\left( 1-e^{ -\frac{T_{e}}{\tau} }z^{-1} \right)}$$
Ainsi, 
$$H(z) =  G \times (1-z^{-1}) \frac{\left( 1-e^{ -\frac{T_{e}}{\tau} } \right)z^{-1}}{(1-z^{-1})\left( 1-e^{ -\frac{T_{e}}{\tau} }z^{-1} \right)}$$
___
$$\boxed{C(z) = 5 \frac{1-0.98z^{-1}}{1-z^{-1}}}$$
___
$$H(z) = \frac{B(z)}{A(z)} = \frac{0.046z^{-2}}{1-0.98z^{-1}}$$
$$C(z) = \frac{R(z)}{S(z) }$$
Alors, 
$$R(z) = r_{0}+r_{1}z^{-1} \text{ et } S(z) =(1-z^{-1})(1-s_{0}z^{-1})$$

q
$$D(z) = A(z)S(z) + B(z)R(z) $$
$$= (1-0.98z^{-1})(1-z^{-1})(1-s_{0}z^{-1}) + 0.046z^{-2}(r_{0}+r_{1}z^{-1})$$
$$D_{desiré}(z) = (1-z_{BF}z^{-1})^{3}$$
Alors, 
$$z_{BF} = e^{ -\frac{6.3T_{e}}{(t_{_{_{reponse}}})_{_{_{95 \%}}}}} = e^{ - \frac{6.3 T_{e}}{0.385} } = $$
Ainsi, 
$$\boxed{\begin{cases}
s_{0}=0.56 \\
r_{0}=1.35 \\
r_{1}=-1.27
\end{cases}}$$


Soit on fait comme dans le cours, soit on choisit un filtre $5 \times$ plus rapide que le système avec le temps de réponse à $95\%$ alors : 
$$5\times t_{reponse} = T_{e}\left(\frac{\ln(0.05)}{\ln(\text{root 1})} + \frac{\ln(0.05)}{\ln(\text{root 2})} \right) = 0.1 $$
On prend $0.17$ (par ce que les valeurs idéales c'est de la merde)
$$\boxed{t_{reponse} = \frac{0.17}{5} = 0.034}$$

$$F(z) = \frac{1-z^{-1}}{1-z_{F}z^{-1}} =\dots$$
$$z_{F} = e^{ - \frac{\frac{T_{e}}{t_{reponse}}}{3} } = 0.414$$



___
Alternative : 
$$H_{sys}(z) = G\frac{\left( 1-e^{ -\frac{T_{e}}{\tau} } \right)z^{-2}}{ 1-e^{ -\frac{T_{e}}{\tau} }z^{-1} } = \frac{0.046z^{-2}}{1-0.980z^{-1}} = \frac{A(z)}{B(z)}$$
On pose : 
$$C(z) = \frac{R(z)}{S(z)}$$

Alors, 
$$R(z) = r_{0}+r_{1}z^{-1} \text{ et } S(z) =(1-z^{-1})(1-s_{0}z^{-1})$$

Donc par définition du polynôme de régulation : 
$$D(z) = A(z)S(z) + B(z)R(z) $$
$$= (1-0.98z^{-1})(1-z^{-1})(1-s_{0}z^{-1}) + 0.046z^{-2}(r_{0}+r_{1}z^{-1})$$
$$ \begin{array}{llcl}
=&-&(-0.046r_{1}+0.98s_{0})&z^{-3} \\
&+&(0.046r_{0}+s_{0}+0.98+0.98s_{0})&z^{-2} \\
&-& (s_{0}+1+0.98)&z^{-1}  \\
&+&1&
\end{array}$$
Or on désire : 
$$D_{desiré}(z) = (1-z_{BF}z^{-1})^{3}$$
$$\begin{array}{llcl}
=&-&z_{BF}^{3}&z^{-3} \\
&+&3z_{BF}^{2}&z^{-2} \\
&-&3z_{BF}&z^{-1} \\
&+&1
\end{array}$$

$$\begin{cases}
s_{0}=0.569 \\
r_{0}=1.32 \\
r_{1}=-1.23
\end{cases}$$
$$\boxed{C(p) = \frac{1.32-1.23z^{-1}}{(1-z^{-1})(1-0.569z^{-1})} }$$
___
Alternative : 
$$H_{sys}(z) = G\frac{\left( 1-e^{ -\frac{T_{e}}{\tau} } \right)z^{-1}}{ 1-e^{ -\frac{T_{e}}{\tau} }z^{-1} } = \frac{0.046z^{-1}}{1-0.980z^{-1}} = \frac{A(z)}{B(z)}$$
On pose : 
$$C(z) = \frac{R(z)}{S(z) }$$
Alors, 
$$R(z) = r_{0}+r_{1}z^{-1} \text{ et } S(z) =(1-z^{-1})(1-s_{0}z^{-1})$$

Donc par définition du polynôme de régulation : 
$$D(z) = A(z)S(z) + B(z)R(z) $$
$$= (1-0.98z^{-1})(1-z^{-1})(1-s_{0}z^{-1}) + 0.046z^{-1}(r_{0}+r_{1}z^{-1})$$
$$ \begin{array}{llcl}
=&-&(0.98s_{0})&z^{-3} \\
&+&(0.046r_{1}+s_{0}+0.98+0.98s_{0})&z^{-2} \\
&-& (0.046r_{0}+s_{0}+1+0.98)&z^{-1}  \\
&+&1&
\end{array}$$
Or on désire : 
$$D_{desiré}(z) = (1-z_{BF}z^{-1})^{3}$$
$$\begin{array}{llcl}
=&-&z_{BF}^{3}&z^{-3} \\
&+&3z_{BF}^{2}&z^{-2} \\
&-&3z_{BF}&z^{-1} \\
&+&1
\end{array}$$
Ainsi par identification (et quelques calculs) :
$$\boxed{\begin{cases}
s_{0}=0.627 \\
r_{0}=-1.24\\
r_{1}=-1.17
\end{cases}}$$
Ce qui nous donne l'expression du calculateur en temps discret : 
$$\boxed{C(z) = -\frac{1.24+1.17z^{-1}}{(1-z^{-1})(1-0.627z^{-1})}= -3.26 \times \frac{0.38+0.359}{1-1.627z^{-1}+0.627z^{-2}}}$$
___
# 24-04
