package y.f.c.a;

import y.c.*;

final class ad implements aQ
{
    bt a;
    int b;
    y c;
    byte d;
    f e;
    private final ac f;
    
    public void a() {
        if (this.b < 0) {
            throw new IllegalStateException();
        }
        this.f.b(this.c());
    }
    
    public ad(final ac f, final byte d, final int b) {
        this.f = f;
        this.a = null;
        this.c = new y();
        this.e = new f();
        this.b = b;
        this.d = d;
    }
    
    public bt b() {
        return this.a;
    }
    
    public void a(final bt a) {
        this.a = a;
    }
    
    public void a(final q q) {
        final as as = (as)this.f.b.a(q);
        as.a(this);
        as.b(this.c.size());
        this.c.add(q);
    }
    
    public int c() {
        if (this.f.c) {
            this.f.c();
        }
        return this.b;
    }
    
    public y d() {
        return this.c;
    }
    
    public byte e() {
        return this.d;
    }
    
    public void a(final D d) {
        final boolean x = N.x;
        if (d.size() != this.c.size()) {
            throw new IllegalArgumentException();
        }
        p p = d.k();
        p p2 = this.c.k();
        int n = 0;
        while (p != null) {
            final q q = (q)p.c();
            p2.a(q);
            ((as)this.f.b.a(q)).b(n);
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
        p p = this.c.k();
        while (p != null) {
            final q q2 = (q)p.c();
            Label_0078: {
                if (q2 == q) {
                    this.c.h(p);
                    if (!x) {
                        break Label_0078;
                    }
                }
                ((as)this.f.b.a(q2)).b(n);
                ++n;
            }
            p = p.a();
            if (x) {
                break;
            }
        }
    }
    
    public D f() {
        return this.e;
    }
    
    public void a(final d d) {
        this.e.add(d);
    }
}
