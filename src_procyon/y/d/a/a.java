package y.d.a;

import y.d.b.*;
import java.util.*;
import y.f.h.*;
import y.c.*;

public class a
{
    private l a;
    private y.d.b.l b;
    
    public a() {
        this.a = null;
        this.b = new o();
    }
    
    public a(final y.d.b.l l) {
        this.a(l);
    }
    
    public void a(final y.d.b.l b) {
        this.a = null;
        this.b = b;
    }
    
    protected Object a(final Object o) {
        if (this.a == null) {
            return o;
        }
        return this.a.a(o);
    }
    
    protected Object b(final Object o) {
        if (this.a == null) {
            return o;
        }
        return this.a.c(o);
    }
    
    protected Collection a(final Collection collection) {
        final int b = y.d.a.b.b;
        if (this.a == null) {
            return collection;
        }
        final D d = new D();
        final Iterator<Object> iterator = collection.iterator();
        D d2 = null;
        while (iterator.hasNext()) {
            d2 = d;
            if (b != 0) {
                return d2;
            }
            d2.add(this.a.b(iterator.next()));
            if (b != 0) {
                break;
            }
        }
        return d2;
    }
    
    public void a(final Collection collection, final N n, final A a, final h h) {
        this.a(collection, n, a, h, null, false);
    }
    
    public void a(final Collection collection, final Object o, final A a, final h h, final k k, final boolean b) {
        final int b2 = b.b;
        final Collection a2 = this.a(collection);
        final b b3 = new b();
        b3.a(k);
        i g = null;
        Label_0174: {
            if (o instanceof i) {
                g = (i)o;
                b3.a(this.b, a2, g, a, h);
                if (!b) {
                    break Label_0174;
                }
                b3.a(this.b, a2, g, a, h, false);
                if (b2 == 0) {
                    break Label_0174;
                }
            }
            if (o instanceof N) {
                final N n = (N)o;
                g = n.g();
                b3.a(this.b, a2, n, a, h);
                if (!b) {
                    break Label_0174;
                }
                b3.a(this.b, a2, g, a, h, true);
                if (b2 == 0) {
                    break Label_0174;
                }
            }
            throw new RuntimeException("wrong parameter: " + o);
        }
        final x o2 = g.o();
        while (o2.f()) {
            final q e = o2.e();
            a.a(e, this.a(a.b(e)));
            o2.g();
            if (b2 != 0) {
                break;
            }
        }
        final e p6 = g.p();
        while (p6.f()) {
            final d a3 = p6.a();
            h.a(a3, this.b(h.b(a3)));
            p6.g();
            if (b2 != 0) {
                break;
            }
        }
    }
}
