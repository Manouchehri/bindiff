package y.f.e.a;

public class J implements ax
{
    public static final Y a;
    public static final Y b;
    public static final Y c;
    public static final Y d;
    public static final Y e;
    public static final Y f;
    public static final Y g;
    public static final Y h;
    public static final Y i;
    public static final Y j;
    public static final Y k;
    public static final Y l;
    public static final Y m;
    public static final Y n;
    public static final Y[] o;
    private final double s;
    private final double t;
    protected ax p;
    protected Y q;
    protected Y r;
    private final double u;
    private double v;
    
    public J(final ax p4, final Y q, final double t, final double s) {
        this.r = J.c;
        this.v = 1.0;
        this.p = p4;
        this.q = q;
        this.t = t;
        this.s = s;
        this.u = s - t;
        if (this.u == 0.0) {
            throw new IllegalArgumentException("Length must not be 0");
        }
    }
    
    public void a(final Y r) {
        this.r = r;
    }
    
    public k a(final m m, final l l, final a a) {
        if (this.a(l)) {
            return a;
        }
        final a a2 = (a)this.p.a(m, l, a);
        this.a(a2);
        this.a(l, a2);
        return a2;
    }
    
    private void a(final l l, final a a) {
        a.d(this.b(l.a()));
    }
    
    private boolean a(final l l) {
        return this.r.b(l.a()) || this.v == 0.0;
    }
    
    void a(final a a) {
        if (this.v == 0.0) {
            a.a();
            return;
        }
        final double c = a.c();
        if (c == 0.0) {
            return;
        }
        final double a2 = this.a(c);
        if (a2 == 0.0) {
            a.a();
            return;
        }
        final double n = a2 * this.v / c;
        a.a(a.d() * n);
        a.b(a.e() * n);
        a.c(a.f() * n);
    }
    
    double a(final double n) {
        return this.q.a((n - this.t) / this.u);
    }
    
    double b(final double n) {
        return this.r.a(n);
    }
    
    public double a() {
        return this.v;
    }
    
    public void c(final double v) {
        this.v = v;
    }
    
    public ax b() {
        return this.p;
    }
    
    public String toString() {
        return "WeightedCalculator{coreCalculator=" + this.p + ", factor=" + this.v + ", model=" + this.q + ", timeModel=" + this.r + "}";
    }
    
    static {
        a = new R();
        b = new V();
        c = new Q();
        d = new K();
        e = new W();
        f = new T();
        g = new X();
        h = new L();
        i = new M();
        j = new S();
        k = new N();
        l = new O();
        m = new U();
        n = new P();
        o = new Y[] { J.c, J.a, J.b, J.h, J.i, J.d, J.e, J.f, J.g, J.j, J.k, J.l, J.m, J.n };
    }
}
