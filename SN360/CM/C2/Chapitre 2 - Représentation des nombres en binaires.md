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
-- Trpe de std_logic par défaut à U
library IEEE;
use IEEE.std_logic1164.all;
signal s : std_logic_vector(5 downto 0);
s <= "U01XZ-";
```
Il y a $9$ valeurs différentes possibles pour std_logic
Par défaut on assigne $U$ à un std_logic

#### Hexadécimal
```VHDL
variable v : bit_vector(15 downto 0);
v:=x"1D9A";
```


### Verilog
```Verilog
// Commentaire
wire w1 w2 w3;

// Bits
assign w1=1'b0;
assign w2=1'b1;
assign w3=1'bX; // Inconnu

// Vecteurs de bits
wire [3:0] v1;
assign v1=4'bX01Z;

// Hexadécimal
wire [15, 0]v2;
assign v1=16h'1D9A 
```
1'b0 : $1$ bit qui vaut 0
1'b1 : $1$ bit qui vaut 1
1'bX : $1$ bit qui vaut une inconnue
1'bZ : $1$ bit qui n'est pas initialisé

# II. Conversion de types
![[Pasted image 20260206110708.png]]

#### std_logic_vector $\Leftrightarrow$ integer
```VHDL
library IEEE;
use IEEE.std_logic1164.all;
use IEEE.numeric_std.all;

signal s1 : integer;
signal s2 : std_logic_vector(15 downto 0);

s2<=std_logic_vector(to_unsigned(s1, 16));

s1<=to_integer(unsigned(s2));

```

```Verilog
wire [15:0] s1 s2;
assign s2=16'd7562
assign s1=s2
```

#### Complément à $2$
```VHDL
library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;

signal s1: unsigned(3 downto 0);
signal s2: signed(3 downto 0);

s1<=to_unsigned(15,4);
s2<=to_signed(-8,4);
```

```Verilog
wire [3:0] s1;
wire signed [3:0] s2;

assign s1=4'b1000; // 8
assign s2=4'b1000; //-8

```
Par défaut les wire sont non signés il suffit d'ajouter signed pour qu'ils le deviennent. 
