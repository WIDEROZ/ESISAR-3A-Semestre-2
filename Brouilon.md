## 1.2 Spécifications pour la synthèse de la commande
#### Modélisation du système
On prend une fonction de transfert d'ordre $2$ : 
$$\boxed{T(u) = \frac{G}{1+2\xi u + u^{2}} e^{  -t_{R} \omega_{0} u }}$$
avec : 
- $\xi$ le coefficient d'amortissement
- $u = \frac{p}{\omega_{0}}$
- $\omega_{0} = \frac{1}{\tau}$ la pulsation propre du système
- $G$ le gain

##### Validité fréquentielle
$$T(p) = \frac{G}{1+\frac{2\xi}{\omega_{0}}  p + \left( \frac{\omega}{\omega_{0}} \right)^{2}} e^{ -t_{R}p }$$
$$\boxed{G_{dB} =  20 \log(G) - 10 \log\left( \left( 1-\left( \frac{\omega}{\omega_{0}} \right)^{2} \right)^{2} + 4 \left( \frac{\xi \omega}{\omega_{0}} \right)^{2} \right)}$$
$$\varphi = \mathrm{arg}(T(p)) = -t_{R}\omega- \mathrm{arg}\left( 1- \left( \frac{\omega}{\omega_{0}} \right)^{2}+j\frac{2\xi}{\omega_{0}} \omega \right)  $$
Si $\omega \leq \omega_{0}$ : 
$$\boxed{\varphi = -t_{R}\omega -\arctan\left( \frac{\frac{\omega_{0}}{\omega}- \frac{\omega}{\omega_{0}} }{2\xi} \right)}$$
Si $\omega \geq \omega_{0}$ : 
$$\boxed{\varphi =\pi -t_{R}\omega -\arctan\left( \frac{\frac{\omega_{0}}{\omega}- \frac{\omega}{\omega_{0}} }{2\xi} \right) }$$

##### Retard pur
De même que précédemment : 
$$\boxed{t_{R} \leq t_{R, \max} = 5 \, ms}$$



#### Schéma fonctionnel
EXCAL 4
- $P_{b}(p)$ : Bruit de mesure
- $P_{u}(p)$ : Perturbation de la commande
- $P_{y}(p)$ : Variations lentes $\Delta H(p)$ de $H(p)$
- $R(p)$ : Consigne que doit suivre la sortie
- $U(p)$ : Entrée(s) du système (Commande actionneur)


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


