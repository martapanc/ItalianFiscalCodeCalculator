import methods.DataPanel;
import javax.swing.*;

public class FiscalCodeCalculator {

    public static void main (String[] args) throws SecurityException {
        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DataPanel dp = new DataPanel();
        frame1.getContentPane().add(dp);
        frame1.setLocation(200,100);
        frame1.pack();
        frame1.setVisible(true);
    }
}
