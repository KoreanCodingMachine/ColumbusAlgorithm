package concept_string_math;

public class MathUtils {
    public static void main(String[] args) {
        int a = 12;
        int b = 18;

        System.out.println("최소 공배수 " + gcd(a,b));
        System.out.println("최대 공약수 " + lcm(a,b));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int lcm(int a, int b) {
        return Math.abs(a*b) / gcd(a,b);
    }
}
