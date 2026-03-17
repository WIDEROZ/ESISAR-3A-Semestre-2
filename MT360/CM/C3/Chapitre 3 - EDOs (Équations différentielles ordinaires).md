# 3. Méthodes de Runge-Kutta
Soit un problème de Cauchy :



____
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
$$x(t + h) = x(t) + h(R_{1}f(x(t)) + R_{2} \dots)$$
