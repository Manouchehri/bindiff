package y.f.c;

import java.util.*;
import y.f.*;
import y.c.*;

class f implements Comparator
{
    private final X a;
    private final e b;
    
    f(final e b, final X a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return y.g.e.a(this.b.a(this.a, (q)o), this.b.a(this.a, (q)o2));
    }
}
