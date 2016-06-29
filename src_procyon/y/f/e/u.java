package y.f.e;

import y.g.*;
import java.util.*;
import y.f.e.a.*;

class u extends p
{
    private final HashSet a;
    private final ay b;
    private final q d;
    
    u(final q d, final HashSet a, final ay b) {
        this.d = d;
        this.a = a;
        this.b = b;
    }
    
    public Object b(final Object o) {
        if (this.a.contains(o)) {
            return this.b;
        }
        return null;
    }
}
