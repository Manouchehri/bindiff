package y.b;

import java.util.*;

public class a extends EventObject
{
    private int a;
    
    public a(final Object o, final int a) {
        super(o);
        this.a = a;
    }
    
    public int a() {
        return this.a;
    }
}
