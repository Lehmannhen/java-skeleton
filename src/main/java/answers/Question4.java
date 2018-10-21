package answers;

public class Question4 {

    public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
        int minTime = 100000000;
        int tempTime;

        for (int i = 0; i < rows.length; i++) {
            tempTime = selectionFailedTradedesks(rows[i], numberMachines);
            if (tempTime != 0)
                if (minTime > tempTime)
                    minTime = tempTime;
        }
        if (minTime == 100000000)
            return 0;

        return minTime;
    }



    public static int selectionFailedTradedesks(String[] row, int numberMachines) {
        int[] consecMachineSums = new int[row.length];
        int minTime;
        int newTime;
        int startingPoint = 0;
        consecMachineSums[0] = 0;
        int numTraders = row.length;

        if (subsecKSum(consecMachineSums,startingPoint, numberMachines,
                       numTraders, row) == -1) {
            return 0;
        }

        minTime = consecMachineSums[startingPoint];

        for (int i = startingPoint; i + numberMachines < row.length; i++) {

            if (row[i + numberMachines].equals("X")) {
                if (i + numberMachines >= row.length)
                    return minTime;
                else {
                    i += numberMachines + 1;

                    if (subsecKSum(consecMachineSums,i, numberMachines, numTraders, row) == -1) {
                        return minTime;
                    }
                    newTime = consecMachineSums[i];
                }
                if (newTime < minTime)
                    minTime = newTime;
            }

            newTime = consecMachineSums[i] - Integer.parseInt(row[i]) +
            Integer.parseInt(row[i + numberMachines]);

            consecMachineSums[i + 1] = newTime;

            if (newTime < minTime)
                minTime = newTime;
        }

        return minTime;
    }




    public static int subsecKSum(int[] consecMachineSums, int startingPoint,
                                 int numberMachines, int numTraders,
                                 String row[]) {
        int numConsec = 0;
        while (startingPoint <= (numTraders - numberMachines) && numConsec < numberMachines) {
            for (int i = startingPoint; i < (numberMachines + startingPoint); i++) {

                if (row[i].equals("X")) {
                    startingPoint++;
                    consecMachineSums[startingPoint] = 0;
                    break;
                }
                consecMachineSums[startingPoint] += Integer.parseInt(row[i]);
                numConsec++;
            }

        }

        if (startingPoint > (numTraders - numberMachines))
            return -1;
        return 0;
    }

}
