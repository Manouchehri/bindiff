package y.f.f.d;

class I
{
    private u[] a;
    private int b;
    
    public I(final int n) {
        this.a = new u[n + 2];
        this.b = 0;
    }
    
    public void a(final int a, final u u) {
        ++this.b;
        u.a = a;
        u.d = this.b;
        this.b(this.b, u);
    }
    
    public void a() {
        final boolean p = o.p;
        int i = 1;
        while (i <= this.b) {
            this.a[i] = null;
            ++i;
            if (p) {
                return;
            }
            if (p) {
                break;
            }
        }
        this.b = 0;
    }
    
    public void b(int n, final u u) {
        final boolean p2 = o.p;
        this.a[0] = u;
        int n2 = n / 2;
        u u2 = this.a[n2];
        while (u2.a > u.a) {
            this.a[n] = u2;
            u2.d = n;
            n = n2;
            n2 >>= 1;
            u2 = this.a[n2];
            if (p2) {
                return;
            }
            if (p2) {
                break;
            }
        }
        this.a[n] = u;
        u.d = n;
    }
    
    public void c(int n, final u u) {
        final boolean p2 = o.p;
        int i = n << 1;
        this.a[this.b + 1] = this.a[this.b];
        while (i <= this.b) {
            u u2 = this.a[i];
            if (p2) {
                return;
            }
            if (i < this.b && this.a[i + 1].a < u2.a) {
                u2 = this.a[++i];
            }
            if (u.a <= u2.a) {
                break;
            }
            this.a[n] = u2;
            u2.d = n;
            n = i;
            i <<= 1;
            if (p2) {
                break;
            }
        }
        this.a[n] = u;
        u.d = n;
    }
    
    public void a(final u u) {
        final u u2 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (u != u2) {
            if (u2.a > u.a) {
                this.c(u.d, u2);
                if (!o.p) {
                    return;
                }
            }
            this.b(u.d, u2);
        }
    }
    
    public void a(final u u, final int a) {
        u.a = a;
        this.b(u.d, u);
    }
    
    public u b() {
        return this.a[1];
    }
    
    public boolean c() {
        return this.b == 0;
    }
}
