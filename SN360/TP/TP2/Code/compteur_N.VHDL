library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;


entity compteur_N is
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
end compteur_N;

architecture BEHAV of compteur_N is

    signal C_MAX_COUNT_STD_LOGIC_INTERN : unsigned := to_unsigned(C_MODULO-1, C_NB_BIT_COUNTER+1);
    signal count_intern : unsigned := unsigned(out_count);

    begin
        process(clk)
        begin
            if clk'event and clk='1' then
                if rst='1' then
                    count_intern <= (others => '0');
                elsif enable='1' then
                    if max='1' then
                        count_intern <= (others => '0');
                        max <= '0';
                    else
                        count_intern <= count_intern + 1;
                        if C_MAX_COUNT_STD_LOGIC_INTERN=count_intern then
                            max <= '1';
                        end if;
                    end if;
                end if;
            end if;




        end process;

        out_count <= std_logic_vector(count_intern);
    
    end BEHAV;

    