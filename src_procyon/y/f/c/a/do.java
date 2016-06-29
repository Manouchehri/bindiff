package y.f.c.a;

import y.c.*;

final class do implements aQ
{
    int a;
    y b;
    byte c;
    f d;
    private final dn e;
    
    public void a() {
        if (this.a < 0) {
            throw new IllegalStateException();
        }
        this.e.b(this.c());
    }
    
    public do(final dn e, final byte c, final int a) {
        this.e = e;
        this.b = new y();
        this.d = new f();
        this.a = a;
        this.c = c;
    }
    
    public void a(final q q) {
        final dk dk = (dk)this.e.b.a(q);
        dk.a(this);
        dk.b(this.b.size());
        this.b.add(q);
    }
    
    public int c() {
        if (this.e.c) {
            this.e.c();
        }
        return this.a;
    }
    
    public bt b() {
        return null;
    }
    
    public void a(final bt bt) {
    }
    
    public y d() {
        return this.b;
    }
    
    public byte e() {
        return this.c;
    }
    
    public void a(final D d) {
        final boolean x = N.x;
        if (d.size() != this.b.size()) {
            throw new IllegalArgumentException();
        }
        p p = d.k();
        p p2 = this.b.k();
        int n = 0;
        while (p != null) {
            final q q = (q)p.c();
            p2.a(q);
            ((dk)this.e.b.a(q)).b(n);
            ++n;
            p = p.a();
            p2 = p2.a();
            if (x) {
                break;
            }
        }
    }
    
    public void b(final q q) {
        final boolean x = N.x;
        int n = 0;
        p p = this.b.k();
        while (p != null) {
            final q q2 = (q)p.c();
            Label_0078: {
                if (q2 == q) {
                    this.b.h(p);
                    if (!x) {
                        break Label_0078;
                    }
                }
                ((dk)this.e.b.a(q2)).b(n);
                ++n;
            }
            p = p.a();
            if (x) {
                break;
            }
        }
    }
    
    public D f() {
        return this.d;
    }
    
    public void a(final d d) {
        this.d.add(d);
    }
}
