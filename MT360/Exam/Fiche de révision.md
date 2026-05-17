Soit $x \in [0, + \infty[$, 
$$\Psi(x) = x - \frac{e^{ x }}{1+e^{ x }}$$
$$\frac{\partial \Psi}{\partial x} = 1- \frac{e^{ x }}{(1+e^{ x })^{2}}$$
Alors, en posant $X = e^{ x }$ :
$$\frac{e^{ x }}{(1+e^{ x })^{2}} = 1 \Leftrightarrow X = 1 + 2X + X^{2} \Leftrightarrow X^{2} + X +1=0$$
Alors, 
$$\Delta = 1-4 = -3 \leq 0$$
Donc comme : 
$$\frac{\partial \Psi}{\partial x}  \geq 0 \text{ car } 0 \leq e^{ x } \leq (1+e^{ x })^{2}$$
$\Psi$ est strictement croissante, comme en plus : 
$$\Psi(0) = -\frac{1}{2} \text{ et } \Psi(1) = 1-\frac{e}{1+e} \geq 0$$
et que $\Psi$ est continue, 
Il existe une unique solution appartenant à $]0, 1[$. 
___
On pose : $I=[0, 1]$ qui est un fermé borné, alors
comme : 
$$f(x) = \frac{e^{ x }}{1+e^{ x }}$$
$$f'(x) \leq 1$$
$$f'(x) \neq 0 \Rightarrow o = 1$$
$$v_{k} = -\log_{\beta}\left| f'(s)\right| = 2\log\left| 1+e^{ s }\right| - \frac{s}{\ln(10)}\approx 2 e^{ s }-\frac{s}{\ln(10)}$$
$$\left| \frac{e_{n+1}}{e_{n}}\right| \sim f'(s)$$

___
$$x_{n+1}=x_{n}- \frac{F(x)}{F'(x)}$$
Avec : 
$$F(x) = x-f(x) = x- \frac{e^{ x }}{1+e^{ x }} \text{ et } F'(x) = 1- \frac{e^{ x }}{(1+e^{ x })^{2}}$$


$$P(t) = \sum_{k =1}^{n}e_{k}(t)f_{k}(t) = 0$$

$$\sum_{i = 0}^{n} e_{i} = 0 \text{ et } \underset{i=1}{\overset{n}{=}} f_{i}$$
