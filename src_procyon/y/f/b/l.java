package y.f.b;

import y.g.*;
import y.c.*;
import java.util.*;

class l
{
    private c a;
    private I b;
    private final j c;
    
    l(final j c, final i i, final c a) {
        this.c = c;
        this.a = a;
        this.b = new I(i);
    }
    
    public void a(final q q) {
        final int a = y.f.b.c.a;
        this.b.a();
        Label_0127: {
            if (q == null || j.a(this.c, q)) {
                final y y = new y();
                final y y2 = new y(this.a.b(q));
                while (!y2.isEmpty()) {
                    final q d = y2.d();
                    y.add(d);
                    if (j.a(this.c, d, this.a) && !j.a(this.c, d)) {
                        y2.addAll(this.a.b(d));
                    }
                    this.b.a(y, true);
                    if (a != 0) {
                        break Label_0127;
                    }
                }
                return;
            }
        }
        this.b.a(q, false);
    }
    
    public void a() {
        this.b.f();
    }
}
