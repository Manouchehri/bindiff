package y.f.i.a;

class W extends Y
{
    private int a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private final long g;
    private long h;
    
    W(final long n, final long f) {
        this.a = 10;
        this.b = 50L;
        this.c = this.b;
        this.e = n;
        this.d = n;
        this.f = f;
        this.g = f - n;
    }
    
    protected boolean a(final long h) {
        if (h != this.c) {
            return false;
        }
        this.h = h;
        final long currentTimeMillis = System.currentTimeMillis();
        final long n = currentTimeMillis - this.d;
        final long max = Math.max(this.a, (this.f - currentTimeMillis) / 2L);
        Label_0092: {
            if (n == 0L) {
                this.b *= max;
                if (ab.a == 0) {
                    break Label_0092;
                }
            }
            this.b = Math.max(1L, max / n * this.b);
        }
        this.c = h + this.b;
        this.d = currentTimeMillis;
        if (currentTimeMillis >= this.f) {
            this.f = currentTimeMillis + this.g;
            return true;
        }
        return false;
    }
}
