package y.h.b;

import y.c.*;
import java.awt.geom.*;
import y.d.*;
import java.util.*;
import java.awt.*;
import y.h.*;

public class S extends ae
{
    private f a;
    private y.h.b.c b;
    private ad c;
    private ac d;
    private g e;
    private d f;
    private g g;
    private d j;
    private aa k;
    private byte l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    
    public S() {
        this.k = new aa();
        this.q = Integer.MAX_VALUE;
        this.r = Integer.MAX_VALUE;
        this.l = 1;
        this.c = new ad();
        this.m = true;
    }
    
    public boolean a(final double n, final double n2) {
        this.b = null;
        this.a = null;
        if (this.h != null && this.i != null) {
            final q a = this.a(new cW(this.h, n, n2, true));
            if (a != null) {
                final bu graph2D = this.h.getGraph2D();
                if (graph2D != null && ae.a(graph2D, a) == this.i) {
                    final f a2 = this.i.l().a(n, n2);
                    if (a2 != null && this.a(a2, n, n2)) {
                        this.a = a2;
                        return true;
                    }
                    final y.h.b.c b = this.i.l().b(n, n2);
                    if (b != null && this.a(b, n, n2)) {
                        this.b = b;
                        return true;
                    }
                }
            }
        }
        this.i();
        return false;
    }
    
    protected boolean a(final y.h.b.c c, final double n, final double n2) {
        return (this.g() == 2 || c.e()) && this.a(this.i, c, n, n2, this.h());
    }
    
    protected boolean a(final f f, final double n, final double n2) {
        return (this.g() == 2 || f.e()) && this.a(this.i, f, n, n2, this.h());
    }
    
    protected void b(final double n, final double n2) {
        if (this.a(n, n2) && (this.b != null || this.a != null)) {
            this.e = null;
            this.f = null;
            this.n = -1;
            this.p = 0;
            Rectangle2D rectangle2D = null;
            if (this.a != null) {
                rectangle2D = this.a.h();
                this.c.a(this.a(this.a, rectangle2D));
                this.e = this.a.a();
                this.n = this.a.b();
                this.p = this.b(this.a);
            }
            else if (this.b != null) {
                rectangle2D = this.b.h();
                this.c.a(this.a(this.b, rectangle2D));
                this.f = this.b.a();
                this.n = this.b.b();
                this.p = this.b(this.b);
            }
            this.h.addDrawable(this.c);
            this.h.updateView(rectangle2D);
            this.g = this.e;
            this.j = this.f;
            this.o = this.n;
            if (y.h.b.a.H == 0) {
                return;
            }
        }
        this.i();
    }
    
    protected void c(final double n, final double n2) {
        Label_0266: {
            if (this.a != null && this.a.b() >= 0) {
                this.e(n, n2);
                if (this.e != this.g) {
                    this.h.getGraph2D().r();
                    try {
                        this.k.a(this.a, this.g);
                        this.k.a(this.a, this.o);
                        break Label_0266;
                    }
                    finally {
                        this.h.getGraph2D().s();
                    }
                }
                if (this.n == this.o) {
                    break Label_0266;
                }
                this.k.a(this.a, this.o);
                if (y.h.b.a.H == 0) {
                    break Label_0266;
                }
            }
            if (this.b != null && this.b.b() >= 0) {
                this.f(n, n2);
                if (this.f != this.j) {
                    this.h.getGraph2D().r();
                    try {
                        this.k.a(this.b, this.j);
                        this.k.a(this.b, this.o);
                        break Label_0266;
                    }
                    finally {
                        this.h.getGraph2D().s();
                    }
                }
                if (this.n != this.o) {
                    this.k.a(this.b, this.o);
                }
            }
        }
        this.e();
    }
    
