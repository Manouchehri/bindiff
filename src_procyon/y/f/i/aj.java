package y.f.i;

import y.c.*;

class aj
{
    public final d a;
    public double b;
    public final double c;
    public final double d;
    
    aj(final d a, final double b, final double n, final double n2) {
        this.a = a;
        this.b = b;
        final double max = Math.max(n, n2);
        this.c = Math.min(n, n2);
        this.d = max;
    }
    
    private void a(final double b) {
        this.b = b;
    }
    
    public String toString() {
        return "[e=" + this.a + "; coord=" + this.b + "; from=" + this.c + "; to=" + this.d + "]";
    }
    
    static void a(final aj aj, final double n) {
        aj.a(n);
    }
}
