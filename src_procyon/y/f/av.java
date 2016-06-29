package y.f;

import java.util.*;
import y.d.*;

class av implements Comparator
{
    public int compare(final Object o, final Object o2) {
        final a a = (a)o;
        final a a2 = (a)o2;
        if (a.c() < a2.c()) {
            return -1;
        }
        if (a.c() > a2.c()) {
            return 1;
        }
        return 0;
    }
}
