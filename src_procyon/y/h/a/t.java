package y.h.a;

import java.util.*;
import y.c.*;

public class t extends EventObject
{
    private byte a;
    private Object b;
    private Object c;
    
    public t(final v v, final byte a, final i c, final Object b) {
        super(v);
        this.a = a;
        this.c = c;
        this.b = b;
    }
    
    public t(final v v, final byte a, final Object c, final Object b) {
        super(v);
        this.a = a;
        this.c = c;
        this.b = b;
    }
    
    public byte a() {
        return this.a;
    }
    
    public Object b() {
        return this.b;
    }
}
