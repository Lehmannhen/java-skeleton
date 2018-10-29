package answers;
import java.lang.Math;

public class Question1 {

    public static int bestMergedPortfolio(int[] portfolios) {
        int maxPortfolio = -1;
        int temp;

        for (int i = 0; i < portfolios.length - 1; i++) {
            for (int j = i + 1; j < portfolios.length; j++) {
                temp = portfolios[i] ^ portfolios[j];
                maxPortfolio = Math.max(maxPortfolio, temp);
            }
        }
        return maxPortfolio;
    }

}
