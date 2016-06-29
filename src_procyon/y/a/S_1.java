package y.a;

import y.c.*;

abstract class S
{
    abstract double a(final d[] p0, final c p1, final int p2);
    
    static S a() {
        return new Y(0.2, 0.4, 0.4);
    }
    
    static S b() {
        return new U(null);
    }
    
    private static int[] b(final i i, final c c, final int n) {
        final boolean a = h.a;
        final int[] array = new int[n];
        final x o = i.o();
        while (o.f()) {
            final int[] array3;
            final int[] array2 = array3 = array;
            if (a) {
                return array3;
            }
            final int a2 = c.a(o.e());
            ++array2[a2];
            o.g();
            if (a) {
                break;
            }
        }
        return array;
    }
    
    private static double[][] c(final d[] array, final c c, final int n) {
        final boolean a = h.a;
        final double[][] array2 = new double[2][n];
        int i = 0;
        while (i < array.length) {
            final d d = array[i];
            Label_0115: {
                if (c.a(d.c()) == c.a(d.d())) {
                    final double[] array3 = array2[0];
                    final int a2 = c.a(d.c());
                    ++array3[a2];
                    if (!a) {
                        break Label_0115;
                    }
                }
                final double[] array4 = array2[1];
                final int a3 = c.a(d.c());
                ++array4[a3];
                final double[] array5 = array2[1];
                final int a4 = c.a(d.d());
                ++array5[a4];
            }
            ++i;
            if (a) {
                break;
            }
        }
        return array2;
    }
    
    static double[][] b(final d[] array, final c c, final int n) {
        return c(array, c, n);
    }
    
    static int[] a(final i i, final c c, final int n) {
        return b(i, c, n);
    }
}
