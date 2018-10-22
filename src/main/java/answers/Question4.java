package answers;
import java.lang.Math;

public class Question4 {

    public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
        int minTime = Integer.MAX_VALUE;
        int tempTime = 0;
        boolean isNonZero = false;

        for (int i = 0; i < rows.length; i++) {
            tempTime = selectionFailedTradedesks(rows[i], numberMachines);
            if (tempTime > 0) {
                minTime = Math.min(minTime, tempTime);
                isNonZero = true;
            }
        }
        if (!isNonZero)
            return 0;

        return minTime;
    }



    public static int selectionFailedTradedesks(String[] row, int numberMachines) {
        int[] consecMachineSums = new int[row.length + 1];

        int minTime;
        int newTime;
        int startingPoint = 0;
        consecMachineSums[0] = 0;
        int numTraders = row.length;

        startingPoint = subsecKSum(consecMachineSums, startingPoint, numberMachines,
                                   numTraders, row);
        if (startingPoint == -1) {
            return 0;
        }

        minTime = consecMachineSums[startingPoint];
        for (int i = startingPoint + numberMachines; i < row.length; i++) {

            if (row[i].equals("X")) {

                if (i + numberMachines >= row.length) {
                    return minTime;
                }
                else {
                    i++;
                    if ((i = subsecKSum(consecMachineSums, i, numberMachines,
                                        numTraders, row)) == -1) {
                        return minTime;
                    }
                    newTime = consecMachineSums[i];
                    consecMachineSums[i - numberMachines + 1] = newTime;
                    i += numberMachines - 1;
                }

                minTime = Math.min(newTime, minTime);

            }
            else {
                newTime = consecMachineSums[i - numberMachines] - Integer.parseInt(row[i - numberMachines]) +
                Integer.parseInt(row[i]);

                consecMachineSums[i - numberMachines + 1] = newTime;

                minTime = Math.min(newTime, minTime);
            }
        }

        return minTime;
    }




    public static int subsecKSum(int consecMachineSums[], int startingPoint,
                                 int numberMachines, int numTraders,
                                 String row[]) {
        int numConsec = 0;
        int maxRightPos = numTraders - numberMachines;

        while (startingPoint <= maxRightPos && numConsec < numberMachines) {

            for (int i = startingPoint; i < (numberMachines + startingPoint); i++) {
                if (row[i].equals("X")) {
                    startingPoint++;
                    consecMachineSums[startingPoint] = 0;
                    numConsec = 0;
                    break;
                }
                numConsec++;
                consecMachineSums[startingPoint] += Integer.parseInt(row[i]);
            }
        }

        if (numConsec != numberMachines)
            return -1;
        return startingPoint;
    }

}
