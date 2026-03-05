# 1. Codage d'un compteur modulo $16$
```VHDL
entity compteur_16 is
	Port ( clk       : in STD_LOGIC;
		   rst       : in STD_LOGIC;
		   enable    : in STD_LOGIC;
		   deb       : out STD_LOGIC;
		   out_count : out STD_LOGIC_VECTOR (3 downto 0)
);
end compteur_16;

architecture bhv of compteur_16 is
{
	
}end bhv;
```
