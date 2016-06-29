package y.f.f.c;

import y.f.f.b.*;
import y.g.*;
import y.d.*;
import y.c.*;

public class r
{
    private h a;
    private f b;
    private l c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    
    public r() {
        this.d = 3;
        this.e = false;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }
    
    public void a(final h a) {
        this.a = a;
    }
    
    public void a(final l c) {
        this.c = c;
    }
    
    public void a(final f b) {
        this.b = b;
    }
    
    public void a(final int d) {
        this.d = d;
    }
    
    public void a(final boolean e) {
        this.e = e;
    }
    
    public void a(final A a) {
        final int a2 = y.f.f.c.g.a;
        final al al = new al();
        final p p = new p(0, this.a);
        final p p2 = new p(1, this.a);
        this.f = (int)al.d();
        al.e();
        if (this.b != null) {
            this.b.a(this.a, p, p2);
            this.g = (int)al.d();
            al.e();
        }
        this.c.a(this.a, p, p2);
        this.h = (int)al.d();
        al.e();
        if (this.d != 3) {
            final b b = new b();
            b.a(this.d);
            b.a(this.a, p, p2);
            this.i = (int)al.d();
        }
        final x o = this.a.a().o();
        while (o.f()) {
            final q e = o.e();
            a.a(e, new t(p.a(e).i(), p2.a(e).i()));
            o.g();
            if (a2 != 0) {
                return;
            }
            if (a2 != 0) {
                break;
            }
        }
        p2.c();
        p.c();
    }
    
    public int a() {
        return this.f;
    }
    
    public int b() {
        return this.g;
    }
    
    public int c() {
        return this.h;
    }
    
    public int d() {
        return this.i;
    }
}
