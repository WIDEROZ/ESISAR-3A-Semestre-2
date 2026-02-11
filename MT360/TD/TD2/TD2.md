# Exercice 1
#### 1.
$\ln$ est bien définie dans l’intervalle $]0, 1[$, 
On pose : 
$$g(x) = x+\ln(x)$$
et on cherche les racines de cette fonction, (elle est bien dérivable sur $]0, 1[$), 
$$g'(x) = 1+\frac{1}{x} \text{ alors, } g'(x) \geq 0 $$
De plus, 
$$g(x) \in ]- \infty, 1[ \text{ et } $$
Donc, la fonction est strictement croissante et continue sur $]0, 1[$, puis traverse l'axe des abscisses?
Ainsi, $x = - \ln(x)$ admet des solutions en $]0, 1[$

#### 2.
On pose $\forall x \in ]0, 1[, f(x) = -\ln(x)$,
$$\left| f'(s)\right| = \frac{1}{s} > 1$$
Ainsi, la suite DV.

#### 3.
$$f(e^{ -y }) = \left| y\right| = y$$
Si on veut trouver le point fixe de $f$, il faut trouver une solution à l'équation : 
$$e^{ -y } = y$$
Alors, il faut donc que : $e^{ -y } \in ]0, 1[$ ie : $y \in ]0,  +\infty[$

On utilise le théorème de Banach comme itération de type point fixe : 
Pour $g(y) = e^{ -y }$ et $y_{n+1} = e^{ -y_{n} }$ alors, 
- $g$ est bien continue sur $I = [\varepsilon, 1]$, pour $\varepsilon \in ]0, 1[$ 
$$\forall x, y \in I, \frac{\left| e^{ -x } - e^{ -y }\right|}{\left| x-y\right|} < 1 $$
car : 
$$\forall y \in I, \left| g'(y)\right| = e^{ -y } < 1 $$
- Donc $g$ est contractante

Ainsi, 
il existe un unique point fixe pour $g$ sur $[\varepsilon, 1]$ 
$$y_{n} \underset{n \to +\infty}{\longrightarrow} s$$
$$\left| e_{n}\right| = \left| y_{n} - t\right| \leq \frac{L^{n}}{1-L} \left| y_{1} - y_{0}\right| \text{ avec } L = e^{ -\varepsilon }$$
De plus, $f'(s)= -e^{ -s } \neq 0$
Ainsi, 
$$\boxed{(y_{n})_{n \in \mathbb{N}}\text{ converge d'ordre }1}$$


#### 4.
On pose : 
$$f(y) = y-e^{ -y }$$
$$y_{n+1} = y_{n} - \frac{f(y_{n})}{f'(y_{n})} = y_{n} - \frac{y_{n}-e^{ -y_{n} }}{1+e^{ -y_{n} }}$$
Alors, 
$$\boxed{y_{n+1} = \frac{y_{n}+1}{1+e^{ y_{n} }}}$$

#### 5.
On pose : 
$$f(y) = \frac{1+y}{1+e^{ y }}$$


# Exercice 3
#### 1.
