package y.a;

import y.g.*;
import y.c.*;
import java.util.*;

public class z
{
    public static void a(final i i) {
        a(i, null);
    }
    
    public static void a(final i i, final f f) {
        final boolean a = h.a;
        final int[] b = b(i);
        final y c = m.c(i, b);
        final D d = new D();
        a(c, d);
        final y[] array = new y[d.size()];
        d.toArray(array);
        final int[][] a2 = a(array, m.c(i, b), b);
        final x o = i.o();
    Label_0235:
        while (o.f()) {
            final q e = o.e();
            final int n = b[e.d()];
            int n2 = 0;
            while (true) {
                do {
                    Label_0099: {
                        final int length = array.length;
                    }
                    int j = 0;
                    int n3 = 0;
                    Label_0104:
                    while (j < n3) {
                        final x a3 = array[n2].a();
                        if (!a) {
                            final x x = a3;
                            while (x.f()) {
                                final q e2 = x.e();
                                j = a2[n2][n];
                                n3 = b[e2.d()];
                                if (a) {
                                    continue Label_0104;
                                }
                                if (j <= n3 && e != e2 && !i.b(e, e2)) {
                                    final d a4 = i.a(e, e2);
                                    if (f != null) {
                                        f.add(a4);
                                    }
                                }
                                x.g();
                                if (a) {
                                    break;
                                }
                            }
                            ++n2;
                            continue Label_0099;
                        }
                        a3.g();
                        if (a) {
                            break Label_0235;
                        }
                        continue Label_0235;
                    }
                    break;
                } while (!a);
                continue;
            }
        }
    }
    
    private static void a(final y y, final D d) {
        final boolean a = h.a;
        while (!y.isEmpty()) {
            final y y2 = new y();
            y.b();
        Label_0024:
            while (true) {
                q q2 = null;
                q q = q2;
                y.remove(q);
                y2.add(q);
                final x a2 = y.a();
                while (a2.f()) {
                    final q e = a2.e();
                    q2 = q;
                    if (a) {
                        continue Label_0024;
                    }
                    if (q2.a(e) != null) {
                        y.remove(e);
                        y2.add(e);
                        q = e;
                    }
                    a2.g();
                    if (a) {
                        break;
                    }
                }
                break;
            }
            d.add(y2);
            if (a) {
                break;
            }
        }
    }
    
    private static int[][] a(final y[] array, final y y, final int[] array2) {
        final boolean a = h.a;
        final int[] array3 = new int[array2.length];
        int i = 0;
    Label_0013:
        while (true) {
        Label_0080_Outer:
            while (i < array.length) {
                final y[] array4 = array;
                if (!a) {
                    final x a2 = array[i].a();
                    while (true) {
                        while (a2.f()) {
                            array3[array2[a2.e().d()]] = i;
                            a2.g();
                            if (!a) {
                                if (a) {
                                    break;
                                }
                                continue Label_0080_Outer;
                            }
                            else {
                                if (a) {
                                    break Label_0080_Outer;
                                }
                                continue Label_0013;
                            }
                        }
                        ++i;
                        continue;
                    }
                }
                final int[][] array5 = new int[array4.length][array3.length];
                int j = 0;
            Label_0141_Outer:
                while (j < array.length) {
                    int k = 0;
                    while (true) {
                        while (k < array3.length) {
                            array5[j][k] = Integer.MAX_VALUE;
                            ++k;
                            if (!a) {
                                if (a) {
                                    break;
                                }
                                continue Label_0141_Outer;
                            }
                            else {
                                if (a) {
                                    break Label_0141_Outer;
                                }
                                continue Label_0141_Outer;
                            }
                        }
                        ++j;
                        continue;
                    }
                }
                final x a3 = y.a();
                a3.j();
                do {
                    Label_0159: {
                        a3.f();
                    }
                    int l = 0;
                    Label_0166:
                    while (l != 0) {
                        final int n = array2[a3.e().d()];
                        final e m = a3.e().l();
                        while (m.f()) {
                            final int n2 = l = array2[m.a().d().d()];
                            if (a) {
                                continue Label_0166;
                            }
                            Label_0299: {
                                if (l <= array5[array3[n2]][n2]) {
                                    int n3 = 0;
                                    while (n3 < array.length) {
                                        array5[n3][n] = Math.min(array5[n3][n], array5[n3][n2]);
                                        ++n3;
                                        if (a) {
                                            break Label_0299;
                                        }
                                        if (a) {
                                            break;
                                        }
                                    }
                                }
                                m.g();
                            }
                            if (a) {
                                break;
                            }
                        }
                        array5[array3[n]][n] = n;
                        a3.h();
                        continue Label_0159;
                    }
                    break;
                } while (!a);
                return array5;
            }
            final y[] array4 = array;
            continue;
        }
    }
    
    private static int[] b(final i i) {
        final int[] array = new int[i.f()];
        if (!m.a(i, array)) {
            throw new B("Graph must be acyclic for this operation");
        }
        i.a(null, y.g.e.a(M.a(array)));
        return array;
    }
}
