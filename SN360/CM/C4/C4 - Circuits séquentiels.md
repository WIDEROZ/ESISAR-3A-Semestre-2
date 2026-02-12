# I - Définition
### Circuit comb
Un circuit combinatoire est un circuit ou la sortie peut changer si on a la même entrée.  

### 1. D-latch (Bascule Verrou)
![[Pasted image 20260212083806.png]]

```VHDL
process(d,c)
begin
if c='1' then
	q<=d;
end if;
end process;

```

```Verilog
always @(*)
begin
	if (c) begin
		q=d;
	end
end
```

##### Transparence des D-latch
Le résultat de : 
![[Pasted image 20260212085947.png]]
Dépend du temps de propagation. 

### 2. D-Flip-Flop
![[Pasted image 20260212090151.png]]
![[Pasted image 20260212090159.png]]
- Si D change quand H présente un front montant, Q est indéterminé
- Intervalle de commutation interdit de $D$ : $T_{\text{Setup}}$ avant et $T_{\text{Hold}}$ après le front d’horloge actif. 
![[Pasted image 20260212090658.png]]





```VHDL

```

```Verilog

```