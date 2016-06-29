package y.h;

import y.d.*;

final class dp implements fO
{
    private dp() {
    }
    
    public fP a(final t t, final t t2) {
        return new dq(this, t, t2);
    }
    
    public fP a(final fj fj, final t t) {
        final t t2 = new t(t.a() - fj.getCenterX(), t.b() - fj.getCenterY());
        return new dq(this, t2, t2);
    }
    
    public t a(final eU eu, final fP fp) {
        final dq dq = (dq)fp;
        final fj b = eu.b();
        return new t(b.getCenterX() + dq.a, b.getCenterY() + dq.b);
    }
    
    dp(final dk dk) {
        this();
    }
}
