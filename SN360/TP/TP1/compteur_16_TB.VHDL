library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity compteur_16_TB is
end compteur_16_TB;

architecture bhv of compteur_16_TB is

    signal clk_TB, rst_TB, enable_TB, deb_TB : STD_LOGIC;
    signal out_count_TB : STD_LOGIC_VECTOR (3 downto 0);

    component compteur_16
        port(clk, rst, enable : in STD_LOGIC;
             deb              : out STD_LOGIC;
             out_count        : out STD_LOGIC_VECTOR
            );
    end component;

    begin




        COMPTEUR: compteur_16
        port map(clk_TB, rst_TB, enable_TB, deb_TB, out_count_TB);

    end bhv ;