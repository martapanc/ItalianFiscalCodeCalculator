import methods.DataPanel;
import methods.FCCalculations;
import methods.Town;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FiscalCodeCalculator {

    public static void main (String[] args) throws NoSuchMethodException, SecurityException {
        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DataPanel dp = new DataPanel();
        frame1.getContentPane().add(dp);
        frame1.setLocation(200,100);
        frame1.pack();
        frame1.setVisible(true);

        System.out.println("************************************************\n    Italian Fiscal Code Calculator project\n************************************************");
        Class<FCCalculations> calc = FCCalculations.class;
        System.out.println("Class name: " + calc.getName());
        System.out.println("Method List:");
        Method[] methods = calc.getDeclaredMethods();
        for (Method m : methods)
            System.out.println(" - " + m.getName() + " (" + Arrays.toString(m.getParameterTypes()) + ")  \treturns: " + m.getReturnType());
        Class<Town> town = Town.class;
        System.out.println ("\n***********************************************\nClass name: " + town.getName());
        @SuppressWarnings("rawtypes")
        Constructor[] c = town.getConstructors();
        System.out.println("Constructor: " + Arrays.toString(c));
        System.out.println("Method List: ");
        methods = town.getDeclaredMethods();
        for (Method m : methods)
            System.out.println(" - " + m.getName() + " (" + Arrays.toString(m.getParameterTypes()) + ")\treturns: " + m.getReturnType());
        List<String> ls = new ArrayList<String>();
        ls.add(0, "element");
        String s = ls.get(0);
        System.out.println(s);
    }

    static <S> void fromArrayToCollection(S[] a, Collection<S> c) {
        for (S o : a) {
            c.add(o); // Correct
        }
    }
}
