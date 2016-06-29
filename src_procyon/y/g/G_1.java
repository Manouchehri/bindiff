package y.g;

import y.c.*;

public class G extends D
{
    public G(final C c, final Object o) {
        super(c, o);
    }
    
    protected b a(final i i) {
        return M.c();
    }
    
    protected void a(final q q, final q q2) {
        super.a(q, q2);
        final c c = q.e().c(this.a);
        if (c != null) {
            final Object a = this.a(this.a, q, q2, c.b(q));
            if (a != null) {
                this.b(q2.e()).a(q2, a);
            }
        }
    }
    
    protected void a(final d d, final d d2) {
        super.a(d, d2);
        final c c = d.a().c(this.a);
        if (c != null) {
            final Object a = this.a(this.a, d, d2, c.b(d));
            if (a != null) {
                this.b(d2.a()).a(d2, a);
            }
        }
    }
    
    protected Object a(final Object o, final q q, final q q2, final Object o2) {
        return o2;
    }
    
    protected Object a(final Object o, final d d, final d d2, final Object o2) {
        return o2;
    }
}
