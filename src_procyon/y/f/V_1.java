package y.f;

import y.d.*;
import y.c.*;

public class V implements ad
{
    private ah a;
    private h b;
    private A c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean n;
    
    public V() {
        this.d = false;
        this.e = true;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = true;
        this.n = true;
    }
    
    public void a(final ah a) {
        this.a = a;
    }
    
    public ah a() {
        return this.a;
    }
    
    public void c(final X x) {
        if (this.a != null) {
            if (this.e() || this.d()) {
                this.a(x);
            }
            this.a.c(x);
            this.d(x);
            this.b(x);
        }
    }
    
    public boolean b() {
        return this.n;
    }
    
    private void a(final X x) {
        final boolean j = X.j;
        X x2 = null;
        Object b2 = null;
        Label_0311: {
            if (x.c(U.a) == null && this.e()) {
                this.b = x.u();
                x.a(U.a, this.b);
                final e p = x.p();
                do {
                    Label_0048: {
                        p.f();
                    }
                    boolean i = false;
                    Label_0054:
                    while (i) {
                        final d a = p.a();
                        final am a2 = x.a((Object)a.c());
                        final am a3 = x.a((Object)a.d());
                        final I b = x.b((Object)a);
                        x2 = x;
                        final d d = (d)(b2 = a);
                        if (!j) {
                            final C[] d2 = x.d((Object)d);
                            final S[] array = new S[d2.length];
                            int k = 0;
                            while (k < d2.length) {
                                final n a4 = d2[k].getLabelModel().a(d2[k].getOrientedBox().d(), b, a2, a3, d2[k].getModelParameter());
                                i = this.i;
                                if (j) {
                                    continue Label_0054;
                                }
                                if (i) {
                                    final t l = a4.k();
                                    a4.c(0.0, -1.0);
                                    a4.b(l);
                                }
                                array[k] = new S(a4.f(-(a2.getX() + a2.getWidth() * 0.5), -(a2.getY() + a2.getHeight() * 0.5)), d2[k].getPreferredPlacementDescriptor());
                                ++k;
                                if (j) {
                                    break;
                                }
                            }
                            this.b.a(a, array);
                            p.g();
                            continue Label_0048;
                        }
                        break Label_0311;
                    }
                    break;
                } while (!j);
            }
            x2 = x;
            b2 = U.b;
        }
        if (x2.c(b2) == null && this.d()) {
            this.c = x.t();
            x.a(U.b, this.c);
            final x o = x.o();
            do {
                Label_0351: {
                    o.f();
                }
                boolean h = false;
                Label_0358:
                while (h) {
                    final q e = o.e();
                    final am a5 = x.a((Object)e);
                    final aj[] a_ = x.a_(e);
                    final S[] array2 = new S[a_.length];
                    int n = 0;
                    while (n < a_.length) {
                        final n a6 = a_[n].a().a(a_[n].getOrientedBox().d(), a5, a_[n].getModelParameter());
                        h = this.h;
                        if (j) {
                            continue Label_0358;
                        }
                        if (h) {
                            final t m = a6.k();
                            a6.c(0.0, -1.0);
                            a6.b(m);
                        }
                        array2[n] = new S(a6.f(-(a5.getX() + a5.getWidth() * 0.5), -(a5.getY() + a5.getHeight() * 0.5)));
                        ++n;
                        if (j) {
                            break;
                        }
                    }
                    this.c.a(e, array2);
                    o.g();
                    continue Label_0351;
                }
                break;
            } while (!j);
        }
    }
    
    private void b(final X x) {
        if (this.b != null) {
            x.d_(U.a);
            x.a(this.b);
            this.b = null;
        }
        if (this.c != null) {
            x.d_(U.b);
            x.a(this.c);
            this.c = null;
        }
    }
    
    private void d(final X x) {
        final boolean j = X.j;
        final c c = x.c(U.a);
        final c c2 = x.c(U.b);
        if (c == null && c2 == null) {
            return;
        }
        if (!this.g && !this.f) {
            return;
        }
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            Label_0290: {
            Label_0092:
                while (true) {
                    Label_0162: {
                        if (c2 == null || !this.f) {
                            break Label_0162;
                        }
                        final S[] array = (S[])c2.b(e);
                        final S[] array3;
                        final S[] array2 = array3;
                        final aj[] a_ = x.a_(e);
                        if (array2 != null && a_ != null && array2.length == a_.length) {
                            int i = 0;
                            while (i < a_.length) {
                                this.a(x, e, a_[i], array2[i]);
                                ++i;
                                if (j) {
                                    break Label_0290;
                                }
                                if (j) {
                                    break;
                                }
                            }
                        }
                    }
                    if (c != null && this.g) {
                        d d = e.f();
                        while (d != null) {
                            final S[] array4 = (S[])c.b(d);
                            final C[] d2 = x.d((Object)d);
                            final S[] array3 = array4;
                            if (j) {
                                continue Label_0092;
                            }
                            Label_0278: {
                                if (array3 != null && d2 != null && array4.length == d2.length) {
                                    int k = 0;
                                    while (k < d2.length) {
                                        this.a(x, d, d2[k], array4[k]);
                                        ++k;
                                        if (j) {
                                            break Label_0278;
                                        }
                                        if (j) {
                                            break;
                                        }
                                    }
                                }
                                d = d.g();
                            }
                            if (j) {
                                break;
                            }
                        }
                    }
                    break;
                }
                o.g();
            }
            if (j) {
                break;
            }
        }
    }
    
    private void a(final X x, final d d, final C c, final S s) {
        final E labelModel = c.getLabelModel();
        final n a = s.a();
        if (this.b()) {
            ae.b(a);
        }
        c.setModelParameter(labelModel.a(a, x.b((Object)d), x.a((Object)d.c()), x.a((Object)d.d())));
    }
    
    private void a(final X x, final q q, final aj aj, final S s) {
        aj.setModelParameter(aj.a().a(s.a(), x.a((Object)q)));
    }
    
    public boolean c() {
        return this.g;
    }
    
    public void a(final boolean g) {
        this.g = g;
    }
    
    public void b(final boolean f) {
        this.f = f;
    }
    
    public boolean d() {
        return this.d;
    }
    
    public void c(final boolean d) {
        this.d = d;
    }
    
    public boolean e() {
        return this.e;
    }
    
    public void d(final boolean e) {
        this.e = e;
    }
}
