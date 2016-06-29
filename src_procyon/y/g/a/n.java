package y.g.a;

class n
{
    private o[] a;
    private int b;
    private int c;
    
    public n(final int c) {
        this.a = new o[c + 2];
        this.b = 0;
        this.c = c;
    }
    
    public o a(final double n, final Object o) {
        if (this.b == this.c) {
            this.c += 1024;
            final o[] a = new o[this.c + 2];
            System.arraycopy(this.a, 0, a, 0, this.a.length);
            this.a = a;
        }
        ++this.b;
        final o o2 = new o(n, o, this.b);
        this.a(this.b, o2);
        return o2;
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
    
    public void a(int n, final o o) {
        final boolean a = d.a;
        this.a[0] = o;
        int n2 = n / 2;
        o o2 = this.a[n2];
        while (o2.a > o.a) {
            this.a[n] = o2;
            o2.c = n;
            n = n2;
            n2 >>= 1;
            o2 = this.a[n2];
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        this.a[n] = o;
        o.c = n;
    }
    
    public void b(int n, final o o) {
        final boolean a = d.a;
        int i = n << 1;
        this.a[this.b + 1] = this.a[this.b];
        while (i <= this.b) {
            o o2 = this.a[i];
            if (a) {
                return;
            }
            if (i < this.b && this.a[i + 1].a < o2.a) {
                o2 = this.a[++i];
            }
            if (o.a <= o2.a) {
                break;
            }
            this.a[n] = o2;
            o2.c = n;
            n = i;
            i <<= 1;
            if (a) {
                break;
            }
        }
        this.a[n] = o;
        o.c = n;
    }
    
    public void a(final o o) {
        final o o2 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (o != o2) {
            if (o2.a > o.a) {
                this.b(o.c, o2);
                if (!d.a) {
                    return;
                }
            }
            this.a(o.c, o2);
        }
    }
    
    public void a(final o o, final double a) {
        o.a = a;
        this.a(o.c, o);
    }
    
    public void b(final o o, final double a) {
        o.a = a;
        this.b(o.c, o);
    }
    
    public void c(final o o, final double n) {
        if (n < o.a) {
            this.a(o, n);
            if (!d.a) {
                return;
            }
        }
        this.b(o, n);
    }
    
    public o b() {
        return this.a[1];
    }
    
    public boolean c() {
        return this.b == 0;
    }
}
