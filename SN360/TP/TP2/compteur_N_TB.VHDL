library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;

entity compteur_N is
end compteur_N;

architecture BHV of compteur_N is


    signal clk_TB : STD_LOGIC := '0';
    signal rst_TB : STD_LOGIC;
    signal enable_TB : STD_LOGIC;
    signal max_TB : STD_LOGIC;
    signal out_count_TB : STD_LOGIC_VECTOR (3 downto 0);

    component COUNTER
        Generic (
                C_NB_BIT_COUNTER : integer;
                C_MODULO : integer
        );
        Port (  
                clk : in STD_LOGIC;
                rst : in STD_LOGIC;
                enable : in STD_LOGIC;
                max : out STD_LOGIC;
                out_count : out STD_LOGIC_VECTOR (C_NB_BIT_COUNTER - 1 downto 0)
        );
    end component;

    begin
        clk_TB <= not clk_TB after 10 ns;
        


    end BHV ;
