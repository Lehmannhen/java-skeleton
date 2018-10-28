package answers;
import java.util.HashSet;

public class Question1 {

    public static int bestMergedPortfolio(int[] portfolios) {
        int maxPortfolio = 0;
        int bitMask = 0;

        for(int k = 31; k >= 0; k--) {
            bitMask = bitMask | (1 << k);
            HashSet<Integer> set = new HashSet<>();

            int temp = maxPortfolio | (1 << k);
            for (int i = 0; i < portfolios.length; i++) {
                int stockAndMask = portfolios[i] & bitMask;
                if (set.contains(temp ^ stockAndMask)) {
                    maxPortfolio = temp;
                    break;
                }
                set.add(stockAndMask);
            }

        }
        return maxPortfolio;
    }

}
