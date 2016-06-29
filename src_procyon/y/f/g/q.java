package y.f.g;

import y.c.*;
import y.d.*;

class q
{
    final int a;
    final int b;
    final int c;
    final D d;
    
    private q(final t t, final int c) {
        this.a = (int)t.a;
        this.b = (int)t.b;
        this.c = c;
        this.d = new D();
    }
    
    q(final t t, final int n, final u u) {
        this(t, n);
        this.d.add(u);
    }
    
    q(final t t, final int n, final u u, final u u2) {
        this(t, n);
        this.d.add(u);
        this.d.add(u2);
    }
}
