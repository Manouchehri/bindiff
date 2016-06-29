package y.f.c.a;

import y.c.*;

class M
{
    final d a;
    final q b;
    final q c;
    private final E d;
    
    M(final E d, final d a, final q b, final q c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private void a() {
        if (this.a.c() != this.c && this.a.d() != this.c) {
            throw new RuntimeException("Edge should contain endpoint " + this.c);
        }
        if (!this.d.b.f(this.b)) {
            this.d.b.d(this.b);
        }
        this.d.b.a(this.b, this.d.b.r(this.c));
        this.d.b.a(this.b, this.d.b.l(this.c));
        if (this.a.c() == this.c) {
            this.d.b.a(this.a, this.b, this.a.d());
            if (!N.x) {
                return;
            }
        }
        this.d.b.a(this.a, this.a.c(), this.b);
    }
    
    static void a(final M m) {
        m.a();
    }
}
