package y.h;

import y.c.*;

class hH extends d
{
    aB l;
    
    protected hH(final bu bu, final q q, final d d, final q q2, final d d2, final int n, final int n2, final aB l) {
        super(bu, q, d, q2, d2, n, n2);
        if (l != null) {
            (this.l = l).bindEdge(this);
        }
    }
    
    public d a(final i i, final q q, final q q2) {
        if (i instanceof bu) {
            return new hH((bu)i, q, null, q2, null, 0, 0, this.l.createCopy());
        }
        return super.a(i, q, q2);
    }
    
    protected void f() {
        super.f();
        if (this.l != null) {
            this.l.setDirty();
        }
    }
}
