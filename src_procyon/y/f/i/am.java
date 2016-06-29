package y.f.i;

import y.c.*;

class am
{
    public d a;
    public double b;
    public byte c;
    public boolean d;
    
    am(final d a, final double b, final byte c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public String toString() {
        return "[e=" + this.a + "; coord=" + this.b + "; side=" + this.c + "; sourceEnd=" + this.d + "]";
    }
}
