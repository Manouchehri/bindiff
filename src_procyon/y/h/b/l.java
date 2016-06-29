package y.h.b;

import java.util.*;
import y.c.*;
import y.f.*;
import y.d.*;

abstract class l implements al
{
    static final Object a;
    private static final double[] b;
    private static final double[] c;
    private final double d;
    
    l(final double d) {
        this.d = d;
    }
    
    public double a() {
        return this.d;
    }
    
    public Object c() {
        return new n(l.a, true, 0.5);
    }
    
    public y.d.n a(final q q, final am am, final Object o) {
        final t b = this.b(q, am, o);
        return new y.d.n(new t(b.a(), b.b() + q.b()), q);
    }
    
    private t b(final q q, final am am, final Object o) {
        final int h = y.h.b.a.H;
        if (am instanceof a) {
            final n a = a(o);
            final i l = ((a)am).l();
            final ArrayList list = new ArrayList<y.h.b.q>();
            list.addAll(this.a(l));
            while (!list.isEmpty()) {
                final y.h.b.q q2 = list.remove(list.size() - 1);
                if (q2.a == a.a) {
                    return this.a(q, q2, a);
                }
                list.addAll(q2.b);
                if (h != 0) {
                    break;
                }
            }
        }
        return new t(am.getX() + (am.getWidth() - q.a) * 0.5, am.getY() + (am.getHeight() - q.b) * 0.5);
    }
    
    public D a(final aj aj, final am am) {
        final int h = y.h.b.a.H;
        final y box = aj.getBox();
        final D d = new D();
        Label_0227: {
            if (am instanceof a) {
                final i l = ((a)am).l();
                final ArrayList list = new ArrayList<y.h.b.q>();
                list.addAll(this.a(l));
            Label_0221_Outer:
                while (!list.isEmpty()) {
                    final y.h.b.q q = list.remove(list.size() - 1);
                    int i = 0;
                Label_0090:
                    while (true) {
                    Label_0206_Outer:
                        while (i < 2) {
                            final int n = i % 2;
                            if (h == 0) {
                                final boolean b = n == 0;
                                final double[] array = b ? y.h.b.l.c : y.h.b.l.b;
                                int j = 0;
                                while (true) {
                                    while (j < array.length) {
                                        final n n2 = new n(q.a, b, array[j]);
                                        d.add(new ai(this.a(box, q, n2), box, n2, aj, true));
                                        ++j;
                                        if (h == 0) {
                                            if (h != 0) {
                                                break;
                                            }
                                            continue Label_0206_Outer;
                                        }
                                        else {
                                            if (h != 0) {
                                                break Label_0206_Outer;
                                            }
                                            continue Label_0090;
                                        }
                                    }
                                    ++i;
                                    continue Label_0221_Outer;
                                }
                            }
                            if (h != 0) {
                                break Label_0227;
                            }
                            continue Label_0221_Outer;
                        }
                        list.addAll(q.b);
                        continue;
                    }
                }
            }
        }
        return d;
    }
    
    public Object a(final y.d.n n, final am am) {
        if (a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final t k = n.k();
        final q d = n.d();
        return this.a(new y(k.a() - d.a() * 0.5, k.b() - d.b() * 0.5, d.a(), d.b()), am);
    }
    
    private Object a(final y y, final am am) {
        final int h = y.h.b.a.H;
        Object o = null;
        if (am instanceof a) {
            final i l = ((a)am).l();
            double n = Double.POSITIVE_INFINITY;
            final ArrayList list = new ArrayList<y.h.b.q>();
            list.addAll(this.a(l));
            while (!list.isEmpty()) {
                final y.h.b.q q = list.remove(list.size() - 1);
                final n a = this.a(y, q);
                final double a2 = t.a(y.e(), this.a(y, q, a));
                if (h != 0) {
                    return o;
                }
                if (n > a2) {
                    n = a2;
                    o = a;
                }
                list.addAll(q.b);
                if (h != 0) {
                    break;
                }
            }
        }
        if (o == null) {
            return this.c();
        }
        return o;
    }
    
    static y.h.b.q a(final a a, final l l, final n n) {
        final int h = a.H;
        if (a != null && l != null && n != null) {
            final i i = a.l();
            final ArrayList list = new ArrayList<y.h.b.q>();
            list.addAll(l.a(i));
            while (!list.isEmpty()) {
                final y.h.b.q q = list.remove(list.size() - 1);
                if (q.a == n.a) {
                    return q;
                }
                list.addAll(q.b);
                if (h != 0) {
                    break;
                }
            }
        }
        return null;
    }
    
    static n a(final Object o) {
        try {
            return (n)o;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Invalid model parameter type.");
        }
    }
    
    static boolean a(final y.d.n n) {
        return Double.isNaN(n.b()) || Double.isNaN(n.c()) || Double.isNaN(n.e()) || Double.isNaN(n.f()) || Double.isNaN(n.g()) || Double.isNaN(n.i());
    }
    
    abstract n a(final y p0, final y.h.b.q p1);
    
    abstract t a(final q p0, final y.h.b.q p1, final n p2);
    
    abstract Collection a(final i p0);
    
    static {
        a = new Object();
        b = new double[] { 0.0, 1.0 };
        c = new double[] { 0.0, 0.25, 0.5, 0.75, 1.0 };
    }
}
