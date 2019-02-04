import java.util.*;
import java.text.SimpleDateFormat;
<<<<<<< HEAD
<<<<<<< HEAD
import java.
=======
=======
>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634
import java.util.stream;

>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634
public class Formulas {
//              Yahoo! Finance .csv Columns 
// Date	Open  |	High |   Low  |	Close* | Adj Close** | Volume
	
    ReadFiles r = new ReadFiles();
    float[][] dataArray = new float[r.findRowNumber()][6];
    Date[] dateArray = new Date[r.findRowNumber()];

    public void createDateArray(String[][] rawdata) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        for (int x = 0; x < rawdata.length; x++) {
            for (int y = 0; y < rawdata[x].length; y++) {
                if (y == 0) {
                    try {
                        Date newdate = (Date) simple.parse(rawdata[x][0]);
                        dateArray[x] = newdate;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    // create float array
    public void createDataArray(String[][] rawdata) {
        for (int x = 0; x < rawdata.length; x++) {
            for (int y = 0; y < rawdata[x].length; y++) {
                switch (y) {
                    case 0:
                        dataArray[x][y] = 0;
                        break;
                    case 1:
                        dataArray[x][y] = new Float(rawdata[x][y]);
                        break;
                    case 2:
                        dataArray[x][y] = new Float(rawdata[x][y]);
                        break;
                    case 3:
                        dataArray[x][y] = new Float(rawdata[x][y]);
                        break;
                    case 4:
                        dataArray[x][y] = new Float(rawdata[x][y]);
                        break;
                    case 5:
                        dataArray[x][y] = new Float(rawdata[x][y]);
                        break;
                    case 6:
                        dataArray[x][y] = new Float(rawdata[x][y]);
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
    //Array of Max for all data columns
    public float[] findMax(float[][] rawdata) {
        float[] result = rawdata[0];
        for (int row = 1; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                if (array[row][column] > result[column]) {
                    result[column] = test[row][column];
                }
            }
        }
        for (float number : result) {
            System.out.print(number + " "); 
            return result;
        }
    }
    //Array of Min for all data columns
    public float[] findMin(float[][] rawdata) {
        float[] result = rawdata[0];
        for (int roww = 1; roww < rawdata.length; roww++) {
            for (int column = 1; column < array[0].length; column++) {
                if (array[roww][column] < result[column]) {
                    result[column] = array[roww][column];
                }
            }
        }
        for (float number : result) {
            System.out.print(number + " "); 
            return result;
        }
    }
	
    //Simple Moving Average
    public float SMA(float[][] rawdata) {
        while (line != null) {
            int row = 0;
            int col = 0;
            int a = 0;
            float answer[];

            for (row = 0; row < rawdata.length; row++) {
                answer[a] = rawdata[row][6];
                row++;
                a++;
            }
            int sum = 0;
            for (float d : answer) {
                sum += d;
            }
            float smaverage;
            smaverage = (float) sum / answer.length;
<<<<<<< HEAD

        }
        return smaverage;
    }

=======

        }
        return smaverage;
    }

>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634

    //Arroon
    public float[] arroonUp(float[][] rawdata) {
        float[] j = findMax(rawdata);
        float max = j[2];
        int k = rawdata.length;
        int o = rawdata.length;
        while (k < max + 1) {
            if (rawdata[k][2] = max) {
                int periods = rawdata.length - k;
            } else {
                k--;
            }
        }
        int arroonUp = ((o - periods) / o) * 100;
	return arroonUp;
    }
    //Aroon
    public float[] arroonDown(float[][] rawdata) {
        float[] p = findMin(rawdata);
        float min = p[3];
        int s = rawdata.length;
        int r = rawdata.length;
        while (s < min + 1) {
            if (rawdata[s][3] = min) {
                int periods = r - s;
            } else {
                s--;
            }
        }
        int arroonDown = ((r - periods) / r) * 100;
	return arroonDown;
    }
    //Rate of Change
    public float rateOfChange(float[][] rdata) {
        float a = rdata[0][4];
        float b = rdata[rdata.length][4];
        float c = b - a / b;
        return c;


    } 
    //Relative Strength Indicator
    public float RSI(float[][] data) {

	int z = 0;
        int v = 0;
        while (z < data[0].length) {          
            float t = data[z][0];
            float u = data[z + 1][0];
            int gain = 0;
            int loss = 0;
<<<<<<< HEAD
<<<<<<< HEAD
            float[] j = b - a;
            if (j[i] > 0) {
                float[gain]gains =j[i];
=======
=======
>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634
            float[] w;
	    w[v]= u - t;
            if (w[v] > 0) {
                float[gain]gains =w[v];
<<<<<<< HEAD
>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634
=======
>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634
                gain++;
            } else if (w[v] < 0) {
                float [loss]losses = w[v];
                loss++;
            }
<<<<<<< HEAD
<<<<<<< HEAD
            g++;
            i++;
        }
        return j;
        Arrays.stream(array).sum();
        

=======
=======
>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634
            z++;
            v++;
	}
	float finalGain = (abs(Arrays.stream(gains).sum()))/gains.length;
	float finalLoss = (abs(Arrays.stream(losses).sum()))/losses.length;
	float RS = finalGain/finalLoss;
	float RSI = 100 - (100 / (1 + RS));
		
        
        return RSI;
	}
<<<<<<< HEAD
>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634
=======
>>>>>>> dc536abee7d88e39a4c2116e92e4fc7db6dc6634
    }
}
