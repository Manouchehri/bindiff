package y.f.c.a;

import y.g.*;
import y.f.*;

class aj extends ao
{
    Object a;
    Object b;
    
    aj(final B b, final Object a, final Object b2) {
        super(b);
        this.a = a;
        this.b = b2;
    }
    
    public Object g() {
        return this.a;
    }
    
    public Object h() {
        return this.b;
    }
    
    public void b(final boolean b) {
        Label_0117: {
            if (this.i != b) {
                if (this.i) {
                    final Object a = this.a;
                    this.a = ((this.b != null) ? ((am)this.b).b : null);
                    this.b = ((a != null) ? ((am)a).b : null);
                    if (!N.x) {
                        break Label_0117;
                    }
                }
                final Object a2 = this.a;
                this.a = ((this.b != null) ? am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", this.b) : null);
                this.b = ((a2 != null) ? am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", a2) : null);
            }
        }
        super.b(b);
    }
    
    public A a(final boolean b, final aE ae) {
        if (this.i()) {
            final aK ak = new aK(this.b(), this.k(), this.h(), this.g(), b ? null : ae, this.d(), b ? ae : null, this.f());
            ak.b(true);
            if (!N.x) {
                return ak;
            }
        }
        return new aK(this.b(), this.k(), this.g(), this.h(), b ? ae : null, this.d(), b ? null : ae, this.f());
    }
}
