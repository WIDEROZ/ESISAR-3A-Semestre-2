# III. Méthodes de Runge-Kutta
## 1. Principe Général
Soit un problème de Cauchy :
Soit $t \in D_{\mathbb{E}}$ (le domaine de définition de l'équation),
On note $t_{0}$ et $x_{0}$ tels que :
$$\begin{cases}
\dot{x}(t) = f(t, y(t)) \\
x(t_{0}) = x_{0}
\end{cases}$$
Soit $h$ le pas sur lequel on intègre et $(t_{i})_{i \in \mathbb{N}}\in D_{\mathbb{E}}^{\mathbb{N}}$ tel que : 
$$\forall n \in \mathbb{N}, t_{n+1} = t_{n} + h$$
On intègre l'équation :
$$\forall n \in \mathbb{N}, x(t_{n}+h)-x(t_{n}) = \int_{t_{n}}^{t_{n}+h}f(t, x(t)) \, dt $$
On cherche à approximer $f$. 
On fait alors un changement de variable $x \leftarrow \frac{t-t_{n}}{h}$ :
$$\boxed{\forall n \in \mathbb{N}, x(t_{n}+h) = x(t_{n})+ h\int_{0}^{1} f(hx+t_{n}, x(hx+t_{n})) \, dx }$$

____
#### Notes (Brouillon)
On pose : 
$$k_{1} = f(t, x(t)) \text{ et } k_{2} = f(t + \alpha h, x + \beta k_{1})$$
Soit deux points : 
$$(t, x(t)) \text{ et } (t + \alpha h, x+\beta k_{1})$$
avec : 
$$\alpha, \beta \in [0, 1]$$
On prend une approximation de runge-kutta d'ordre $2$ : 
$$\phi^{RT_{2}} = R_{1}k_{1} + R_{2}k_{2} \text{ avec } R_{1}, R_{2} \in [0, 1] \text{ et } R_{1}+R_{2} = 1$$
(pour avoir une moyenne)
Donc, 
$$x_{k+1} = x_{k} + h\phi^{RT_{2}}$$
Alors, 
$$x(t + h) = x(t) + h(R_{1}f(x(t)) + R_{2} f(t + \alpha h, x + \beta k_{1}))$$
Donc, 
$$\frac{x(t+h)-x(t)}{h} = R_{1}f(t, x(t)) + R_{2} f(t + \alpha h, x + \beta k_{1})$$
$$= R_{1}f(t, x(t)) + R_{2}\left(f(t, x( t))+ \alpha h \frac{\partial f}{\partial t}(t, x(t))+ \beta f(t, x(t)) \frac{\partial f}{\partial x}(t, x(t))   \right)$$

De plus, 
$$\Delta = \dot{x}(t) + \frac{h}{2} \ddot{x}(t) + \dots$$
$$ = f(t, x) + \frac{h}{2}\left( \frac{\partial f}{\partial t} (t, x(t)) + f(t, x(t))\frac{\partial f}{\partial x} (t, x(t)) \right) + \dots$$
___

## 3. $s$-stages Runge-Kutta method
Soient $i,j \in [\![1, n]\!]$, $a_{i, j} \in [0, 1]$ 
Soient : 
$$c_{i} = \sum_{j = 1}^{s} a_{i, j}$$
$$k_{i} = f\left( t+c_{i}k_{i}, x + h \sum_{l = 1}^{s} a_{i, l}k_{l} \right)$$
$$x^{RKs}(t+h) = x^{RKs}(t) + h \sum_{l = 1}^{s} b_{l}k_{l}$$

### Tableau de Butcher
Voir [Wikipedia](https://fr.wikipedia.org/wiki/M%C3%A9thodes_de_Runge-Kutta).


