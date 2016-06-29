package y.f.i;

import y.d.*;
import java.util.*;
import y.c.*;
import java.awt.geom.*;

public class b
{
    private byte a;
    private Map b;
    private List c;
    private double d;
    private double e;
    private double f;
    private int g;
    private Map h;
    private List i;
    private Map j;
    private Set k;
    private boolean l;
    private double m;
    
    public b(final double n, final double n2, final byte b) {
        this.h = new HashMap();
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new HashSet();
        this.l = true;
        this.m = 0.5;
        this.b = new HashMap(11);
        this.c = new ArrayList(62);
        this.a(n, n2, b);
    }
    
    public b(final double n, final double n2) {
        this(n, n2, (byte)1);
    }
    
    public void a(final double n, final double n2, final byte a) {
        this.k.clear();
        this.j.clear();
        this.i.clear();
        this.h.clear();
        this.d = Math.min(n, n2);
        this.f = Math.max(n, n2);
        this.e = (n + n2) / 2.0;
        this.a = a;
        this.b.clear();
        this.c.clear();
        this.g = -1;
    }
    
    public void a(final Object o, t b, t b2) {
        if (this.a == 0) {
            b = t.b(b);
            b2 = t.b(b2);
        }
        e e = null;
        Label_0059: {
            if (b.a > b2.a) {
                e = new e(o, b2, b);
                if (v.f == 0) {
                    break Label_0059;
                }
            }
            e = new e(o, b, b2);
        }
        this.b.put(o, e);
        this.c.add(e);
        this.k.add(o);
    }
    
    public void a(final Object o, final Object o2, t b, t b2) {
        if (this.a == 0) {
            b = t.b(b);
            b2 = t.b(b2);
        }
        D d = this.h.get(o2);
        if (d == null) {
            d = new D();
            this.h.put(o2, d);
            this.i.add(d);
        }
        Label_0126: {
            if (b.a > b2.a) {
                d.add(new e(o, b2, b));
                if (v.f == 0) {
                    break Label_0126;
                }
            }
            d.add(new e(o, b, b2));
        }
        this.j.put(o, d);
    }
    
    public Iterator a() {
        return this.k.iterator();
    }
    
    public boolean a(final Object o) {
        final Object value = this.h.get(o);
        return value != null && this.b.containsKey(value);
    }
    
