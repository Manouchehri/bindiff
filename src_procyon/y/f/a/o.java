package y.f.a;

import y.d.*;
import y.c.*;

class o implements g
{
    private D a;
    private final j b;
    
    o(final j b) {
        this.b = b;
        this.a = new D();
    }
    
    public D a() {
        return this.a;
    }
    
    public void a(final Object o, final Object o2) {
        this.a.add(new p(this.b, ((m)o).a(), ((m)o2).a()));
    }
}
