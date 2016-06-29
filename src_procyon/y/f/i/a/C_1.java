package y.f.i.a;

import y.g.*;
import java.util.*;

class C extends p
{
    private final HashSet a;
    private final y b;
    
    C(final y b, final HashSet a) {
        this.b = b;
        this.a = a;
    }
    
    public boolean d(final Object o) {
        return this.a.contains(o);
    }
}
