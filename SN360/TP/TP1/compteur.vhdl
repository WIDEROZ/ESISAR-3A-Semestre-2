

entity compteur_16 is
	Port ( clk       : in STD_LOGIC;
		   rst       : in STD_LOGIC;
		   enable    : in STD_LOGIC;
		   deb       : out STD_LOGIC;
		   out_count : out STD_LOGIC_VECTOR (3 downto 0)
);
end compteur_16;

architecture bhv of compteur_16 is
begin
	if clk'event and clk='1' then
        if rst = '1' and enable then
            deb <= '1'
            out_count <= '000'

end bhv;