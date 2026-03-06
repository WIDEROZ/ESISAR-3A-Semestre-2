$$J(t) = \int_{- \infty}^{+ \infty} e^{ itx } \frac{1-\cos(x)}{\pi x^{2}} \, dx $$
$$=\int_{\mathbb{R}} \cos(tx)\frac{ 1- \cos(x)}{\pi x^{2}} \, dx+ i\int_{\mathbb{R}} \sin(tx)\frac{1 - \cos(x)}{\pi x^{2}} \, dx$$
(car impaire centrée en $0$)
$$=\int_{\mathbb{R}} \frac{\cos(tx) - \cos(tx)\cos(x)}{\pi x^{2}} \, dx$$
Or, 
$$\cos(a)\cos(b) = \frac{1}{2}(\cos(a-b)+\cos(a+b))$$
Alors, 
$$J(t)=\int_{\mathbb{R}} \frac{2\cos(tx)- \cos((t-1)x) -\cos((t+1)x)}{2\pi x^{2}} \, dx $$
De plus on pose : 
$$I(t) = \int_{\mathbb{R}} \frac{\cos(tx)-1}{\pi x^{2}} \, dx $$
Alors, 
$$J(t) = I(t)-\frac{1}{2}(I(t-1)+I(t+1))$$
($+2$, $-2$ au numérateur de $J(t)$)
Or : 
$$I'(t) = -\int_{\mathbb{R}} \frac{\sin(tx)}{\pi x} \, dx \underset{u = xt}{=} - \int_{\mathbb{R}} \frac{\sin(u)}{\pi u}\, du = -1 $$
(par le lemme de la mémoire $\int _{\mathbb{R}} \frac{\sin(x)}{x} \, dx = \pi$)
Donc, 
$$I(t) = -t + C = -t \text{ (car } I(0) = 0 \text{)} $$

Ainsi : 
$$\boxed{\int_{\mathbb{R}} e^{ itx } \frac{1-\cos(x)}{\pi x^{2}} \, dx = -t - \frac{1}{2}(-(t-1) - (t+1))= 0}$$
