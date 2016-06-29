package y.d.b;

import java.util.*;
import y.d.*;
import y.g.*;

class q implements Comparator
{
    public int compare(final Object o, final Object o2) {
        if (o == o2) {
            return 0;
        }
        return e.a(((m)o).f(), ((m)o2).f());
    }
}
