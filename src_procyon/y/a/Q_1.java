package y.a;

import y.c.*;

class Q
{
    N[] a;
    M b;
    
    public Q(final i i) {
        final boolean a = h.a;
        this.a = new N[i.e()];
        this.b = new M();
        final x o = i.o();
        while (o.f()) {
            this.a[o.e().d()] = this.b.a(o.e());
            o.g();
            if (a) {
                break;
            }
        }
    }
    
    public void a(final q q, final q q2) {
        this.b.a(this.b(q), this.b(q2));
    }
    
    public q a(final q q) {
        return this.a(this.b.a(this.b(q)));
    }
    
    public boolean b(final q q, final q q2) {
        return this.a(q) == this.a(q2);
    }
    
    private N b(final q q) {
        return this.a[q.d()];
    }
    
    private q a(final N n) {
        if (n != null) {
            return (q)this.b.b(n);
        }
        return null;
    }
}
