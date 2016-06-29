package y.f;

import java.util.*;
import y.c.*;

public class ay
{
    public static final Object a;
    static final Comparator b;
    private List c;
    private long d;
    
    public ay() {
        this.c = new ArrayList();
    }
    
    public void a(final ax ax) {
        this.a(ax, 1);
    }
    
    public void a(final ax ax, final int n) {
        if (n > 0) {
            this.d += n;
            this.c.add(new aB(ax, n));
        }
    }
    
    public Iterator a() {
        return this.c.iterator();
    }
    
    public az b() {
        return new aD(this, this.c);
    }
    
    protected double a(final aA aa, final d d, final boolean b) {
        return -aa.a().f();
    }
    
    static {
        a = "y.layout.PortCandidateSet.DP_KEY";
        b = new aC();
    }
}
