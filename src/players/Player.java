package players;

import java.util.List;

public interface Player {
    public List<Integer> playerComb();
    public void checkWin();
    int stepToWin = 3;
}
