package y.f.i.a;

import java.util.*;
import y.c.*;

class bw
{
    private final bs a;
    
    bw(final bs a) {
        this.a = a;
    }
    
    public int a(final int n) {
        return n;
    }
    
    public int b(final int n) {
        return n;
    }
    
    public List c(final int n) {
        return this.a(n, true);
    }
    
    public List d(final int n) {
        return this.a(n, false);
    }
    
    private List a(final int n, final boolean b) {
        final int a = ab.a;
        List<Integer> list = null;
        final q q = bs.a(this.a)[this.a(n)];
        final e j = q.j();
        while (j.f()) {
            final d d = (d)j.d();
            if (a != 0) {
                return list;
            }
            final int a2 = bs.b(this.a).a((d.c() != q) ? d.c() : d.d());
            final int b2 = this.b(a2);
            if ((b && b2 < n) || (!b && b2 > n)) {
                if (list == null) {
                    list = (List<Integer>)new D();
                }
                list.add(new Integer(a2));
            }
            j.g();
            if (a != 0) {
                break;
            }
        }
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return list;
    }
}
