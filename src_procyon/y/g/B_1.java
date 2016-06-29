package y.g;

import y.c.*;
import java.util.*;

public class B
{
    private C a;
    private boolean b;
    private boolean c;
    private boolean d;
    
    public B() {
        this.a = new k();
    }
    
    public B(final C a) {
        if (a == null) {
            throw new NullPointerException("copyFactory");
        }
        this.a = a;
    }
    
    public y a(final i i, final i j) {
        return this.a(i, this.b(i), j);
    }
    
    public C a() {
        return this.a;
    }
    
    public void a(final C a) {
        if (a == null) {
            throw new NullPointerException();
        }
        this.a = a;
    }
    
    private C a(C c, final i i) {
        final boolean c2 = p.c;
        if (this.c) {
            c = new H(c);
        }
        if (this.d) {
            c = new E(c);
        }
        if (this.b) {
            final Object[] z = i.z();
            int j = 0;
            while (j < z.length) {
                final C c4;
                final C c3 = c4 = new G(c, z[j]);
                if (c2) {
                    return c4;
                }
                c = c3;
                ++j;
                if (c2) {
                    break;
                }
            }
        }
        return c;
    }
    
    public y a(final i i, final x x, final i j) {
        return this.a(this.a(this.a, i), i, x, null, j);
    }
    
    public y a(final i i, final x x, final e e, final i j) {
        return this.a(this.a(this.a, i), i, x, e, j);
    }
    
    private y a(final C c, final i i, x a, final e e, final i j) {
        final boolean c2 = p.c;
        this.a(c, i, j);
        final y y = new y();
        final Map c3 = this.c();
        final Map b = this.b();
        if (i == j) {
            a = new y(a).a();
        }
    Label_0131_Outer:
        while (true) {
            while (true) {
                while (a.f()) {
                    final q e2 = a.e();
                    final q a2 = this.a(c, j, e2);
                    c3.put(e2, a2);
                    y.add(a2);
                    a.g();
                    if (c2) {
                        final e a3 = this.a(i);
                        e a4 = a3;
                        if (i == j) {
                            a4 = new f(a4).a();
                        }
                        while (a4.f()) {
                            final d a5 = a4.a();
                            final q c4 = a5.c();
                            final q d = a5.d();
                            final q q = c3.get(c4);
                            final q q2 = c3.get(d);
                            if (c2) {
                                return y;
                            }
                            if (q != null && q2 != null) {
                                final d a6 = this.a(c, j, q, q2, a5);
                                if (b != null) {
                                    b.put(a5, a6);
                                }
                            }
                            a4.g();
                            if (c2) {
                                break;
                            }
                        }
                        this.a(c, i, j, c3, b);
                        return y;
                    }
                    if (c2) {
                        break;
                    }
                }
                if (e != null) {
                    final e a3 = e;
                    continue;
                }
                break;
            }
            continue Label_0131_Outer;
        }
    }
    
    protected void a(final C c, final i i, final i j) {
        c.a(i, j);
    }
    
    protected void a(final C c, final i i, final i j, final Map map, final Map map2) {
        c.a(i, j, map, map2);
    }
    
    protected Map b() {
        return new HashMap();
    }
    
    protected d a(final C c, final i i, final q q, final q q2, final d d) {
        return c.a(i, q, q2, d);
    }
    
    protected e a(final i i) {
        return i.p();
    }
    
    protected q a(final C c, final i i, final q q) {
        return c.a(i, q);
    }
    
    protected Map c() {
        return new HashMap();
    }
    
    protected x b(final i i) {
        return i.o();
    }
}
