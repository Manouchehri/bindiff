package y.d.b;

import java.util.*;
import y.g.*;

class i implements Comparator, g
{
    private final d a;
    
    i(final d a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return this.a.j(o, o2);
    }
}
