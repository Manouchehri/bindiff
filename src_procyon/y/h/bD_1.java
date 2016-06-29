package y.h;

import y.g.*;
import y.c.*;
import java.util.*;
import y.f.*;

public class bD implements m, C
{
    private static final C a;
    
    public i a(final Object o) {
        if (o instanceof bu) {
            return new bu((bu)o);
        }
        return new bu();
    }
    
    public q a(final i i, final Object o) {
        if (o instanceof q) {
            final q q = (q)o;
            if (q.e() instanceof bu) {
                return ((bu)i).a(this.a(((bu)q.e()).t(q)));
            }
        }
        return i.d();
    }
    
    protected aB a(final aB ab) {
        return ab.createCopy();
    }
    
    public q a(final i i, final q q) {
        final i e = q.e();
        if (e instanceof bu) {
            return ((bu)i).a(this.a(((bu)e).t(q)));
        }
        return bD.a.a(i, q);
    }
    
    protected fj a(final fj fj) {
        return fj.createCopy();
    }
    
    public d a(final i i, final q q, final q q2, final d d) {
        final i a = d.a();
        if (a instanceof bu) {
            return ((bu)i).a(q, q2, this.a(((bu)a).i(d)));
        }
        return bD.a.a(i, q, q2, d);
    }
    
    public void a(final i i, final i j) {
    }
    
    public void a(final i i, final i j, final Map map, final Map map2) {
    }
    
    static {
        a = new Y();
    }
}
