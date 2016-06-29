package y.h;

import y.c.*;
import y.f.*;
import y.d.*;
import java.util.*;
import java.awt.geom.*;

public class dh extends e
{
    private al a;
    private fj b;
    private eR c;
    private boolean d;
    private n e;
    private double f;
    private double g;
    
    public dh() {
        this(null);
    }
    
    public dh(final ch ch) {
        super(ch);
        this.c(30.0);
        this.b(5.0);
        this.d = false;
    }
    
    public void f() {
        super.f();
        this.n();
    }
    
    private void n() {
        this.c = null;
        this.b = null;
        this.a = null;
        this.d = false;
        this.e = null;
    }
    
    public void a(final t t, final aA aa) {
        this.n();
        this.a(t);
        this.a(this.m());
        this.g();
        this.e = aa.getOrientedBox();
        this.d = true;
    }
    
    public void a(final t t, final eR c) {
        this.n();
        this.a(t);
        this.a(this.l());
        this.g();
        this.c = c;
        this.b = c.g();
        this.e = c.getOrientedBox();
        this.a = c.a();
        this.d = true;
    }
    
    public t b(final t t) {
        final D d = new D();
        final al a = this.a;
        if (a instanceof gw) {
            this.a(((gw)a).a(), t, d);
            if (!fj.z) {
                return this.b(d, t);
            }
        }
        if (a instanceof M) {
            this.a(this.c.e(), t, d);
        }
        return this.b(d, t);
    }
    
    public t b(final List list, final t t) {
        this.h();
        if (!this.d) {
            return t;
        }
        return this.a(list, t);
    }
    
    private void a(final double n, final t t, final List list) {
        final n e = this.e;
        final n n2 = new n(e.h());
        n2.b(n2.e() + 2.0 * n, n2.f() + 2.0 * n);
        n2.b(t);
        final List o = this.o();
        if (o != null && !o.isEmpty()) {
            this.a(t, new t(n2.e() * 0.5, n2.f() * 0.5), o, list);
        }
        final List p3 = this.p();
        if (p3 != null && !p3.isEmpty()) {
            this.a(t, new t(e.e() * 0.5, e.f() * 0.5), p3, list);
        }
        final D d = new D();
        final y box = this.c.getBox();
        final double n3 = box.c() + box.a() * 0.5;
        final double n4 = box.d() + box.b() * 0.5;
        final t k = e.k();
        d.add(new di((byte)1, k, Math.min(k.b(), n4), Math.max(k.b(), n4)));
        d.add(new di((byte)0, k, Math.min(k.a(), n3), Math.max(k.a(), n3)));
        this.a(t, new t(e.e() * 0.5, e.f() * 0.5), d, list);
    }
    
    private void a(final t t, final t t2, final List list, final List list2) {
        final boolean z = fj.z;
        final double n = this.e() / this.c().getZoom();
        for (final gy gy : list) {
            if (gy.c() == 1) {
                final double a = gy.b().a();
                final double a2 = t.a();
                if (gy.d() == 16) {
                    final double n2 = a - a2;
                    if (Math.abs(n2) >= n) {
                        continue;
                    }
                    list2.add(gz.a(n - Math.abs(n2), gy, true, a2 + n2));
                    if (!z) {
                        continue;
                    }
                }
                final double a3 = t2.a();
                if (gy.d() == 4) {
                    final double n3 = a - (a2 + a3);
                    if (Math.abs(n3) >= n) {
                        continue;
                    }
                    list2.add(gz.a(n - Math.abs(n3), gy, true, a2 + n3));
                    if (!z) {
                        continue;
                    }
                }
                if (gy.d() != 8) {
                    continue;
                }
                final double n4 = a - (a2 - a3);
                if (Math.abs(n4) >= n) {
                    continue;
                }
                list2.add(gz.a(n - Math.abs(n4), gy, true, a2 + n4));
                if (!z) {
                    continue;
                }
            }
            final double b = gy.b().b();
            final double b2 = t.b();
            if (gy.d() == 16) {
                final double n5 = b - b2;
                if (Math.abs(n5) >= n) {
                    continue;
                }
                list2.add(gz.a(n - Math.abs(n5), gy, false, b2 + n5));
                if (!z) {
                    continue;
                }
            }
            final double b3 = t2.b();
            if (gy.d() == 1) {
                final double n6 = b - (b2 + b3);
                if (Math.abs(n6) >= n) {
                    continue;
                }
                list2.add(gz.a(n - Math.abs(n6), gy, false, b2 + n6));
                if (!z) {
                    continue;
                }
            }
            if (gy.d() == 2) {
                final double n7 = b - (b2 - b3);
                if (Math.abs(n7) >= n) {
                    continue;
                }
                list2.add(gz.a(n - Math.abs(n7), gy, false, b2 + n7));
                if (z) {
                    break;
                }
                continue;
            }
        }
    }
    
