package y.h;

import y.d.*;
import y.c.*;
import y.f.*;
import java.util.*;

public class fM implements al
{
    private static final byte[] a;
    private final double b;
    private final boolean c;
    
    public boolean a() {
        return this.c;
    }
    
    public Object a(final n n, final am am) {
        if (a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final t k = n.k();
        final q d = n.d();
        return this.a(new y(k.a() - d.a() * 0.5, k.b() - d.b() * 0.5, d.a(), d.b()), am);
    }
    
    private Object a(final y y, final am am) {
        final boolean z = fj.z;
        Object o = null;
        Label_0155: {
            if (am instanceof fj) {
                final fj fj = (fj)am;
                if (fj.portCount() > 0) {
                    double n = Double.POSITIVE_INFINITY;
                    final t e = y.e();
                    final Iterator ports = fj.ports();
                Label_0046:
                    while (true) {
                        double hasNext = ports.hasNext() ? 1 : 0;
                    Label_0053:
                        while (hasNext != 0) {
                            final eU eu = ports.next();
                            int i = 0;
                            while (i < fM.a.length) {
                                final byte b = fM.a[i];
                                final double a = t.a(e, this.a(y, eu, b));
                                if (z) {
                                    return o;
                                }
                                final double n2 = hasNext = dcmpl(n, a);
                                if (z) {
                                    continue Label_0053;
                                }
                                if (n2 > 0) {
                                    n = a;
                                    o = new fN(fj.c(eu), b);
                                }
                                ++i;
                                if (z) {
                                    break Label_0155;
                                }
                            }
                            continue Label_0046;
                        }
                        break;
                    }
                }
            }
        }
        if (o == null) {
            return this.c();
        }
        return o;
    }
    
    public Object c() {
        return new fN(null, (byte)0);
    }
    
    public n a(final q q, final am am, final Object o) {
        final t b = this.b(q, am, o);
        return new n(new t(b.a(), b.b() + q.b()), q);
    }
    
    private t b(final q q, final am am, final Object o) {
        if (am instanceof fj) {
            final fN c = c(o);
            final eU a = a((fj)am, o);
            if (a != null) {
                return this.a(q, a, c.b);
            }
        }
        return this.a(q, am);
    }
    
    private t a(final q q, final am am) {
        return new t(am.getX() + (am.getWidth() - q.a) * 0.5, am.getY() + (am.getHeight() - q.b) * 0.5);
    }
    
    public D a(final aj aj, final am am) {
        final boolean z = fj.z;
        final D d = new D();
        Label_0159: {
            if (am instanceof fj) {
                final fj fj = (fj)am;
                final Iterator a = this.a(aj, fj);
                if (a.hasNext()) {
                    final y box = aj.getBox();
                    while (a.hasNext()) {
                        final eU eu = a.next();
                        final Object c = fj.c(eu);
                        int i = 0;
                        while (i < fM.a.length) {
                            d.add(new ai(this.a(box, eu, fM.a[i]), box, new fN(c, fM.a[i]), aj, true));
                            ++i;
                            if (z) {
                                break Label_0159;
                            }
                            if (z) {
                                return d;
                            }
                            if (z) {
                                break Label_0159;
                            }
                        }
                    }
                }
            }
        }
        if (d.isEmpty()) {
            final y box2 = aj.getBox();
            d.add(new ai(this.a((q)box2, am), box2, this.c(), aj, true));
        }
        return d;
    }
    
    private Iterator a(final aj aj, final fj fj) {
        if (fj.portCount() > 0) {
            if (!this.a()) {
                return fj.ports();
            }
            if (a(aj.getModelParameter())) {
                final eU a = a(fj, aj.getModelParameter());
                if (a != null) {
                    final ArrayList<eU> list = new ArrayList<eU>(1);
                    list.add(a);
                    return list.iterator();
                }
            }
        }
        return Collections.EMPTY_LIST.iterator();
    }
    
    private t a(final q q, final eU eu, final byte b) {
        final y k = eu.k();
        final double a = k.a();
        final double b2 = k.b();
        final double n = k.c() + 0.5 * a;
        final double n2 = k.d() + 0.5 * b2;
        switch (b) {
            case 0: {
                return new t(n - q.a() * 0.5, n2 - b2 * 0.5 - this.b - q.b());
            }
            case 1: {
                return new t(n - q.a() * 0.5, n2 + b2 * 0.5 + this.b);
            }
            case 2: {
                return new t(n + a * 0.5 + this.b, n2 - q.b() * 0.5);
            }
            case 3: {
                return new t(n - a * 0.5 - this.b - q.a(), n2 - q.b() * 0.5);
            }
            case 4: {
                return new t(n - q.a() * 0.5, n2 - q.b() * 0.5);
            }
            default: {
                throw new IllegalArgumentException("Invalid position: " + b);
            }
        }
    }
    
    static boolean a(final Object o) {
        return o instanceof fN;
    }
    
    public static byte b(final Object o) {
        return c(o).b;
    }
    
    public static eU a(final eR er) {
        if (a(er.getModelParameter())) {
            final fj g = er.g();
            if (g != null) {
                return a(g, er.getModelParameter());
            }
        }
        return null;
    }
    
    public static eU a(final fj fj, final Object o) {
        return fj.b(c(o).a);
    }
    
    public static Collection a(final eU eu) {
        final ArrayList<eR> list = new ArrayList<eR>(1);
        final fj b = eu.b();
        if (b != null && b.labelCount() > 0) {
            final Object c = b.c(eu);
            for (int i = 0; i < b.labelCount(); ++i) {
                final eR label = b.getLabel(i);
                if (a(label.getModelParameter()) && c == c(label.getModelParameter()).a) {
                    list.add(label);
                }
            }
        }
        return list;
    }
    
    static boolean a(final n n) {
        return Double.isNaN(n.b()) || Double.isNaN(n.c()) || Double.isNaN(n.e()) || Double.isNaN(n.f()) || Double.isNaN(n.g()) || Double.isNaN(n.i());
    }
    
    static fN c(final Object o) {
        try {
            return (fN)o;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Invalid model parameter type.");
        }
    }
    
    static {
        a = new byte[] { 0, 1, 2, 3, 4 };
    }
}
