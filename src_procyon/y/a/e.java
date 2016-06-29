package y.a;

import y.c.*;

public class e
{
    private h a;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    protected A b;
    protected static final Object c;
    protected static final Object d;
    protected static final Object e;
    private final byte[] j;
    
    public e() {
        this.j = new byte[1];
        this.i = false;
        this.h = true;
    }
    
    public void a(final boolean i) {
        this.i = i;
    }
    
    public void b(final boolean h) {
        this.h = h;
    }
    
    public void a(final i i) {
        if (i.f() == 0) {
            return;
        }
        this.a(i, i.k());
    }
    
    public void a(final i i, final q q) {
        final boolean a = y.a.h.a;
        if (q == null) {
            return;
        }
        this.b = i.t();
        if (!this.i) {
            this.a = i.u();
        }
        this.f = 0;
        this.g = 0;
        final f f = new f(Math.min(60, i.e() + 3));
        try {
            this.a(f, q);
            if (this.h) {
                final x o = i.o();
                while (o.f()) {
                    final q e = o.e();
                    if (this.b.b(e) == null) {
                        this.a(e);
                        this.a(f, e);
                    }
                    o.g();
                    if (a) {
                        break;
                    }
                }
            }
        }
        finally {
            i.a(this.b);
            this.b = null;
            if (!this.i) {
                i.a(this.a);
                this.a = null;
            }
        }
    }
    
    private final d a(final q q, final d d, final byte[] array) {
        switch (array[0]) {
            case 0: {
                if (this.i) {
                    array[0] = 1;
                    return q.f();
                }
                final d f = q.f();
                if (f == null) {
                    final d g = q.g();
                    array[0] = 3;
                    return g;
                }
                array[0] = 2;
                return f;
            }
            case 1: {
                return d.g();
            }
            case 2: {
                d d2 = d.g();
                if (d2 == null) {
                    d2 = q.g();
                    array[0] = 3;
                }
                return d2;
            }
            case 3: {
                return d.h();
            }
            default: {
                throw new InternalError();
            }
        }
    }
    
    private final void a(final f f, final q q) {
        final boolean a = y.a.h.a;
        this.j[0] = 0;
        q c = q;
        this.b.a(c, y.a.e.d);
        this.a(c, ++this.f);
        f.a(c, this.a(c, null, this.j), this.j[0], this.f);
    Label_0374_Outer:
        while (!f.a()) {
            d d = f.d();
            this.j[0] = f.e();
            while (true) {
                while (d != null) {
                    final boolean i = this.i;
                    if (!a) {
                        if (i || !this.a.d(d)) {
                            q q2 = null;
                            Label_0166: {
                                if (!this.i) {
                                    this.a.a(d, true);
                                    q2 = d.a(c);
                                    if (!a) {
                                        break Label_0166;
                                    }
                                }
                                q2 = d.d();
                            }
                            if (this.b.b(q2) == null) {
                                this.a(d, q2, true);
                                this.b.a(q2, y.a.e.d);
                                c = q2;
                                this.a(c, ++this.f);
                                this.j[0] = 0;
                                d = this.a(c, null, this.j);
                                f.a(c, d, this.j[0], this.f);
                                if (!a) {
                                    continue Label_0374_Outer;
                                }
                            }
                            this.a(d, q2, false);
                            d = this.a(c, d, this.j);
                            f.a(d, this.j[0]);
                            if (!a) {
                                continue Label_0374_Outer;
                            }
                        }
                        d = this.a(c, d, this.j);
                        f.a(d, this.j[0]);
                        if (a) {
                            break;
                        }
                        continue Label_0374_Outer;
                    }
                    else {
                        if (i) {
                            continue Label_0374_Outer;
                        }
                        final d d2 = f.d();
                        this.a(d2, c);
                        c = f.c();
                        this.j[0] = f.e();
                        f.a(this.a(c, d2, this.j), this.j[0]);
                        if (a) {
                            break Label_0374_Outer;
                        }
                        continue Label_0374_Outer;
                    }
                }
                this.a(c, f.f(), ++this.g);
                this.b.a(c, y.a.e.e);
                f.b();
                f.a();
                continue;
            }
        }
    }
    
    protected void a(final q q, final int n) {
    }
    
    protected void a(final q q, final int n, final int n2) {
    }
    
    protected void a(final d d, final q q, final boolean b) {
    }
    
    protected void a(final d d, final q q) {
    }
    
    protected void a(final q q) {
    }
    
    static {
        c = null;
        d = new Object();
        e = new Object();
    }
}
