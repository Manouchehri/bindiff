package y.f.i;

import y.f.*;
import y.d.*;
import java.util.*;
import y.c.*;

public class g extends a
{
    public static final Object a;
    
    public g(final ah ah) {
        super(ah);
    }
    
    public void c(final X x) {
        final int f = v.f;
        final ArrayList<h> list = new ArrayList<h>();
        final c c = x.c(g.a);
        final y.c.e p = x.p();
        while (true) {
        Label_0274_Outer:
            while (p.f()) {
                final d a = p.a();
                if (f != 0) {
                    final Iterator<Object> iterator = list.iterator();
                Label_0576:
                    while (true) {
                        iterator.hasNext();
                        int i = 0;
                    Label_0571_Outer:
                        while (i != 0) {
                            final h h = iterator.next();
                            final D m = x.m(h.a);
                            t t = (t)m.f();
                            p p2 = m.k();
                            int b = h.b;
                            while (p2 != null) {
                                i = b;
                                if (f != 0) {
                                    continue Label_0571_Outer;
                                }
                                if (i <= 0) {
                                    break;
                                }
                                if (b == 1) {
                                    t = (t)p2.c();
                                }
                                p2 = p2.a();
                                --b;
                                if (f != 0) {
                                    break;
                                }
                            }
                            if (p2 != null) {
                                final t t2 = (t)p2.c();
                                while (true) {
                                    for (final double doubleValue : h.c) {
                                        m.a(new t(t.a + doubleValue * (t2.a - t.a), t.b + doubleValue * (t2.b - t.b)), p2);
                                        if (f == 0) {
                                            if (f != 0) {
                                                break;
                                            }
                                            continue Label_0571_Outer;
                                        }
                                        else {
                                            if (f != 0) {
                                                break Label_0576;
                                            }
                                            continue Label_0576;
                                        }
                                    }
                                    x.a(h.a, m);
                                    continue;
                                }
                            }
                            continue Label_0576;
                        }
                        break;
                    }
                    return;
                }
                Label_0306: {
                    if (c == null || c.d(a)) {
                        final D j = x.m(a);
                        final p k = j.k();
                        t t3 = (t)k.c();
                        final p a2 = k.a();
                        t t4 = (t)a2.c();
                        int n = 1;
                        final int size = j.size();
                        h h2 = new h(a, n);
                        p p3 = a2.a();
                        while (true) {
                            while (p3 != null) {
                                final t t5 = (t)p3.c();
                                final boolean d = e.d(t3, t5, t4);
                                if (f == 0) {
                                    Label_0249: {
                                        if (d) {
                                            h2.c.add(new Double(t3.a(t4)));
                                            j.h(p3.b());
                                            t4 = t5;
                                            if (f == 0) {
                                                break Label_0249;
                                            }
                                        }
                                        this.a(t3, t4, h2, list);
                                        h2 = new h(a, n + 1);
                                        t3 = t4;
                                        t4 = t5;
                                    }
                                    p3 = p3.a();
                                    ++n;
                                    if (f != 0) {
                                        break;
                                    }
                                    continue Label_0274_Outer;
                                }
                                else {
                                    if (!d) {
                                        this.a(t3, t4, h2, list);
                                    }
                                    if (j.size() < size) {
                                        x.a(a, j);
                                    }
                                    break Label_0306;
                                }
                            }
                            h2.c.isEmpty();
                            continue;
                        }
                    }
                }
                p.g();
                if (f != 0) {
                    break;
                }
            }
            this.a().c(x);
            continue;
        }
    }
    
    private void a(final t t, final t t2, final h h, final List list) {
        if (h.a()) {
            return;
        }
        h.a(t, t2);
        list.add(h);
    }
    
    static {
        a = "CollinearBendHider#SELECTED_EDGES";
    }
}
