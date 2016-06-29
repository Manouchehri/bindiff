package y.h.b;

import java.awt.geom.*;
import y.d.*;
import y.c.*;
import y.h.a.*;
import java.util.*;
import y.h.*;
import java.awt.*;

public class X extends ae
{
    private byte j;
    protected i a;
    protected f b;
    protected f c;
    protected y.h.b.c d;
    protected y.h.b.c e;
    private byte k;
    private double l;
    private double m;
    private double n;
    private Rectangle2D o;
    private Rectangle2D p;
    private Rectangle2D q;
    private double r;
    private double s;
    protected double f;
    protected double g;
    private ad t;
    private ad u;
    private ad v;
    private ac w;
    private ac x;
    private ac y;
    private boolean z;
    private boolean A;
    private aa B;
    
    public X() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.k = 0;
        this.l = 5.0;
        this.z = true;
        this.j = 2;
        this.B = new aa();
        this.t = new ad();
        this.u = new ad();
        this.v = new ad();
    }
    
    public boolean a(final double n, final double n2) {
        final int h = y.h.b.a.H;
        this.l();
        if (this.h != null && this.i != null) {
            final q i = new cW(this.h, n, n2, true).i();
            if (i != null) {
                final bu graph2D = this.h.getGraph2D();
                if (graph2D != null && ae.a(graph2D, i) == this.i) {
                    final byte a = this.a(new y(this.i.getX(), this.i.getY(), this.i.getWidth(), this.i.getHeight()), n, n2, this.k());
                    if (a != 0) {
                        this.k = a;
                        this.a = this.i.l();
                        Label_0403: {
                            switch (a) {
                                case 1: {
                                    f b = this.i.l().c(0);
                                    while (true) {
                                        while (!b.o().isEmpty()) {
                                            b = b.c(0);
                                            if (h == 0) {
                                                if (h != 0) {
                                                    break;
                                                }
                                                continue;
                                            }
                                            else {
                                                if (h != 0) {
                                                    break Label_0403;
                                                }
                                                break Label_0403;
                                            }
                                        }
                                        this.b = b;
                                        continue;
                                    }
                                }
                                case 3: {
                                    final List o = this.i.l().o();
                                    f b2 = o.get(o.size() - 1);
                                    while (true) {
                                        while (!b2.o().isEmpty()) {
                                            final List o2 = b2.o();
                                            b2 = o2.get(o2.size() - 1);
                                            if (h == 0) {
                                                if (h != 0) {
                                                    break;
                                                }
                                                continue;
                                            }
                                            else {
                                                if (h != 0) {
                                                    break Label_0403;
                                                }
                                                break Label_0403;
                                            }
                                        }
                                        this.b = b2;
                                        continue;
                                    }
                                }
                                case 2: {
                                    y.h.b.c d = this.i.l().b(0);
                                    while (true) {
                                        while (!d.l().isEmpty()) {
                                            d = d.b(0);
                                            if (h == 0) {
                                                if (h != 0) {
                                                    break;
                                                }
                                                continue;
                                            }
                                            else {
                                                if (h != 0) {
                                                    break Label_0403;
                                                }
                                                break Label_0403;
                                            }
                                        }
                                        this.d = d;
                                        continue;
                                    }
                                }
                                case 4: {
                                    final List l = this.i.l().l();
                                    y.h.b.c d2 = l.get(l.size() - 1);
                                    while (!d2.l().isEmpty()) {
                                        final List j = d2.l();
                                        d2 = j.get(j.size() - 1);
                                        if (h != 0) {
                                            break Label_0403;
                                        }
                                        if (h != 0) {
                                            break;
                                        }
                                    }
                                    this.d = d2;
                                    break;
                                }
                            }
                        }
                        return true;
                    }
                    final f a2 = this.i.l().a(n, n2);
                    if (a2 != null) {
                        final Rectangle2D h2 = a2.h();
                        if (this.a(new y(h2.getX(), h2.getY(), h2.getWidth(), h2.getHeight()), n, n2, this.k()) == 3) {
                            this.k = 3;
                            f b3 = a2;
                            while (true) {
                                while (!b3.o().isEmpty()) {
                                    final List o3 = b3.o();
                                    b3 = o3.get(o3.size() - 1);
                                    if (h != 0) {
                                        f c = null;
                                        f f;
                                        for (g a3 = b3; a3 instanceof f; a3 = f.a()) {
                                            f = (f)a3;
                                            final int b4 = f.b();
                                            if (f.a().n() > b4 + 1) {
                                                c = f.a().c(b4 + 1);
                                                break;
                                            }
                                        }
                                        if (c != null) {
                                            while (c.n() > 0) {
                                                c = c.c(0);
                                                if (h != 0) {
                                                    return true;
                                                }
                                                if (h != 0) {
                                                    break;
                                                }
                                            }
                                            this.c = c;
                                        }
                                        return true;
                                    }
                                    if (h != 0) {
                                        break;
                                    }
                                }
                                this.b = b3;
                                continue;
                            }
                        }
                    }
                    final y.h.b.c b5 = this.i.l().b(n, n2);
                    if (b5 != null) {
                        final Rectangle2D h3 = b5.h();
                        if (this.a(new y(h3.getX(), h3.getY(), h3.getWidth(), h3.getHeight()), n, n2, this.k()) == 4) {
                            this.k = 4;
                            y.h.b.c d3 = b5;
                            while (true) {
                                while (!d3.l().isEmpty()) {
                                    final List k = d3.l();
                                    d3 = k.get(k.size() - 1);
                                    if (h != 0) {
                                        y.h.b.c e = null;
                                        y.h.b.c c2;
                                        for (d a4 = d3; a4 instanceof y.h.b.c; a4 = c2.a()) {
                                            c2 = (y.h.b.c)a4;
                                            final int b6 = c2.b();
                                            if (c2.a().k() > b6 + 1) {
                                                e = c2.a().b(b6 + 1);
                                                break;
                                            }
                                        }
                                        if (e != null) {
                                            while (e.k() > 0) {
                                                e = e.b(0);
                                                if (h != 0) {
                                                    return true;
                                                }
                                                if (h != 0) {
                                                    break;
                                                }
                                            }
                                            this.e = e;
                                        }
                                        return true;
                                    }
                                    if (h != 0) {
                                        break;
                                    }
                                }
                                this.d = d3;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        this.i();
        return false;
    }
    
    protected boolean d(final dw dw) {
        return (dw.d() & 0x40) != 0x0;
    }
    
    private byte a(final y y, final double n, final double n2, final double n3) {
        if (new y(y.c - n3, y.d - n3, 2.0 * n3, y.b + 2.0 * n3).a(n, n2)) {
            return 2;
        }
        if (new y(y.c + y.a - n3, y.d - n3, 2.0 * n3, y.b + 2.0 * n3).a(n, n2)) {
            return 4;
        }
        if (new y(y.c - n3, y.d - n3, y.a + 2.0 * n3, 2.0 * n3).a(n, n2)) {
            return 1;
        }
        if (new y(y.c - n3, y.d + y.b - n3, y.a + 2.0 * n3, y.b + 2.0 * n3).a(n, n2)) {
            return 3;
        }
        return 0;
    }
    
    private void l() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.k = 0;
        this.a = null;
        this.A = false;
    }
    
    private void a(final bu bu, final a a) {
        final int h = a.H;
        this.r = -1.7976931348623157E308;
        this.s = Double.MAX_VALUE;
        Label_0156: {
            switch (this.k) {
                case 1: {
                    if (this.b == null) {
                        break;
                    }
                    this.s = this.a(bu, a, this.b);
                    if (h != 0) {
                        break Label_0156;
                    }
                    break;
                }
                case 3: {
                    if (this.b != null) {
                        this.r = -this.b(bu, a, this.b);
                    }
                    if (!this.A || this.c == null) {
                        break;
                    }
                    this.s = this.a(bu, a, this.c);
                    if (h != 0) {
                        break Label_0156;
                    }
                    break;
                }
                case 2: {
                    if (this.d == null) {
                        break;
                    }
                    this.s = this.a(bu, a, this.d);
                    if (h != 0) {
                        break Label_0156;
                    }
                    break;
                }
                case 4: {
                    if (this.d != null) {
                        this.r = -this.b(bu, a, this.d);
                    }
                    if (this.A && this.e != null) {
                        this.s = this.a(bu, a, this.e);
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private double a(final bu bu, final a a, final f f) {
        final int h = a.H;
        double n = f.g() - this.B.a(f);
        final r i = f.i();
        double n2 = 0.0;
        if (bu != null && a != null) {
            double minY = f.h().getMinY();
            if (i != null) {
                minY += i.a;
            }
            final byte h2 = this.h();
            Label_0214: {
                if (3 == h2) {
                    boolean b = true;
                    g a2 = f;
                    while (true) {
                        while (a2 instanceof f) {
                            final f f2 = (f)a2;
                            a2 = f2.a();
                            final boolean b2 = b;
                            if (h == 0) {
                                b = (b2 & f2.b() == 0);
                                if (h != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (!b2) {
                                    return n2;
                                }
                                final Rectangle2D b3 = b(bu, a);
                                if (b3.getWidth() <= 0.0 || b3.getHeight() <= 0.0) {
                                    return n2;
                                }
                                if (b3.getY() < minY) {
                                    return 0.0;
                                }
                                if (n <= b3.getY() - minY) {
                                    return n2;
                                }
                                n = b3.getY() - minY;
                                if (h != 0) {
                                    break Label_0214;
                                }
                                return n2;
                            }
                        }
                        continue;
                    }
                }
            }
            final x a3 = f.d().a();
            while (a3.f()) {
                final fj t = bu.t(a3.e());
                n2 = 0.0;
                if (h != 0) {
                    break;
                }
                double n3 = n2;
                Label_0287: {
                    if (h2 != 0) {
                        n3 = t.getCenterY();
                        if (h == 0) {
                            break Label_0287;
                        }
                    }
                    if (2 == h2) {
                        n3 = t.getY();
                    }
                }
                if (n3 < minY) {
                    return 0.0;
                }
                if (n3 - minY < n) {
                    n = n3 - minY;
                }
                a3.g();
                if (h != 0) {
                    break;
                }
            }
        }
        return n2;
    }
    
    private double b(final bu bu, final a a, final f f) {
        final int h = a.H;
        double n = f.g() - this.B.a(f);
        final r i = f.i();
        double n2 = 0.0;
        if (bu != null && a != null) {
            double maxY = f.h().getMaxY();
            if (i != null) {
                maxY -= i.c;
            }
            final byte h2 = this.h();
            Label_0223: {
                if (3 == h2) {
                    boolean b = true;
                    g a2 = f;
                    while (true) {
                        while (a2 instanceof f) {
                            final f f2 = (f)a2;
                            a2 = f2.a();
                            final boolean b2 = b;
                            if (h == 0) {
                                b = (b2 & f2.b() == a2.n() - 1);
                                if (h != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (!b2) {
                                    return n2;
                                }
                                final Rectangle2D b3 = b(bu, a);
                                if (b3.getWidth() <= 0.0 || b3.getHeight() <= 0.0) {
                                    return n2;
                                }
                                if (b3.getMaxY() > maxY) {
                                    return 0.0;
                                }
                                if (n <= maxY - b3.getMaxY()) {
                                    return n2;
                                }
                                n = maxY - b3.getMaxY();
                                if (h != 0) {
                                    break Label_0223;
                                }
                                return n2;
                            }
                        }
                        continue;
                    }
                }
            }
            final x a3 = f.d().a();
            while (a3.f()) {
                final fj t = bu.t(a3.e());
                n2 = 0.0;
                if (h != 0) {
                    break;
                }
                double centerY = n2;
                Label_0302: {
                    if (h2 == 1) {
                        centerY = t.getCenterY();
                        if (h == 0) {
                            break Label_0302;
                        }
                    }
                    if (h2 == 2) {
                        centerY = t.getY() + t.getHeight();
                    }
                }
                if (centerY > maxY) {
                    return 0.0;
                }
                if (maxY - centerY < n) {
                    n = maxY - centerY;
                }
                a3.g();
                if (h != 0) {
                    break;
                }
            }
        }
        return n2;
    }
    
    private double a(final bu bu, final a a, final y.h.b.c c) {
        final int h = a.H;
        double n = c.g() - this.B.a(c);
        final r i = c.i();
        double n2 = 0.0;
        if (bu != null && a != null) {
            double minX = c.h().getMinX();
            if (i != null) {
                minX += i.b;
            }
            final byte h2 = this.h();
            Label_0214: {
                if (3 == h2) {
                    boolean b = true;
                    d a2 = c;
                    while (true) {
                        while (a2 instanceof y.h.b.c) {
                            final y.h.b.c c2 = (y.h.b.c)a2;
                            a2 = c2.a();
                            final boolean b2 = b;
                            if (h == 0) {
                                b = (b2 & c2.b() == 0);
                                if (h != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (!b2) {
                                    return n2;
                                }
                                final Rectangle2D b3 = b(bu, a);
                                if (b3.getWidth() <= 0.0 || b3.getHeight() <= 0.0) {
                                    return n2;
                                }
                                if (b3.getX() < minX) {
                                    return 0.0;
                                }
                                if (n <= b3.getX() - minX) {
                                    return n2;
                                }
                                n = b3.getX() - minX;
                                if (h != 0) {
                                    break Label_0214;
                                }
                                return n2;
                            }
                        }
                        continue;
                    }
                }
            }
            final x a3 = c.d().a();
            while (a3.f()) {
                final q e = a3.e();
                n2 = 0.0;
                if (h != 0) {
                    break;
                }
                double n3 = n2;
                Label_0291: {
                    if (h2 == 1) {
                        n3 = bu.t(e).getCenterX();
                        if (h == 0) {
                            break Label_0291;
                        }
                    }
                    if (h2 == 2) {
                        n3 = bu.t(e).getX();
                    }
                }
                if (n3 < minX) {
                    return 0.0;
                }
                if (n3 - minX < n) {
                    n = n3 - minX;
                }
                a3.g();
                if (h != 0) {
                    break;
                }
            }
        }
        return n2;
    }
    
    private double b(final bu bu, final a a, final y.h.b.c c) {
        final int h = a.H;
        double n = c.g() - this.B.a(c);
        final r i = c.i();
        double n2 = 0.0;
        if (bu != null && a != null) {
            double maxX = c.h().getMaxX();
            if (i != null) {
                maxX -= i.d;
            }
            final byte h2 = this.h();
            Label_0223: {
                if (3 == h2) {
                    boolean b = true;
                    d a2 = c;
                    while (true) {
                        while (a2 instanceof y.h.b.c) {
                            final y.h.b.c c2 = (y.h.b.c)a2;
                            a2 = c2.a();
                            final boolean b2 = b;
                            if (h == 0) {
                                b = (b2 & c2.b() == a2.k() - 1);
                                if (h != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (!b2) {
                                    return n2;
                                }
                                final Rectangle2D b3 = b(bu, a);
                                if (b3.getWidth() <= 0.0 || b3.getHeight() <= 0.0) {
                                    return n2;
                                }
                                if (b3.getMaxX() > maxX) {
                                    return 0.0;
                                }
                                if (n <= maxX - b3.getMaxX()) {
                                    return n2;
                                }
                                n = maxX - b3.getMaxX();
                                if (h != 0) {
                                    break Label_0223;
                                }
                                return n2;
                            }
                        }
                        continue;
                    }
                }
            }
            final x a3 = c.d().a();
            while (a3.f()) {
                final q e = a3.e();
                n2 = 0.0;
                if (h != 0) {
                    break;
                }
                double centerX = n2;
                Label_0310: {
                    if (h2 == 1) {
                        centerX = bu.t(e).getCenterX();
                        if (h == 0) {
                            break Label_0310;
                        }
                    }
                    if (h2 == 2) {
                        centerX = bu.t(e).getX() + bu.t(e).getWidth();
                    }
                }
                if (centerX > maxX) {
                    return 0.0;
                }
                if (maxX - centerX < n) {
                    n = maxX - centerX;
                }
                a3.g();
                if (h != 0) {
                    break;
                }
            }
        }
        return n2;
    }
    
    private static Rectangle2D b(final bu bu, final a a) {
        final int h = a.H;
        final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        final v c = bu.C();
        if (c != null) {
            final q node = a.getNode();
            if (node != null && node.e() == bu && c.k(node)) {
                final x p2 = c.p(node);
                while (p2.f()) {
                    bu.t(p2.e()).calcUnionRect(double1);
                    p2.g();
                    if (h != 0) {
                        break;
                    }
                }
            }
        }
        return double1;
    }
    
    protected void a(final double m, final double n, final boolean b) {
        final int h = y.h.b.a.H;
        if (!this.a(m, n)) {
            this.m();
            return;
        }
        if (this.i == null) {
            this.m();
            return;
        }
        this.m = m;
        this.n = n;
        this.f = 0.0;
        this.g = 0.0;
        this.A = ((b || 3 == this.h()) && (this.e != null || this.c != null));
        this.a(this.h.getGraph2D(), this.i);
        Label_0279: {
            if (this.b != null) {
                this.o = this.b.h();
                this.t.a(this.a(this.b, this.o));
                if (!this.A) {
                    break Label_0279;
                }
                this.p = this.c.h();
                this.u.a(this.a(this.c, this.p));
                if (h == 0) {
                    break Label_0279;
                }
            }
            if (this.d != null) {
                this.o = this.d.h();
                this.t.a(this.a(this.d, this.o));
                if (!this.A) {
                    break Label_0279;
                }
                this.p = this.e.h();
                this.u.a(this.a(this.e, this.p));
                if (h == 0) {
                    break Label_0279;
                }
            }
            throw new IllegalStateException("A resize action was started although no row or column was set to be resized.");
        }
        this.h.addDrawable(this.t);
        if (this.A) {
            this.h.addDrawable(this.u);
        }
        if (this.j()) {
            this.q = new Rectangle2D.Double(this.i.getX(), this.i.getY(), this.i.getWidth(), this.i.getHeight());
            this.v.a(this.a(this.i.l(), this.q));
            this.h.addDrawable(this.v);
            this.h.updateView(this.v.getBounds());
            if (h == 0) {
                return;
            }
        }
        this.h.updateView(this.t.getBounds());
        if (this.A) {
            this.h.updateView(this.u.getBounds());
        }
    }
    
    protected void b(final double n, final double n2) {
        final int h = y.h.b.a.H;
        this.f = Math.min(Math.max(n - this.m, this.r), this.s);
        this.g = Math.min(Math.max(n2 - this.n, this.r), this.s);
        Label_0546: {
            switch (this.k) {
                case 1: {
                    this.t.a(this.a(this.b, new Rectangle2D.Double(this.o.getX(), this.o.getY() + this.g, this.o.getWidth(), this.o.getHeight() - this.g)));
                    if (!this.j()) {
                        break;
                    }
                    this.v.a(this.a(this.a, new Rectangle2D.Double(this.q.getX(), this.q.getY() + this.g, this.q.getWidth(), this.q.getHeight() - this.g)));
                    if (h != 0) {
                        break Label_0546;
                    }
                    break;
                }
                case 3: {
                    this.t.a(this.a(this.b, new Rectangle2D.Double(this.o.getX(), this.o.getY(), this.o.getWidth(), this.o.getHeight() + this.g)));
                    if (this.A) {
                        this.u.a(this.a(this.c, new Rectangle2D.Double(this.p.getX(), this.p.getY() + this.g, this.p.getWidth(), this.p.getHeight() - this.g)));
                        if (h == 0) {
                            break;
                        }
                    }
                    if (!this.j()) {
                        break;
                    }
                    this.v.a(this.a(this.a, new Rectangle2D.Double(this.q.getX(), this.q.getY(), this.q.getWidth(), this.q.getHeight() + this.g)));
                    if (h != 0) {
                        break Label_0546;
                    }
                    break;
                }
                case 2: {
                    this.t.a(this.a(this.d, new Rectangle2D.Double(this.o.getX() + this.f, this.o.getY(), this.o.getWidth() - this.f, this.o.getHeight())));
                    if (!this.j()) {
                        break;
                    }
                    this.v.a(this.a(this.a, new Rectangle2D.Double(this.q.getX() + this.f, this.q.getY(), this.q.getWidth() - this.f, this.q.getHeight())));
                    if (h != 0) {
                        break Label_0546;
                    }
                    break;
                }
                case 4: {
                    this.t.a(this.a(this.d, new Rectangle2D.Double(this.o.getX(), this.o.getY(), this.o.getWidth() + this.f, this.o.getHeight())));
                    if (this.A) {
                        this.u.a(this.a(this.e, new Rectangle2D.Double(this.p.getX() + this.f, this.p.getY(), this.p.getWidth() - this.f, this.p.getHeight())));
                        if (h == 0) {
                            break;
                        }
                    }
                    if (this.j()) {
                        this.v.a(this.a(this.a, new Rectangle2D.Double(this.q.getX(), this.q.getY(), this.q.getWidth() + this.f, this.q.getHeight())));
                        break;
                    }
                    break;
                }
            }
        }
        this.h.getGraph2D().T();
    }
    
    protected void c(final double n, final double n2) {
        this.g();
        this.m();
    }
    
    protected void g() {
        final int h = y.h.b.a.H;
        if (this.i == null) {
            return;
        }
        final q node = this.i.getNode();
        final bu bu = (bu)node.e();
        if (bu == null || (this.b == null && this.d == null)) {
            return;
        }
        bu.r();
        try {
            bu.a(new y.c.y(node).a());
            final fj a = ae.a(bu, node);
            if (a == this.i) {
                if (this.b != null) {
                    this.a(bu, this.i, this.b, this.c);
                    if (h == 0) {
                        return;
                    }
                }
                if (this.d == null) {
                    return;
                }
                this.a(bu, this.i, this.d, this.e);
                if (h == 0) {
                    return;
                }
            }
            if (a instanceof a) {
                final a a2 = (a)a;
                if (this.b != null) {
                    final ArrayList list = new ArrayList();
                    this.a(bu, a2, aa.a(this.b, a2, list), (this.c == null) ? null : aa.a(this.c, a2, list));
                    if (h == 0) {
                        return;
                    }
                }
                if (this.d != null) {
                    final ArrayList list2 = new ArrayList();
                    this.a(bu, a2, aa.a(this.d, a2, list2), (this.e == null) ? null : aa.a(this.e, a2, list2));
                }
            }
        }
        finally {
            bu.s();
        }
    }
    
    private void a(final bu bu, final a a, final y.h.b.c c, final y.h.b.c c2) {
        final int h = a.H;
        if (3 == this.h()) {
            Label_0194: {
                switch (this.k) {
                    case 2: {
                        c.b(c.g() - this.f);
                        if (c.b() == 0) {
                            boolean b = true;
                            d d = c.a();
                            while (true) {
                                while (d instanceof y.h.b.c) {
                                    final y.h.b.c c3 = (y.h.b.c)d;
                                    c3.b(c3.g() - this.f);
                                    d = c3.a();
                                    final boolean b2 = b;
                                    if (h == 0) {
                                        b = (b2 & c3.b() == 0);
                                        if (h != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                    else {
                                        if (!b2) {
                                            break Label_0194;
                                        }
                                        a(a, a.getX() + this.f, a.getY(), a.getWidth() - this.f, a.getHeight());
                                        if (h != 0) {
                                            break Label_0194;
                                        }
                                        break Label_0194;
                                    }
                                }
                                continue;
                            }
                        }
                        break;
                    }
                    case 4: {
                        c.b(c.g() + this.f);
                        Label_0356: {
                            if (c.b() == c.a().k() - 1) {
                                boolean b3 = true;
                                d d2 = c.a();
                                while (true) {
                                    while (d2 instanceof y.h.b.c) {
                                        final y.h.b.c c4 = (y.h.b.c)d2;
                                        c4.b(c4.g() + this.f);
                                        d2 = c4.a();
                                        final boolean b4 = b3;
                                        if (h == 0) {
                                            b3 = (b4 & c4.b() == d2.k() - 1);
                                            if (h != 0) {
                                                break;
                                            }
                                            continue;
                                        }
                                        else {
                                            if (b4) {
                                                a(a, a.getX(), a.getY(), a.getWidth() + this.f, a.getHeight());
                                            }
                                            break Label_0356;
                                        }
                                    }
                                    continue;
                                }
                            }
                        }
                        if (!this.A) {
                            break;
                        }
                        c2.b(c2.g() - this.f);
                        if (c2.b() == 0) {
                            d d3 = c2.a();
                            while (d3 instanceof y.h.b.c) {
                                final y.h.b.c c5 = (y.h.b.c)d3;
                                c5.b(c5.g() - this.f);
                                d3 = c5.a();
                                if (h != 0) {
                                    return;
                                }
                                if (h != 0) {
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                }
            }
            if (h == 0) {
                return;
            }
        }
        Label_0605: {
            switch (this.k) {
                case 2: {
                    this.B.a(c, c.g() - this.f, true);
                    final y.c.y y = new y.c.y();
                    this.B.a(a.getNode(), a.getBoundingBox(), y);
                    final z z = new z();
                    this.B.a(bu, a.getBoundingBox(), z);
                    a.setFrame(a.getX() + this.f, a.getY(), a.getWidth(), a.getHeight());
                    this.B.a(bu, y, z, this.f, 0.0);
                    if (h != 0) {
                        break Label_0605;
                    }
                    break;
                }
                case 4: {
                    this.B.a(c, c.g() + this.f, false);
                    if (this.A) {
                        this.B.a(c2, c2.g() - this.f, true);
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void a(final bu bu, final a a, final f f, final f f2) {
        final int h = a.H;
        if (3 == this.h()) {
            Label_0194: {
                switch (this.k) {
                    case 1: {
                        f.b(f.g() - this.g);
                        if (f.b() == 0) {
                            boolean b = true;
                            g g = f.a();
                            while (true) {
                                while (g instanceof f) {
                                    final f f3 = (f)g;
                                    f3.b(f3.g() - this.g);
                                    g = f3.a();
                                    final boolean b2 = b;
                                    if (h == 0) {
                                        b = (b2 & f3.b() == 0);
                                        if (h != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                    else {
                                        if (!b2) {
                                            break Label_0194;
                                        }
                                        a(a, a.getX(), a.getY() + this.g, a.getWidth(), a.getHeight() - this.g);
                                        if (h != 0) {
                                            break Label_0194;
                                        }
                                        break Label_0194;
                                    }
                                }
                                continue;
                            }
                        }
                        break;
                    }
                    case 3: {
                        f.b(f.g() + this.g);
                        Label_0356: {
                            if (f.b() == f.a().n() - 1) {
                                boolean b3 = true;
                                g g2 = f.a();
                                while (true) {
                                    while (g2 instanceof f) {
                                        final f f4 = (f)g2;
                                        f4.b(f4.g() + this.g);
                                        g2 = f4.a();
                                        final boolean b4 = b3;
                                        if (h == 0) {
                                            b3 = (b4 & f4.b() == g2.n() - 1);
                                            if (h != 0) {
                                                break;
                                            }
                                            continue;
                                        }
                                        else {
                                            if (b4) {
                                                a(a, a.getX(), a.getY(), a.getWidth(), a.getHeight() + this.g);
                                            }
                                            break Label_0356;
                                        }
                                    }
                                    continue;
                                }
                            }
                        }
                        if (!this.A) {
                            break;
                        }
                        f2.b(f2.g() - this.g);
                        if (f2.b() == 0) {
                            g g3 = f2.a();
                            while (g3 instanceof f) {
                                final f f5 = (f)g3;
                                f5.b(f5.g() - this.g);
                                g3 = f5.a();
                                if (h != 0) {
                                    return;
                                }
                                if (h != 0) {
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                }
            }
            if (h == 0) {
                return;
            }
        }
        Label_0605: {
            switch (this.k) {
                case 1: {
                    this.B.a(f, f.g() - this.g, true);
                    final y.c.y y = new y.c.y();
                    this.B.a(a.getNode(), a.getBoundingBox(), y);
                    final z z = new z();
                    this.B.a(bu, a.getBoundingBox(), z);
                    a.setFrame(a.getX(), a.getY() + this.g, a.getWidth(), a.getHeight());
                    this.B.a(bu, y, z, 0.0, this.g);
                    if (h != 0) {
                        break Label_0605;
                    }
                    break;
                }
                case 3: {
                    this.B.a(f, f.g() + this.g, false);
                    if (this.A) {
                        this.B.a(f2, f2.g() - this.g, true);
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private static void a(final a a, final double n, final double n2, final double n3, final double n4) {
        final y.h.a.a autoBoundsFeature = a.getAutoBoundsFeature();
        final boolean autoBoundsEnabled = autoBoundsFeature != null && autoBoundsFeature.isAutoBoundsEnabled();
        if (autoBoundsEnabled) {
            autoBoundsFeature.setAutoBoundsEnabled(false);
        }
        try {
            final boolean k = a.k();
            if (k) {
                a.c(false);
            }
            try {
                a.setFrame(n, n2, n3, n4);
            }
            finally {
                if (k) {
                    a.c(k);
                }
            }
        }
        finally {
            if (autoBoundsEnabled) {
                autoBoundsFeature.setAutoBoundsEnabled(autoBoundsEnabled);
            }
        }
    }
    
    private void m() {
        this.l();
        if (this.t.a() != null) {
            this.t.a((az)null);
            this.h.removeDrawable(this.t);
        }
        if (this.u.a() != null) {
            this.u.a((az)null);
            this.h.removeDrawable(this.u);
        }
        if (this.v.a() != null) {
            this.v.a((az)null);
            this.h.removeDrawable(this.v);
        }
        this.h.getGraph2D().T();
        this.e();
    }
    
    protected az a(final i i, final Rectangle2D rectangle2D) {
        if (this.y == null) {
            this.y = new ac();
        }
        Label_0085: {
            if (i != null) {
                final r d = i.d();
                if (d.a > d.b) {
                    this.y.a(false);
                    this.y.a(d.a);
                    if (y.h.b.a.H == 0) {
                        break Label_0085;
                    }
                }
                this.y.a(true);
                this.y.a(d.b);
            }
        }
        this.y.a(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        return this.y;
    }
    
    protected az a(final f f, final Rectangle2D rectangle2D) {
        final int h = y.h.b.a.H;
        ac ac = null;
        Label_0087: {
            if (f != null && f == this.b) {
                if (this.w == null) {
                    this.w = new ac();
                }
                ac = this.w;
                if (h == 0) {
                    break Label_0087;
                }
            }
            if (f != null && f == this.c) {
                if (this.x == null) {
                    this.x = new ac();
                }
                ac = this.x;
                if (h == 0) {
                    break Label_0087;
                }
            }
            return null;
        }
        if (f.i() != null) {
            ac.a(true);
            ac.a(f.i().b);
        }
        ac.a(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        return ac;
    }
    
    protected az a(final y.h.b.c c, final Rectangle2D rectangle2D) {
        final int h = y.h.b.a.H;
        ac ac = null;
        Label_0087: {
            if (c != null && c == this.d) {
                if (this.w == null) {
                    this.w = new ac();
                }
                ac = this.w;
                if (h == 0) {
                    break Label_0087;
                }
            }
            if (c != null && c == this.e) {
                if (this.x == null) {
                    this.x = new ac();
                }
                ac = this.x;
                if (h == 0) {
                    break Label_0087;
                }
            }
            return null;
        }
        if (c.i() != null) {
            ac.a(false);
            ac.a(c.i().a);
        }
        ac.a(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        return ac;
    }
    
    public byte h() {
        return this.j;
    }
    
    public boolean j() {
        return this.z;
    }
    
    public double k() {
        return this.l;
    }
    
    public void e() {
        this.h.setViewCursor(Cursor.getPredefinedCursor(13));
        super.e();
    }
    
    public boolean a(final dw dw) {
        return this.f(dw) && this.a(dw.a(), dw.b());
    }
    
    public void b(final dw dw) {
        final int h = y.h.b.a.H;
        Label_0089: {
            switch (dw.c()) {
                case 501: {
                    if (!this.e(dw)) {
                        return;
                    }
                    this.a(dw.a(), dw.b(), this.d(dw));
                    if (h != 0) {
                        break Label_0089;
                    }
                    return;
                }
                case 506: {
                    this.b(dw.a(), dw.b());
                    if (h != 0) {
                        break Label_0089;
                    }
                    return;
                }
                case 502: {
                    if (!this.e(dw)) {
                        return;
                    }
                    this.c(dw.a(), dw.b());
                    if (h != 0) {
                        break;
                    }
                    return;
                }
            }
        }
        this.m();
    }
    
    public Cursor c(final dw dw) {
        if (!this.a(dw.a(), dw.b())) {
            return null;
        }
        switch (this.k) {
            case 2:
            case 4: {
                return Cursor.getPredefinedCursor(10);
            }
            case 1:
            case 3: {
                return Cursor.getPredefinedCursor(8);
            }
            default: {
                return null;
            }
        }
    }
    
    void i() {
        super.i();
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }
}
