import java.util.*;
import java.text.SimpleDateFormat;

public class Formulas {

    ReadFiles r = new ReadFiles();
    float[][] dataArray = new float[r.findRowNumber()][6];
    Date[] dateArray = new Date[r.findRowNumber()];

    public void createDateArray(String[][] n) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int x = 0; x < n.length; x++) {
            for (int y = 0; y < n[x].length; y++) {
                if (y == 0) {
                    try {
                        Date newdate = (Date) df.parse(n[x][0]);
                        dateArray[x] = newdate;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    // create float array
    public void createDataArray(String[][] n) {
        for (int x = 0; x < n.length; x++) {
            for (int y = 0; y < n[x].length; y++) {
                switch (y) {
                    case 0:
                        dataArray[x][y] = 0;
                        break;
                    case 1:
                        dataArray[x][y] = new Float(n[x][y]);
                        break;
                    case 2:
                        dataArray[x][y] = new Float(n[x][y]);
                        break;
                    case 3:
                        dataArray[x][y] = new Float(n[x][y]);
                        break;
                    case 4:
                        dataArray[x][y] = new Float(n[x][y]);
                        break;
                    case 5:
                        dataArray[x][y] = new Float(n[x][y]);
                        break;
                    case 6:
                        dataArray[x][y] = new Float(n[x][y]);
                        break;
                }
            }
        }
    }


    // print data array
    public void printArray() {
        for (int x = 0; x < dataArray.length; x++) {
            for (int y = 0; y < dataArray[x].length; y++) {
                System.out.printf("%s ", dataArray[x][y]);
            }
            System.out.println();
        }

    }

    public float SMA(float[][] array) {
        while (line != null) {
            int row = 0;
            int col = 0;
            int a = 0;
            float answer[];

            for (row = 0; row < array.length; row++) {
                answer[a] = array[row][6];
                row++;
                a++;
            }
            int sum = 0;
            for (float d : answer) {
                sum += d;
            }
            float smaverage;
            smaverage = (float) sum / answer.length;

        }
        return smaverage;
    }


    public float[] findMax(float[][] array) {
        float[][] test = {{3, 9, 3, 5}, {4, 19, 4, 9}, {2, 10, 5, 6}};
        float[] result = array[0];
        for (int row = 1; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                if (array[row][column] > result[column]) {
                    result[column] = test[row][column];
                }
            }
        }
        for (float number : result) {
            System.out.print(number + " "); // 4 19 5 9
            return result;
        }
    }

    public float[] findMin(float[][] array) {
        float[] result = array[0];
        for (int roww = 1; roww < array.length; roww++) {
            for (int column = 1; column < array[0].length; column++) {
                if (array[roww][column] < result[column]) {
                    result[column] = array[roww][column];
                }
            }
        }
        for (float number : result) {
            System.out.print(number + " "); // 4 19 5 9
            return result;
        }
    }

    public float[] arroonUp(float[][] array) {
        float[] j = findMax(array);
        float max = j[2];
        int x = array.length;
        int y = array.length;
        while (x < max + 1) {
            if (array[x][2] = max) {
                int periods = array.length - x
            } else {
                x--;
            }
        }
        int arroon = ((y - periods) / y) * 100

    }

    public float[] arroonDown(float[][] jay) {
        float[] j = findMin(jay);
        float min = j[3];
        int x = jay.length;
        int y = jay.length;
        while (x < min + 1) {
            if (jay[x][3] = min) {
                int periods = y - x;
            } else {
                x--;
            }
        }
        int arroon = ((y - periods) / y) * 100;
    }

    public float rateOfChange(float[][] jay) {
        float a = jay[0][4];
        float b = jay[jay.length][4];
        float c = b - a / b;
        return c;


    }

    public float[] RSI(float[][] jay) {


        while (x < min + 1) {
            int g = 0;
            int i = 0;
            float a = jay[g][0];
            float b = jay[g + 1][0];
            int gain = 0;
            int loss = 0;
            float[] j = b - a;
            if (j[i] > 0) {
                float[gain]gains;
			   =j[i];
                gain++;
            } else if (j[i] < 0) {
                float [loss]losses = j[i];
                loss++;
            }
            g++;
            i++;
        }
        return j;

    }
}
