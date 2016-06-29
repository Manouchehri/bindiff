package y.h;

import y.g.*;
import java.util.*;
import y.c.*;

class hW extends p
{
    private final HashSet a;
    private final hV b;
    
    hW(final hV b, final HashSet a) {
        this.b = b;
        this.a = a;
    }
    
    public boolean d(final Object o) {
        final d d = (d)o;
        return !this.a.contains(d.c()) && !this.a.contains(d.d());
    }
}
