package y.f.a;

import y.d.*;
import y.c.*;

class d implements g
{
    private boolean a;
    private double b;
    private double c;
    private A d;
    
    d(final double b, final double c, final A d) {
        this.a = false;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public boolean a() {
        return this.a;
    }
    
    public void a(final Object o, final Object o2) {
        final e e = (e)o;
        final e e2 = (e)o2;
        if (e.b() != e2.b() && (this.d.d(e.b()) || this.d.d(e2.b()))) {
            final double b = t.b(e.c(), e2.c());
            if (e.a() && e2.a()) {
                if (b >= this.b) {
                    return;
                }
                this.a = true;
                if (f.u == 0) {
                    return;
                }
            }
            if (b < this.c) {
                this.a = true;
            }
        }
    }
}
