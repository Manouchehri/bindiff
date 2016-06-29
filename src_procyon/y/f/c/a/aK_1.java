package y.f.c.a;

import y.c.*;
import y.f.*;
import java.util.*;
import y.g.*;

class aK extends ak
{
    Object k;
    Object l;
    
    aK(final d d, final B b, final Object k, final Object l, final aE ae, final Collection collection, final aE ae2, final Collection collection2) {
        super(d, b, ae, collection, ae2, collection2);
        this.k = k;
        this.l = l;
    }
    
    public Object g() {
        return this.k;
    }
    
    public Object h() {
        return this.l;
    }
    
    public void b(final boolean b) {
        Label_0117: {
            if (this.i != b) {
                if (this.i) {
                    final Object k = this.k;
                    this.k = ((this.l != null) ? ((am)this.l).b : null);
                    this.l = ((k != null) ? ((am)k).b : null);
                    if (!N.x) {
                        break Label_0117;
                    }
                }
                final Object i = this.k;
                this.k = ((this.l != null) ? am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", this.l) : null);
                this.l = ((i != null) ? am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", i) : null);
            }
        }
        super.b(b);
    }
    
    public A a(final boolean b, final aE ae) {
        final boolean x = N.x;
        if (b) {
            if (this.i) {
                this.b = ae;
                if (!x) {
                    return this;
                }
            }
            this.a = ae;
            if (!x) {
                return this;
            }
        }
        if (this.i) {
            this.a = ae;
            if (!x) {
                return this;
            }
        }
        this.b = ae;
        return this;
    }
}
