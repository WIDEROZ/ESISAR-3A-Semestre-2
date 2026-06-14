# Modélisation physique
$$J_{y} \ddot{\psi} + D_{y}\dot{\psi} = \tau_{y} = D_{t} K_{f}u$$
- $J_{y}$ Moment autour de l'axe de lacet
- $\psi$ : le mouvement de lacet
- $D_{y}$ : Coefficient d'amortissement visqueux
- $\tau_{y}$ : Couple
- $K_{f}$ : Gain de la force de poussée
- $D_{t}$ : distance entre le pivot et le centre de l'hélice
- $u$ : tension appliqué au système


Fonction de transfert de l'angle de lacet : 
$$H_{sys}(p) = \frac{\Psi(p)}{U(p)} = \frac{D_{t}K_{f}}{p(J_{y} p+D_{y})}$$
Fonction de transfert de la vitesse de lacet :
$$H_{sys}(p) = \frac{\Psi(p)}{U(p)} = \frac{D_{t}K_{f}}{J_{y} p+D_{y}}$$

#### Calcul du gain et du temps de réponse
$$K = 0.171 \text{ et } T = 0.171$$
$$H(p) = \frac{K}{pT +1}$$

#### Calcul de $K_{f}$ et $D_{y}$
$$K = \frac{D_{t}K_{f}}{D_{y}}$$
$$T = \frac{J_{y}}{D_{y}}$$

$$\begin{cases}
D_{t} = 0.1674 \\
J_{y} = 0.0238 \\
T = 7.9 \\
K = 0.171
\end{cases}$$
$$\boxed{\begin{cases}
D_{y} = \frac{J_{y}}{T} = 3.0 \times 10^{-3} \\
K_{f} = \frac{KD_{y}}{D_{t}} = 3.077 \times 10^{-3}
\end{cases}}$$


$$\frac{D_tK_{f}}{p(J_{y}p + D_{y})}\left( K_{p} + \frac{K_{i}}{p} + K_{d}p \right)$$

## 2.4
#### 1.
$$\deg(R) = \deg(A) = 2$$
$$\deg(S) = \deg(R) = 2$$
$$\deg(T) = 0$$

#### 2.
$$D(p) = (p+p_{0})^{2}(p^{2} + 2\xi \omega_{n}p + \omega_{n}^{2})$$

#### 3.
On pose alors : 
$$\begin{cases}
R(p) = r_{2}p^{2}+ r_{1}p+ r_{0}\\
S(p) = p(p + s_{0}) &\text{car } S \text{ contient un intégrateur} (S(0) = 0)
\end{cases}$$
Donc comme : 
$$H(p) = \frac{\frac{D_{t}K_{f}}{J_{y}}}{p\left( p + \frac{D_{y}}{J_{y}} \right)} = \frac{\frac{K}{T}}{p\left( p+\frac{1}{T} \right)}$$
$$\begin{array}{l}
D(p) &= A(p) S(p) + B(p)R(p) \\
&=p^{2}(p+s_{0})\left( p + \frac{1}{T} \right) + \frac{K}{T}(r_{2}p^{2}+ r_{1}p+ r_{0}) \\
&= p^{4} + \left( \frac{1}{T}+s_{0} \right)p^{3} + \left( \frac{s_{0}}{T} +\frac{K}{T} r_{2} \right)p^{2} + \left( \frac{K}{T}r_{1} \right)p
\end{array}$$

###### Premier correcteur
$$(p+p_{0})^{4} \sim \begin{cases}
1 \\
4p_{0} \\
6p_{0}^{2} \\
4p_{0}^{3} \\
p_{0}^{4}
\end{cases} = \begin{cases}
1 \\
\frac{1}{T}+s_{0} \\
\frac{s_{0}}{T} +\frac{K}{T} r_{2} \\
\frac{K}{T}r_{1}  \\
\frac{K}{T}r_{0}
\end{cases} \sim A(p) S(p) + B(p)R(p)$$
$$\boxed{\begin{cases}
r_{0} = \frac{T}{K}p_{0}^{4} \\
r_{1} = 4\frac{T}{K} p_{0}^{3} \\
r_{2} = \frac{T}{K}\left( 6p_{0} - \frac{4p_{0} - \frac{1}{T}}{T} \right) \\
s_{0} = 4p_{0} - \frac{1}{T}
\end{cases}}$$
$$t_{rep, 95\%} = \frac{3}{\xi \omega_{n}}=2.85 \, s$$

$$\boxed{p_{0} = \frac{a}{t_{rep, 95\%}} = 2.7368}$$

$$T(p) = t_{0}$$
$$F(0) = 1\Leftrightarrow t_{0} = r_{0} = \frac{T}{K}p_{0}^{4}$$

Ainsi, 
$$\boxed{T(p) =  \frac{T}{K}p_{0}^{4}}$$

##### Deuxième correcteur
$$(p + p_{0})^{2}$$
$$(p^{2}+2p_{0}p + p_{0}^{2})(p^{2} + 2\xi \omega_{n}p + \omega_{n}^{2})\sim \begin{cases}
1 \\
2\xi \omega_{n} + 2p_{0} =d_{3}\\
\omega_{n}^{2} + p_{0}^{2}+4\xi \omega_{n}p_{0} =d_{2}\\
2p_{0}\omega_{n}^{2} + 2 \xi \omega_{n}p_{0}^{2} =d_{1}\\
p_{0}^{2}\omega_{n}^{2} =d_{0}
\end{cases} $$
$$= \begin{cases}
1 \\
\frac{1}{T}+s_{0} \\
\frac{s_{0}}{T} +\frac{K}{T} r_{2} \\
\frac{K}{T}r_{1}  \\
\frac{K}{T}r_{0}
\end{cases} \sim A(p) S(p) + B(p)R(p)$$
$$\boxed{\begin{cases}
s_{0} = d_{3}-\frac{1}{T} \\
r_{0} = \frac{T}{K}d_{0} \\
r_{1} = \frac{T}{K}d_{1} \\
r_{2} = \frac{T}{K}\left( d_{2}-\frac{s_{0}}{T} \right)
\end{cases}}$$

$$C(p) = \frac{R(p)}{S(p)} \text{ et } H(p) = \frac{B(p)}{A(p)} \text{ et }F(p) = \frac{t_{0}}{R(p) }$$


#### Arduino
Préfiltre : 
$$F(p) = \frac{U_{f}(p)}{U(p)}$$
$$\boxed{U_{f}(n) = \frac{1}{1.257 \times 10^{4}}(10^{4}(2.51U_{f}(n-1) - 1.254 U_{f}(n-2)) + 1.864U(n))}$$
___
$$C(p) = \frac{e_{f}(p)}{e(p)}$$

$$\boxed{e_{f}(n) = \frac{1}{1.813}(3.572 e_{f}(n-1) -1.759 e_{f}(n-2) +10^{4}(1.67e(n) -3.336e(n-1) + 1.666e(n-2)))}$$


$$\boxed{C(p) = \frac{r_{2}p^{2} + r_{1}p+r_{0}}{p(p+s_{0})}}$$
$$\boxed{F(p) = \frac{t_{0}}{r_{2}p^{2}+r_{1}p+r_{0}}}$$

On a calculé les marges avec le filtre pour assurer la stabilité du système : 
$$\boxed{C_\text{stabilisé}(p) = C(p)F_{stab}(p) = C(p) \frac{\omega_{n}}{p+\omega_{n}}}$$


