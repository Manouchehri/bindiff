package y.f.i.a;

import y.c.*;
import y.d.*;

class bU
{
    private final d a;
    private final int b;
    private final m[] c;
    
    private bU(final d a, final m[] c, final int b) {
        this.a = a;
        this.c = c;
        this.b = b;
    }
    
    static d a(final bU bu) {
        return bu.a;
    }
    
    static m[] b(final bU bu) {
        return bu.c;
    }
    
    static int c(final bU bu) {
        return bu.b;
    }
    
    bU(final d d, final m[] array, final int n, final bT bt) {
        this(d, array, n);
    }
}
