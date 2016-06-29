package y.f.d;

import y.d.*;
import y.f.*;

class z implements o
{
    Object a;
    Object b;
    byte c;
    int d;
    boolean e;
    private final u f;
    
    z(final u f, final Object a, final Object b, final byte c, final boolean e) {
        this.f = f;
        this.d = 0;
        this.e = false;
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = e;
    }
    
    public boolean a() {
        return this.c == 2 || this.c == 3;
    }
    
    public y h() {
        if (this.c == 1) {
            return ((m)this.a).h();
        }
        if (this.c == 3) {
            return u.a(this.f, (R)this.a, this.b);
        }
        if (this.c == 2) {
            return u.a(this.f, (R)this.a, this.b);
        }
        final am a = u.a(this.f).a(this.a);
        return new y(a.getX(), a.getY(), a.getWidth(), a.getHeight());
    }
}
