package y.f.f.a.b;

import java.util.*;
import y.c.*;
import y.f.f.a.a.*;

public class o
{
    private i a;
    private p b;
    private y.f.f.a.b.i c;
    private f d;
    private f e;
    
    public o(final i a, final p b) {
        this.a = a;
        this.b = b;
        this.c = new y.f.f.a.b.i(this.a, this.b);
        this.d = new f();
        this.e = new f();
    }
    
    public void a() {
        this.c.d();
    }
    
    public f b() {
        return this.e;
    }
    
    public f c() {
        return this.d;
    }
    
    public void d() {
        final boolean c = y.f.f.a.b.a.c;
        this.d.clear();
        this.e.clear();
        this.e.a(this.a.p());
        this.c.h();
        this.c.e();
        this.e();
        final e a = this.d.a();
        a.j();
        while (a.f()) {
            final d a2 = a.a();
            final d a3 = this.c.a(a2);
            if (c) {
                return;
            }
            if (a3 != null) {
                this.d.b(a3);
                this.d.remove(a2);
            }
            a.h();
            if (c) {
                break;
            }
        }
        this.e.removeAll(this.d);
        this.c.i();
    }
    
    private void e() {
        this.c.f();
        m.a(new q(this, null), this.c);
        this.c.g();
    }
    
    static i a(final o o) {
        return o.a;
    }
    
    static f b(final o o) {
        return o.d;
    }
}
