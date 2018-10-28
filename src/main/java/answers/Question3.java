package answers;

import java.util.HashSet;
import helpers.Edge;

public class Question3 {

	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
        HashSet<Integer> exchanges = new HashSet<Integer>();
        int numTimesVisited[] = new int[numNodes + 1];
        int numOfTrades = edgeList.length - 1;
        int edgeA;
        int edgeB;

        for (int i = 1; i < numTimesVisited.length; i++)
            numTimesVisited[i] = 0;

        edgeA = edgeList[1].getEdgeA();
        edgeB = edgeList[1].getEdgeB();
        exchanges.add(edgeA);
        exchanges.add(edgeB);
        numTimesVisited[edgeA]++;
        numTimesVisited[edgeB]++;

        for (int e = 2; e < edgeList.length; e++) {
            edgeA = edgeList[e].getEdgeA();
            edgeB = edgeList[e].getEdgeB();
            if (exchanges.contains(edgeA)) {
                numTimesVisited[edgeA]++;
                if (numTimesVisited[edgeA] == 2)
                    numOfTrades--;
            }
            else {
                exchanges.add(edgeA);
                numTimesVisited[edgeA]++;
            }
            if (exchanges.contains(edgeB)) {
                numTimesVisited[edgeB]++;
                if (numTimesVisited[edgeB] == 2)
                    numOfTrades--;
            }
            else {
                exchanges.add(edgeB);
                numTimesVisited[edgeB]++;
            }

        }

        return numOfTrades;
	}

}
