package answers;
import java.lang.Math;

public class Question1 {

    public static int bestMergedPortfolio(int[] portfolios) {
        int maxPortfolio = 0;

        if(portfolios == null || portfolios.length == 0) {
            return 0;
        }
        // Build the trie
        Trie rootNode = new Trie();
        for(int stock: portfolios) {
            Trie currentPos = rootNode;
            for(int i = 16; i >= 0; i--) {
                int currentBit = (stock >>> i) & 1;
                if(currentPos.children[currentBit] == null) {
                    currentPos.children[currentBit] = new Trie();
                }
                currentPos = currentPos.children[currentBit];
            }
        }

        for(int stock: portfolios) {
            Trie currentPos = rootNode;
            int currentSum = 0;
            for(int j = 16; j >= 0; j--) {
                int currentBit = (stock >>> j) & 1;
                if(currentPos.children[currentBit ^ 1] != null) {
                    currentSum += (1 << j);
                    currentPos = currentPos.children[currentBit ^ 1];
                }
                else {
                    currentPos = currentPos.children[currentBit];
                }
            }
            maxPortfolio = Math.max(currentSum, maxPortfolio);
        }

        return maxPortfolio;
    }

}


class Trie {
    Trie[] children;
    public Trie() {
        children = new Trie[2];
    }
}
