package y.f.f.a;

import java.util.*;
import y.f.*;

class b implements Comparator
{
    public int compare(final Object o, final Object o2) {
        final S s = (S)o;
        final S s2 = (S)o2;
        final aG f = s.f();
        final aG f2 = s2.f();
        final int a = this.a(f);
        final int a2 = this.a(f2);
        if (a < a2) {
            return -1;
        }
        if (a > a2) {
            return 1;
        }
        return 0;
    }
    
    private int a(final aG ag) {
        if (ag.i()) {
            return 0;
        }
        if (!ag.i() && !ag.j()) {
            return 2;
        }
        return 1;
    }
}
