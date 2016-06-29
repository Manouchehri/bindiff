package y.h;

import y.g.*;
import y.c.*;

public class fk extends p implements c
{
    private fl a;
    
    public fk(final bu bu, final boolean b) {
        this(bu, true, b);
    }
    
    public fk(final bu bu, final boolean b, final boolean b2) {
        if (bu == null) {
            throw new NullPointerException();
        }
        this.a = new fl(bu, b, b2);
    }
    
    public Object b(final Object o) {
        if (!(o instanceof d)) {
            return null;
        }
        this.a.c = (d)o;
        return this.a;
    }
}
