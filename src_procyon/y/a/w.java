package y.a;

import y.c.*;

public final class w
{
    public static q[] a(final i i) {
        return a(i, new x());
    }
    
    public static q[] a(final i i, final c c) {
        final boolean a = h.a;
        int n = 0;
        final q[] array = new q[i.e()];
        final y.c.x o = i.o();
        while (true) {
            while (o.f()) {
                final int a2;
                final int n2 = a2 = c.a(o.e());
                final int n3 = n;
                if (a) {
                    final int[] array2 = new int[a2 + n3];
                    y.c.x x = i.o();
                    while (true) {
                    Label_0227:
                        while (true) {
                            while (x.f()) {
                                final q e = x.e();
                                final int[] array3 = array2;
                                final int a3 = c.a(e);
                                ++array3[a3];
                                x.g();
                                if (a) {
                                    q[] array4 = null;
                                    while (x.f()) {
                                        final q e2 = x.e();
                                        array4 = array;
                                        if (a) {
                                            return array4;
                                        }
                                        array4[array2[c.a(e2)]++] = e2;
                                        x.g();
                                        if (a) {
                                            break;
                                        }
                                    }
                                    return array4;
                                }
                                if (a) {
                                    break;
                                }
                            }
                            int j = 1;
                            while (j < array2.length) {
                                final int[] array5 = array2;
                                final int n4 = j;
                                array5[n4] += array2[j - 1];
                                ++j;
                                if (a) {
                                    while (true) {
                                        while (j > 0) {
                                            array2[j] = array2[j - 1];
                                            --j;
                                            if (a) {
                                                x = i.o();
                                                continue Label_0227;
                                            }
                                            if (a) {
                                                break;
                                            }
                                        }
                                        array2[0] = 0;
                                        continue;
                                    }
                                }
                                if (a) {
                                    break;
                                }
                            }
                            break;
                        }
                        int j = array2.length - 1;
                        continue;
                    }
                }
                if (a2 > n3) {
                    n = n2;
                }
                o.g();
                if (a) {
                    break;
                }
            }
            continue;
        }
    }
}
