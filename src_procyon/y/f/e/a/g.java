package y.f.e.a;

class g extends q
{
    private y.c.q[] d;
    private int e;
    private boolean f;
    private int g;
    private double h;
    private a i;
    private a j;
    
    g() {
        this(false);
    }
    
    g(final boolean f) {
        this.h = 0.25;
        this.i = new Z();
        this.j = new Z();
        this.f = f;
    }
    
    public void a() {
        this.d = null;
        this.e = -1;
    }
    
    public void a(final l l) {
        final boolean b = af.b;
        final af f = l.f();
        if (this.d == null || this.e != f.g()) {
            this.d = this.a(f);
        }
        int i = 0;
        while (i < this.d.length) {
            final ag c = f.c(this.d[i]);
            Label_0112: {
                if (c.g() == 1.0) {
                    c.p();
                    c.c(this.c.a(c, l));
                    if (!b) {
                        break Label_0112;
                    }
                }
                this.a(c, l);
                this.a(i, c, l);
            }
            ++i;
            if (b) {
                break;
            }
        }
    }
    
    private void a(final int n, final m m, final l l) {
        final double c = l.b().c();
        final double e = m.e();
        if (this.f) {
            if (e > c * (2.0 - this.h)) {
                this.a(n, (n + this.g + 1) % this.d.length);
            }
            if (this.d.length <= 2 || l.d().a(0, 2) != 1) {
                return;
            }
            this.a(l.d().a(n + 1, n + this.g) % this.d.length, l.d().a(n + 1, n + this.g) % this.d.length);
            if (!af.b) {
                return;
            }
        }
        this.a(n, l.d().nextInt(n + 1));
    }
    
    protected void a(final ag ag, final l l) {
        final boolean b = af.b;
        ag.p();
        int i = 0;
        while (i < this.a.size()) {
            final ax ax = this.a.get(i);
            this.j.a();
            this.a(ag);
            ag.a(ax.a(ag, l, this.j));
            this.a(ax);
            ++i;
            if (b) {
                return;
            }
            if (b) {
                break;
            }
        }
        ag.c(this.c.a(ag, l));
        this.i.a();
        this.b.a(ag, l, this.i);
    }
    
    private y.c.q[] a(final af af) {
        this.e = af.g();
        this.g = af.f().e() / 3 + 1;
        return af.f().m();
    }
    
    protected void a(final ag ag) {
    }
    
    protected void a(final ax ax) {
    }
    
    private void a(final int n, final int n2) {
        if (n != n2) {
            final y.c.q q = this.d[n2];
            this.d[n2] = this.d[n];
            this.d[n] = q;
        }
    }
}
