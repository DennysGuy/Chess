package Engine;

import Board.*;

public class Move {
    private Player player;
    private Square start;
    private Square end;

    public Move(Player player, Square start, Square end){
        this.player = player;
        this.start = start;
        this.end = end;

    }

}
