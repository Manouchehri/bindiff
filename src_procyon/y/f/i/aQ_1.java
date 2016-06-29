package y.f.i;

import y.c.*;

class aQ
{
    d[] a;
    q[] b;
    int c;
    int d;
    private i e;
    
    public aQ(final i e) {
        this.e = e;
        this.a = new d[200];
        this.c = 0;
        this.b = new q[200];
        this.d = 0;
    }
    
    public d a(final q q, final q q2) {
        if (this.c == 0) {
            return this.e.a(q, q2);
        }
        final d[] a = this.a;
        final int c = this.c - 1;
        this.c = c;
        final d d = a[c];
        this.e.a(d, q, q2);
        this.e.b(d);
        return d;
    }
    
    public void a(final d d) {
        this.e.a(d);
        if (this.c >= this.a.length) {
            final d[] a = new d[2 * this.c];
            System.arraycopy(this.a, 0, a, 0, this.a.length);
            this.a = a;
        }
        this.a[this.c++] = d;
    }
    
    public q a() {
        if (this.d == 0) {
            return this.e.d();
        }
        final q[] b = this.b;
        final int d = this.d - 1;
        this.d = d;
        final q q = b[d];
        this.e.b(q);
        return q;
    }
    
    public void a(final q q) {
        final int f = v.f;
    Label_0058:
        while (true) {
            while (q.b() > 0) {
                this.a(q.g());
                if (f != 0) {
                    if (this.d >= this.b.length) {
                        final q[] b = new q[2 * this.d];
                        System.arraycopy(this.b, 0, b, 0, this.b.length);
                        this.b = b;
                    }
                    this.b[this.d++] = q;
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            while (q.c() > 0) {
                this.a(q.f());
                if (f != 0) {
                    continue Label_0058;
                }
                if (f != 0) {
                    break;
                }
            }
            this.e.a(q);
            continue Label_0058;
        }
    }
}
