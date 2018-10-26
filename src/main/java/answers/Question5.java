package answers;
import java.lang.Math;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {

        if (allowedAllocations == null || allowedAllocations.length == 0)
            return 0;

        int[] dynamicP = new int[totalValue + 1];

        // No overflow issues
        int max = Integer.MAX_VALUE - 1000000;
        dynamicP[0] = 0;

        for (int i = 1; i <= totalValue; i++)
            dynamicP[i] = max;

        for (int i = 0; i <= allowedAllocations.length - 1; i++) {
            for (int k = 1; k <= totalValue; k++) {
                if (allowedAllocations[i] <= k)
                    if ((dynamicP[k - allowedAllocations[i]] + 1) < dynamicP[k])
                        dynamicP[k] = dynamicP[k - allowedAllocations[i]] + 1;
            }
        }

        if (dynamicP[totalValue] == max)
            return 0;
        else
            return dynamicP[totalValue];

	}
}
