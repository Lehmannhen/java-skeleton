package answers;

import java.util.Arrays;
import helpers.Edge;

public class Question3 {

    public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
        int[] counts = new int[numNodes + 1];
        int length = counts.length;
        int numOfTrades = 0;
        int numOfLeast = 1;
        int numOfMost = 1;
        int temp;
        int i;

        if (edgeList == null || edgeList.length == 0)
            return 0;

        for (int j = 0; j < length; j++)
            counts[j] = 0;

        for (Edge e: edgeList) {
            counts[e.getEdgeA()]++;
            counts[e.getEdgeB()]++;
        }

        Arrays.sort(counts);

        // Find number of of exchanges with least connections
        temp = counts[1];
        i = 2;

        while (i < length) {
            if (temp == counts[i]) {
                numOfLeast++;
            }
            else
                break;
            i++;
        }

        if (i >= length)
            return numOfLeast;

        temp = counts[numNodes];
        for (int j = numNodes - 1; j > 0; j--) {
            if (temp == counts[j]) {
                numOfMost++;
            }
            else
                break;
        }

        numOfTrades = numOfLeast - numOfMost;

        return numOfTrades;

    }

}
