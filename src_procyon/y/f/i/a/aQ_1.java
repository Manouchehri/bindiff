package y.f.i.a;

import y.d.*;
import y.c.*;

class aQ extends aT
{
    private final y g;
    private final double h;
    private final t i;
    private final aN j;
    
    aQ(final aN j, final m m, final m i, final d d) {
        super(d, m.b() ? m : i, m.a() ? m : i);
        this.j = j;
        this.i = new t(this.b.c().a, this.a.c().b);
        this.h = (m.b() ? Math.abs(this.i.a - m.d().a) : Math.abs(this.i.b - m.d().b));
        this.g = this.g();
    }
    
    private y g() {
        final double n = this.h + 2.0;
        if (this.c == 3) {
            return new y(this.i.a - this.h - 1.0, this.i.b - 1.0, n, n);
        }
        if (this.c == 2) {
            return new y(this.i.a - 1.0, this.i.b - 1.0, n, n);
        }
        if (this.c == 0) {
            return new y(this.i.a - 1.0, this.i.b - this.h - 1.0, n, n);
        }
        return new y(this.i.a - this.h - 1.0, this.i.b - this.h - 1.0, n, n);
    }
    
    public boolean a() {
        return true;
    }
    
    public double b() {
        return this.i.a();
    }
    
    public double c() {
        return this.i.b();
    }
    
    public y h() {
        return this.g;
    }
    
    public void a(final double n) {
        throw new IllegalStateException("Segment offset is fixed!");
    }
    
    public double d() {
        if (this.c == 3 || this.c == 1) {
            return this.b() - this.h;
        }
        return this.b() + this.h;
    }
    
    public double e() {
        if (this.c == 0 || this.c == 1) {
            return this.c() - this.h;
        }
        return this.c() + this.h;
    }
}
