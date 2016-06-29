package y.f.c.a;

import y.c.*;

class ar extends aM
{
    D a;
    private final q b;
    private final d c;
    
    public p d() {
        return (this.a != null) ? this.a.k() : null;
    }
    
    public p a(final d d) {
        if (this.a == null) {
            this.a = new D();
        }
        return this.a.b(d);
    }
    
    public void a(final p p) {
        this.a.h(p);
        if (this.a.isEmpty()) {
            this.a = null;
        }
    }
    
    public int e() {
        return (this.a != null) ? this.a.size() : 0;
    }
    
    ar(final bK bk, final q b, final aQ aq, final d c) {
        super(null, bk);
        this.b = b;
        this.c = c;
        this.a(b);
        this.a(aq);
    }
    
    public d g() {
        return this.c;
    }
    
    public q f() {
        return this.b;
    }
    
    public byte b() {
        return 15;
    }
}
