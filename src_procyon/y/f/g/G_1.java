package y.f.g;

import y.f.c.a.*;
import y.c.*;

final class G implements aQ
{
    int a;
    y b;
    byte c;
    f d;
    private final F e;
    
    public void a() {
        if (this.a < 0) {
            throw new IllegalStateException();
        }
        this.e.b(this.c());
    }
    
    public G(final F e, final byte c, final int a) {
        this.e = e;
        this.b = new y();
        this.d = new f();
        this.a = a;
        this.c = c;
    }
    
    public void a(final q q) {
        final C c = (C)this.e.b.a(q);
        c.a(this);
        c.b(this.b.size());
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
        final boolean d2 = d.d;
        if (d.size() != this.b.size()) {
            throw new IllegalArgumentException();
        }
        p p = d.k();
        p p2 = this.b.k();
        int n = 0;
        while (p != null) {
            final q q = (q)p.c();
            p2.a(q);
            ((C)this.e.b.a(q)).b(n);
            ++n;
            p = p.a();
            p2 = p2.a();
            if (d2) {
                break;
            }
        }
    }
    
    public void b(final q q) {
        final boolean d = y.f.g.d.d;
        int n = 0;
        p p = this.b.k();
        while (p != null) {
            final q q2 = (q)p.c();
            Label_0078: {
                if (q2 == q) {
                    this.b.h(p);
                    if (!d) {
                        break Label_0078;
                    }
                }
                ((C)this.e.b.a(q2)).b(n);
                ++n;
            }
            p = p.a();
            if (d) {
                break;
            }
        }
    }
    
    public D f() {
        return this.d;
    }
    
    public void a(final y.c.d d) {
        this.d.add(d);
    }
}
