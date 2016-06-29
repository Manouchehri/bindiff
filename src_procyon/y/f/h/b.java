package y.f.h;

import java.util.*;
import y.c.*;
import y.g.*;

class b implements Comparator
{
    private final f a;
    private final a b;
    
    b(final a b, final f a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a.indexOf(o), this.a.indexOf(o2));
    }
}
