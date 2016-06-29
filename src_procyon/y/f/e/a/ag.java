package y.f.e.a;

import y.c.*;
import y.f.*;

public class ag implements m
{
    private a a;
    private double b;
    private double c;
    private double d;
    private a e;
    private q f;
    private double g;
    private double h;
    private m i;
    private short j;
    private double k;
    private final af l;
    
    ag(final af l, final q f) {
        this.l = l;
        this.a = new Z();
        this.d = 0.9;
        this.e = new Z();
        this.j = 0;
        this.f = f;
        this.o();
    }
    
    public boolean m() {
        return this.i != null;
    }
    
    public boolean n() {
        return this.j == 3;
    }
    
    public void a(final boolean b) {
        if (b) {
            this.j |= 0x2;
            if (!af.b) {
                return;
            }
        }
        this.j &= 0xFFFFFFFD;
    }
    
    public void a(final m i) {
        this.i = i;
    }
    
    public boolean k() {
        return this.j != 0;
    }
    
    public m l() {
        return this.i;
    }
    
    public void b(final boolean b) {
        if (b) {
            this.j |= 0x1;
            if (!af.b) {
                return;
            }
        }
        this.j &= 0xFFFFFFFE;
    }
    
    public void o() {
        final am h = af.a(this.l).h(this.f);
        this.a(h.getWidth(), h.getHeight());
        this.a(h.getX() + h.getWidth() / 2.0, h.getY() + h.getHeight() / 2.0, 0.0);
    }
    
    public void a(final double b, final double c) {
        this.b = b;
        this.c = c;
        this.q();
    }
    
    private void q() {
        this.h = (this.b + this.c) / 4.0;
    }
    
    private void b(final double n, final double n2) {
        af.b(this.l).a(af.b(this.l).d() - n + n2);
        af.c(this.l).a(af.c(this.l).d() + (n2 * n2 - n * n));
    }
    
    private void c(final double n, final double n2) {
        af.b(this.l).b(af.b(this.l).e() - n + n2);
        af.c(this.l).b(af.c(this.l).e() + (n2 * n2 - n * n));
    }
    
    private void d(final double n, final double n2) {
        af.b(this.l).c(af.b(this.l).f() - n + n2);
        af.c(this.l).c(af.c(this.l).f() + (n2 * n2 - n * n));
    }
    
    public void a(final double n, final double n2, final double n3) {
        final double d = this.a.d();
        final double e = this.a.e();
        final double f = this.a.f();
        this.b(this.a.d(), n);
        this.a.a(n);
        this.c(this.a.e(), n2);
        this.a.b(n2);
        this.d(this.a.f(), n3);
        this.a.c(n3);
        this.l.a(this, d, e, f, n, n2, n3);
    }
    
    public void a(final double n) {
        final double d = this.a.d();
        this.b(this.a.d(), n);
        this.a.a(n);
        this.l.a(this, d, this.a.e(), this.a.f(), n, this.a.e(), this.a.f());
    }
    
    public void b(final double n) {
        final double e = this.a.e();
        this.c(this.a.e(), n);
        this.a.b(n);
        this.l.a(this, this.a.d(), e, this.a.f(), this.a.d(), n, this.a.f());
    }
    
    public k a() {
        return this.a;
    }
    
    public double b() {
        return this.a.d();
    }
    
    public double c() {
        return this.a.e();
    }
    
    public double d() {
        return this.a.f();
    }
    
    public double e() {
        return this.d;
    }
    
    public void c(final double d) {
        this.e(this.d, d);
        this.d = d;
    }
    
    private void e(final double n, final double n2) {
        af.a(this.l, n2 - n);
        af.b(this.l, n2 * n2 - n * n);
        af.d(this.l);
    }
    
    public void p() {
        this.e.a();
    }
    
    public k f() {
        return this.e;
    }
    
    public void a(final k k) {
        this.e.a(k);
    }
    
    public void b(final k k) {
        this.a(k.d() + this.a.d(), k.e() + this.a.e(), k.f() + this.a.f());
    }
    
    public q j() {
        return this.f;
    }
    
    public void d(final double g) {
        this.g = g;
    }
    
    public double g() {
        return this.g;
    }
    
    public double h() {
        return this.h;
    }
    
    public void e(final double k) {
        this.k = k;
    }
    
    public double i() {
        return this.k;
    }
    
    public void f(final double h) {
        this.h = h;
    }
}
