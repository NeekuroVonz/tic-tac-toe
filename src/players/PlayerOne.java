package players;

import java.util.ArrayList;
import java.util.List;

public class PlayerOne implements Player {
    private List<Integer> comb = new ArrayList<>();
    PlayerOne(int i) {
        comb.add(i);
    }

    @Override
    public List<Integer> playerComb() {
        return comb;
    }

    @Override
    public void checkWin() {
        
    }
    
}
