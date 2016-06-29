package y.h;

import java.awt.geom.*;
import java.awt.*;

public class eH implements Shape
{
    private int a;
    private eM b;
    private eM c;
    private int d;
    private int e;
    private int f;
    private long g;
    private eM h;
    private eM i;
    private eM j;
    private AffineTransform k;
    private int l;
    
    public eI a() {
        return this.b;
    }
    
    public void a(final PathIterator pathIterator) {
        final boolean z = fj.z;
        final double[] array = new double[6];
        while (!pathIterator.isDone()) {
            Label_0128: {
                switch (pathIterator.currentSegment(array)) {
                    case 4: {
                        this.b();
                        if (z) {
                            break Label_0128;
                        }
                        break;
                    }
                    case 1: {
                        this.b(array[0], array[1]);
                        if (z) {
                            break Label_0128;
                        }
                        break;
                    }
                    case 0: {
                        this.a(array[0], array[1]);
                        if (z) {
                            break Label_0128;
                        }
                        break;
                    }
                    case 2: {
                        this.a(array[0], array[1], array[2], array[3]);
                        if (z) {
                            break Label_0128;
                        }
                        break;
                    }
                    case 3: {
                        this.a(array[0], array[1], array[2], array[3], array[4], array[5]);
                        break;
                    }
                }
            }
            pathIterator.next();
            if (z) {
                break;
            }
        }
    }
    
    public eI a(final double a, final double b, final double c, final double d, final eI ei) {
        final eK e = this.e();
        e.a = a;
        e.b = b;
        e.c = c;
        e.d = d;
        this.a(e, (eM)ei);
        return e;
    }
    
    public eI a(final double b, final double c, final eI ei) {
        ++this.e;
        final eN d = this.d();
        d.a = 0;
        d.b = b;
        d.c = c;
        this.a(d, (eM)ei);
        return d;
    }
    
    public eI b(final double b, final double c, final eI ei) {
        final eN d = this.d();
        d.a = 1;
        d.b = b;
        d.c = c;
        this.a(d, (eM)ei);
        return d;
    }
    
    public eI a(final double b, final double c) {
        ++this.e;
        final eN d = this.d();
        d.a = 0;
        d.b = b;
        d.c = c;
        this.a(d);
        return d;
    }
    
    public eI b(final double b, final double c) {
        final eN d = this.d();
        d.a = 1;
        d.b = b;
        d.c = c;
        this.a(d);
        return d;
    }
    
    public eI b() {
        ++this.f;
        final eO eo = new eO();
        this.a(eo);
        return eo;
    }
    
    public eI a(final double a, final double b, final double c, final double d, final double e, final double f) {
        final eL f2 = this.f();
        f2.a = a;
        f2.b = b;
        f2.c = c;
        f2.d = d;
        f2.e = e;
        f2.f = f;
        this.a(f2);
        ++this.d;
        return f2;
    }
    
    public eI a(final double a, final double b, final double c, final double d) {
        final eK e = this.e();
        e.a = a;
        e.b = b;
        e.c = c;
        e.d = d;
        this.a(e);
        ++this.d;
        return e;
    }
    
    private eN d() {
        final boolean z = fj.z;
        if (this.h != null) {
            while (this.h != null && !(this.h instanceof eN)) {
                final eM h = this.h;
                this.h = this.h.g;
                h.g = null;
                h.h = null;
                if (h instanceof eK) {
                    h.g = this.i;
                    this.i = h;
                    if (!z) {
                        continue;
                    }
                }
                if (h instanceof eL) {
                    h.g = this.j;
                    this.j = h;
                    if (z) {
                        return new eN();
                    }
                    if (z) {
                        break;
                    }
                    continue;
                }
            }
            if (this.h != null) {
                final eN en = (eN)this.h;
                this.h = en.g;
                en.g = null;
                en.h = null;
                return en;
            }
        }
        return new eN();
    }
    
    private eK e() {
        if (this.i != null) {
            final eK ek = (eK)this.i;
            this.i = ek.g;
            ek.g = null;
            ek.h = null;
            if (!fj.z) {
                return ek;
            }
        }
        return new eK();
    }
    
    private eL f() {
        if (this.j != null) {
            final eL el = (eL)this.j;
            this.j = el.g;
            el.g = null;
            el.h = null;
            if (!fj.z) {
                return el;
            }
        }
        return new eL();
    }
    
    public void c() {
        if (this.c == null) {
            return;
        }
        if (this.a > this.d + this.f) {
            this.c.g = this.h;
            this.h = this.b;
        }
        ++this.g;
        final eM em = null;
        this.c = em;
        this.b = em;
        this.a = 0;
        this.d = 0;
        this.f = 0;
        this.e = 0;
    }
    
    private void a(final eM b, final eM g) {
        final boolean z = fj.z;
        Label_0068: {
            if (g == null) {
                this.a(b);
                if (!z) {
                    break Label_0068;
                }
            }
            ++this.g;
            final eM h = g.h;
            g.h = b;
            b.g = g;
            if ((b.h = h) != null) {
                h.g = b;
                if (!z) {
                    break Label_0068;
                }
            }
            this.b = b;
        }
        ++this.a;
    }
    
    private void a(final eM c) {
        ++this.g;
        c.g = null;
        Label_0064: {
            if (this.c == null) {
                this.b = c;
                this.a = 1;
                if (!fj.z) {
                    break Label_0064;
                }
            }
            ++this.a;
            this.c.g = c;
            c.h = this.c;
        }
        this.c = c;
    }
    
    public PathIterator getPathIterator(final AffineTransform affineTransform) {
        if (affineTransform == null) {
            if (this.k != null) {
                return new eJ(this.b, affineTransform, this.l);
            }
            return new eP(this.b, this.l);
        }
        else {
            if (this.k != null) {
                final AffineTransform affineTransform2 = (AffineTransform)this.k.clone();
                affineTransform2.preConcatenate(affineTransform);
                return new eJ(this.b, affineTransform2, this.l);
            }
            return new eJ(this.b, affineTransform, this.l);
        }
    }
    
    public PathIterator getPathIterator(final AffineTransform affineTransform, final double n) {
        if (this.d > 0) {
            return new FlatteningPathIterator(this.getPathIterator(affineTransform), n);
        }
        return this.getPathIterator(affineTransform);
    }
    
    public boolean contains(final Rectangle2D rectangle2D) {
        return this.contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
    
    public boolean contains(final Point2D point2D) {
        return this.contains(point2D.getX(), point2D.getY());
    }
    
    public boolean contains(final double n, final double n2) {
        return this.f != 0 && new Area(this).contains(n, n2);
    }
    
    public boolean contains(final double n, final double n2, final double n3, final double n4) {
        return new Area(this).contains(n, n2, n3, n4);
    }
    
    public Rectangle getBounds() {
        return this.getBounds2D().getBounds();
    }
    
    public Rectangle2D getBounds2D() {
        return new Area(this).getBounds2D();
    }
    
    public boolean intersects(final Rectangle2D rectangle2D) {
        return this.intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
    
    public boolean intersects(final double n, final double n2, final double n3, final double n4) {
        return new Area(this).intersects(n, n2, n3, n4);
    }
}
