package BraunAssertions;
public class BraunAssert {
    
    public static void bassert(boolean exp, String msg) {
        if(!exp) {
            System.out.printf("ASSERTION FAIL: %s%n", msg);
            System.exit(0);
        }
    }
}
