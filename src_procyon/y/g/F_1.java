package y.g;

import java.util.*;
import y.c.*;

public abstract class F implements C
{
    private final C a;
    
    protected F(final C a) {
        if (a == null) {
            throw new NullPointerException("delegatingFactory");
        }
        this.a = a;
    }
    
    public void a(final i i, final i j) {
        this.b(i, j);
        this.a.a(i, j);
    }
    
    public void a(final i i, final i j, final Map map, final Map map2) {
        this.a.a(i, j, map, map2);
        this.b(i, j, map, map2);
    }
    
    public q a(final i i, final q q) {
        final q a = this.a.a(i, q);
        if (q != null) {
            this.a(q, a);
        }
        return a;
    }
    
    protected void b(final i i, final i j) {
    }
    
    protected void b(final i i, final i j, final Map map, final Map map2) {
    }
    
    protected void a(final q q, final q q2) {
    }
    
    protected void a(final d d, final d d2) {
    }
    
    public d a(final i i, final q q, final q q2, final d d) {
        final d a = this.a.a(i, q, q2, d);
        if (d != null) {
            this.a(d, a);
        }
        return a;
    }
}
