import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class stockBot {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Enter Ticker: ");
        Scanner scanner = new Scanner(System.in);
        final String ticker = scanner.nextLine();
        URL url = new URL("https://finance.yahoo.com/quote/" + ticker + "?p=" + ticker);
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String price = "not found";
        String line = buff.readLine();
        while (line != null) {
            if (line.contains("currentPrice\":{\"raw")) {
                int target = line.indexOf("currentPrice\":{\"raw");
                int deci = line.indexOf(".", target);
                int start = deci;
                while (line.charAt(start) != ',' || line.charAt(start) != ':') {
                    start--;
                }
                price = line.substring(start + 1, deci + 3);
            }
            line = buff.readLine();
        }
        System.out.println(price);


    }

}
