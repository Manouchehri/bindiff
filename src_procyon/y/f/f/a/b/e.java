package y.f.f.a.b;

import java.util.*;
import y.c.*;

class e implements Comparator
{
    private f a;
    
    e(final f a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return y.g.e.a(this.a.indexOf(o), this.a.indexOf(o2));
    }
}
