package y.d.a;

import java.util.*;
import y.g.*;

class f implements Comparator, g
{
    Comparator a;
    private final b b;
    
    f(final b b) {
        this.b = b;
        this.a = y.d.a.b.a(this.b).b();
    }
    
    public int compare(final Object o, final Object o2) {
        if (o == o2) {
            return 0;
        }
        return this.a.compare(((e)o2).g, ((e)o).g);
    }
}
