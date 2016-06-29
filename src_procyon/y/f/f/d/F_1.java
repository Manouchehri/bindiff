package y.f.f.d;

import y.f.f.b.*;
import java.util.*;
import y.c.*;

public class F extends e
{
    public void b() {
        this.d();
        super.b();
        this.i = false;
    }
    
    protected void d() {
        final boolean p = o.p;
        final boolean[] p2 = this.b.p();
        final y.c.e p3 = this.d.p();
        while (p3.f()) {
            d d = p3.a();
            Label_0267: {
                if (p2[d.b()]) {
                    d d2 = this.c.j(this.b.a(d));
                    if (this.b.c(d2)) {
                        d2 = this.b.a(d2);
                    }
                    if (this.b.c(d)) {
                        d = this.b.a(d);
                    }
                    final ArrayList list = (ArrayList)this.e.b(d);
                    final ArrayList list2 = (ArrayList)this.e.b(d2);
                    this.e.a(d, null);
                    if (list2 != null && list != null) {
                        if (this.b.c(p3.a())) {
                            list2.addAll(list);
                            this.e.a(d2, list2);
                            if (!p) {
                                break Label_0267;
                            }
                        }
                        list.addAll(list2);
                        this.e.a(d2, list);
                        if (!p) {
                            break Label_0267;
                        }
                    }
                    if (list2 != null) {
                        this.e.a(d2, list2);
                        if (!p) {
                            break Label_0267;
                        }
                    }
                    if (list != null) {
                        this.e.a(d2, list);
                    }
                }
            }
            p3.g();
            if (p) {
                break;
            }
        }
    }
}
