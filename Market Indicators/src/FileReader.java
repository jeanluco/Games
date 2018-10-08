import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FileReader {
    String files;

    public String getFile(String a) {
        return files;
    }

    File file = new File(files);
    int row = 0;
    String[][] items;

    public boolean checkIsFile() {
        return file.isFile();
    }

    // find number of rows in file
    public int findRowNumber() {
        row = 0;
        if (checkIsFile()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while ((reader.readLine()) != null) {
                    row++;
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("This is not a file.");
        }
        return row;
    }

    // convert csv to array
    public void convertToArray() {
        int r = 0;
        items = new String[findRowNumber()][6];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                StringTokenizer z = new StringTokenizer(line, ",");
                while (z.hasMoreTokens()) {
                    for (int c = 0; c < 6; c++) {
                        items[r][c] = z.nextToken();
                    }
                    r++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // print items array
    public void printArray() {
        for (int x = 0; x < items.length; x++) {
            System.out.printf("%s - ", x);
            for (int y = 0; y < items[x].length; y++) {
                System.out.printf("%s ", items[x][y]);
            }
            System.out.println();
        }
    }

    public String[][] getArray() {
        return items;
    }
/*
    private java.sql.Connection connection = null;
    private PreparedStatement state = null;
    private ResultSet result = null;
    private String location = "jdbc:mysql://.....";
    private String UN = "...";
    private String PW = "...";

    try {
         connection = DriverManager.getConnection(url, user, password);
         Statement one = (Statement) con.createStatement(); 

         st.executeUpdate("INSERT INTO table_name (col1, col2, col3,...)
VALUES (val1, val2, val3,...)



         connection.close();
    }

    catch (SQLException ex) {
         Logger logg = Logger.getLogger(deliveryMain.class.getName());
         logg.log(Level.SEVERE, ex.getMessage(), ex);
*/
     } 
}