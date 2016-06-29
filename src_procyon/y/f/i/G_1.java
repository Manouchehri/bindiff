package y.f.i;

import y.c.*;

class G extends J
{
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    
    G(final double b, final double c, final double d, final double e) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public String toString() {
        return "EdgeObject{}";
    }
    
    F a(final boolean b, final double n) {
        return new F(b, n, Math.min(this.c, this.e), Math.max(this.c, this.e), this);
    }
    
    double a(final d d, final double n, final double n2, final double n3, final E e) {
        if (n3 < this.c && n3 < this.e) {
            return 0.0;
        }
        if (n2 > this.c && n2 > this.e) {
            return 0.0;
        }
        final double b = e.b();
        if (this.d != this.b) {
            final double n4 = this.c + (this.e - this.c) / (this.d - this.b) * (n - this.b);
            return (n4 <= n3 && n4 >= n2) ? b : 0.0;
        }
        final double d2 = e.d();
        if (this.e > this.c) {
            return (n2 <= this.e && n3 >= this.c) ? d2 : 0.0;
        }
        return (n2 <= this.c && n3 >= this.e) ? d2 : 0.0;
    }
}
