package y.f.c.a;

import y.c.*;

class aC extends aM implements as
{
    byte a;
    private D b;
    
    aC(final bK bk, final q q, final aQ aq, final byte a) {
        super(null, bk);
        this.a = a;
        this.a(q);
        this.a(aq);
    }
    
    public byte b() {
        return this.a;
    }
    
    public q f() {
        return this.l();
    }
    
    public p d() {
        return (this.b != null) ? this.b.k() : null;
    }
    
    public p a(final d d) {
        if (this.b == null) {
            this.b = new D();
        }
        return this.b.b(d);
    }
    
    public void a(final p p) {
        this.b.h(p);
        if (this.b.isEmpty()) {
            this.b = null;
        }
    }
    
    public int e() {
        return (this.b != null) ? this.b.size() : 0;
    }
}
