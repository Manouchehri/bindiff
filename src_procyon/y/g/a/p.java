package y.g.a;

class p
{
    private q[] a;
    private int b;
    private int c;
    
    public p(final int c) {
        this.a = new q[c + 2];
        this.b = 0;
        this.c = c;
    }
    
    public q a(final int n, final Object o) {
        if (this.b == this.c) {
            this.c += 1024;
            final q[] a = new q[this.c + 2];
            System.arraycopy(this.a, 0, a, 0, this.a.length);
            this.a = a;
        }
        ++this.b;
        final q q = new q(n, o, this.b);
        this.a(this.b, q);
        return q;
    }
    
    public void a() {
        final boolean a = d.a;
        int i = 1;
        while (i <= this.b) {
            this.a[i] = null;
            ++i;
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        this.b = 0;
    }
    
    public void a(int n, final q q) {
        final boolean a = d.a;
        this.a[0] = q;
        int n2 = n / 2;
        q q2 = this.a[n2];
        while (q2.a > q.a) {
            this.a[n] = q2;
            q2.c = n;
            n = n2;
            n2 >>= 1;
            q2 = this.a[n2];
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        this.a[n] = q;
        q.c = n;
        this.a[0] = null;
    }
    
    public void b(int n, final q q) {
        final boolean a = d.a;
        int i = n << 1;
        this.a[this.b + 1] = this.a[this.b];
        while (i <= this.b) {
            q q2 = this.a[i];
            if (a) {
                return;
            }
            if (i < this.b && this.a[i + 1].a < q2.a) {
                q2 = this.a[++i];
            }
            if (q.a <= q2.a) {
                break;
            }
            this.a[n] = q2;
            q2.c = n;
            n = i;
            i <<= 1;
            if (a) {
                break;
            }
        }
        this.a[n] = q;
        q.c = n;
        this.a[this.b + 1] = null;
    }
    
    public void a(final q q) {
        final q q2 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (q != q2) {
            if (q2.a > q.a) {
                this.b(q.c, q2);
                if (!d.a) {
                    return;
                }
            }
            this.a(q.c, q2);
        }
    }
    
    public void a(final q q, final int a) {
        q.a = a;
        this.a(q.c, q);
    }
    
    public void b(final q q, final int a) {
        q.a = a;
        this.b(q.c, q);
    }
    
    public void c(final q q, final int n) {
        if (n < q.a) {
            this.a(q, n);
            if (!d.a) {
                return;
            }
        }
        this.b(q, n);
    }
    
    public q b() {
        return this.a[1];
    }
    
    public boolean c() {
        return this.b == 0;
    }
}
