package y.h.a;

import y.g.*;
import y.d.*;
import y.h.*;

public class k extends p
{
    private final bu a;
    private q b;
    
    public k(final bu a) {
        this.b = new q(0.0, 0.0);
        this.a = a;
    }
    
    public Object b(final Object o) {
        final gt sizeConstraintProvider = this.a.t((y.c.q)o).getSizeConstraintProvider();
        if (sizeConstraintProvider != null) {
            return sizeConstraintProvider.getMinimumSize();
        }
        return this.b;
    }
}