    protected void d(final double n, final double n2) {
        final int h = y.h.b.a.H;
        Label_0944: {
            if (this.a != null) {
                this.e(n, n2);
                if (this.g instanceof i) {
                    final i i = (i)this.g;
                    final Rectangle2D h2 = i.c((i.n() > this.o) ? this.o : (this.o - 1)).h();
                    final double x = h2.getX();
                    double y = h2.getY();
                    final double width = h2.getWidth();
                    final double g = this.a.g();
                    if (i.n() <= this.o) {
                        y += h2.getHeight();
                    }
                    this.c.a(this.a(this.a, new Rectangle2D.Double(x, y, width, g)));
                    if (h == 0) {
                        break Label_0944;
                    }
                }
                if (!(this.g instanceof f)) {
                    break Label_0944;
                }
                final f f = (f)this.g;
                double n3 = 0.0;
                double n4 = 0.0;
                double n5 = 0.0;
                double n6 = 0.0;
                Label_0442: {
                    if (f.o().isEmpty()) {
                        final Rectangle2D h3 = f.h();
                        n3 = h3.getX();
                        n4 = h3.getY();
                        n5 = h3.getWidth();
                        n6 = h3.getHeight();
                        final r j = f.i();
                        if (j != null) {
                            n3 += j.b;
                            n4 += j.a;
                            n5 -= j.b + j.d;
                            n6 -= j.a + j.c;
                        }
                        if (n6 >= this.a.g()) {
                            break Label_0442;
                        }
                        n6 = this.a.g();
                        if (h == 0) {
                            break Label_0442;
                        }
                    }
                    final Rectangle2D h4 = f.c((f.n() > this.o) ? this.o : (this.o - 1)).h();
                    n3 = h4.getX();
                    n5 = h4.getWidth();
                    n6 = this.a.g();
                    n4 = h4.getY();
                    if (f.n() <= this.o) {
                        n4 += h4.getHeight();
                    }
                }
                this.c.a(this.a(this.a, new Rectangle2D.Double(n3, n4, n5, n6)));
                if (h == 0) {
                    break Label_0944;
                }
            }
            if (this.b != null) {
                this.f(n, n2);
                if (this.j instanceof i) {
                    final i k = (i)this.j;
                    final Rectangle2D h5 = k.b((k.k() > this.o) ? this.o : (this.o - 1)).h();
                    double x2 = h5.getX();
                    final double y2 = h5.getY();
                    final double g2 = this.b.g();
                    final double height = h5.getHeight();
                    if (k.k() <= this.o) {
                        x2 += h5.getWidth();
                    }
                    this.c.a(this.a(this.b, new Rectangle2D.Double(x2, y2, g2, height)));
                    if (h == 0) {
                        break Label_0944;
                    }
                }
                if (this.j instanceof y.h.b.c) {
                    final y.h.b.c c = (y.h.b.c)this.j;
                    double n7 = 0.0;
                    double n8 = 0.0;
                    double n9 = 0.0;
                    double n10 = 0.0;
                    Label_0914: {
                        if (c.l().isEmpty()) {
                            final Rectangle2D h6 = c.h();
                            n7 = h6.getX();
                            n8 = h6.getY();
                            n9 = h6.getWidth();
                            n10 = h6.getHeight();
                            final r l = c.i();
                            if (l != null) {
                                n7 += l.b;
                                n8 += l.a;
                                n9 -= l.b + l.d;
                                n10 -= l.a + l.c;
                            }
                            if (n9 >= this.b.g()) {
                                break Label_0914;
                            }
                            n9 = this.b.g();
                            if (h == 0) {
                                break Label_0914;
                            }
                        }
                        final Rectangle2D h7 = c.b((c.k() > this.o) ? this.o : (this.o - 1)).h();
                        n7 = h7.getX();
                        n8 = h7.getY();
                        n9 = this.b.g();
                        n10 = h7.getHeight();
                        if (c.k() <= this.o) {
                            n7 += h7.getWidth();
                        }
                    }
                    this.c.a(this.a(this.b, new Rectangle2D.Double(n7, n8, n9, n10)));
                }
            }
        }
        this.h.getGraph2D().T();
    }
    
