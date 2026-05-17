# Exercice 1
## 1, 2 - Graph de Bond
On pose la vitesse relative : 
$$v(t)$$
($+T$ signifie que la vitesse relative est positive lorsque le système est en extension)
$$e = \text{Tension} / \text{Force}$$
$$f = \text{Courrant} / \text{Vitesse}$$

## 3 - Algorithme $PS^{3}$
On souhaite trouver :
$$\dot{x}(t) = Ax(t) + Be_{1}(t)$$
On initialise la variable d'entrée : 
$$F(t) = e_{1}(t)$$
Les éléments qui stockent de l'énergie sont : $M_{1}, M_{2}, \frac{1}{k_{s}}$
On a alors : 
$$\dot{x}(t) = \begin{pmatrix}
\dot{q}(t) \\
\dot{p}_{1}(t) \\
\dot{p}_{2}(t)
\end{pmatrix} = A\begin{pmatrix}
q(t) \\
p_{1}(t) \\
p_{2}(t)
\end{pmatrix} + BF_{\mathrm{ext}}(t)$$
On a alors par définition des flows et des efforts : 
$$\begin{cases}
\dot{q}(t) = \frac{1}{k_{s}} f_{4} \\
\dot{p}_{1}(t) = \frac{1}{M_{1}}e_{3} \\
\dot{p}_{2}(t) = \frac{1}{M_{2}}e_{2} \\
 \\
{q}(t) = \frac{1}{k_{s}} e_{4} \\
{p}_{1}(t) = \frac{1}{M_{1}}f_{3} \\
{p}_{2}(t) = \frac{1}{M_{2}}f_{2} \\
 \\
e_{1}=F_\mathrm{ext} (t)
\end{cases}$$
Alors, comme d'après le graphe : 
$$f_{4} = f_{6} = f_{8}-f_{7} = f_{2} -f_{3}$$
$$e_{3} = e_{7} = e_{6} = e_{4} + e_{5} = e_{4} + \nu_{s}f_{4}=e_{4} + \nu_{s}(f_{2}-f_{3})$$
$$e_{2} = e_{1}-e_{8} = e_{1} - e_{7} = e_{1} - e_{3} = e_{1} - e_{4} - \nu_{s}(f_{2}-f_{3})$$
On a alors : 
$$\begin{cases}
\dot{q}(t) = \frac{M_{2}}{k_{s}}p_{2}(t) - \frac{M_{1}}{k_{s}}p_{1}(t) \\
\dot{p}_{1}(t) = \frac{k_{s}}{M_{1}}q(t) + \frac{\nu_{s}M_{2}}{M_{1}}p_{2}(t) -\nu_{s}M_{1} p_{1}(t) \\
\dot{p}_{2}(t) = \frac{1}{M_{2}} F_{ext}(t)-\frac{k_{s}}{M_{2}}q(t) - \nu_{s}p_{2}(t)+\frac{\nu _{s}M_{1}}{M_{2}}p_{1}(t))
\end{cases}$$
$$\boxed{\begin{pmatrix}
\dot{q}(t) \\
\dot{p}_{1}(t) \\
\dot{p}_{2}(t)
\end{pmatrix} = \begin{pmatrix}
0&-\frac{M_{1}}{k_{s}}& \frac{M_{2}}{k_{s}} \\
\frac{k_{s}}{M_{1}} & -\nu_{s}M_{1} &\frac{\nu_{s}M_{2}}{M_{1}} \\
-\frac{k_{s}}{M_{2}} & \frac{\nu_{s}M_{1}}{M_{2}} & -\nu_{s}
\end{pmatrix}\begin{pmatrix}
{q}(t) \\
{p}_{1}(t) \\
{p}_{2}(t)
\end{pmatrix} + \begin{pmatrix}
0 \\
0 \\
\frac{1}{M_{2}}
\end{pmatrix}F_\mathrm{ext}}$$

#### 4.
Energie :
$$E_{c}(t) = \frac{p_{1}^{2}(t)}{2M_{1}} + \frac{p_{2}^{2}(t)}{2M_{2}}$$
$$E_{p}(t) = \frac{k_{s}}{2}q(t)^{2}$$
$$E_{m}(t) = E_{c}(t) + E_{p}(t)$$

Puissance :
$$\mathcal{P}_{ext} = F_{ext}v_{2}$$
$$\mathcal{P}_{diss} = \nu_{s}v^{2}$$

Ainsi, 
$$\frac{d}{dt} E_{m} =\mathcal{P}_{ext}-\mathcal{P}_{diss}$$
Par le principe de conservation de l’énergie 


# Exercice 2
#### 1.
$$H(p, q, \phi) = -mgq + \frac{p^{2}}{2m} + \frac{\phi^{2}}{2L(q)}$$
$$H_{1}(q, \phi) = -mgq+\frac{\phi^{2}}{2L(q)}$$
Alors, 
$$\dot{x}(t) = f(V(t), x(t))$$
On pose alors :  
$$\dot{x} = Ax(t) + BV(t)$$
Donc, 
$$\frac{\partial H_{1}}{\partial q} =-mg+\frac{\phi^{2}L'(q)}{2L(q)^{2}}$$
$$\frac{\partial H_{1}}{\partial \phi} =\frac{\phi}{L(q)}$$
#### 2.
En appliquant PS3 on a alors : 
$$\boxed{\begin{cases}
\dot{q} = \frac{\partial H}{\partial p}  =\frac{p}{m} \\
\dot{p}=-\frac{\partial H}{\partial q} =-mg+\frac{\phi^{2}L'(q)}{2L^{2}(q)}=-mg + \frac{\phi^{2}(L_{\infty}-L_{0})}{2(L_{0}+qL_{\infty})^{2}} \\
\dot{\phi}=-R \frac{\partial H}{\partial \phi} +V=-\frac{R\phi}{L(q)} + V= - \frac{R\phi(1+q)}{L_{0}+qL_{\infty}}+V
\end{cases}}$$

#### 3.
On a donc : 
$$\frac{\partial H(x(t))}{\partial x} = \begin{pmatrix}
mg-\frac{\phi^{2}(L_{\infty}-L_{0})}{2(L_{0}+qL_{\infty})^{2}} \\
\frac{p}{m} \\
\frac{\phi(1+q)}{L_{0}+qL_{\infty}}
\end{pmatrix} $$
et si on pose :
$$J = \begin{pmatrix}
0 & 1 & 0 \\
-1 & 0 & 0 \\
0 & 0 & 0
\end{pmatrix}\text{ et } R = \begin{pmatrix}
0 & 0 & 0 \\
0 & 0 & 0 \\
0 & 0 & R
\end{pmatrix} \text{ et } g= \begin{pmatrix}
0 \\
0 \\
1
\end{pmatrix} \text{ et } u(t)= V(t)$$
Ainsi :
$$\boxed{\dot{x}(t) = (J-R)\frac{\partial H(x(t))}{\partial x} + gu(t)}$$

#### 4.
On pose : 
$$I=\frac{\phi}{L(q)}$$

Energie : 
$$E_{c} = \frac{p^{2}}{2m}$$
$$E_{p} = mgq +\frac{\phi^{2}}{2L(q)}$$
$$E_{m}= H(q, p, \phi)$$

Puissance : 
$$P_{elec} = VI$$
$$P_{diss} = RI^{2}$$
$$\frac{dE_{m}}{dt} = P_{elec} - \mathcal{P}_{diss}$$
