package hackerrank.java.inheritance;

class MyCalculator implements AdvancedArithmetic {


    @Override
    public int divisor_sum(int num) {

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
