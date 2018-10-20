package answers;
import java.util.Arrays;

public class Question1 {

    public static int bestMergedPortfolio(int[] portfolios) {
        int maxMergedPort = -1;
        int tempMergedPort;

        Arrays.sort(portfolios);
        for (int i = 0; i < portfolios.length - 1; i++) {
            tempMergedPort = portfolios[i] ^ portfolios[i + 1];
            if (tempMergedPort > maxMergedPort)
                maxMergedPort = tempMergedPort;
        }
        return maxMergedPort;
    }

}
