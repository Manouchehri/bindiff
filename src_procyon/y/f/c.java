package y.f;

import y.f.d.*;
import y.f.b.*;
import y.c.*;
import y.g.*;
import java.util.*;

public abstract class c implements ah
{
    private ad n;
    private ad o;
    private ad p;
    private ad q;
    private ad r;
    private ad s;
    private ad t;
    boolean a_;
    boolean b_;
    boolean c_;
    boolean d_;
    boolean e;
    boolean f;
    boolean g;
    List h;
    List i;
    
    public c() {
        this.a_ = true;
        this.b_ = true;
        this.c_ = true;
        this.d_ = false;
        this.e = true;
        this.f = false;
        this.g = true;
        this.h = new ArrayList(5);
        this.i = new ArrayList(5);
        this.n = new aN();
        this.o = new as();
        this.p = new e();
        this.q = new aQ();
        this.r = new an();
        this.s = new f();
        this.t = new b();
    }
    
    protected abstract void a(final X p0);
    
    protected abstract boolean b(final X p0);
    
    private void d(final X x) {
        this.a(x, x);
    }
    
    private void a(final n n, final O o) {
        final boolean j = X.j;
        y.c.c c = n.c(y.f.b.f.d);
        if (c == null) {
            c = y.g.q.a(Boolean.FALSE);
        }
        final Iterator x = n.x();
        while (x.hasNext()) {
            final Object next = x.next();
            if (!c.d(next)) {
                this.a(o, next);
                if (!j) {
                    continue;
                }
            }
            this.b(o, next);
            if (j) {
                break;
            }
        }
    }
    
    protected void a(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    protected void b(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    public void a(final ad ad) {
        this.h.add(ad);
    }
    
    public void b(final ad ad) {
        this.i.add(ad);
    }
    
    public ad b() {
        return this.s;
    }
    
    public void c(final ad s) {
        this.s = s;
    }
    
    public ad c() {
        return this.n;
    }
    
    public ad d() {
        return this.o;
    }
    
    public ad e() {
        return this.p;
    }
    
    public void d(final ad p) {
        this.p = p;
    }
    
    public ad f() {
        return this.t;
    }
    
    public ad g() {
        return this.r;
    }
    
    public void e(final ad r) {
        this.r = r;
    }
    
    public void a(final boolean e) {
        this.e = e;
    }
    
    public void a(final byte b) {
        if (this.r instanceof an) {
            ((an)this.r).a(b);
        }
    }
    
    public byte h() {
        if (this.r instanceof an) {
            return ((an)this.r).b();
        }
        return 0;
    }
    
    public boolean i() {
        return this.e;
    }
    
    public void b(final boolean b_) {
        this.b_ = b_;
    }
    
    public boolean j() {
        return this.b_;
    }
    
    public void c(final boolean f) {
        this.f = f;
    }
    
    public void d(final boolean g) {
        this.g = g;
    }
    
    public void e(final boolean c_) {
        this.c_ = c_;
    }
    
    public boolean k() {
        return this.c_;
    }
    
    public void f(final boolean a_) {
        this.a_ = a_;
    }
    
    public boolean l() {
        return this.a_;
    }
    
    public void m() {
        this.d_ = false;
        this.a_ = false;
        this.f = false;
        this.b_ = false;
        this.c_ = false;
        this.e = false;
        this.g = false;
    }
    
    private ah a() {
        final boolean j = X.j;
        Object o = new d(this);
        int i = this.i.size() - 1;
        while (true) {
            while (i >= 0) {
                final ad ad = this.i.get(i);
                ad.a((ah)o);
                o = ad;
                --i;
                if (j) {
                    if (this.b_) {
                        this.n.a((ah)o);
                        o = this.n;
                    }
                    if (this.e) {
                        this.r.a((ah)o);
                        o = this.r;
                    }
                    if (this.f) {
                        this.s.a((ah)o);
                        o = this.s;
                    }
                    if (this.c_) {
                        this.p.a((ah)o);
                        o = this.p;
                    }
                    if (this.d_) {
                        this.q.a((ah)o);
                        o = this.q;
                    }
                    if (this.g) {
                        this.t.a((ah)o);
                        o = this.t;
                    }
                    int k = 0;
                    while (k < this.h.size()) {
                        final ad ad2 = this.h.get(k);
                        ad2.a((ah)o);
                        final ah ah;
                        final ad ad3 = (ad)(ah = ad2);
                        if (j) {
                            return ah;
                        }
                        o = ad3;
                        ++k;
                        if (j) {
                            break;
                        }
                    }
                    return (ah)o;
                }
                if (j) {
                    break;
                }
            }
            if (this.a_) {
                this.o.a((ah)o);
                o = this.o;
            }
            continue;
        }
    }
    
    public void c(final X x) {
        boolean b = false;
        if (x.c("y.layout.CANONIC_MULTI_STAGE_LAYOUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
            this.d(x);
            x.a("y.layout.CANONIC_MULTI_STAGE_LAYOUTER_NODE_SIZE_CHECKED_DPKEY", y.g.q.a(Boolean.TRUE));
            b = true;
        }
        this.a().c(x);
        if (b) {
            x.d_("y.layout.CANONIC_MULTI_STAGE_LAYOUTER_NODE_SIZE_CHECKED_DPKEY");
        }
    }
    
    static void a(final c c, final X x) {
        c.d(x);
    }
}
