package y.h;

final class fB
{
    final fC a;
    final double b;
    final double c;
    private double d;
    private boolean e;
    
    fB(final fC a, final double b, final double d) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.c = d - b;
    }
    
    double a() {
        return this.d;
    }
    
    double a(final double n) {
        if ((n < 0.0 && this.c > 0.0) || (n > 0.0 && this.c < 0.0)) {
            final double b = this.b;
            if (!fj.z) {
                return b;
            }
        }
        return this.b + n;
    }
    
    void b(final double n) {
        final double a = this.a(n);
        if (this.e) {
            if (this.d == a) {
                return;
            }
            this.a.b();
            if (!fj.z) {
                return;
            }
        }
        this.d = a;
        this.e = true;
    }
}
