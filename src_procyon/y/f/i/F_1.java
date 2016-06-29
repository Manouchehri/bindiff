package y.f.i;

import y.g.*;

class F implements Comparable
{
    final boolean a;
    final double b;
    final double c;
    final double d;
    int e;
    final J f;
    
    F(final boolean a, final double b, final double n, final double n2, final J f) {
        this.a = a;
        this.f = f;
        this.b = b;
        if (n < n2) {
            this.c = n;
            this.d = n2;
            if (v.f == 0) {
                return;
            }
        }
        this.c = n2;
        this.d = n;
    }
    
    public int compareTo(final Object o) {
        final F f = (F)o;
        final int a = y.g.e.a(this.b, f.b);
        if (a != 0) {
            return a;
        }
        if (this.a) {
            return f.a ? 0 : -1;
        }
        return f.a ? 1 : 0;
    }
    
    public String toString() {
        return "Event{open=" + this.a + ", x=" + this.b + ", yBegin=" + this.c + ", yEnd=" + this.d + ", openEventCount=" + this.e + ", graphicalObject=" + this.f + '}';
    }
}
