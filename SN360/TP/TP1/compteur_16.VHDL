library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity compteur_16 is
	Port (clk       : in STD_LOGIC;
		  rst       : in STD_LOGIC;
		  enable    : in STD_LOGIC;
		  deb       : out STD_LOGIC;
		  out_count : out STD_LOGIC_VECTOR (3 downto 0)
         );
end compteur_16;

architecture bhv of compteur_16 is

    signal count : UNSIGNED(3 downto 0);

    begin
        process(clk)

        begin
        if clk'event and clk='1' then
            if rst = '1' then
                deb <= '0';
                count <= "0000";
            elsif enable = '1' then
                if out_count = '1111' then
                    deb <= '1';
                    count <= "0000";
                else
                    deb <= '0';
                    count <= count + 1;
                end if;
            else
                deb <= '0';
            end if;
        end if;

        end process;

        out_count <= std_logic_vector(count);

    end bhv;