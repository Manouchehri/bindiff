package y.h;

import y.g.*;
import java.util.*;
import y.c.*;

class hZ implements C
{
    private C a;
    private Map b;
    private Map c;
    private Map d;
    private f e;
    
    hZ(final C a, final f e, final Map b, final Map c, final Map d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public d a(final i i, final q q, final q q2, final d d) {
        final d a = this.a.a(i, q, q2, d);
        this.d.put(a, d);
        this.e.add(a);
        return a;
    }
    
    public q a(final i i, final q q) {
        final q a = this.a.a(i, q);
        this.b.put(a, q);
        this.c.put(q, a);
        return a;
    }
    
    public void a(final i i, final i j, final Map map, final Map map2) {
        this.a.a(i, j, map, map2);
    }
    
    public void a(final i i, final i j) {
        this.a.a(i, j);
    }
}
