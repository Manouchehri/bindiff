package y.h;

import java.util.*;
import y.c.*;

final class hQ extends hO
{
    private final Iterator a;
    private final boolean b;
    
    hQ(final bu bu, final Iterator a, final int n, final boolean b) {
        super(bu, n);
        this.a = a;
        this.b = b;
    }
    
    void a() {
        final boolean z = fj.z;
        while (this.f.isEmpty() && this.a.hasNext()) {
            final q next = this.a.next();
            if (next instanceof d) {
                if (this.b) {
                    this.a((d)next);
                    if (!z) {
                        continue;
                    }
                }
                this.b((d)next);
                if (!z) {
                    continue;
                }
            }
            if (next instanceof q) {
                if (this.b) {
                    this.a(next);
                    if (!z) {
                        continue;
                    }
                }
                this.b(next);
                if (z) {
                    break;
                }
                continue;
            }
        }
    }
}
