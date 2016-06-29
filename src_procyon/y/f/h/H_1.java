package y.f.h;

import y.c.*;

public class H implements x
{
    x a;
    private int b;
    private G c;
    
    public H(final x a) {
        this.a = null;
        this.b = 0;
        if (a == null) {
            throw new IllegalArgumentException("You must specify a handler for non-planar graphs!");
        }
        this.a = a;
        this.c = new G();
    }
    
    public void a(final D d) {
        if (this.c.a(d)) {
            this.b = 1;
            if (!N.d) {
                return;
            }
        }
        this.a.a(d);
        this.b = 2;
    }
    
    public f c_() {
        if (this.b == 0) {
            throw new RuntimeException("Invalid Execution Order: call 'createPlanarization' first!");
        }
        if (this.b == 1) {
            return this.c.a();
        }
        return this.a.c_();
    }
}
