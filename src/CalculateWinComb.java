import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateWinComb {
    // int[][] winCombNumsNums = {{0,1,2},{3,4,5},{6,7,8}, {0,3,6},{1,4,7},{2,5,8}, {0,4,8},{2,4,6}};
    private List<Integer[]> winCombNums = new ArrayList<>();

    CalculateWinComb(int sizeNumb) {
        // auto calculate winning comb when user input how many size number their want
        ArrayList<Integer> horizontalComb = new ArrayList<>();
        List<Integer> verticalComb = new ArrayList<>();
        List<Integer> diagonalComb1 = new ArrayList<>();
        List<Integer> diagonalComb2 = new ArrayList<>();
        for (int i = 0; i < sizeNumb; i++) {
            horizontalComb.add(i);
            verticalComb.add(i * sizeNumb);
            diagonalComb1.add(i * (sizeNumb + 1));
            diagonalComb2.add((i + 1) * (sizeNumb - 1));
        }

        winCombNums.add(horizontalComb.toArray(new Integer[0]).clone());
        for (int i = 0; i < winCombNums.size(); i++) {
            Integer[] temp;
            if (!winCombNums.isEmpty() && winCombNums.size() < sizeNumb) {
                for (int j = 0; j < horizontalComb.size(); j++) {
                    horizontalComb.set(j, horizontalComb.get(j) + sizeNumb);
                }
                temp = horizontalComb.toArray(new Integer[0]).clone();
                winCombNums.add(temp);
                if (winCombNums.size() == sizeNumb) {
                    winCombNums.add(verticalComb.toArray(new Integer[0]).clone());
                }
            } else {
                for (int j = 0; j < verticalComb.size(); j++) {
                    verticalComb.set(j, verticalComb.get(j) + 1);
                }
                temp = verticalComb.toArray(new Integer[0]).clone();
                if (winCombNums.size() >= sizeNumb * 2) {
                    winCombNums.add(diagonalComb1.toArray(new Integer[0]));
                    winCombNums.add(diagonalComb2.toArray(new Integer[0]));
                    break;
                } else {
                    winCombNums.add(temp);
                }
            }
        }
        System.out.println(Arrays.deepToString(winCombNums.toArray()));
    }

    public List<Integer[]> getWinComb() {
        return this.winCombNums;
    }
}
