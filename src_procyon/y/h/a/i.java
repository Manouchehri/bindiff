package y.h.a;

import y.h.*;
import y.f.b.*;
import y.g.*;
import y.c.*;
import y.d.*;
import java.util.*;

public class i
{
    private bu a;
    private v b;
    private c c;
    private c d;
    private c e;
    private c f;
    private c g;
    private HashMap h;
    private boolean i;
    
    public i(final bu a) {
        this.a = a;
        this.b = v.a(a);
    }
    
    public boolean a() {
        return this.i;
    }
    
    public void b() {
        if (this.b != null) {
            this.c = this.a.c(y.f.b.f.d);
            this.d = this.a.c(y.f.b.f.b);
            this.e = this.a.c(y.f.b.f.c);
            if (this.c != null) {
                this.a.d_(y.f.b.f.d);
            }
            if (this.d != null) {
                this.a.d_(y.f.b.f.b);
            }
            if (this.e != null) {
                this.a.d_(y.f.b.f.c);
            }
            this.a.a(y.f.b.f.d, this.a(this.a));
            this.a.a(y.f.b.f.c, this.b.d());
            this.a.a(y.f.b.f.b, this.b.c());
        }
    }
    
    protected c a(final bu bu) {
        final int a = v.a;
        final c e = this.b.e();
        if (!this.a() || e == null) {
            return e;
        }
        final A a2 = M.a();
        final x o = bu.o();
        while (o.f()) {
            final q e2 = o.e();
            a2.a(e2, e.d(e2) && this.b.p(e2).k() > 0);
            o.g();
            if (a != 0) {
                break;
            }
        }
        return a2;
    }
    
    public void c() {
        if (this.b != null) {
            this.f = this.a.c(y.f.b.f.e);
            this.a.a(y.f.b.f.e, new j(this));
        }
    }
    
    protected r a(final bu bu, final q q) {
        final a autoBoundsFeature = bu.t(q).getAutoBoundsFeature();
        if (autoBoundsFeature == null) {
            return null;
        }
        return autoBoundsFeature.getAutoBoundsInsets();
    }
    
    public void d() {
        if (this.b != null) {
            this.g = this.a.c(y.f.b.f.f);
            this.a.a(y.f.b.f.f, new k(this.a));
        }
    }
    
    public void e() {
        final int a = v.a;
        Label_0105: {
            if (this.b != null) {
                final Iterator b = this.b.b();
                while (b.hasNext()) {
                    final q q = b.next();
                    if (this.a.f(q)) {
                        final a autoBoundsFeature = this.a.t(q).getAutoBoundsFeature();
                        if (autoBoundsFeature == null || !autoBoundsFeature.isAutoBoundsEnabled()) {
                            continue;
                        }
                        autoBoundsFeature.setAutoBoundsEnabled(false);
                        autoBoundsFeature.setAutoBoundsEnabled(true);
                        if (a != 0) {
                            break Label_0105;
                        }
                        continue;
                    }
                }
                return;
            }
        }
        final x o = this.a.o();
        while (o.f()) {
            final a autoBoundsFeature2 = this.a.t(o.e()).getAutoBoundsFeature();
            if (autoBoundsFeature2 != null && autoBoundsFeature2.isAutoBoundsEnabled()) {
                autoBoundsFeature2.setAutoBoundsEnabled(false);
                autoBoundsFeature2.setAutoBoundsEnabled(true);
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    public void f() {
        final int a = v.a;
        if (this.b != null) {
            Label_0046: {
                if (this.c == null) {
                    this.a.d_(y.f.b.f.d);
                    if (a == 0) {
                        break Label_0046;
                    }
                }
                this.a.a(y.f.b.f.d, this.c);
            }
            Label_0081: {
                if (this.e == null) {
                    this.a.d_(y.f.b.f.c);
                    if (a == 0) {
                        break Label_0081;
                    }
                }
                this.a.a(y.f.b.f.c, this.e);
            }
            Label_0116: {
                if (this.d == null) {
                    this.a.d_(y.f.b.f.b);
                    if (a == 0) {
                        break Label_0116;
                    }
                }
                this.a.a(y.f.b.f.b, this.d);
            }
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }
    
    public void g() {
        if (this.b != null) {
            this.a(true);
        }
    }
    
    public void h() {
        if (this.b != null) {
            if (this.f != null) {
                this.a.a(y.f.b.f.e, this.f);
                if (v.a == 0) {
                    return;
                }
            }
            this.a.d_(y.f.b.f.e);
        }
    }
    
    public void i() {
        if (this.b != null) {
            if (this.g != null) {
                this.a.a(y.f.b.f.f, this.g);
                if (v.a == 0) {
                    return;
                }
            }
            this.a.d_(y.f.b.f.f);
        }
    }
    
    public void j() {
        if (this.b != null) {
            this.a(false);
        }
    }
    
    private void a(final boolean b) {
        final int a = v.a;
        Label_0033: {
            if (b) {
                this.h = new HashMap();
                if (a == 0) {
                    break Label_0033;
                }
            }
            if (this.h == null) {
                return;
            }
        }
        final x o = this.a.o();
        while (o.f()) {
            final q e = o.e();
            final a autoBoundsFeature = this.a.t(e).getAutoBoundsFeature();
            if (a != 0) {
                return;
            }
            Label_0150: {
                if (autoBoundsFeature != null) {
                    if (b) {
                        if (autoBoundsFeature.isAutoBoundsEnabled()) {
                            autoBoundsFeature.setAutoBoundsEnabled(false);
                            if (a == 0) {
                                break Label_0150;
                            }
                        }
                        this.h.put(e, Boolean.TRUE);
                        if (a == 0) {
                            break Label_0150;
                        }
                    }
                    if (this.h.get(e) != Boolean.TRUE) {
                        autoBoundsFeature.setAutoBoundsEnabled(true);
                    }
                }
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
        if (!b) {
            this.h = null;
        }
    }
    
    public void k() {
        if (this.b != null) {
            this.e();
            this.b();
            this.c();
            this.g();
            this.d();
        }
    }
    
    public void l() {
        if (this.b != null) {
            this.j();
            this.h();
            this.f();
            this.i();
        }
    }
    
    static bu a(final i i) {
        return i.a;
    }
}
