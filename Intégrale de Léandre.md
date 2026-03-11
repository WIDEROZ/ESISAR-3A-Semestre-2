$$I(t) = \int_{- \infty}^{+ \infty} e^{ itx } \frac{1-\cos(x)}{\pi x^{2}} \, dx $$
$$=\int_{\mathbb{R}} \cos(tx)\frac{ 1- \cos(x)}{\pi x^{2}} \, dx+ i\int_{\mathbb{R}} \sin(tx)\frac{1 - \cos(x)}{\pi x^{2}} \, dx$$
(car impaire centrée en $0$)
$$=\int_{\mathbb{R}} \frac{\cos(tx) - \cos(tx)\cos(x)}{\pi x^{2}} \, dx$$
Or, 
$$\forall a, b \in \mathbb{R}, \cos(a)\cos(b) = \frac{1}{2}(\cos(a-b)+\cos(a+b))$$
Alors, 
$$I(t)=\int_{\mathbb{R}} \frac{2\cos(tx)- \cos((t-1)x) -\cos((t+1)x)}{2\pi x^{2}} \, dx $$
$$= \int_{\mathbb{R}} \frac{\cos(tx)-1}{\pi x^{2}} \, dx - \frac{1}{2}\left( \int_{\mathbb{R}} \frac{\cos((t+1)x)-1}{\pi x^{2}} \, dx + \int_{\mathbb{R}} \frac{\cos((t-1)x)-1}{\pi x^{2}} \, dx \right) $$
De plus on pose : 
$$J(t) = \int_{\mathbb{R}} \frac{1-\cos(tx)}{\pi x^{2}} \, dx $$
Alors, 
$$J(t) = \frac{1}{2}(J(t-1)+J(t+1)) - J(t)$$
Or : 
en posant : 
$$\varepsilon = \begin{cases}
0&\text{si }t=0 \\
1&\text{si }t > 0 \\
-1&\text{si }t<0
\end{cases}$$
$$J'(t) = \int_{\mathbb{R}} \frac{\sin(tx)}{\pi x} \, dx \underset{u = xt}{=} \varepsilon\int_{\mathbb{R}} \frac{\sin(u)}{\pi u}\, du = \varepsilon $$
(Comme par le lemme de la mémoire $\int _{\mathbb{R}} \frac{\sin(x)}{x} \, dx = \pi$)
Donc, 
$$J(t) = \left| t\right| + C = \left| t\right| \text{ (car } J(0) = 0 \text{)} $$

Ainsi : 
$$\boxed{I(t) = \int_{\mathbb{R}} e^{ itx } \frac{1-\cos(x)}{\pi x^{2}} \, dx = \frac{\left| t-1\right|+\left| t+1\right|}{2} - \left| t\right|}$$
(Triangle $[-1, 1]$ d'amplitude $1$)
