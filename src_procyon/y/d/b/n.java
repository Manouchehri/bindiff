package y.d.b;

import java.math.*;

public class n extends x
{
    private boolean i;
    private static final n j;
    private static BigInteger k;
    private static BigInteger l;
    
    public n() {
        this.i = true;
    }
    
    public static n f() {
        return n.j;
    }
    
    public Object a(final double n, final double n2) {
        final BigInteger[] array = new BigInteger[2];
        final BigInteger[] array2 = new BigInteger[2];
        a(n, array);
        a(n2, array2);
        z z = null;
        z z2 = null;
        z z3 = null;
        z z4 = null;
        Label_0141: {
            if (this.i) {
                z = new A(array[0]);
                z2 = new A(array[1]);
                z3 = new A(array2[0]);
                z4 = new A(array2[1]);
                if (y.d.b.c.a == 0) {
                    break Label_0141;
                }
            }
            z = new v(array[0]);
            z2 = new v(array[1]);
            z3 = new v(array2[0]);
            z4 = new v(array2[1]);
        }
        final b b = new b(z.c(z4), z3.c(z2), z2.c(z4), this);
        b.g();
        return b;
    }
    
    private static void a(final double n, final BigInteger[] array) {
        final int a = y.d.b.c.a;
        final long doubleToLongBits = Double.doubleToLongBits(n);
        final int n2 = (doubleToLongBits >> 63 == 0L) ? 1 : -1;
        final int n3 = (int)(doubleToLongBits >> 52 & 0x7FFL);
        final long n4 = (n3 == 0) ? ((doubleToLongBits & 0xFFFFFFFFFFFFFL) << 1) : ((doubleToLongBits & 0xFFFFFFFFFFFFFL) | 0x10000000000000L);
        final int n5 = n3 - 1075;
        array[0] = BigInteger.valueOf(n2 * n4);
        if (n5 == 0) {
            array[1] = n.k;
            if (a == 0) {
                return;
            }
        }
        if (n5 > 0) {
            array[0] = array[0].multiply(n.l.pow(n5));
            array[1] = n.k;
            if (a == 0) {
                return;
            }
        }
        array[1] = n.l.pow(-n5);
    }
    
    static {
        j = new n();
        n.k = BigInteger.valueOf(1L);
        n.l = BigInteger.valueOf(2L);
    }
}
