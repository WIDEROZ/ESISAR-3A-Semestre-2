# Exercice 1
## 1.
On a besoin de $8$ bascules min. pour faire un compteur $8$ bits

## 2.
Voir photo


## 3.
```VHDL
library IEEE;
use IEEE.STD_LOGIC1164.all;

entity compteur8 is
	port(
		clk    : in STD_LOGIC;
		rst    : in STD_LOGIC;
		enable : in STD_LOGIC;
		count  : out STD_LOGIC_VECTOR (7 downto 0)
	);
end compteur8;

architecture BEHAV of compteur8 is
signal count_intern : unsigned (7 downto 0) := (others => '0'); -- Attention a la synthèse pas tous les outils de syntèse autorisent la définition

begin
	compteur : process(clk, rst)
	begin
		if rst = '1' then
			count_intern <= (others => '0');
		else if clk'event and clk='1' then
			if enable = '1' then
				count_intern = count_intern + 1;
			end if;
		end if;
	end process;
	count <= STD_LOGIC(count_intern);
end BEHAV;
```


## 4.
```VHDL
entity compteur8_TB is
end compteur8_TB;

architecture BHV of compteur8_TB is
component counter is
	port(
		clk    : in STD_LOGIC;
		rst    : in STD_LOGIC;
		enable : in STD_LOGIC;
		count  : out STD_LOGIC_VECTOR (7 downto 0)
		);
end component;

begin
	DUT : compteur8
	port map(
		clk<=clk,
		rst<=rst,
		enable<=enable,
		count<=count 
	);
	
	process(clk)
	begin
		clk <= not clk after 5 ns;
	end process;
	
	enable <= '1', '0' after 50ns, '1' after 30 ns, '1' after 40 ns;
	rst <= '1', '0' after 50 ns, '1' after 200 ns;
	
end BHV;
```

# Exercice 2
#### 2.
```VHDL
entity SIPO is
	port(
		clk    : in STD_LOGIC;
		rst    : in STD_LOGIC;
		enable : in STD_LOGIC;
		D      : in STD_LOGIC;
		Q      : out STD_LOGIC_VECTOR (1 downto 0)
	);
end SPIO;

architecture BEHAV of SPIO is
component bascule is
	port(
		clk    : in STD_LOGIC;
		rst    : in STD_LOGIC;
		enable : in STD_LOGIC;
		D      : in STD_LOGIC;
		Q      : out STD_LOGIC_VECTOR (1 downto 0)
	);
end component;
begin
	B1 : bascule
	port map(
		D <= D;
		clk <= clk; 
		rst <= rst;
		enable <= enable;
		Q <= toto
	);
	
	B2: bascule
	port map(
		D <= toto;
		clk <= clk; 
		rst <= rst;
		enable <= enable;
		Q <= Q2
	);
	Q <= toto & Q2;
end BEHAV;

```