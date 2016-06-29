package y.d.b;

import java.util.*;
import y.d.*;

class p implements Comparator
{
    public int compare(final Object o, final Object o2) {
        if (o == o2) {
            return 0;
        }
        final t t = (t)o;
        final t t2 = (t)o2;
        if (t.a() < t2.a()) {
            return -1;
        }
        if (t.a() > t2.a()) {
            return 1;
        }
        if (t.b() < t2.b()) {
            return -1;
        }
        if (t.b() > t2.b()) {
            return 1;
        }
        return 0;
    }
}
