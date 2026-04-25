$$\begin{pmatrix}
L_{A} & L_{Rg}&IP&|&IP_{A}&IP_{C}&TCP&|&1035&80&SYN
\end{pmatrix}$$
$$\begin{pmatrix}
L_{Rd} & L_{Sg}&IP&|&IP_{A}&IP_{C}&TCP&|&1035&80&SYN
\end{pmatrix}$$
$$\begin{pmatrix}
L_{Sg} & L_{C}&IP&|&IP_{A}&IP_{C}&TCP&|&1035&80&SYN
\end{pmatrix}$$

On ne peut faire des requêtes ARP que dans un Réseau
ICMP : Donnés uniquement envoyé dans un réseau

$$\begin{pmatrix}
L_{a}&L_{c}&|&IP_{a}&IP_{h} & ttl =1 &|&UDP&3000&2000
\end{pmatrix}$$
$$\begin{pmatrix}
L_{c}&L_{a}&|&IP_{a}&IP_{h}&ICMP&\text{ttl expired}
\end{pmatrix}$$


$$\begin{pmatrix}
L_{a}&L_{c}&|&IP_{a}&IP_{h} & ttl =2 &|&UDP&3000&2000
\end{pmatrix}$$
$$\begin{pmatrix}
L_{c}&L_{e}&|&IP_{a}&IP_{h} & ttl =1&|&UDP&3000&2001
\end{pmatrix}$$
$$\begin{pmatrix}
\dots|&IP_{h}&IP_{a} &ICMP&\text{ttl expired}
\end{pmatrix}$$


$$\begin{pmatrix}
L_{a}&L_{c}&|&IP_{a}&IP_{h} & ttl =3 &|&UDP&3000&2000
\end{pmatrix}$$
$$\begin{pmatrix}
L_{c}&L_{e}&|&IP_{a}&IP_{h} & ttl =2&|&UDP&3000&2001
\end{pmatrix}$$
$$\begin{pmatrix}
L_{e}&L_{h}&|&IP_{a}&IP_{h} & ttl =1&|&UDP&3000&2002
\end{pmatrix}$$
$$\begin{pmatrix}
\dots|&IP_{h}&IP_{a} &ICMP & \text{Port unreachable}
\end{pmatrix}$$