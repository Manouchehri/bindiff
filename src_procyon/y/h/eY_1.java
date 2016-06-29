package y.h;

import java.util.*;

public final class eY
{
    final Map a;
    final Set b;
    final fe c;
    
    private eY() {
        this.a = new HashMap();
        this.b = Collections.unmodifiableSet(this.a.keySet());
        this.c = new fe("DEFAULT");
    }
    
    fe a() {
        return this.c;
    }
    
    eY(final eV ev) {
        this();
    }
}
