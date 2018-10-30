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

        if ((counts[1] == counts[numNodes]) && counts[numNodes] == 1) {
            return numNodes;
        }

        numOfLeast = count(counts, counts[1], counts.length);
        numOfMost = count(counts, counts[numNodes], counts.length);

        numOfTrades = numOfLeast - numOfMost;

        return numOfTrades;

    }

    static int count(int arr[], int x, int n) {
        int i;
        int j;

        i = first(arr, 0, n-1, x, n);

        if(i == -1)
            return i;

        j = last(arr, i, n-1, x, n);

        return j - i + 1;
    }


    static int first(int arr[], int low, int high, int x, int n) {
        if(high >= low) {

            int mid = (low + high) / 2;
            if((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            else if(x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }


    static int last(int arr[], int low, int high, int x, int n) {
        if(high >= low) {

            int mid = (low + high) / 2;
            if((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x )
                return mid;
            else if(x < arr[mid])
                return last(arr, low, (mid - 1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }

}
