Tag :
(A FAIRE : peut être moyen de trouver un autre coef. de $T(z)$ avec $S(z=s_{0})=0$)
De la même manière : $S(z=s_{0}) = S(z=0.569)=0$ alors, 
$$H_{BF}(z = s_{0}) = \frac{T(z=s_{0})}{R(z=s_{0})} = F(z=s_{0})$$
$$H_{BF}(z) = F(z) \frac{C(z)H(z)}{1+C(z)H(z)}$$


# NON GARDÉ
#### 1.3.2.2 - Commande obtenue ^a322
##### a. Temps de réponse d'un échelon de consigne en température
$$Y_{c}(t) = T \Leftrightarrow Y_{c}(p) = \frac{T}{p}$$
Alors, 
$$\begin{array}{ll}
Y(p) &= F(p) \frac{H(p)C(p)}{1+H(p)C(p)}Y_{c}(p) \\
& = \frac{r_{0}}{r_{1}p+r_{0}} \times \frac{\frac{r_{1}p+r_{0}}{p} \frac{G}{1+\tau p}}{1+\frac{r_{1}p+r_{0}}{p} \frac{G}{1+\tau p}} \frac{T}{p} \\
&= \frac{r_{1}T}{p} \frac{G}{p(1+\tau p) + G(r_{1}p+r_{0})} \\
&= \frac{r_{1}T}{p} \frac{G}{r_{0}G + (1+r_{1}G)p+ \tau p^{2}}
\end{array}$$
Alors, en posant : 
$$\begin{cases}
a = \tau = 0.5 \\
b = 1+r_{1}G = p_{0} = 6.82  \\
c=r_{0}G=\frac{p_{0}^{2}}{2} = 23.3
\end{cases}$$
$$\Delta = b^{2}-4ac = 0$$
Alors, 
$$p_{-} = \frac{-b -\sqrt{\Delta}}{2a} = -18.38\text{ et }p_{+} = \frac{-b +\sqrt{\Delta}}{2a} = -9.62$$
Donc, 
$$34G + (1+5G)p+ \tau p^{2}= \tau(p-p_{-})(p-p_{+})$$
On effectue alors une decomposition en éléments simples :
$$Y(p)= \frac{5TG}{\tau} \frac{1}{p(p-p_{-})(p-p_{+})}$$
$$=\frac{5TG}{\tau}\left( \frac{\frac{1}{p_{+}p_{-}}}{p}+\frac{\frac{1}{p_{-}(p_{-}-p_{+})}}{p-p_{-}}+\frac{\frac{1}{p_{+}(p_{+}-p_{-})}}{p-p_{+}} \right)$$
$$Y(t)= \frac{5TG}{\tau}\left( \frac{1}{p_{+}p_{-}} + \frac{1}{p_{-}(p_{-}-p_{+})} e^{ p_{-}t } + \frac{1}{p_{+}(p_{+}-p_{-})} e^{ p_{+}t } \right)$$
![[Pasted image 20260417224040.png]]

