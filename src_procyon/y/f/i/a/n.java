package y.f.i.a;

import y.d.*;
import y.g.*;
import java.util.*;
import y.c.*;

public class n implements O, l
{
    private static final t a;
    private static final u b;
    private R c;
    private i d;
    private A e;
    private Map f;
    private Map g;
    private Map h;
    private Map i;
    private double j;
    private double k;
    private double l;
    private List m;
    
    public void a(final m m) {
        this.m.add(m);
    }
    
    public void b(final m m) {
        this.m.remove(m);
    }
    
    protected void a(final R r, final List list) {
        final int a = ab.a;
        if (!this.m.isEmpty()) {
            final Iterator<m> iterator = (Iterator<m>)this.m.iterator();
            while (iterator.hasNext()) {
                iterator.next().a(r, list);
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    protected void a(final R r) {
        final int a = ab.a;
        if (!this.m.isEmpty()) {
            final Iterator<m> iterator = (Iterator<m>)this.m.iterator();
            while (iterator.hasNext()) {
                iterator.next().b(r);
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    protected void b(final R r) {
        final int a = ab.a;
        if (!this.m.isEmpty()) {
            final Iterator<m> iterator = (Iterator<m>)this.m.iterator();
            while (iterator.hasNext()) {
                iterator.next().a(r);
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    public n() {
        this.j = 8.0;
        this.k = 2.0;
        this.l = 2.0;
        this.m = new ArrayList();
    }
    
    public void a(final List list, final y y) {
        final int a = ab.a;
        if (this.d == null) {
            this.d = new i();
            this.f = new HashMap();
            this.i = new HashMap();
            this.g = new HashMap();
            this.h = new HashMap();
        }
        this.e = M.a();
        final y.c.q d = this.d.d();
        this.c = new R(y, this);
        this.e.a(d, this.c);
        this.f.put(this.c, d);
        final D d2 = new D(list);
        d2.sort(new o(this));
        final D d3 = new D(list);
        d3.sort(new p(this));
        this.i.put(this.c, new q(this.c, false, d2, d3));
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            final ArrayList<R> list2 = new ArrayList<R>();
            list2.add(this.c);
            this.h.put(iterator.next(), list2);
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.b(this.c);
    }
    
    private boolean a(final R r, final D d) {
        final int a = ab.a;
        final C m = d.m();
        boolean a2 = false;
        while (m.f()) {
            a2 = this.a((N)m.d(), r);
            if (a != 0) {
                return a2;
            }
            if (!a2) {
                return true;
            }
            m.g();
            if (a != 0) {
                break;
            }
        }
        return a2;
    }
    
    private boolean a(final N n, final R r) {
        final y a = n.a();
        final y g = r.g();
        return g.c() > a.c() - 1.0E-6 && g.c() + g.a() < a.c() + a.a() + 1.0E-6 && g.d() > a.d() - 1.0E-6 && g.d() + g.b() < a.d() + a.b() + 1.0E-6;
    }
    
    public void a() {
        final int a = ab.a;
        if (this.c != null) {
            final Iterator<R> iterator = this.a(false).iterator();
            while (true) {
                while (iterator.hasNext()) {
                    iterator.next().a();
                    if (a != 0) {
                        this.e = null;
                        return;
                    }
                    if (a != 0) {
                        break;
                    }
                }
                this.c = null;
                this.d.j();
                this.f.clear();
                this.i.clear();
                this.g.clear();
                this.h.clear();
                continue;
            }
        }
    }
    
    private void e(final R r) {
        final int a = ab.a;
        final q q = this.i.get(r);
        if (q.c) {
            return;
        }
        final D d = q.d;
        final D e = q.e;
        final y g = r.g();
        final r a2 = this.a(d, g, n.a);
        final r a3 = this.a(e, g, n.b);
        R r2 = null;
        R r3 = null;
        Label_0392: {
            if (a3.b <= a2.b) {
                final double a4 = a3.a;
                final D d2 = new D();
                final D d3 = new D();
                this.a(d, n.b, a4, d2, d3);
                final D d4 = new D();
                final D d5 = new D();
                this.a(e, n.b, a4, d4, d5);
                r2 = this.a(r, d2, d4, new y(r.h(), r.i(), r.l(), a4 - r.i()));
                r3 = this.a(r, d3, d5, new y(r.h(), a4, r.l(), r.k() - a4));
                if (a == 0) {
                    break Label_0392;
                }
            }
            final double a5 = a2.a;
            final D d6 = new D();
            final D d7 = new D();
            this.a(d, n.a, a5, d6, d7);
            final D d8 = new D();
            final D d9 = new D();
            this.a(e, n.a, a5, d8, d9);
            r2 = this.a(r, d6, d8, new y(r.h(), r.i(), a5 - r.h(), r.m()));
            r3 = this.a(r, d7, d9, new y(a5, r.i(), r.j() - a5, r.m()));
        }
        final q q2 = this.i.get(r2);
        final q q3 = this.i.get(r3);
        Label_0463: {
            if (q2.b) {
                q3.f.add(r2);
                if (a == 0) {
                    break Label_0463;
                }
            }
            q3.g.add(r2);
        }
        Label_0502: {
            if (q3.b) {
                q2.f.add(r3);
                if (a == 0) {
                    break Label_0502;
                }
            }
            q2.g.add(r3);
        }
        final ArrayList list = new ArrayList<Object>(q.f.size() + q.g.size());
        list.addAll((Collection<?>)q.f);
        list.addAll((Collection<?>)q.g);
        final Iterator<R> iterator = list.iterator();
        while (iterator.hasNext()) {
            ((q)this.i.get(iterator.next())).g.remove(r);
            if (a != 0) {
                break;
            }
        }
        final C m = d.m();
        while (true) {
            while (m.f()) {
                ((List)this.h.get(m.d())).remove(r);
                m.g();
                if (a != 0) {
                    this.a(r, Arrays.asList(r2, r3));
                    if (q2.b) {
                        this.a(r2);
                    }
                    if (q3.b) {
                        this.a(r3);
                    }
                    return;
                }
                if (a != 0) {
                    break;
                }
            }
            q.a();
            q.c = true;
            continue;
        }
    }
    
    private void a(final D d, final s s, final double n, final D d2, final D d3) {
        final int a = ab.a;
        final C m = d.m();
        while (m.f()) {
            final N n2 = (N)m.d();
            final y a2 = n2.a();
            if (s.a(a2) < n - 1.0E-6) {
                d2.add(n2);
            }
            if (s.b(a2) > n + 1.0E-6) {
                d3.add(n2);
            }
            m.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private r a(final D d, final y y, final s s) {
        final int i = ab.a;
        final double a = s.a(y);
        final double b = s.b(y);
        final double c = s.c(y);
        final double d2 = s.d(y);
        double n = 0.0;
        double n2 = Double.MAX_VALUE;
        final int size = d.size();
        int n3 = 0;
        int n4 = 0;
        int n5 = size;
        final D d3 = new D();
        final C m = d.m();
        while (true) {
            do {
                double f = 0.0;
                Label_0080: {
                    f = (m.f() ? 1 : 0);
                }
                Label_0087:
            Label_0297_Outer:
                while (f != 0) {
                    final N n6 = (N)m.d();
                    final double a2 = s.a(n6.a());
                    if (i == 0) {
                        final double n7 = a2;
                        while (true) {
                            while (d3.size() > 0 && (double)d3.get(0) <= n7 + 1.0E-6) {
                                final double n8 = (double)d3.remove(0);
                                ++n3;
                                --n4;
                                final double n9 = this.a(n3, n5, n4) + this.a(n8, a, b, c, d2);
                                if (n9 < n2) {
                                    n2 = n9;
                                    n = n8;
                                    if (i != 0) {
                                        if (n8 + 1.0E-6 < b) {
                                            y.c.p p3 = d3.k();
                                            while (p3 != null) {
                                                final double n10 = f = dcmpg((double)p3.c(), n8);
                                                if (i != 0) {
                                                    continue Label_0087;
                                                }
                                                if (n10 >= 0) {
                                                    break;
                                                }
                                                p3 = p3.a();
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                            d3.a(new Double(n8), p3);
                                        }
                                        m.g();
                                        continue Label_0080;
                                    }
                                    if (i != 0) {
                                        break;
                                    }
                                    continue Label_0297_Outer;
                                }
                            }
                            if (n7 > a + 1.0E-6) {
                                final double n11 = this.a(n3, n5, n4) + this.a(n7, a, b, c, d2);
                                if (n11 < n2) {
                                    n2 = n11;
                                    n = n7;
                                }
                            }
                            ++n4;
                            --n5;
                            final double n8 = s.b(n6.a());
                            continue;
                        }
                    }
                    if (a2 < Double.MAX_VALUE) {
                        return new r(n, n2);
                    }
                    return new r((b + a) / 2.0, Double.MAX_VALUE);
                }
                break;
            } while (i == 0);
            while (d3.size() > 0) {
                final double doubleValue = (double)d3.remove(0);
                ++n3;
                --n4;
                final double n12 = this.a(n3, n5, n4) + this.a(doubleValue, a, b, c, d2);
                if (n12 < n2) {
                    n2 = n12;
                    n = doubleValue;
                    if (i != 0) {
                        return new r((b + a) / 2.0, Double.MAX_VALUE);
                    }
                    if (i != 0) {
                        break;
                    }
                    continue;
                }
            }
            continue;
        }
    }
    
    protected double a(final int n, final int n2, final int n3) {
        final int n4 = n + n2 + n3;
        return this.j * (n3 / n4) + this.k * Math.abs(n - n2) / n4;
    }
    
    protected double a(final double n, final double n2, final double n3, final double n4, final double n5) {
        final double n6 = n - n2;
        final double n7 = n3 - n;
        final double n8 = n5 - n4;
        return (1.0 - Math.min((n6 > n8) ? (n8 / n6) : (n6 / n8), (n7 > n8) ? (n8 / n7) : (n7 / n8))) * this.l;
    }
    
    private R a(final R r, final D d, final D d2, final y y) {
        final int a = ab.a;
        if (d.size() != d2.size()) {
            throw new IllegalArgumentException("Number of obstacles in horizontal and vertical list have to be identical");
        }
        final y.c.q q = this.f.get(r);
        final y.c.q d3 = this.d.d();
        this.d.a(q, d3);
        final R r2 = new R(y, this);
        this.e.a(d3, r2);
        this.f.put(r2, d3);
        q q2 = null;
        Object value = null;
        Label_0334: {
            Label_0324: {
                Label_0310: {
                    Label_0197: {
                        if (this.a(r2, d)) {
                            q2 = new q(r2, false, d, d2);
                            final C m = d.m();
                            while (m.f()) {
                                ((List<R>)this.h.get(m.d())).add(r2);
                                m.g();
                                if (a != 0) {
                                    break Label_0324;
                                }
                                if (a != 0) {
                                    break Label_0197;
                                }
                            }
                            break Label_0310;
                        }
                    }
                    q2 = new q(r2, true, d, d2);
                    final C i = d.m();
                    while (i.f()) {
                        final N n = (N)i.d();
                        List<?> list = this.g.get(n);
                        final List<R> list2 = (List<R>)(value = list);
                        if (a != 0) {
                            break Label_0334;
                        }
                        if (list2 == null) {
                            list = new ArrayList<Object>();
                            this.g.put(n, list);
                        }
                        list.add(r2);
                        i.g();
                        if (a != 0) {
                            break;
                        }
                    }
                }
                this.i.put(r2, q2);
            }
            value = this.i.get(r);
        }
        final q q3 = (q)value;
        final ArrayList list3 = new ArrayList<Object>(q3.f.size() + q3.g.size());
        list3.addAll((Collection<?>)q3.f);
        list3.addAll((Collection<?>)q3.g);
        for (final R r3 : list3) {
            if (a(r3, r2)) {
                final q q4 = this.i.get(r3);
                if (a != 0) {
                    return r2;
                }
                Label_0496: {
                    if (q2.b) {
                        q4.f.add(r2);
                        if (a == 0) {
                            break Label_0496;
                        }
                    }
                    q4.g.add(r2);
                }
                if (q4.b) {
                    q2.f.add(r3);
                    if (a == 0) {
                        continue;
                    }
                }
                q2.g.add(r3);
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        this.b(r2);
        return r2;
    }
    
    public List c(final R r) {
        final int a = ab.a;
        final q q = this.i.get(r);
    Label_0079:
        while (q.g.size() > 0) {
            final Object[] array = q.g.toArray();
            int i = 0;
            while (i < array.length) {
                this.e((R)array[i]);
                ++i;
                if (a != 0 || a != 0) {
                    break Label_0079;
                }
            }
        }
        return q.f;
    }
    
    public List d(final R r) {
        final q q = this.i.get(r);
        if (q.d == null) {
            return Collections.EMPTY_LIST;
        }
        return q.d;
    }
    
    public List a(final N n) {
        final int a = ab.a;
        final List list = this.h.get(n);
    Label_0084:
        while (true) {
        Label_0074:
            while (!list.isEmpty()) {
                final Object[] array = list.toArray();
                int i = 0;
                while (i < array.length) {
                    final Object value = this;
                    if (a != 0) {
                        break Label_0084;
                    }
                    this.e((R)array[i]);
                    ++i;
                    if (a != 0 || a != 0) {
                        break Label_0074;
                    }
                }
                continue;
                Object value = null;
                final List list2 = (List<?>)value;
                if (list2 == null) {
                    return Collections.EMPTY_LIST;
                }
                return new ArrayList(list2);
            }
            final Object value = this.g.get(n);
            continue Label_0084;
        }
    }
    
    public List a(final y y) {
        final int a = ab.a;
        final D d = new D();
        final D d2 = new D();
        d2.add(this.c);
    Label_0201:
        while (!d2.isEmpty()) {
            final R r = d2.remove(0);
            final q q = this.i.get(r);
            if (y.a(r.g(), y)) {
                if (q.b) {
                    d.add(r);
                    if (a == 0) {
                        continue;
                    }
                }
                if (!q.c) {
                    this.e(r);
                }
                final x o = this.f.get(r).o();
                while (o.f()) {
                    d2.add((R)this.e.b(o.e()));
                    o.g();
                    if (a != 0 || a != 0) {
                        break Label_0201;
                    }
                }
            }
        }
        return d;
    }
    
    public y b() {
        return (this.c != null) ? this.c.g() : null;
    }
    
    List a(final boolean b) {
        final ArrayList list = new ArrayList();
        this.a(this.c, list, b);
        return list;
    }
    
    private void a(final R r, final List list, final boolean b) {
        final int a = ab.a;
        final q q = this.i.get(r);
        if (q.b || (!b && !q.c)) {
            list.add(r);
            if (a == 0) {
                return;
            }
        }
        if (!q.c) {
            this.e(r);
        }
        final x o = this.f.get(r).o();
        while (o.f()) {
            this.a((R)this.e.b(o.e()), list, b);
            o.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private static boolean a(final R r, final R r2) {
        final int a = ab.a;
        final double h = r.h();
        final double j = r.j();
        final double h2 = r2.h();
        final double i = r2.j();
        int n = 2;
        Label_0100: {
            if (Math.abs(j - h2) < 1.0E-6 || Math.abs(h - i) < 1.0E-6) {
                n = 0;
                if (a == 0) {
                    break Label_0100;
                }
            }
            if ((h2 <= j && h <= h2) || (h <= i && h2 <= h)) {
                n = 1;
            }
        }
        final double k = r.i();
        final double l = r.k();
        final double m = r2.i();
        final double k2 = r2.k();
        int n2 = 2;
        if (Math.abs(l - m) < 1.0E-6 || Math.abs(k - k2) < 1.0E-6) {
            n2 = 0;
            if (a == 0) {
                return (n == 1 && n2 == 0) || (n == 0 && n2 == 1);
            }
        }
        if ((m <= l && k <= m) || (k <= k2 && m <= k)) {
            n2 = 1;
        }
        return (n == 1 && n2 == 0) || (n == 0 && n2 == 1);
    }
    
    static {
        a = new t();
        b = new u();
    }
}