    private List o() {
        final D d = new D();
        final fj b = this.b;
        if (this.a(b)) {
            final double x = b.getX();
            final double y = b.getY();
            final double width = b.getWidth();
            final double height = b.getHeight();
            final double n = x + width * 0.5;
            final double n2 = y + height * 0.5;
            final t k = this.c.getOrientedBox().k();
            final double b2 = k.b();
            final double min = Math.min(n2, b2);
            final double max = Math.max(n2, b2);
            d.add(b((byte)16, n, n2, min, max));
            d.add(b((byte)4, x, n2, min, max));
            d.add(b((byte)16, x, n2, min, max));
            d.add(b((byte)8, x, n2, min, max));
            d.add(b((byte)4, x + width, n2, min, max));
            d.add(b((byte)16, x + width, n2, min, max));
            d.add(b((byte)8, x + width, n2, min, max));
            final double a = k.a();
            final double min2 = Math.min(n, a);
            final double max2 = Math.max(n, a);
            d.add(a((byte)16, n, n2, min2, max2));
            d.add(a((byte)1, n, y, min2, max2));
            d.add(a((byte)16, n, y, min2, max2));
            d.add(a((byte)2, n, y, min2, max2));
            d.add(a((byte)1, n, y + height, min2, max2));
            d.add(a((byte)16, n, y + height, min2, max2));
            d.add(a((byte)2, n, y + height, min2, max2));
        }
        return d;
    }
    
    private List p() {
        final boolean z = fj.z;
        final D d = new D();
        final fj b = this.b;
        final n orientedBox = this.c.getOrientedBox();
        final y box = this.c.getBox();
        final double n = box.c() + box.a() * 0.5;
        final double n2 = box.d() + box.b() * 0.5;
        int i = 0;
        while (i < b.labelCount()) {
            final eR label = b.getLabel(i);
            final n orientedBox2 = label.getOrientedBox();
            if (!orientedBox.equals(orientedBox2) && this.a(orientedBox2)) {
                final y box2 = label.getBox();
                final double c = box2.c();
                final double d2 = box2.d();
                final double a = box2.a();
                final double b2 = box2.b();
                final double n3 = c + a * 0.5;
                final double n4 = d2 + b2 * 0.5;
                final double min = Math.min(n4, n2);
                final double max = Math.max(n4, n2);
                d.add(b((byte)8, c, n4, min, max));
                d.add(b((byte)16, n3, n4, min, max));
                d.add(b((byte)4, c + a, n4, min, max));
                final double min2 = Math.min(n3, n);
                final double max2 = Math.max(n3, n);
                d.add(a((byte)2, n3, d2, min2, max2));
                d.add(a((byte)16, n3, n4, min2, max2));
                d.add(a((byte)1, n3, d2 + b2, min2, max2));
            }
            ++i;
            if (z) {
                break;
            }
        }
        return d;
    }
    
    private static gy a(final byte b, final double n, final double n2, final double n3, final double n4) {
        return a((byte)0, b, n, n2, n3, n4);
    }
    
    private static gy b(final byte b, final double n, final double n2, final double n3, final double n4) {
        return a((byte)1, b, n, n2, n3, n4);
    }
    
    private static gy a(final byte b, final byte b2, final double n, final double n2, final double n3, final double n4) {
        return new gy(b, b2, new t(n, n2), n3, n4, null, 1.0);
    }
    
    private boolean a(final n n) {
        final Rectangle2D visibleRect2D = this.c().getVisibleRect2D();
        return n.a(n, new y(visibleRect2D.getX(), visibleRect2D.getY(), visibleRect2D.getWidth(), visibleRect2D.getHeight()), 0.0);
    }
    
    public double l() {
        return this.f;
    }
    
    public void b(final double f) {
        this.f = f;
    }
    
    public double m() {
        return this.g;
    }
    
    public void c(final double g) {
        this.g = g;
    }
}
