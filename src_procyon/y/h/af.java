package y.h;

import y.h.a.*;
import java.util.*;

abstract class af extends hO
{
    final v a;
    BitSet b;
    ArrayList c;
    
    af(final bu bu, final v a, final int n) {
        super(bu, n);
        this.a = a;
    }
    
    void c() {
        this.f = new ArrayList();
        this.c = new ArrayList();
        this.b = new BitSet(this.d.f());
        this.b();
    }
    
    void a() {
        final boolean z = fj.z;
        while (this.f.isEmpty() && !this.c.isEmpty()) {
            final int n = this.c.size() - 1;
            if (((am)this.c.get(n)).a()) {
                this.c.remove(n);
                if (z) {
                    break;
                }
                continue;
            }
        }
    }
    
    abstract void b();
}
