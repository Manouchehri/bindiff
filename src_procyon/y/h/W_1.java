package y.h;

import java.util.*;
import y.h.a.*;
import y.g.*;
import y.c.*;

final class W extends hO
{
    private final Iterator a;
    private final boolean b;
    
    W(final bu bu, final v v, final int n, final boolean b) {
        this(bu, b ? v.h(v.e(bu)) : v.i(v.e(bu)), n, b);
    }
    
    W(final bu bu, final int n, final boolean b) {
        this(bu, b ? l.a(bu.o()) : l.b(bu.o()), n, b);
    }
    
    private W(final bu bu, final Iterator a, final int n, final boolean b) {
        super(bu, n);
        this.a = a;
        this.b = b;
    }
    
    void a() {
        final boolean z = fj.z;
        while (this.f.isEmpty() && this.a.hasNext()) {
            final q q = this.a.next();
            if (this.b) {
                this.a(q);
                if (!z) {
                    continue;
                }
            }
            this.b(q);
            if (z) {
                break;
            }
        }
    }
}
