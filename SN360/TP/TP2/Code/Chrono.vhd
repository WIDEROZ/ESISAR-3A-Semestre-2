library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;


entity chrono is
    port(
        start : in std_logic;
        clk   : in std_logic;
        rst   : in std_logic;
        
        seconds : out std_logic_vector(7 downto 0);
        minutes : out std_logic_vector(7 downto 0)
    );
end chrono;

architecture BHV of chrono is

    signal max_27_8 : STD_LOGIC;
    signal max_8_8 : STD_LOGIC;
    signal rst_27_8 : STD_LOGIC;
    signal out_count_seconds : STD_LOGIC_VECTOR(7 downto 0);
    signal out_count_minutes : STD_LOGIC_VECTOR(7 downto 0);


    component compteur_N
        Generic (
            C_NB_BIT_COUNTER : integer;
            C_MODULO         : integer
        );
        Port ( 
            clk       : in  STD_LOGIC;
            rst       : in  STD_LOGIC;
            enable    : in  STD_LOGIC;
            max       : out STD_LOGIC;
            out_count : out STD_LOGIC_VECTOR (C_NB_BIT_COUNTER - 1 downto 0)
        );
    end component;
    
    
    
    begin

    COUNT_27 : compteur_N
        generic map (
            C_NB_BIT_COUNTER => 27,
            C_MODULO => 100000000
        )
        port map (
            clk => clk,
            rst => rst,
            enable => start,
            max => max_27_8,
            out_count => open
        );
        
    COUNT_seconds : compteur_N
        generic map (
            C_NB_BIT_COUNTER => 8,
            C_MODULO => 60
        )
        port map (
            clk => clk,
            rst => rst,
            enable => max_27_8,
            max => max_8_8,
            out_count => out_count_seconds
        );
        
     COUNT_minutes : compteur_N
        generic map (
            C_NB_BIT_COUNTER => 8,
            C_MODULO => 60
        )
        port map (
            clk => clk,
            rst => rst,
            enable => max_8_8,
            max => open,
            out_count => out_count_minutes
        );
        
     
     seconds <= out_count_seconds;
     minutes <= out_count_minutes;


end BHV;
