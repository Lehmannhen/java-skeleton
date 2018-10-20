package answers;
import java.util.Arrays;

public class Question1 {

    public static int bestMergedPortfolio(int[] portfolios) {
        int maxMergedPort = -1;
        int tempMergedPort;
        int n = portfolios.length;

        Arrays.sort(portfolios);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                tempMergedPort = portfolios[i] ^ portfolios[j];
                if (tempMergedPort > maxMergedPort)
                    maxMergedPort = tempMergedPort;
            }
        }
        return maxMergedPort;
    }

}
