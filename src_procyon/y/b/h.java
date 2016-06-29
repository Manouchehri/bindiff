package y.b;

final class h
{
    private final d a;
    private long b;
    private long c;
    private final e d;
    
    h(final e d, final d a) {
        this.d = d;
        this.a = a;
        this.b = -1L;
        this.c = -1L;
    }
    
    boolean a() {
        if (this.c < 0L) {
            final long preferredDuration = this.a.preferredDuration();
            this.b = ((0L < preferredDuration) ? ((long)(preferredDuration / e.a(this.d))) : 0L);
            this.c = System.currentTimeMillis();
        }
        final double n = (0L < this.b) ? ((System.currentTimeMillis() - this.c) / this.b) : 1.0;
        if (n < 1.0) {
            this.a.calcFrame(n);
            return false;
        }
        this.a.calcFrame(1.0);
        this.a.disposeAnimation();
        return true;
    }
}
