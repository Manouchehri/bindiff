package y.f.k;

import y.c.*;
import y.f.*;
import java.util.*;
import y.d.*;

public abstract class d implements w
{
    protected double a;
    protected X b;
    protected final l c;
    protected c d;
    protected c e;
    protected List f;
    public static int g;
    
    protected d(final l c) {
        this.a = 20.0;
        this.c = c;
    }
    
    public K a(final x x, final X x2, final q q) {
        return null;
    }
    
    W a(final y.c.d d, final P p2) {
        return new W(this.c, this.b, d, p2);
    }
    
    y.f.k.X a(final q q, final P p2) {
        return new y.f.k.X(this.a(q), p2);
    }
    
    protected abstract P a(final q p0, final byte p1);
    
    protected P a(final q q) {
        return new P(this.c, (A)this.e.b(q));
    }
    
    protected P b(final q q) {
        final P p = new P(this.c, (A)this.d.b(q));
        this.f.add(p);
        return p;
    }
    
    public void a(final q q, final b b) {
        final int g = y.f.k.d.g;
        this.b = (X)q.e();
        try {
            y.c.d d = q.f();
            while (d != null) {
                final q d2 = d.d();
                b.a(d2, this.a(this.d(d2)));
                d = d.g();
                if (g == 0 && g == 0) {
                    continue;
                }
                return;
            }
            goto Label_0072;
        }
        finally {
            this.b = null;
        }
    }
    
    protected aE c(final q q) {
        final y.c.d g = q.g();
        if (g == null) {
            final aE ae = aE.a((byte)0);
            if (y.f.k.d.g == 0) {
                return this.a(ae);
            }
        }
        aE ae = aE.e(this.b, g);
        if (ae == null) {
            ae = aE.a((byte)0);
        }
        return this.a(ae);
    }
    
    private aE a(final aE ae) {
        final int g = y.f.k.d.g;
        n n = null;
        Label_0071: {
            if (ae.c()) {
                n = y.f.k.n.a;
                if (g == 0) {
                    break Label_0071;
                }
            }
            if (ae.e()) {
                n = y.f.k.n.b;
                if (g == 0) {
                    break Label_0071;
                }
            }
            if (ae.d()) {
                n = y.f.k.n.c;
                if (g == 0) {
                    break Label_0071;
                }
            }
            if (ae.f()) {
                n = y.f.k.n.d;
                if (g == 0) {
                    break Label_0071;
                }
            }
            return ae;
        }
        final n a = n.a(this.c.a());
        if (a.equals(y.f.k.n.a)) {
            return aE.a((byte)1);
        }
        if (a.equals(y.f.k.n.b)) {
            return aE.a((byte)4);
        }
        if (a.equals(y.f.k.n.c)) {
            return aE.a((byte)2);
        }
        if (a.equals(y.f.k.n.d)) {
            return aE.a((byte)8);
        }
        throw new RuntimeException("Should not reach... " + ae);
    }
    
    protected byte a(final byte b) {
        final int g = y.f.k.d.g;
        n n = null;
        Label_0071: {
            switch (b) {
                case 0: {
                    n = y.f.k.n.a;
                    if (g != 0) {
                        break Label_0071;
                    }
                    break;
                }
                case 1: {
                    n = y.f.k.n.b;
                    if (g != 0) {
                        break Label_0071;
                    }
                    break;
                }
                case 2: {
                    n = y.f.k.n.c;
                    if (g != 0) {
                        break Label_0071;
                    }
                    break;
                }
                case 3: {
                    n = y.f.k.n.d;
                    if (g != 0) {
                        return -1;
                    }
                    break;
                }
                case -1: {
                    return -1;
                }
                case -2: {
                    return -2;
                }
                default: {
                    throw new IllegalArgumentException("Not implemented for " + b);
                }
            }
        }
        final n a = n.a(this.c);
        if (a.equals(y.f.k.n.a)) {
            return 0;
        }
        if (a.equals(y.f.k.n.b)) {
            return 1;
        }
        if (a.equals(y.f.k.n.c)) {
            return 2;
        }
        if (a.equals(y.f.k.n.d)) {
            return 3;
        }
        throw new RuntimeException("Should not reach... " + b);
    }
    
    protected byte b(final byte b) {
        final int g = y.f.k.d.g;
        n n = null;
        Label_0071: {
            switch (b) {
                case 0: {
                    n = y.f.k.n.a;
                    if (g != 0) {
                        break Label_0071;
                    }
                    break;
                }
                case 1: {
                    n = y.f.k.n.b;
                    if (g != 0) {
                        break Label_0071;
                    }
                    break;
                }
                case 2: {
                    n = y.f.k.n.c;
                    if (g != 0) {
                        break Label_0071;
                    }
                    break;
                }
                case 3: {
                    n = y.f.k.n.d;
                    if (g != 0) {
                        return -1;
                    }
                    break;
                }
                case -1: {
                    return -1;
                }
                case -2: {
                    return -2;
                }
                default: {
                    throw new IllegalArgumentException("Not implemented for " + b);
                }
            }
        }
        final n a = n.a(this.c.a());
        if (a.equals(y.f.k.n.a)) {
            return 0;
        }
        if (a.equals(y.f.k.n.b)) {
            return 1;
        }
        if (a.equals(y.f.k.n.c)) {
            return 2;
        }
        if (a.equals(y.f.k.n.d)) {
            return 3;
        }
        throw new RuntimeException("Should not reach... " + b);
    }
    
    protected abstract byte d(final q p0);
    
    public A a(final c e, final c d, final X b, final q q, final byte b2) {
        this.d = d;
        this.e = e;
        this.b = b;
        try {
            this.f = new ArrayList();
            final P a = this.a(q, this.b(b2));
            a.j();
            return a.i();
        }
        finally {}
    }
    
    public l a() {
        return this.c;
    }
    
    public static t a(final l l, final t t) {
        if (t == null) {
            return null;
        }
        final n a = n.a(t.a(), t.b()).a(l.a());
        return new t(a.a(0), a.a(1));
    }
}
