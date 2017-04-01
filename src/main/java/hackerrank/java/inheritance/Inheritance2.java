package hackerrank.java.inheritance;

public class Inheritance2 {

    public static void main(String []args) {
        // Create a new Adder object
        Adder adder = new Adder();

        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + adder.getClass().getSuperclass().getName());

        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(adder.add(10,32) + " " + adder.add(10,3) + " " + adder.add(10,10) + "\n");
    }
}
