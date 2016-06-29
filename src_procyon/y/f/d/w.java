package y.f.d;

import y.d.*;

class w
{
    static double[] a(final v v, final t t) {
        final int f = a.f;
        final double[] array = new double[6];
        double n = 0.0;
        final s j = v.j();
        if (!j.f()) {
            return null;
        }
        final t c = j.a().c();
        double a = t.a(t.a(), t.b(), c.a(), c.b());
        array[0] = c.a();
        array[1] = c.b();
        array[2] = a;
        array[3] = 0.0;
        array[5] = (array[4] = 0.0);
        int n2 = 0;
        double n3 = 0.0;
        while (true) {
            while (j.f()) {
                final m a2 = j.a();
                final t c2 = a2.c();
                final t d = a2.d();
                final z z = new z(d, c2);
                final double d2 = z.d();
                n += d2;
                z.c();
                final t a3 = y.d.a.a(new y.d.a(c2, z), new y.d.a(t, y.d.z.c(z)));
                final z z2 = new z(a3, c2);
                final double c3 = y.d.z.c(new z(d, c2), z);
                final double c4 = y.d.z.c(z2, z);
                final double n4 = dcmpg(c4, 0.0);
                if (f != 0) {
                    if (n4 > 0) {
                        array[5] /= n;
                        if (f == 0) {
                            return array;
                        }
                    }
                    array[5] = 0.0;
                    return array;
                }
                double n5 = 0.0;
                t t2 = null;
                double n6 = 0.0;
                Label_0327: {
                    if (n4 <= 0) {
                        n5 = t.a(t, c2);
                        t2 = c2;
                        n6 = 0.0;
                        if (f == 0) {
                            break Label_0327;
                        }
                    }
                    if (c4 >= c3) {
                        n5 = t.a(t, d);
                        t2 = d;
                        n6 = 1.0;
                        if (f == 0) {
                            break Label_0327;
                        }
                    }
                    n5 = t.a(t, a3);
                    t2 = a3;
                    n6 = c4 / c3;
                }
                if (n5 < a) {
                    a = n5;
                    array[0] = t2.a();
                    array[1] = t2.b();
                    array[2] = a;
                    array[3] = n2;
                    array[5] = d2 * (array[4] = n6) + n3;
                }
                ++n2;
                n3 = n;
                j.g();
                if (f != 0) {
                    break;
                }
            }
            final double n7 = dcmpl(n, 0.0);
            continue;
        }
    }
}
