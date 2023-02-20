/** Class that print the Collatz sequence starting from a given number.
 *  @author Zhen Kang
 */
public class Collatz {
    /** Method that get the next term of a positive integer
     *
     * @param n is a positive integer
     * @return n / 2 (if n is even)
     *         3 * n + 1 (if n is odd)
     */
    public static int nextNumber(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    public static void main(String[] args) {
        int x = 5;
        System.out.print(x + " ");
        while (x != 1){
            x = nextNumber(x);
            System.out.print(x + " ");
        }
        System.out.println();
    }

}