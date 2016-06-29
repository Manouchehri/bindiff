package y.f.f.a.a;

import y.c.*;

public class f implements e
{
    protected f b;
    protected D c;
    protected int d;
    public static boolean e;
    
    public f() {
        this(null);
    }
    
    public f(final f f) {
        this(f, null);
    }
    
    public f(final f b, final D c) {
        this.b = b;
        this.c = c;
        if (this.e()) {
            this.d = 0;
            if (!f.e) {
                return;
            }
        }
        this.d = this.b.d + 1;
    }
    
    public C a() {
        if (this.d()) {
            this.c = new D();
        }
        return this.c.m();
    }
    
    public int b() {
        return this.d;
    }
    
    public e c() {
        return this.b;
    }
    
    public boolean d() {
        return this.c == null || this.c.size() == 0;
    }
    
    public boolean e() {
        return this.b == null;
    }
    
    public void a(final f f) {
        if (this.c == null) {
            this.c = new D();
        }
        this.c.add(f);
    }
    
    public void f() {
        if (!this.e()) {
            ((f)this.c()).c.remove(this);
        }
    }
}
