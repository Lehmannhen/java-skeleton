package answers;
import java.lang.Math;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {

        if (allowedAllocations == null || allowedAllocations.length == 0)
            return 0;

        boolean existAtLeastOneSolution = false;

        // Scan through to see if there exist a min solution
        for (int i = 0; i < allowedAllocations.length; i++) {
            if (allowedAllocations[i] == totalValue)
                return 1;
            else if ((totalValue % allowedAllocations[i]) == 0)
                existAtLeastOneSolution = true;
        }

        // No solution
        if (!existAtLeastOneSolution)
            return 0;

        int[][] dynamicP = new int[allowedAllocations.length + 1][];

        // initialise matrix
        for (int i = 0; i < dynamicP.length; i++) {
            dynamicP[i] = new int[totalValue + 1];
            for (int j = 0; j < totalValue + 1; j++)
                dynamicP[i][j] = 0;
        }

        // initialise first row with corresponding sum
        for (int i = 0; i < totalValue + 1; i++)
            dynamicP[0][i] = i;

        for (int i = 1; i <= allowedAllocations.length; i++) {
            for (int j = 1; j <= totalValue; j++) {
                if (allowedAllocations[i - 1] == j)
                    dynamicP[i][j] = 1;
                else if (allowedAllocations[i - 1] > j)
                    dynamicP[i][j] = dynamicP[i - 1][j];
                else
                    dynamicP[i][j] = Math.min(dynamicP[i - 1][j], 1 +
                                            dynamicP[i][j - allowedAllocations[i - 1]]);
            }
        }

        return dynamicP[allowedAllocations.length][totalValue];
	}
}
