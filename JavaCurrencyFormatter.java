import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        NumberFormat enusC = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat zhcnC = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat frfrC = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat eninC = NumberFormat.getCurrencyInstance(
            new Locale.Builder().setLanguage("en").setRegion("IN").build());
        
        System.out.println("US: " + enusC.format(payment));
        System.out.println("India: " + eninC.format(payment));
        System.out.println("China: " + zhcnC.format(payment));
        System.out.println("France: " + frfrC.format(payment));
    }
}
