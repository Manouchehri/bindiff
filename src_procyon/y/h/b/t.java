package y.h.b;

import y.d.*;
import java.awt.geom.*;
import y.c.*;
import java.util.*;

final class t extends q implements c
{
    private d d;
    private final a e;
    
    t(final a a, final double n, final double n2, final r r) {
        this(a, null, n, n2, r);
    }
    
    t(final a e, final d d, final double n, final double n2, final r r) {
        super(n, n2, r);
        this.e = e;
        this.d = d;
    }
    
    t(final a e, final t t) {
        final int h = y.h.b.a.H;
        super(t);
        this.e = e;
        final Iterator<t> iterator = t.b.iterator();
        while (iterator.hasNext()) {
            final t t2 = new t(e, iterator.next());
            t2.d = this;
            this.b.add(t2);
            if (h != 0) {
                return;
            }
            if (h != 0) {
                break;
            }
        }
        this.d = null;
    }
    
    a r() {
        return this.e;
    }
    
    public void a(final double n) {
        this.c(n);
    }
    
    public double f() {
        return this.p();
    }
    
    public void b(final double n) {
        this.d(n);
    }
    
    public double g() {
        return this.q();
    }
    
    double b(final r r) {
        return r.b + r.d;
    }
    
    public Rectangle2D h() {
        return y.h.b.a.a(this.e, this);
    }
    
    public c j() {
        return this.c(this.b.size());
    }
    
