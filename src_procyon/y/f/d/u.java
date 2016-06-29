package y.f.d;

import y.f.b.*;
import java.util.*;
import y.c.*;
import y.d.*;
import y.f.*;
import java.awt.geom.*;

class u
{
    private X a;
    private D b;
    private double c;
    private double d;
    private double e;
    private boolean f;
    private boolean g;
    private boolean h;
    private c i;
    
    u() {
        this.c = 15.0;
        this.d = 60.0;
        this.e = 5.0;
        this.f = true;
        this.g = true;
        this.h = true;
    }
    
    public void a(final boolean h) {
        this.h = h;
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public void b(final boolean g) {
        this.g = g;
    }
    
    public void c(final boolean f) {
        this.f = f;
    }
    
    public void b(final double d) {
        this.d = d;
    }
    
    public void c(final double c) {
        this.c = c;
    }
    
    public void a(final X a, final y.c.c c) {
        final int f = a.f;
        this.a = a;
        if (a.c(y.f.b.f.d) != null) {
            this.i = new c(a);
        }
        this.a(c);
        final D d = this.d(this.g);
        d.sort(new v(this));
        final C m = d.m();
        while (m.f()) {
            this.c((z)m.d());
            m.g();
            if (f != 0) {
                return;
            }
            if (f != 0) {
                break;
            }
        }
        if (this.i != null) {
            this.i.c();
            this.i = null;
        }
    }
    
    private boolean a(final aj aj) {
        return aj.a() instanceof M;
    }
    
    private boolean a(final y.f.C c) {
        return c.getLabelModel() instanceof K;
    }
    
    private boolean a(final q q, final aj aj) {
        return this.a.s(q).b(this.a(aj, q)) && !(aj instanceof M);
    }
    
    private void a(final y.c.c c) {
        final int f = y.f.d.a.f;
        this.b = new D();
        final x o = this.a.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final u u = this;
                if (f != 0) {
                    final e p = u.a.p();
                Label_0429_Outer:
                    while (p.f()) {
                        final d a = p.a();
                        final y.d.u b = this.a.l(a).b();
                        t a2 = b.a();
                        b.g();
                        while (b.f()) {
                            final t a3 = b.a();
                            this.b.add(new z(this, new m(a2, a3), a, (byte)1, false));
                            a2 = a3;
                            b.g();
                            if (f != 0) {
                                continue Label_0429_Outer;
                            }
                            if (f != 0) {
                                break;
                            }
                        }
                        final y.f.C[] d = this.a.d((Object)a);
                        int i = 0;
                        while (true) {
                            while (i < d.length) {
                                final y.f.C c2 = d[i];
                                if (f == 0) {
                                    this.b.add(new z(this, c2, a, (byte)3, (c == null || c.d(c2)) && this.a(c2)));
                                    ++i;
                                    if (f != 0) {
                                        break;
                                    }
                                    continue Label_0429_Outer;
                                }
                                else {
                                    if (f != 0) {
                                        break Label_0429_Outer;
                                    }
                                    continue Label_0429_Outer;
                                }
                            }
                            p.g();
                            continue;
                        }
                    }
                    return;
                }
                Label_0193: {
                    if (this.i == null || !this.i.d(e)) {
                        this.b.add(new z(this, e, e, (byte)0, false));
                        final aj[] a_ = this.a.a_(e);
                        int j = 0;
                        while (j < a_.length) {
                            final aj aj = a_[j];
                            if (f != 0) {
                                break Label_0193;
                            }
                            this.b.add(new z(this, aj, e, (byte)2, (c == null || c.d(aj)) && this.a(aj) && !this.a(e, aj)));
                            ++j;
                            if (f != 0) {
                                break;
                            }
                        }
                    }
                    o.g();
                }
                if (f != 0) {
                    break;
                }
            }
            final u u = this;
            continue;
        }
    }
    
    private double a(final z z) {
        final y h = z.h();
        return this.c + Math.sqrt(h.a() * h.a() + h.b() * h.b()) * 0.5;
    }
    
    private D a(final n n, final z z) {
        final int f = y.f.d.a.f;
        final D d = new D();
        final double a = this.a(z);
        final C m = this.b.m();
        while (m.f()) {
            final z z2 = (z)m.d();
            Label_0120: {
                if (z2 != z) {
                    if (z2.c == 1) {
                        if (!n.a(n, (m)z2.a, a)) {
                            break Label_0120;
                        }
                        d.add(z2);
                        if (f == 0) {
                            break Label_0120;
                        }
                    }
                    if (n.a(n, z2.h(), a)) {
                        d.add(z2);
                    }
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return d;
    }
    
    private D d(final boolean b) {
        final int f = y.f.d.a.f;
        y.d.f.a(this.b, new y.f.d.y(this));
        final D d = new D();
        final C m = this.b.m();
        while (m.f()) {
            final z z = (z)m.d();
            if (z.a() && z.e && (!b || z.d > 0)) {
                d.add(z);
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return d;
    }
    
    private t b(final z z) {
        final y h = z.h();
        final t t = new t(h.c() + h.a() * 0.5, h.d() + h.b() * 0.5);
        if (z.c == 3) {
            final double[] a = w.a(this.a.l((d)z.b), t);
            return new t(a[0], a[1]);
        }
        if (z.c == 2) {
            return this.a.l((q)z.b);
        }
        return t;
    }
    
    private n a(final t t, final t t2, final R r) {
        if (this.h && this.b(r)) {
            return null;
        }
        if (t.equals(t2)) {
            final n n = new n(t.a() - this.d, t.b() + this.d, 2.0 * this.d, 2.0 * this.d);
            if (y.f.d.a.f == 0) {
                return n;
            }
        }
        final y.d.z z = new y.d.z(t2, t);
        final double d = z.d();
        final double max = Math.max(this.d - d, 0.0);
        z.c();
        final y.d.z c = y.d.z.c(z);
        t t3 = y.d.z.a(t, new y.d.z(-c.a() * this.d, -c.b() * this.d));
        if (max > 0.0) {
            t3 = y.d.z.a(t3, new y.d.z(-z.a() * max, -z.b() * max));
        }
        n n = new n(t3, new y.d.q(this.d + max, 2.0 * this.d), z);
        if (this.h && this.d > d && this.a(r)) {
            n = new n(t3, new y.d.q(d + max, 2.0 * this.d), z);
        }
        return n;
    }
    
    private boolean a(final R r) {
        if (r instanceof y.f.C) {
            final byte b = ((y.f.C)r).getPreferredPlacementDescriptor().b();
            return b == 16 || b == 32;
        }
        return false;
    }
    
    private boolean b(final R r) {
        return r instanceof y.f.C && ((y.f.C)r).getPreferredPlacementDescriptor().b() == 8;
    }
    
    private boolean c(final z z) {
        final R r = (R)z.a;
        final y h = z.h();
        final t t = new t(h.c() + h.a() * 0.5, h.d() + h.b() * 0.5);
        final n a = this.a(t, this.b(z), r);
        if (a == null) {
            return false;
        }
        final y.f.d.x a2 = this.a(this.a(a, z));
        final y.f.d.x a3 = a(this.d(z), this.c);
        final boolean a4 = a3.a(a2, (int)Math.floor(t.a / this.c), (int)Math.floor(t.b / this.c), (int)Math.max(1.0, Math.ceil(this.e / this.c)), (int)Math.floor(this.d / this.c), new n(a.b() / this.c, a.c() / this.c, a.e() / this.c, a.f() / this.c, a.g(), a.i()), this.f);
        if (a4) {
            this.a(r, t.a() + a3.a() * this.c, t.b() + a3.b() * this.c, z.b);
        }
        return a4;
    }
    
    private void a(final R r, final double n, final double n2, final Object o) {
        if (r instanceof y.f.C) {
            final y.f.C c = (y.f.C)r;
            final E labelModel = c.getLabelModel();
            final d d = (d)o;
            final I b = this.a.b((Object)d);
            final am a = this.a.a((Object)d.c());
            final am a2 = this.a.a((Object)d.d());
            final n n3 = new n(r.getOrientedBox());
            n3.e(n, n2);
            c.setModelParameter(labelModel.a(n3, b, a, a2));
            if (y.f.d.a.f == 0) {
                return;
            }
        }
        if (r instanceof aj) {
            final aj aj = (aj)r;
            final n n4 = new n(r.getOrientedBox());
            n4.e(n, n2);
            aj.setModelParameter(aj.a().a(n4, this.a.a(o)));
        }
    }
    
    private y a(final R r, final Object o) {
        if (r instanceof y.f.C) {
            final y.f.C c = (y.f.C)r;
            final d d = (d)o;
            return c.getLabelModel().a(c.getOrientedBox().d(), this.a.b((Object)d), this.a.a((Object)d.c()), this.a.a((Object)d.d()), c.getModelParameter()).h();
        }
        if (r instanceof aj) {
            final aj aj = (aj)r;
            return aj.a().a(aj.getOrientedBox().d(), this.a.a(o), aj.getModelParameter()).h();
        }
        return null;
    }
    
    private n d(final z z) {
        if (!z.a()) {
            return null;
        }
        if (z.a instanceof y.f.C) {
            final y.f.C c = (y.f.C)z.a;
            final d d = (d)z.b;
            return c.getLabelModel().a(c.getOrientedBox().d(), this.a.b((Object)d), this.a.a((Object)d.c()), this.a.a((Object)d.d()), c.getModelParameter());
        }
        if (z.a instanceof aj) {
            final aj aj = (aj)z.a;
            return aj.a().a(aj.getOrientedBox().d(), this.a.a(z.b), aj.getModelParameter());
        }
        return null;
    }
    
    private y.f.d.x a(final D d) {
        final int f = y.f.d.a.f;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final C m = d.m();
        while (true) {
            while (m.f()) {
                final y h = ((z)m.d()).h();
                double1.setFrame(h.c(), h.d(), h.a(), h.b());
                min = Math.min((int)Math.floor(double1.x / this.c), min);
                min2 = Math.min((int)Math.floor(double1.y / this.c), min2);
                max = Math.max((int)Math.floor((double1.x + double1.width) / this.c), max);
                max2 = Math.max((int)Math.floor((double1.y + double1.height) / this.c), max2);
                m.g();
                if (f != 0) {
                    final y.f.d.x x = new y.f.d.x(min, min2, max - min, max2 - min2);
                    final C i = d.m();
                    while (i.f()) {
                        final z z = (z)i.d();
                        Label_0342: {
                            if (z.c == 1) {
                                a(x, (m)z.a, this.c);
                                if (f == 0) {
                                    break Label_0342;
                                }
                            }
                            if (z.c == 0) {
                                a(x, z.h(), this.c);
                                if (f == 0) {
                                    break Label_0342;
                                }
                            }
                            a(x, this.d(z), this.c);
                        }
                        i.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    return x;
                }
                if (f != 0) {
                    break;
                }
            }
            min -= 2;
            min2 -= 2;
            max += 2;
            max2 += 2;
            continue;
        }
    }
    
    static void a(final y.f.d.x x, final n n, final double n2) {
        x.a(a(n, n2));
    }
    
    static y.f.d.x a(final n n, final double n2) {
        final int f = a.f;
        final y h = n.h();
        final int n3 = (int)(Math.floor(h.c / n2) - 2.0);
        final int n4 = (int)(Math.floor(h.d / n2) - 2.0);
        final y.f.d.x x = new y.f.d.x(n3, n4, (int)(Math.floor((h.c + h.a) / n2) + 2.0) - n3, (int)(Math.floor((h.d + h.b) / n2) + 2.0) - n4);
        final t[] a = n.a(n);
        a(x, a[0], a[1], n2);
        a(x, a[1], a[2], n2);
        a(x, a[2], a[3], n2);
        a(x, a[3], a[0], n2);
        x.c();
        final y.f.d.x x2 = x;
        if (f != 0) {
            i.g = !i.g;
        }
        return x2;
    }
    
    static void a(final y.f.d.x x, final y y, final double n) {
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        double1.setFrame(y.c(), y.d(), y.a(), y.b());
        x.a((int)Math.floor(double1.x / n), (int)Math.floor(double1.y / n), 1 + (int)Math.floor((double1.x + double1.width) / n), 1 + (int)Math.floor((double1.y + double1.height) / n));
    }
    
    static void a(final y.f.d.x x, final m m, final double n) {
        a(x, m.c(), m.d(), n);
    }
    
    static void a(final y.f.d.x x, final t t, final t t2, final double n) {
        int f = a.f;
        final double a = t.a;
        final double b = t.b;
        final double a2 = t2.a;
        final double b2 = t2.b;
        final double n2 = a2 - a;
        final double n3 = b2 - b;
        double min = 0.1;
        Label_0103: {
            if (n > 1.0) {
                int i = 1 + (int)Math.rint(n);
                while (i > 0) {
                    min /= 10.0;
                    i /= 10;
                    if (f != 0) {
                        break Label_0103;
                    }
                    if (f != 0) {
                        break;
                    }
                }
            }
            min = Math.min(min, 1.0E-5);
        }
        double min2 = 0.1;
        int j = 0;
        Label_0173: {
            if (n > 1.0) {
                j = 1 + (int)Math.rint(n);
                while (j > 0) {
                    min2 /= 10.0;
                    j /= 10;
                    if (f != 0) {
                        break Label_0173;
                    }
                    if (f != 0) {
                        break;
                    }
                }
            }
            min2 = Math.min(min2, 1.0E-5);
            j = (int)Math.floor(a / n);
        }
        final int n4 = (int)Math.floor(b / n);
        final int n5 = (int)Math.floor(a2 / n);
        final int n6 = (int)Math.floor(b2 / n);
        final int n7 = n5 - j;
        final int n8 = n6 - n4;
        Label_0973: {
            if (n7 == 0 || Math.abs(n2) < min) {
                x.a(j, Math.min(n4, n6), j + 1, Math.max(n4, n6) + 1);
                if (f == 0) {
                    break Label_0973;
                }
            }
            if (n8 == 0 || Math.abs(n3) < min2) {
                x.a(Math.min(j, n5), n4, Math.max(j, n5) + 1, n4 + 1);
                if (f == 0) {
                    break Label_0973;
                }
            }
            Label_0655: {
                if (Math.abs(n2) > Math.abs(n3)) {
                    Label_0497: {
                        if (j > n5) {
                            final double n9 = n3 / n2;
                            double n10 = b2;
                            double n11 = (Math.floor(a2 / n) + 1.0 - n5) * n9 + b2;
                            final double n12 = n * n9;
                            int k = n5;
                            while (true) {
                                while (k < j) {
                                    final int n13 = (int)Math.floor(n10 / n);
                                    final int n14 = (int)Math.floor(n11 / n);
                                    x.a(k, n13, true);
                                    final int n15 = n13;
                                    final int n16 = n14;
                                    if (f == 0) {
                                        if (n15 != n16 && k < j) {
                                            x.a(k, n14, true);
                                        }
                                        n10 = n11;
                                        n11 += n12;
                                        ++k;
                                        if (f != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                    else {
                                        if (n15 == n16) {
                                            break Label_0973;
                                        }
                                        x.a(j, n4, true);
                                        if (f != 0) {
                                            break Label_0497;
                                        }
                                        break Label_0973;
                                    }
                                }
                                x.a(j, (int)Math.floor(n10 / n), true);
                                continue;
                            }
                        }
                    }
                    final double n17 = n3 / n2;
                    double n18 = b;
                    double n19 = (Math.floor(a / n) + 1.0 - j) * n17 + b;
                    final double n20 = n * n17;
                    int l = j;
                    while (true) {
                        while (l < n5) {
                            final int n21 = (int)Math.floor(n18 / n);
                            final int n22 = (int)Math.floor(n19 / n);
                            x.a(l, n21, true);
                            final int n23 = n21;
                            final int n24 = n22;
                            if (f == 0) {
                                if (n23 != n24) {
                                    x.a(l, n22, true);
                                }
                                n18 = n19;
                                n19 += n20;
                                ++l;
                                if (f != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (n23 == n24) {
                                    break Label_0973;
                                }
                                x.a(n5, n6, true);
                                if (f != 0) {
                                    break Label_0655;
                                }
                                break Label_0973;
                            }
                        }
                        x.a(n5, (int)Math.floor(n18 / n), true);
                        continue;
                    }
                }
            }
            Label_0820: {
                if (n4 > n6) {
                    final double n25 = n2 / n3;
                    double n26 = a2;
                    double n27 = (Math.floor(b2 / n) + 1.0 - n6) * n25 + a2;
                    final double n28 = n * n25;
                    int n29 = n6;
                    while (true) {
                        while (n29 < n4) {
                            final int n30 = (int)Math.floor(n26 / n);
                            final int n31 = (int)Math.floor(n27 / n);
                            x.a(n30, n29, true);
                            final int n32 = n30;
                            final int n33 = n31;
                            if (f == 0) {
                                if (n32 != n33) {
                                    x.a(n31, n29, true);
                                }
                                n26 = n27;
                                n27 += n28;
                                ++n29;
                                if (f != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (n32 == n33) {
                                    break Label_0973;
                                }
                                x.a(j, n4, true);
                                if (f != 0) {
                                    break Label_0820;
                                }
                                break Label_0973;
                            }
                        }
                        x.a((int)Math.floor(n26 / n), n4, true);
                        continue;
                    }
                }
            }
            final double n34 = n2 / n3;
            double n35 = a;
            double n36 = (Math.floor(b / n) + 1.0 - n4) * n34 + a;
            final double n37 = n * n34;
            int n38 = n4;
            while (true) {
                while (n38 < n6) {
                    final int n39 = (int)Math.floor(n35 / n);
                    final int n40 = (int)Math.floor(n36 / n);
                    x.a(n39, n38, true);
                    final int n41 = n39;
                    final int n42 = n40;
                    if (f == 0) {
                        if (n41 != n42) {
                            x.a(n40, n38, true);
                        }
                        n35 = n36;
                        n36 += n37;
                        ++n38;
                        if (f != 0) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (n41 != n42) {
                            x.a(n5, n6, true);
                        }
                        break Label_0973;
                    }
                }
                x.a((int)Math.floor(n35 / n), n6, true);
                continue;
            }
        }
        if (i.g) {
            y.f.d.a.f = ++f;
        }
    }
    
    static y a(final u u, final R r, final Object o) {
        return u.a(r, o);
    }
    
    static X a(final u u) {
        return u.a;
    }
}
