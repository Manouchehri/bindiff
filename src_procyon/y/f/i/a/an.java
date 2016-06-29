package y.f.i.a;

import y.f.*;

class an
{
    private int a;
    private int b;
    
    an(final ai ai, final ai ai2, final ai ai3) {
        final int a = this.a(ai2);
        final int a2 = this.a(a, 1);
        this.b = a2 * this.b(this.a(a2, ai, ai3));
        final int a3 = this.a(a, -1);
        this.a = a3 * this.b(this.a(a3, ai, ai3));
    }
    
    private int a(final ai ai) {
        final y h = ai.h();
        if (y.b == h || y.a == h) {
            return 1;
        }
        return -1;
    }
    
    private ai a(final int n, final ai ai, final ai ai2) {
        return (n > 0) ? ai2 : ai;
    }
    
    private int a(final int n, final int n2) {
        return n * n2;
    }
    
    private int b(final ai ai) {
        if (ai == null) {
            return 0;
        }
        final y h = ai.h();
        if (y.d == h || y.a == h) {
            return -1;
        }
        return 1;
    }
    
    public int a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
}
