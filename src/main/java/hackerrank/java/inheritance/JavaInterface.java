package hackerrank.java.inheritance;

import java.util.Scanner;

public class JavaInterface {

    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();
        System.out.print("I implemented: ");
        implementedInterfaceNames(myCalculator);
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.print(myCalculator.divisor_sum(num) + "\n");
        sc.close();
    }

    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void implementedInterfaceNames(Object o) {
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++) {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}