    public void b() {
        final int f = v.f;
        if (this.h.size() > 0) {
            this.d();
        }
        final e[] array = new e[this.c.size()];
        double min = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        int i = this.c.size() - 1;
        while (true) {
            while (i >= 0) {
                array[i] = (e)this.c.get(i);
                max = Math.max(max, array[i].c.a);
                min = Math.min(min, array[i].b.a);
                --i;
                if (f != 0) {
                    final D d = new D();
                    d.a(new d(min, -1.0));
                    d.b(new d(max, -1.0));
                    int j = 0;
                    while (j < array.length) {
                        this.a(d, array[j]);
                        ++j;
                        if (f != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            y.g.e.a(array, new f(this, null));
            continue;
        }
    }
    
    private void d() {
        final int i = v.f;
        int n = this.i.size() - 1;
        do {
            double n2 = 0.0;
            Label_0017: {
                n2 = n;
            }
            Label_0018:
            while (n2 >= 0) {
                double a = Double.MAX_VALUE;
                double a2 = -1.7976931348623157E308;
                double n3 = a;
                double n4 = a2;
                boolean b = true;
                boolean b2 = true;
                final D d = this.i.get(n);
                p p = d.k();
                while (p != null) {
                    final e e = (e)p.c();
                    final double n5 = n2 = dcmpg(e.b.b, n3);
                    if (i != 0) {
                        continue Label_0018;
                    }
                    if (n5 < 0) {
                        n3 = e.b.b;
                    }
                    if (e.c.b < n3) {
                        n3 = e.c.b;
                    }
                    if (e.b.b > n4) {
                        n4 = e.b.b;
                    }
                    if (e.c.b > n4) {
                        n4 = e.c.b;
                    }
                    if (e.b.a < a) {
                        a = e.b.a;
                        final byte a3 = e.a(this.e);
                        b = (a3 == 1 || a3 == 0);
                    }
                    if (e.c.a > a2) {
                        a2 = e.c.a;
                        final byte a4 = e.a(this.e);
                        b2 = (a4 == 2 || a4 == 0);
                    }
                    this.k.add(e.a);
                    p = p.a();
                    if (i != 0) {
                        break;
                    }
                }
                final e e2 = new e(d, new t(a, b ? n3 : n4), new t(a2, b2 ? n3 : n4));
                this.b.put(d, e2);
                this.c.add(e2);
                --n;
                continue Label_0017;
            }
            break;
        } while (i == 0);
    }
    
    public double b(final Object o) {
        if (this.g == 0) {
            return (this.d + this.f) * 0.5;
        }
        return this.d + this.c(o) / this.g * (this.f - this.d);
    }
    
    public int c() {
        return this.g + 1;
    }
    
    public int c(final Object o) {
        return this.e(o).d;
    }
    
    public int d(final Object o) {
        return this.c(this.h.get(o));
    }
    
    private void a(final D d, final e e) {
        final int f = v.f;
        if (this.l && Math.abs(e.b.a - e.c.a) < this.m) {
            e.d = 0;
            return;
        }
        final byte a = e.a(this.e);
        final d d2 = new d(e.b.a(), e.b.b(), a == 0 || a == 1);
        final d d3 = new d(e.c.a(), e.c.b(), a == 2 || a == 0);
        p k = d.k();
        d d4 = (d)k.c();
        double n = ((Point2D.Double)d4).getY();
        while (true) {
            while (((Point2D.Double)d2).getX() > ((Point2D.Double)d4).getX()) {
                n = ((Point2D.Double)d4).getY();
                final p a2;
                k = (a2 = k.a());
                if (f != 0) {
                    final p p2 = a2;
                    double y = n;
                    while (true) {
                        while (((Point2D.Double)d3).getX() >= ((Point2D.Double)d4).getX()) {
                            y = ((Point2D.Double)d4).getY();
                            n = Math.max(y, n);
                            d.h(k);
                            final p a3;
                            k = (a3 = k.a());
                            if (f != 0) {
                                if (a3 != null) {
                                    final d d5 = (d)p2.b().c();
                                    if (((Point2D.Double)d5).getX() + 5.0 > ((Point2D.Double)d2).getX() && d5.a != d2.a && p2.b().b() != null) {
                                        n = Math.max(n, ((Point2D.Double)p2.b().b().c()).getY());
                                    }
                                }
                                if (p2.a() != null) {
                                    final d d6 = (d)p2.a().c();
                                    if (((Point2D.Double)d6).getX() - 5.0 < ((Point2D.Double)d3).getX() && d6.a != d3.a) {
                                        n = Math.max(n, ((Point2D.Double)d6).getY());
                                    }
                                }
                                p2.a(new d(e.b.a(), n + 1.0));
                                d.b(new d(e.c.a(), y), p2);
                                e.d = (int)Math.round(n + 1.0);
                                this.g = Math.max(this.g, e.d);
                                return;
                            }
                            if (a3 == null) {
                                break;
                            }
                            d4 = (d)k.c();
                            if (f != 0) {
                                break;
                            }
                        }
                        p2.b();
                        continue;
                    }
                }
                d4 = (d)a2.c();
                if (f != 0) {
                    break;
                }
            }
            d.a(d2, k);
            continue;
        }
    }
    
    private e e(final Object o) {
        final e e = this.b.get(o);
        if (e != null) {
            return e;
        }
        final Object value = this.j.get(o);
        if (value != null) {
            return (e)this.b.get(value);
        }
        throw new IllegalArgumentException("No such key registered!");
    }
    
    static double a(final b b) {
        return b.e;
    }
}
