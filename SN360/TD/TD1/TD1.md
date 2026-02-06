# Exercice 1
## 1.
$$\begin{cases}
\text{Signé : } [\![-2^{N-1}, 2^{N-1}-1]\!] \\
\text{Non signé : } [\![0, 2^{N}-1]\!]
\end{cases}$$
## 2.
$10$ bits non-signés : Tous les nombres positifs strictement inférieurs à : $2^{10} = 512$
$10$ bits non signés : Tous les nombres entre : $-256$ et $255$
$$344 = 0b0101011000 = 0x158$$
$$115 = 0b0001101001 = 0x73$$
$$-42 = 0b1111010110 = \begin{cases}
0x{3}D6 \text{ : réel}\\
0xFD6 \text{ : machine}
\end{cases}$$

## 5.
```VHDL
library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;

n : signal std_logic_vector(19 downto 0);
i : variable integer;
i:=293900;

v<=std_logic_vector(to_signed(i, v'length));

```

```Verilog
wire [18:0] s;
assign s=293900;
```

## 7.
```Verilog
wire signed [18:0] s;
assign s=-293900;
```


# Exercice 2
## 8.
$$\begin{array}{|c|c|}\hline
e&s \\ \hline
00&1 \\\hline
01&1 \\\hline
10&1 \\\hline
11&0  \\\hline
\end{array}$$
## 9.
$$\begin{array}{|c|c|}\hline
a&b&a \oplus b&\overline{a}.b+a.\overline{b} \\ \hline
0&0&0&0 \\\hline
0&1&1&1 \\\hline
1&0&1&1 \\\hline
1&1&0&0  \\\hline
\end{array}$$

## 10.
On veut : 
$$\begin{array}{|c|c|} \hline
a&b&a \text{ xnor } b& ab + \overline{a}\overline{b} \\ \hline
0&0&1&1 \\\hline
0&1&0&0 \\\hline
1&0&0&0 \\\hline
1&1&0&0 \\\hline
\end{array}$$



# Exercice 3
## 2.
```VHDL
entity Eq1 is
port(a, b : in bit
	 s    : out bit);
end Eq1;

entity Eq2 is
port(a, b, c : in bit
	 s    : out bit);
end Eq2;

architecture A of Eq1 is
begin
	s <= (a and b) or (a nor b);
end eq1;

architecture B of Eq2 is
begin
	s <= (a nand b) or c;
end eq2;

```