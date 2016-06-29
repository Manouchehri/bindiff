package y.f.e.a;

import y.c.*;
import java.util.*;
import y.a.*;
import y.f.*;
import y.f.e.*;

public class ay extends c
{
    public static final Object n;
    private List p;
    private List q;
    private s r;
    private G s;
    private aw t;
    private r u;
    private List v;
    private List w;
    private List x;
    private boolean y;
    protected l o;
    private af z;
    private double A;
    private double B;
    private boolean C;
    private List D;
    private boolean E;
    
    public ay() {
        this(true);
    }
    
    public void g(final boolean e) {
        this.E = e;
    }
    
    public ay(final boolean b) {
        final boolean b2 = af.b;
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ak();
        this.s = new b();
        this.t = new o();
        this.u = new g(false);
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = true;
        this.A = 50.0;
        this.B = 50.0;
        this.D = new ArrayList();
        this.E = true;
        this.e(false);
        this.d(true);
        if (b) {
            this.a();
        }
        this.e(new au(this));
        this.n();
        if (y.c.i.g) {
            af.b = !b2;
        }
    }
    
    protected void a() {
        this.a(new h());
    }
    
    protected void n() {
        this.a(new e());
    }
    
    public void a(final p p) {
        p.a(this);
        this.D.add(p);
    }
    
    public List o() {
        return Collections.unmodifiableList((List<?>)this.D);
    }
    
    public boolean b(final X x) {
        return x.e() != 0;
    }
    
    public void a(final X x) {
        this.d(x);
        try {
            this.a(0);
        }
        finally {
            this.e(x);
        }
    }
    
    protected void d(final X x) {
        this.g(x);
        this.z = this.h(x);
        this.o = this.v();
        this.u();
        this.r();
        this.C();
    }
    
    protected int a(int n) {
        final boolean b = af.b;
        this.C = true;
        while (!this.q()) {
            a.a();
            this.b(n);
            this.u.a(this.o);
            this.A();
            this.p();
            ++n;
            if (b) {
                break;
            }
        }
        return n;
    }
    
    protected void e(final X x) {
        this.B();
        this.t();
        this.f(x);
        this.C = false;
    }
    
    protected void f(final X x) {
        this.z.a(x);
        this.z = null;
    }
    
    protected void b(final int n) {
        this.o.a(n);
        this.o.a(this.t.a(this.o));
    }
    
    protected void p() {
    }
    
    private void A() {
        final boolean b = af.b;
        int i = 0;
        while (i < this.x.size()) {
            ((am)this.x.get(i)).a(this.o, this.z);
            ++i;
            if (b) {
                break;
            }
        }
    }
    
    private void B() {
        final boolean b = af.b;
        int i = 0;
        while (i < this.w.size()) {
            ((am)this.w.get(i)).a(this.o, this.z);
            ++i;
            if (b) {
                break;
            }
        }
    }
    
    private void C() {
        final boolean b = af.b;
        int i = 0;
        while (i < this.v.size()) {
            ((am)this.v.get(i)).a(this.o, this.z);
            ++i;
            if (b) {
                break;
            }
        }
    }
    
    protected boolean q() {
        return this.t.b(this.o);
    }
    
    protected void r() {
        this.u.a(this.q);
        this.u.a(this.r);
        this.u.a(this.s);
        this.u.a();
    }
    
    protected void g(final X x) {
        if (this.E) {
            ae.a(x);
        }
    }
    
    public l s() {
        return this.o;
    }
    
    protected void t() {
        this.z.k();
    }
    
    public af h(final X x) {
        return new af(x);
    }
    
    protected void u() {
        final boolean b = af.b;
        int i = 0;
        while (i < this.p.size()) {
            ((am)this.p.get(i)).a(this.o, this.z);
            ++i;
            if (b) {
                break;
            }
        }
    }
    
    protected l v() {
        return new l(this.z, this, this.y);
    }
    
    public double w() {
        return this.A;
    }
    
    public void a(final double a) {
        this.A = a;
    }
    
    public double x() {
        return this.B;
    }
    
    public void b(final double b) {
        this.B = b;
    }
    
    public void h(final boolean y) {
        this.y = y;
    }
    
    public void a(final ax ax) {
        this.q.add(ax);
    }
    
    public List y() {
        return Collections.unmodifiableList((List<?>)this.q);
    }
    
    public void b(final ax ax) {
        final int index = this.q.indexOf(ax);
        if (index < 0) {
            return;
        }
        this.q.remove(index);
    }
    
    public void a(final am am) {
        this.v.add(am);
    }
    
    public void b(final am am) {
        this.w.add(am);
    }
    
    public void c(final am am) {
        this.x.add(am);
    }
    
    public void d(final am am) {
        final int index = this.x.indexOf(am);
        if (index < 0) {
            return;
        }
        this.x.remove(index);
    }
    
    public aw z() {
        return this.t;
    }
    
    public void a(final aw t) {
        this.t = t;
    }
    
    public void e(final am am) {
        this.p.add(am);
    }
    
    static {
        n = d.p;
    }
}
