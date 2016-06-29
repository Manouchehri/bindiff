package y.h;

import java.util.*;
import y.c.*;

public class ce extends EventObject
{
    private Object a;
    
    public ce(final bu bu, final Object a) {
        super(bu);
        this.a = a;
    }
    
    public boolean a() {
        return this.a instanceof q;
    }
    
    public boolean b() {
        return this.a instanceof d;
    }
    
    public boolean c() {
        return this.a instanceof x;
    }
    
    public Object d() {
        return this.a;
    }
    
    public bu e() {
        return (bu)this.getSource();
    }
}
