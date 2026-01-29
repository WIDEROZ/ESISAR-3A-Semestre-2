# I. Types et objets
### VHDL
#### Variable entière
```VHDL
-- Commentaire
variable i : integer;
i:=10;
```

#### Signal bit
```VHDL
signal s1 : bit;
s1 <= '0';
```

#### Vecteur de bits
```VHDL
variable v : bit_vector(3 downto 0);
v:="0101";
```
3 downto 0 : met l'indice $3$ à gauche et l'indice $0$ à droite
0 to 3 : met l'indice $0$ à gauche et l'indice $3$ à droite

#### Entiers non signés
```VHDL
library IEEE;
use IEEE.std_logic1164.all;
signal s : std_logic_vector(5 downto  0);
s <= ""
```

### Verilog
```Verilog
// Commentaire
wire w1 w2 w3;

assign w1=1'b0;
assign w2=1'b1;
assign w3=1'bX; // Inconnu
```
1'b0 : $1$ bit qui vaut 0
1'b1 : $1$ bit qui vaut 1
1'bX : $1$ bit qui vaut une inconnue
1'bZ : $1$ bit qui n'est pas initialisé




```VHDL

```
```Verilog

```