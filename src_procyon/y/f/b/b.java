package y.f.b;

import y.g.*;
import y.f.*;
import java.util.*;
import y.c.*;

public class b extends a
{
    private I a;
    private c b;
    private c c;
    private c d;
    private j e;
    
    public b() {
        (this.e = new j()).a(true);
    }
    
    public b(final ah ah) {
        this();
        this.a(ah);
    }
    
    public boolean b() {
        return this.e.b();
    }
    
    public void a(final boolean b) {
        this.e.a(b);
    }
    
    public void b(final X x) {
        this.a((i)x);
        this.b((i)x);
    }
    
    public void d(final X x) {
        this.c((i)x);
        this.c();
    }
    
    void a(final i i) {
        final int a = y.f.b.c.a;
        final c c = i.c(f.d);
        if (c != null) {
            final boolean b = this.b();
            final HashSet set = new HashSet<Object>();
            c c2 = null;
            Label_0118: {
                if (!b) {
                    c2 = i.c(f.c);
                    final x o = i.o();
                    while (o.f()) {
                        set.add(c2.b(o.e()));
                        o.g();
                        if (a != 0) {
                            break Label_0118;
                        }
                        if (a != 0) {
                            break;
                        }
                    }
                }
                this.a = new I(i);
                c2 = i.c(f.b);
            }
            final x o2 = i.o();
            while (o2.f()) {
                final q e = o2.e();
                if (c.d(e) && (b || set.contains(c2.b(e)))) {
                    this.a.a(e);
                }
                o2.g();
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    void c() {
        if (this.a != null) {
            this.a.f();
            this.e.c((X)this.a.i());
            this.a = null;
        }
    }
    
    public void a(final y.f.b.a a) {
        this.e.a(a);
    }
    
    void b(final i i) {
        this.b = i.c(f.d);
        this.c = i.c(f.b);
        this.d = i.c(f.c);
        if (this.b != null) {
            i.d_(f.d);
        }
        if (this.c != null) {
            i.d_(f.b);
        }
        if (this.d != null) {
            i.d_(f.c);
        }
    }
    
    void c(final i i) {
        if (this.b != null) {
            i.a(f.d, this.b);
        }
        if (this.c != null) {
            i.a(f.b, this.c);
        }
        if (this.d != null) {
            i.a(f.c, this.d);
        }
        this.b = null;
        this.c = null;
        this.d = null;
    }
    
    public void c(final X x) {
        if (this.a() == null) {
            return;
        }
        this.a((i)x);
        this.b((i)x);
        this.a().c(x);
        this.c((i)x);
        this.c();
    }
}
