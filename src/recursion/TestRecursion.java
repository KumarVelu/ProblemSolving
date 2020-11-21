package recursion;

public class TestRecursion {

    private static void fun(int n) {
        if (n == 0) return;

        System.out.println(n - 1);
        fun(n - 1);
        System.out.println(n - 1);

    }

    public static void main(String[] args) {
        fun(3);
    }
}
