package y.f.i;

import y.d.*;

class e
{
    Object a;
    t b;
    t c;
    int d;
    
    e(final Object a, final t b, final t c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    byte a(final double n) {
        if (this.b.b < n) {
            if (this.c.b < n) {
                return 0;
            }
            return 1;
        }
        else {
            if (this.c.b < n) {
                return 2;
            }
            return 3;
        }
    }
}
