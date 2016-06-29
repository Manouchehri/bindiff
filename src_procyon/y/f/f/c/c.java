package y.f.f.c;

import java.util.*;

public class c implements Comparator
{
    private final b a;
    
    public c(final b a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        if (d.a() < d2.a()) {
            return -1;
        }
        if (d.a() > d2.a()) {
            return 1;
        }
        if (d.b() == 1 && d2.b() == 0) {
            return 1;
        }
        if (d.b() == 0 && d2.b() == 1) {
            return -1;
        }
        if (d.c().i() < d2.c().i()) {
            return -1;
        }
        if (d.c().i() > d2.c().i()) {
            return 1;
        }
        return 0;
    }
}
