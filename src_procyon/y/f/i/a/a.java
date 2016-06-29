package y.f.i.a;

import y.f.*;
import y.c.*;
import y.d.*;

public abstract class a
{
    private double a;
    private boolean b;
    private final y c;
    private final c d;
    private M e;
    private M f;
    private final M g;
    private ah h;
    private byte i;
    
    protected a(final d d, final int n, final y c, final M e, final M f, final M g) {
        this.i = 0;
        this.c = c;
        this.d = new c(d, n, null);
        this.b = false;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    protected a(final d d, final int n, final m m) {
        this.i = 0;
        this.c = c(m);
        this.d = new c(d, n, null);
        this.a = a(m);
        this.e = new M(this.a, this.a);
        final M b = b(m);
        this.g = b;
        this.f = b;
        this.b = true;
    }
    
    public String toString() {
        return "SegmentInfo{" + ((this.i() != null) ? ("edge=" + this.i().c().d() + "->" + this.i().d().d()) : "grouped Segment") + ", segmentIndex=" + this.j() + ", direction=" + this.c + ", location range=" + this.e + ", min extension=" + this.f + ", max extension=" + this.g + '}';
    }
    
    static double a(final m m) {
        final t c = m.c();
        if (Math.abs(c.a - m.d().a) < 1.0E-6) {
            return c.a;
        }
        return c.b;
    }
    
    static M b(final m m) {
        final t c = m.c();
        final t d = m.d();
        if (Math.abs(c.a - d.a) < 1.0E-6) {
            return new M(c.b, d.b);
        }
        return new M(c.a, d.a);
    }
    
    static y c(final m m) {
        final t c = m.c();
        final t d = m.d();
        if (c.a > d.a + 1.0E-6) {
            return y.d;
        }
        if (c.a + 1.0E-6 < d.a) {
            return y.b;
        }
        if (c.b > d.b + 1.0E-6) {
            return y.a;
        }
        if (c.b + 1.0E-6 < d.b) {
            return y.c;
        }
        throw new RuntimeException("could not determine direction for segment " + m);
    }
    
    public M a() {
        return this.f;
    }
    
    void a(final M f) {
        this.f = f;
    }
    
    public M b() {
        return this.g;
    }
    
    public M c() {
        return this.e;
    }
    
    void b(final M e) {
        this.e = e;
    }
    
    public byte d() {
        return this.i;
    }
    
    public void a(final byte i) {
        switch (i) {
            case -1:
            case 0:
            case 1: {
                this.i = i;
                if (ab.a != 0) {
                    break;
                }
                return;
            }
        }
        throw new IllegalArgumentException("unknown alignment " + i);
    }
    
    public void a(final double a) {
        if (this.f()) {
            throw new IllegalStateException("try to change location for a fixed segment");
        }
        if (this.e.a() - 1.0E-6 > a || this.e.b() + 1.0E-6 < a) {
            throw new IllegalArgumentException("location " + a + " does not lie in location range " + this.e + "!");
        }
        this.a = a;
        this.b = true;
    }
    
    public double e() {
        return this.a;
    }
    
    public boolean f() {
        return this.b;
    }
    
    public boolean g() {
        return this.c.e();
    }
    
    public y h() {
        return this.c;
    }
    
    public d i() {
        return y.f.i.a.c.a(this.d);
    }
    
    public int j() {
        return y.f.i.a.c.b(this.d);
    }
    
    void a(final int n) {
        y.f.i.a.c.a(this.d, n);
    }
    
    public void a(final ah h) {
        this.h = h;
        this.e = h.a();
    }
    
    public ah k() {
        return this.h;
    }
}
