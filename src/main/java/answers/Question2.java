package answers;
import java.util.ArrayList;
import java.lang.Math;

public class Question2 {

    public static int equallyBalancedCashFlow(int[] cashflowIn, int[] cashflowOut) {
        ArrayList<Integer> cashIn = subArraySums(cashflowIn);
        ArrayList<Integer> cashOut = subArraySums(cashflowOut);
        int n = cashIn.size();
        int m = cashOut.size();

        // Consider on of the empty subsets and the smallest subset sum
        // in the other array and vice versa, works because lists are sorted
        int smallestDiff = cashIn.get(1);

        if (cashOut.get(1) < smallestDiff)
            smallestDiff = cashOut.get(1);

        int temp;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                temp = Math.abs(cashIn.get(i) - cashOut.get(j));
                if (temp < smallestDiff) {
                    smallestDiff = temp;
                }
            }
        }

        return smallestDiff;
    }



    public static int totalCashflowSum(int[] cashFlow) {
        int sum = 0;

        for (int i = 0; i < cashFlow.length; i++) {
            sum += cashFlow[i];
        }

        return sum;
    }


    public static ArrayList<Integer> subArraySums(int[] cashFlow) {
        int n = cashFlow.length;
        int subSumArr[];
        int sum = totalCashflowSum(cashFlow);


        ArrayList<Integer> sumList = new ArrayList<Integer>();
        int[] dpArr = new int[sum + 1];
        dpArr[0] = 1;

        for (int i = 0; i < n; i++)
            for (int j = sum; j >= cashFlow[i]; j--)
                dpArr[j] += dpArr[j - cashFlow[i]];

        for (int i = 0; i <= sum; i++) {
            if (dpArr[i] > 0)
                sumList.add(i);
        }

        return sumList;
    }
}
