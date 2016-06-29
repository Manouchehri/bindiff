package y.f.f.d;

import y.f.f.b.*;

public class b
{
    private p a;
    private p b;
    private int c;
    private o d;
    private int e;
    private boolean f;
    private boolean g;
    
    public b(final p a, final p b, final int c, final o d, final int e) {
        this.f = false;
        this.g = false;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public int a() {
        return this.e;
    }
    
    public int b() {
        return this.c;
    }
    
    public o c() {
        return this.d;
    }
    
    public p d() {
        return this.a;
    }
    
    public p e() {
        return this.b;
    }
    
    public boolean f() {
        return this.f;
    }
    
    public void a(final boolean f) {
        this.f = f;
    }
    
    public boolean g() {
        return this.g;
    }
    
    public void b(final boolean g) {
        this.g = g;
    }
    
    public String toString() {
        return "type=" + ((this.c == 1) ? "KONKAVE" : "KONVEX") + " dir=" + this.d;
    }
}
