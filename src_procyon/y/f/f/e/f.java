package y.f.f.e;

class f
{
    private h[] a;
    private int b;
    
    f(final int n) {
        this.a = new h[n + 2];
        this.b = 0;
    }
    
    public void a(final int a, final h h) {
        ++this.b;
        h.a = a;
        h.d = this.b;
        this.b(this.b, h);
    }
    
    public void a() {
        final int a = y.f.f.e.a.a;
        int i = 1;
        while (i <= this.b) {
            this.a[i] = null;
            ++i;
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.b = 0;
    }
    
    public void b(int n, final h h) {
        final int a = y.f.f.e.a.a;
        this.a[0] = h;
        int n2 = n / 2;
        h h2 = this.a[n2];
        while (h2.a > h.a) {
            this.a[n] = h2;
            h2.d = n;
            n = n2;
            n2 >>= 1;
            h2 = this.a[n2];
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.a[n] = h;
        h.d = n;
    }
    
    public void c(int n, final h h) {
        final int a = y.f.f.e.a.a;
        int i = n << 1;
        this.a[this.b + 1] = this.a[this.b];
        while (i <= this.b) {
            h h2 = this.a[i];
            if (a != 0) {
                return;
            }
            if (i < this.b && this.a[i + 1].a < h2.a) {
                h2 = this.a[++i];
            }
            if (h.a <= h2.a) {
                break;
            }
            this.a[n] = h2;
            h2.d = n;
            n = i;
            i <<= 1;
            if (a != 0) {
                break;
            }
        }
        this.a[n] = h;
        h.d = n;
    }
    
    public void a(final h h) {
        final h h2 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (h != h2) {
            if (h2.a > h.a) {
                this.c(h.d, h2);
                if (y.f.f.e.a.a == 0) {
                    return;
                }
            }
            this.b(h.d, h2);
        }
    }
    
    public void a(final h h, final int a) {
        h.a = a;
        this.b(h.d, h);
    }
    
    public h b() {
        return this.a[1];
    }
    
    public boolean c() {
        return this.b == 0;
    }
}
