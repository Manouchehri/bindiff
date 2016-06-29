package y.f.k;

import java.util.*;
import y.c.*;
import y.g.*;

class r implements Comparator
{
    private final o a;
    
    r(final o a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a.e(((d)o).d()).a(), this.a.e(((d)o2).d()).a());
    }
}