    public c c(final int n) {
        final int h = y.h.b.a.H;
        final boolean c = y.h.b.a.c(this.e);
        if (c) {
            y.h.b.a.a(this.e, false);
        }
        try {
            final t t = new t(this.e, this.e.m(), this.e.n(), this.e.o());
            final s s = new s();
            y.h.b.a.b(this.e, s);
            final double a = y.h.b.a.a(this.e);
            double q = this.q();
            final r i = this.i();
            if (i != null) {
                q -= i.b + i.d;
            }
            double n2 = 0.0;
            Label_0268: {
                Label_0243: {
                    if (!this.b.isEmpty() || t.g() > q) {
                        n2 = (this.b.isEmpty() ? (t.g() - q) : t.g());
                        d a2 = this;
                        while (true) {
                            while (a2 instanceof c) {
                                final t t2 = (t)a2;
                                t2.b(t2.g() + n2);
                                a2 = t2.a();
                                if (h == 0) {
                                    if (h != 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (h != 0) {
                                        break Label_0243;
                                    }
                                    break Label_0268;
                                }
                            }
                            this.b.add(n, t);
                            t.d = this;
                            continue;
                        }
                    }
                }
                n2 = 0.0;
                t.b(q);
                this.b.add(n, t);
                t.d = this;
            }
            final s s2 = new s();
            y.h.b.a.b(this.e, s2);
            y.h.b.a.c(this.e, a + n2, this.r().getHeight() + s2.a - s.a + s2.c - s.c);
            return t;
        }
        finally {
            if (c) {
                y.h.b.a.a(this.e, c);
            }
        }
    }
    
    public void c() {
        if (this.d == null) {
            throw new IllegalStateException("Parent container is null.");
        }
        final j m = this.m();
        if (m == this.d) {
            if (j.b(m).size() > 1 || this.k() > 0) {
                y.h.b.a.a(this.e, m, j.b(m), this);
                if (y.h.b.a.H == 0) {
                    return;
                }
            }
            throw new IllegalStateException("Sole column in table.");
        }
        y.h.b.a.a(this.e, m, ((t)this.d).b, this);
    }
    
    public c b(final int n) {
        return this.b.get(n);
    }
    
    public int k() {
        return this.b.size();
    }
    
    private j m() {
        return y.h.b.a.e(this.r());
    }
    
    public List l() {
        return this.c;
    }
    
    public d a() {
        return this.d;
    }
    
    public void a(final d d) {
        this.c(d);
        final boolean c = y.h.b.a.c(this.e);
        if (c) {
            y.h.b.a.a(this.e, false);
        }
        try {
            this.b(d);
        }
        finally {
            if (c) {
                y.h.b.a.a(this.e, c);
            }
        }
    }
    
    private void b(final d d) {
        final int h = y.h.b.a.H;
        final s s = new s();
        y.h.b.a.b(this.e, s);
        double n = 0.0;
        double n2 = 0.0;
        Label_0427: {
            Label_0422: {
                if (this.d instanceof j) {
                    j.b((j)this.d).remove(this);
                    if (h == 0) {
                        break Label_0422;
                    }
                }
                if (this.d instanceof t) {
                    final t t = (t)this.d;
                    final int b = this.b();
                    t.b.remove(b);
                    if (t.b.isEmpty()) {
                        n += this.q();
                        if (h == 0) {
                            break Label_0422;
                        }
                    }
                    double q = this.q();
                    d d2 = this.d;
                    while (true) {
                        while (d2 instanceof c) {
                            final c c = (c)d2;
                            final double n3 = c.g() - c.f();
                            final double n4 = dcmpl(q, n3);
                            if (h == 0) {
                                if (n4 > 0) {
                                    q = n3;
                                }
                                d2 = c.a();
                                if (h != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                double empty = 0.0;
                                Label_0362: {
                                    if (n4 < 0) {
                                        final double n5 = this.q() - q;
                                        n += n5;
                                        final boolean b2 = t.b.size() == b;
                                        c c2 = t.b.get(b2 ? (b - 1) : b);
                                        while (c2 != null) {
                                            c2.b(c2.g() + n5);
                                            final List l = c2.l();
                                            final int n6 = (int)(empty = (l.isEmpty() ? 1 : 0));
                                            if (h != 0) {
                                                break Label_0362;
                                            }
                                            if (n6 != 0) {
                                                c2 = null;
                                            }
                                            else {
                                                c2 = l.get(b2 ? (l.size() - 1) : 0);
                                                if (h != 0) {
                                                    break;
                                                }
                                                continue;
                                            }
                                        }
                                    }
                                    empty = dcmpl(q, 0.0);
                                }
                                if (empty > 0) {
                                    d d3 = this.d;
                                    while (d3 instanceof c) {
                                        final c c3 = (c)d3;
                                        c3.b(c3.g() - q);
                                        d3 = c3.a();
                                        if (h != 0) {
                                            break Label_0427;
                                        }
                                        if (h != 0) {
                                            break;
                                        }
                                    }
                                }
                                break Label_0422;
                            }
                        }
                        final double n7 = dcmpg(q, this.q());
                        continue;
                    }
                }
            }
            this.d = d;
        }
        Label_0711: {
            if (this.d instanceof j) {
                j.b((j)this.d).add(this);
                if (h == 0) {
                    break Label_0711;
                }
            }
            if (this.d instanceof t) {
                final t t2 = (t)this.d;
                t2.b.add(this);
                if (t2.b.size() == 1) {
                    final double g = t2.g();
                    final r i = t2.i();
                    final double n8 = g - (i.b + i.d);
                    final double q2 = this.q();
                    if (q2 < n8) {
                        this.d(n8);
                        n -= q2;
                        if (h == 0) {
                            break Label_0711;
                        }
                    }
                    Label_0649: {
                        if (q2 > n8) {
                            final double n9 = q2 - n8;
                            d a = t2;
                            while (true) {
                                while (a instanceof c) {
                                    final t t3 = (t)a;
                                    t3.b(t3.g() + n9);
                                    a = t3.a();
                                    if (h == 0) {
                                        if (h != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                    else {
                                        if (h != 0) {
                                            break Label_0649;
                                        }
                                        break Label_0711;
                                    }
                                }
                                n = n - q2 + n9;
                                continue;
                            }
                        }
                    }
                    n -= q2;
                    if (h == 0) {
                        break Label_0711;
                    }
                }
                d a2 = t2;
                while (a2 instanceof c) {
                    final t t4 = (t)a2;
                    t4.b(t4.g() + this.q());
                    a2 = t4.a();
                    if (h != 0) {
                        break;
                    }
                }
            }
        }
        final s s2 = new s();
        y.h.b.a.b(this.e, s2);
        if (s2.a != s.a || s2.c != s.c) {
            n2 += s2.a - s.a + (s2.c - s.c);
        }
        if (n2 != 0.0 || n != 0.0) {
            y.h.b.a.a(this.e, this.r().getX(), this.r().getY(), this.r().getWidth() + n, this.r().getHeight() + n2);
            if (h == 0) {
                return;
            }
        }
        y.h.b.a.d(this.e);
    }
    
    private void c(final d d) {
        final int h = y.h.b.a.H;
        if (this.d == null) {
            throw new IllegalStateException("Old parent is null.");
        }
        if (d == null) {
            throw new IllegalArgumentException("New parent is null.");
        }
        d a = d;
        while (true) {
            while (a instanceof c) {
                final d d2 = a;
                final t t = this;
                if (h == 0) {
                    if (d2 == this) {
                        throw new IllegalArgumentException("New parent is descendant of column.");
                    }
                    a = ((t)a).a();
                    if (h != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    if (d2 != t.m()) {
                        throw new IllegalArgumentException("Parent does not belong to table.");
                    }
                    return;
                }
            }
            final t t = this;
            continue;
        }
    }
    
    public int b() {
        if (this.d == null) {
            return -1;
        }
        final j m = this.m();
        return ((m == this.d) ? j.b(m) : ((t)this.d).b).indexOf(this);
    }
    
    public void a(final int n) {
        if (this.d == null) {
            throw new IllegalStateException("Parent container is null.");
        }
        final int b = this.b();
        if (b != n) {
            final j m = this.m();
            final List list = (m == this.d) ? j.b(m) : ((t)this.d).b;
            list.remove(b);
            list.add(n, this);
            y.h.b.a.d(this.e);
        }
    }
    
    public y d() {
        final y y = new y();
        if (this.b.isEmpty()) {
            y.h.b.a.a(this.e, this.h(), y);
        }
        return y;
    }
    
    static d a(final t t, final d d) {
        return t.d = d;
    }
}
