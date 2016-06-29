package y.f.g;

import java.util.*;

class s implements Comparator
{
    private s() {
    }
    
    public int compare(final Object o, final Object o2) {
        final u u = (u)o;
        final u u2 = (u)o2;
        if (u.b() && !u2.b()) {
            return -1;
        }
        if (!u.b() && u2.b()) {
            return 1;
        }
        final int l = u.l();
        final int i = u2.l();
        if (l < i) {
            return -1;
        }
        if (l > i) {
            return 1;
        }
        return 0;
    }
    
    s(final o o) {
        this();
    }
}
