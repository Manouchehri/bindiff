package y.d;

public class b
{
    public static double a(final double n, final double n2) {
        double n3 = n + n2;
        if (n3 >= 6.283185307179586) {
            n3 -= 6.283185307179586;
        }
        if (n3 < 0.0) {
            n3 += 6.283185307179586;
        }
        return n3;
    }
}
