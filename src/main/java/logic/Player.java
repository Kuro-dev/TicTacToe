package logic;

public interface Player {

    void setSymbol(PlayerSymbol symbol);

    /**
     * Select field, put your symbol in there during your turn
     */
    void doMove();
    
    
}
