package y.f.i.a;

class bE
{
    private int a;
    private bD b;
    
    public bE(final int n) {
        this(n, null);
    }
    
    public bE(final int a, final bD b) {
        this.a = a;
        this.b = b;
    }
    
    public int a() {
        return this.a;
    }
    
    public bD b() {
        return this.b;
    }
    
    public boolean c() {
        return this.b != null;
    }
    
    public void a(final bD b) {
        final int a = ab.a;
        if (this.b == null) {
            this.b = b;
            if (a == 0) {
                return;
            }
        }
        if (b != null && this.b.a(b)) {
            final int c = this.b.c();
            final int c2 = b.c();
            final int min = Math.min(c, c2);
            this.a += min;
            if (c2 > min) {
                this.b = new bD(bD.c(b), bD.d(b), bD.b(b), c2 - min);
                if (a == 0) {
                    return;
                }
            }
            if (c > min) {
                this.b.a(c - min);
                if (a == 0) {
                    return;
                }
            }
            this.b = null;
        }
    }
}