    private void e(final double n, final double n2) {
        final int h = y.h.b.a.H;
        if (this.i != null) {
            f a = this.i.l().a(n, n2);
            if (a != null && (a == this.a || this.p + 1 < this.q)) {
                int a2 = this.a(a);
                while (a != this.a && a2 + this.p > this.q) {
                    a = (f)a.a();
                    --a2;
                    if (h != 0) {
                        break;
                    }
                }
                final r i = a.i();
                final Rectangle2D h2 = a.h();
                g a3 = null;
                int o = 0;
                Label_0254: {
                    if (a2 + this.p >= this.q || (i != null && n < h2.getX() + i.b)) {
                        a3 = a.a();
                        o = a.b();
                        if (h == 0) {
                            break Label_0254;
                        }
                    }
                    a3 = a;
                    if (i != null && n2 > h2.getMaxY() - i.c) {
                        if (a3 == this.a.a()) {
                            o = a3.n() - 1;
                            if (h == 0) {
                                break Label_0254;
                            }
                        }
                        o = a3.n();
                        if (h == 0) {
                            break Label_0254;
                        }
                    }
                    o = 0;
                }
                g a4 = a3;
                boolean b = false;
                while (a4 instanceof f) {
                    if (a4 == this.a) {
                        b = true;
                    }
                    a4 = ((f)a4).a();
                    if (h != 0) {
                        break;
                    }
                }
                if (b) {
                    this.g = this.e;
                    this.o = this.n;
                    if (h == 0) {
                        return;
                    }
                }
                this.g = a3;
                this.o = o;
                if (h == 0) {
                    return;
                }
            }
            double n3 = this.i.getY() + this.i.t();
            final i l = this.i.l();
            if (n2 < n3) {
                this.g = l;
                this.o = 0;
                if (h == 0) {
                    return;
                }
            }
            for (final f f : l.o()) {
                n3 += f.g();
                if (n2 < n3) {
                    this.g = l;
                    this.o = f.b();
                    if (h == 0) {
                        break;
                    }
                    return;
                }
            }
            if (n2 >= n3) {
                this.g = l;
                this.o = ((this.e == l) ? (l.n() - 1) : l.n());
            }
        }
    }
    
    private void f(final double n, final double n2) {
        final int h = y.h.b.a.H;
        if (this.i != null) {
            y.h.b.c b = this.i.l().b(n, n2);
            if (b != null && (b == this.b || this.p + 1 < this.r)) {
                int a = this.a(b);
                while (b != this.b && a + this.p > this.r) {
                    b = (y.h.b.c)b.a();
                    --a;
                    if (h != 0) {
                        break;
                    }
                }
                final r i = b.i();
                final Rectangle2D h2 = b.h();
                d a2 = null;
                int o = 0;
                Label_0254: {
                    if (a + this.p >= this.r || (i != null && n2 < h2.getY() + i.a)) {
                        a2 = b.a();
                        o = b.b();
                        if (h == 0) {
                            break Label_0254;
                        }
                    }
                    a2 = b;
                    if (i != null && n > h2.getMaxX() - i.d) {
                        if (a2 == this.b.a()) {
                            o = a2.k() - 1;
                            if (h == 0) {
                                break Label_0254;
                            }
                        }
                        o = a2.k();
                        if (h == 0) {
                            break Label_0254;
                        }
                    }
                    o = 0;
                }
                d a3 = a2;
                boolean b2 = false;
                while (a3 instanceof y.h.b.c) {
                    if (a3 == this.b) {
                        b2 = true;
                    }
                    a3 = ((y.h.b.c)a3).a();
                    if (h != 0) {
                        break;
                    }
                }
                if (b2) {
                    this.j = this.f;
                    this.o = this.n;
                    if (h == 0) {
                        return;
                    }
                }
                this.j = a2;
                this.o = o;
                if (h == 0) {
                    return;
                }
            }
            double n3 = this.i.getX() + this.i.v();
            final i l = this.i.l();
            if (n < n3) {
                this.j = l;
                this.o = 0;
                if (h == 0) {
                    return;
                }
            }
            for (final y.h.b.c c : l.l()) {
                n3 += c.g();
                if (n < n3) {
                    this.j = l;
                    this.o = c.b();
                    if (h == 0) {
                        break;
                    }
                    return;
                }
            }
            if (n >= n3) {
                this.j = l;
                this.o = ((this.f == l) ? (l.k() - 1) : l.k());
            }
        }
    }
    
