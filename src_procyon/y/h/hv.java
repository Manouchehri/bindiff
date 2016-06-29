package y.h;

import java.awt.*;

class hv extends Key
{
    private final Class a;
    private final String b;
    
    hv(final int n, final Class a, final String b) {
        super(n);
        this.a = a;
        this.b = b;
    }
    
    public boolean isCompatibleValue(final Object o) {
        return o == null || this.a.isInstance(o);
    }
    
    public String toString() {
        return this.b;
    }
}
