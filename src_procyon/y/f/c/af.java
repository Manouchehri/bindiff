package y.f.c;

import y.f.*;
import y.g.*;
import y.c.*;
import java.util.*;
import y.a.*;
import y.f.c.a.*;

public class af implements R, aT
{
    byte a;
    
    public void a(final byte a) {
        this.a = a;
    }
    
    public int a(final X x, final A a, final f f) {
        final boolean i = a.i;
        o.a(this, "Topological layering ...");
        if (x.i()) {
            return 0;
        }
        final A t = x.t();
        final int a2 = h.a(x, t);
        final J j = new J(x, t);
        int max = 0;
        int k = 0;
        while (k < a2) {
            j.c(new Integer(k));
            int n = this.a(x, a);
            o.a(this, "Reverse edges ...");
            this.a((i)x, a, f);
            final int a3;
            final byte b = (byte)(a3 = this.a);
            if (i) {
                return a3;
            }
            Label_0147: {
                switch (b) {
                    case 1: {
                        o.a(this, "Downshift nodes ...");
                        this.a(x, a, n);
                        if (i) {
                            break Label_0147;
                        }
                        break;
                    }
                    case 2: {
                        o.a(this, "doGanserStuff");
                        this.a(x, a, n);
                        n = this.b(x, a);
                        break;
                    }
                }
            }
            max = Math.max(max, n);
            ++k;
            if (i) {
                break;
            }
        }
        j.b();
        x.a(t);
        return max;
    }
    
    int a(final i i, final A a) {
        final boolean j = a.i;
        final y b = m.b(i);
        b.n();
        int max = 0;
        x x = b.a();
        while (true) {
            while (x.f()) {
                a.a(x.e(), -1);
                x.g();
                if (j) {
                    int n = 0;
                Label_0184_Outer:
                    while (x.f()) {
                        final q e = x.e();
                        n = -1;
                        if (!j) {
                            int max2 = n;
                            final x n2 = e.n();
                            while (true) {
                                while (n2.f()) {
                                    max2 = Math.max(max2, a.a(n2.e()));
                                    n2.g();
                                    if (!j) {
                                        if (j) {
                                            break;
                                        }
                                        continue Label_0184_Outer;
                                    }
                                    else {
                                        if (j) {
                                            break Label_0184_Outer;
                                        }
                                        continue Label_0073;
                                    }
                                }
                                a.a(e, max2 + 1);
                                max = Math.max(max, max2 + 1);
                                x.g();
                                continue;
                            }
                        }
                        return n;
                    }
                    return n;
                }
                if (j) {
                    break;
                }
            }
            x = b.a();
            continue;
        }
    }
    
    private void a(final i i, final A a, final f f) {
        f.a(w.a(i, a));
    }
    
    private void a(final i i, final A a, final int n) {
        final boolean j = a.i;
        final D[] array = new D[n + 1];
        int k = 0;
        while (true) {
            while (k <= n) {
                array[k] = new D();
                ++k;
                if (j) {
                    do {
                        int l = 0;
                        while (l >= 0) {
                            final C m = array[k].m();
                            while (m.f()) {
                                final q q = (q)m.d();
                                l = q.c();
                                if (j) {
                                    continue Label_0107;
                                }
                                Label_0271: {
                                    if (l != 0) {
                                        int min = n;
                                        final x o = q.o();
                                        while (o.f()) {
                                            min = Math.min(min, a.a(o.e()));
                                            o.g();
                                            if (j) {
                                                break Label_0271;
                                            }
                                            if (j) {
                                                break;
                                            }
                                        }
                                        if (min > a.a(q) + 1 && q.c() >= q.b()) {
                                            a.a(q, min - 1);
                                        }
                                    }
                                    m.g();
                                }
                                if (j) {
                                    break;
                                }
                            }
                            --k;
                        }
                        break;
                    } while (!j);
                    return;
                }
                if (j) {
                    break;
                }
            }
            final x o2 = i.o();
            while (o2.f()) {
                array[a.a(o2.e())].b(o2.e());
                o2.g();
                if (j) {
                    break;
                }
            }
            k = n - 1;
            continue;
        }
    }
    
    private int b(final i i, final A a) {
        final boolean j = a.i;
        final int[] array = new int[i.e()];
        final x o = i.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final int[] array2 = array;
                if (j) {
                    final int[] array3 = array2;
                    Arrays.fill(array3, 1);
                    final int a2 = u.a(i, array, array3);
                    final x o2 = i.o();
                    while (o2.f()) {
                        final q e2 = o2.e();
                        a.a(e2, array[e2.d()]);
                        o2.g();
                        if (j) {
                            break;
                        }
                    }
                    return a2;
                }
                array2[e.d()] = a.a(e);
                o.g();
                if (j) {
                    break;
                }
            }
            final int[] array4 = new int[i.g()];
            continue;
        }
    }
    
    public void a(final X x, final aU au, final aV av) {
        new ba(this).a(x, au, av);
    }
}
