package y.f.i;

import y.c.*;
import y.d.*;
import y.f.*;

class W extends R
{
    private q a;
    private m b;
    
    W(final q a, final byte b) {
        super((byte)1, 0.0);
        this.a = a;
        final am a2 = ((X)a.e()).a((Object)a);
        final t t = new t(a2.getX(), a2.getY());
        final t t2 = new t(a2.getX() + a2.getWidth(), a2.getY());
        final t t3 = new t(a2.getX(), a2.getY() + a2.getHeight());
        final t t4 = new t(a2.getX() + a2.getWidth(), a2.getY() + a2.getHeight());
        if (b == 0) {
            this.a((byte)1);
            this.b = new m(t2, t4);
            this.a(this.b.c().a());
            if (v.f == 0) {
                return;
            }
        }
        if (b == 1) {
            this.a((byte)2);
            this.b = new m(t, t3);
            this.a(this.b.c().a());
        }
    }
    
    public q a() {
        return this.a;
    }
    
    public m b() {
        return this.b;
    }
    
    public String toString() {
        return "Node: " + this.a().d() + ", Side: " + ((this.k() == 1) ? "EAST" : "WEST");
    }
}
