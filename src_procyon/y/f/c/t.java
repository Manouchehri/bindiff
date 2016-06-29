package y.f.c;

import y.g.*;
import y.c.*;

class t implements s
{
    private i b;
    private b c;
    
    public t(final i b) {
        this.b = b;
        this.c = M.c();
        if (b != null) {
            b.a(s.a, q.a((Object)this.c));
        }
    }
    
    public void a() {
        if (this.b != null) {
            this.b.d_(s.a);
            this.b = null;
        }
        this.c = null;
    }
    
    public void a(final Object o, final Object o2) {
        this.a(o2, new u((byte)1, o, 1));
    }
    
    public void a(final Object o, final Object o2, final int n) {
        this.a(o2, new u((byte)1, o, n));
    }
    
    public void a(final Object o, final Object o2, final int n, final int n2) {
        this.a(o2, new u((byte)1, o, n, n2));
    }
    
    public void b(final Object o, final Object o2, final int n) {
        this.a(o2, new u((byte)(-1), o, n));
    }
    
    public void b(final Object o, final Object o2, final int n, final int n2) {
        this.a(o2, new u((byte)(-1), o, n, n2));
    }
    
    public void b(final Object o, final Object o2) {
        this.a(o2, new u((byte)0, o, 0));
    }
    
    public void a(final Object o) {
        this.a(o, new u((byte)2, null, 0));
    }
    
    public void b(final Object o) {
        this.a(o, new u((byte)(-2), null, 0));
    }
    
    private void a(final Object o, final u u) {
        D d = (D)this.c.b(o);
        if (d == null) {
            d = new D();
            this.c.a(o, d);
        }
        d.add(u);
    }
}