    private int a(final f f) {
        final int h = y.h.b.a.H;
        int n = 1;
        g g = f.a();
        while (g instanceof f) {
            ++n;
            g = ((f)g).a();
            if (h != 0) {
                break;
            }
        }
        return n;
    }
    
    private int a(final y.h.b.c c) {
        final int h = y.h.b.a.H;
        int n = 1;
        d d = c.a();
        while (d instanceof y.h.b.c) {
            ++n;
            d = ((y.h.b.c)d).a();
            if (h != 0) {
                break;
            }
        }
        return n;
    }
    
    private int b(final f f) {
        final int h = y.h.b.a.H;
        int n = 0;
        int n2 = 0;
        if (f.n() > 0) {
            final List o = f.o();
            int i = 0;
            while (i < o.size()) {
                final int b = this.b(o.get(i));
                n2 = b + 1;
                if (h != 0) {
                    break;
                }
                if (n2 > n) {
                    n = b + 1;
                }
                ++i;
                if (h != 0) {
                    break;
                }
            }
        }
        return n2;
    }
    
    private int b(final y.h.b.c c) {
        final int h = y.h.b.a.H;
        int n = 0;
        int n2 = 0;
        if (c.k() > 0) {
            final List l = c.l();
            int i = 0;
            while (i < l.size()) {
                final int b = this.b(l.get(i));
                n2 = b + 1;
                if (h != 0) {
                    break;
                }
                if (n2 > n) {
                    n = b + 1;
                }
                ++i;
                if (h != 0) {
                    break;
                }
            }
        }
        return n2;
    }
    
    public void e() {
        if (this.c.a() != null) {
            this.c.a((az)null);
            this.h.removeDrawable(this.c);
        }
        this.h.setViewCursor(Cursor.getDefaultCursor());
        this.h.getGraph2D().T();
        super.e();
    }
    
    protected az a(final f f, final Rectangle2D rectangle2D) {
        if (this.d == null) {
            this.d = new ac();
        }
        this.d.a(true);
        if (f != null && f.i() != null) {
            this.d.a(f.i().b);
        }
        this.d.a(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        return this.d;
    }
    
    protected az a(final y.h.b.c c, final Rectangle2D rectangle2D) {
        if (this.d == null) {
            this.d = new ac();
        }
        this.d.a(false);
        if (c != null && c.i() != null) {
            this.d.a(c.i().a);
        }
        this.d.a(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        return this.d;
    }
    
    public byte g() {
        return this.l;
    }
    
    public boolean a(final dw dw) {
        return this.f(dw) && this.a(dw.a(), dw.b());
    }
    
    public void b(final dw dw) {
        final int h = y.h.b.a.H;
        Label_0084: {
            switch (dw.c()) {
                case 501: {
                    if (!this.e(dw)) {
                        break;
                    }
                    this.b(dw.a(), dw.b());
                    if (h != 0) {
                        break Label_0084;
                    }
                    break;
                }
                case 506: {
                    this.d(dw.a(), dw.b());
                    if (h != 0) {
                        break Label_0084;
                    }
                    break;
                }
                case 502: {
                    if (this.e(dw)) {
                        this.c(dw.a(), dw.b());
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    public Cursor c(final dw dw) {
        if (this.a(dw.a(), dw.b())) {
            return Cursor.getPredefinedCursor(13);
        }
        return null;
    }
    
    public boolean h() {
        return this.m;
    }
    
    void i() {
        super.i();
        this.a = null;
        this.b = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = null;
    }
}
