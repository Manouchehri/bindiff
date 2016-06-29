package y.h.b;

import java.awt.geom.*;
import y.c.*;
import java.util.*;

final class r extends q implements f
{
    private g d;
    private final a e;
    
    r(final a a, final double n, final double n2, final y.d.r r) {
        this(a, null, n, n2, r);
    }
    
    r(final a e, final g d, final double n, final double n2, final y.d.r r) {
        super(n, n2, r);
        this.e = e;
        this.d = d;
    }
    
    r(final a e, final r r) {
        final int h = y.h.b.a.H;
        super(r);
        this.e = e;
        final Iterator<r> iterator = r.b.iterator();
        while (iterator.hasNext()) {
            final r r2 = new r(e, iterator.next());
            r2.d = this;
            this.b.add(r2);
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
    
    double b(final y.d.r r) {
        return r.a + r.c;
    }
    
    public Rectangle2D h() {
        return y.h.b.a.a(this.e, this);
    }
    
    public f m() {
        return this.b(this.b.size());
    }
    
    public f b(final int n) {
        int h = y.h.b.a.H;
        final boolean c = y.h.b.a.c(this.e);
        if (c) {
            y.h.b.a.a(this.e, false);
        }
        try {
            final r r = new r(this.e, this.e.p(), this.e.q(), this.e.r());
            final s s = new s();
            y.h.b.a.a(this.e, s);
            final double b = y.h.b.a.b(this.e);
            double q = this.q();
            final y.d.r i = this.i();
            if (i != null) {
                q -= i.a + i.c;
            }
            double n2 = 0.0;
            Label_0268: {
                Label_0243: {
                    if (!this.b.isEmpty() || r.g() > q) {
                        n2 = (this.b.isEmpty() ? (r.g() - q) : r.g());
                        g a = this;
                        while (true) {
                            while (a instanceof f) {
                                final r r2 = (r)a;
                                r2.b(r2.g() + n2);
                                a = r2.a();
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
                            this.b.add(n, r);
                            r.d = this;
                            continue;
                        }
                    }
                }
                n2 = 0.0;
                r.b(q);
                this.b.add(n, r);
                r.d = this;
            }
            final s s2 = new s();
            y.h.b.a.a(this.e, s2);
            y.h.b.a.c(this.e, this.r().getWidth() + s2.b - s.b + s2.d - s.d, b + n2);
            final r r3 = r;
            if (c) {
                y.h.b.a.a(this.e, c);
            }
            final r r4 = r3;
            if (y.c.i.g) {
                y.h.b.a.H = ++h;
            }
            return r4;
        }
        finally {
            if (c) {
                y.h.b.a.a(this.e, c);
            }
        }
    }
    
    public void c() {
        final g a = this.a();
        if (a == null) {
            throw new IllegalStateException("Parent container is null.");
        }
        final j j = this.j();
        if (j == a) {
            if (y.h.b.j.a(j).size() > 1 || this.n() > 0) {
                y.h.b.a.a(this.e, j, y.h.b.j.a(j), this);
                if (y.h.b.a.H == 0) {
                    return;
                }
            }
            throw new IllegalStateException("Sole row in table.");
        }
        y.h.b.a.a(this.e, j, ((r)a).b, this);
    }
    
    public f c(final int n) {
        return this.b.get(n);
    }
    
    public int n() {
        return this.b.size();
    }
    
    private j j() {
        return y.h.b.a.e(this.r());
    }
    
    public List o() {
        return this.c;
    }
    
    public g a() {
        return this.d;
    }
    
    public void a(final g g) {
        this.c(g);
        final boolean c = y.h.b.a.c(this.e);
        if (c) {
            y.h.b.a.a(this.e, false);
        }
        try {
            this.b(g);
        }
        finally {
            if (c) {
                y.h.b.a.a(this.e, c);
            }
        }
    }
    
    private void b(final g d) {
        final int h = y.h.b.a.H;
        final s s = new s();
        y.h.b.a.a(this.e, s);
        double n = 0.0;
        double n2 = 0.0;
        Label_0431: {
            Label_0426: {
                if (this.d instanceof j) {
                    j.a((j)this.d).remove(this);
                    if (h == 0) {
                        break Label_0426;
                    }
                }
                if (this.d instanceof r) {
                    final r r = (r)this.d;
                    final int b = this.b();
                    r.b.remove(b);
                    if (r.b.isEmpty()) {
                        n2 += this.q();
                        if (h == 0) {
                            break Label_0426;
                        }
                    }
                    double q = this.q();
                    g g = this.d;
                    while (true) {
                        while (g instanceof f) {
                            final f f = (f)g;
                            final double n3 = f.g() - f.f();
                            final double n4 = dcmpl(q, n3);
                            if (h == 0) {
                                if (n4 > 0) {
                                    q = n3;
                                }
                                g = f.a();
                                if (h != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                double empty = 0.0;
                                Label_0366: {
                                    if (n4 < 0) {
                                        final double n5 = this.q() - q;
                                        n2 += n5;
                                        final boolean b2 = r.b.size() == b;
                                        f f2 = r.b.get(b2 ? (b - 1) : b);
                                        while (f2 != null) {
                                            f2.b(f2.g() + n5);
                                            final List o = f2.o();
                                            final int n6 = (int)(empty = (o.isEmpty() ? 1 : 0));
                                            if (h != 0) {
                                                break Label_0366;
                                            }
                                            if (n6 != 0) {
                                                f2 = null;
                                            }
                                            else {
                                                f2 = o.get(b2 ? (o.size() - 1) : 0);
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
                                    g g2 = this.d;
                                    while (g2 instanceof f) {
                                        final f f3 = (f)g2;
                                        f3.b(f3.g() - q);
                                        g2 = f3.a();
                                        if (h != 0) {
                                            break Label_0431;
                                        }
                                        if (h != 0) {
                                            break;
                                        }
                                    }
                                }
                                break Label_0426;
                            }
                        }
                        final double n7 = dcmpg(q, this.q());
                        continue;
                    }
                }
            }
            this.d = d;
        }
        Label_0723: {
            if (this.d instanceof j) {
                j.a((j)this.d).add(this);
                if (h == 0) {
                    break Label_0723;
                }
            }
            if (this.d instanceof r) {
                final r r2 = (r)this.d;
                r2.b.add(this);
                if (r2.b.size() == 1) {
                    final double g3 = r2.g();
                    final y.d.r i = r2.i();
                    final double n8 = g3 - (i.a + i.c);
                    final double q2 = this.q();
                    if (q2 < n8) {
                        this.d(n8);
                        n2 -= q2;
                        if (h == 0) {
                            break Label_0723;
                        }
                    }
                    Label_0659: {
                        if (q2 > n8) {
                            final double n9 = q2 - n8;
                            g a = r2;
                            while (true) {
                                while (a instanceof f) {
                                    final r r3 = (r)a;
                                    r3.b(r3.g() + n9);
                                    a = r3.a();
                                    if (h == 0) {
                                        if (h != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                    else {
                                        if (h != 0) {
                                            break Label_0659;
                                        }
                                        break Label_0723;
                                    }
                                }
                                n2 = n2 - q2 + n9;
                                continue;
                            }
                        }
                    }
                    n2 -= q2;
                    if (h == 0) {
                        break Label_0723;
                    }
                }
                g a2 = r2;
                while (a2 instanceof f) {
                    final r r4 = (r)a2;
                    r4.b(r4.g() + this.q());
                    a2 = r4.a();
                    if (h != 0) {
                        break;
                    }
                }
            }
        }
        final s s2 = new s();
        y.h.b.a.a(this.e, s2);
        if (s2.b != s.b || s2.d != s.d) {
            n += s2.b - s.b + (s2.d - s.d);
        }
        if (n2 != 0.0 || n != 0.0) {
            y.h.b.a.a(this.e, this.r().getX(), this.r().getY(), this.r().getWidth() + n, this.r().getHeight() + n2);
            if (h == 0) {
                return;
            }
        }
        y.h.b.a.d(this.e);
    }
    
    private void c(final g g) {
        final int h = y.h.b.a.H;
        if (this.d == null) {
            throw new IllegalStateException("Old parent is null.");
        }
        if (g == null) {
            throw new IllegalArgumentException("New parent is null.");
        }
        g a = g;
        while (true) {
            while (a instanceof f) {
                final g g2 = a;
                final r r = this;
                if (h == 0) {
                    if (g2 == this) {
                        throw new IllegalArgumentException("New parent is descendant of row.");
                    }
                    a = ((r)a).a();
                    if (h != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    if (g2 != r.j()) {
                        throw new IllegalArgumentException("Parent does not belong to table.");
                    }
                    return;
                }
            }
            final r r = this;
            continue;
        }
    }
    
    public int b() {
        if (this.d == null) {
            return -1;
        }
        final j j = this.j();
        return ((j == this.d) ? y.h.b.j.a(j) : ((r)this.d).b).indexOf(this);
    }
    
    public void a(final int n) {
        if (this.d == null) {
            throw new IllegalStateException("Parent container is null.");
        }
        final int b = this.b();
        if (b != n) {
            final j j = this.j();
            final List list = (j == this.d) ? y.h.b.j.a(j) : ((r)this.d).b;
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
    
    static g a(final r r, final g d) {
        return r.d = d;
    }
}
