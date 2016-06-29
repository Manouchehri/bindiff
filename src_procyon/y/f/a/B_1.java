package y.f.a;

import y.d.*;

class B implements o
{
    private Object a;
    private o b;
    private byte c;
    private int d;
    private y e;
    private boolean f;
    private C g;
    private final z h;
    
    public B(final z h, final Object a, final int d, final o b, final y e, final byte c) {
        this.h = h;
        this.e = null;
        this.g = null;
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
        if (c != 1) {
            this.e = e;
        }
    }
    
    public B(final z h, final Object a, final int d, final o b, final byte c) {
        this.h = h;
        this.e = null;
        this.g = null;
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public B(final z h, final Object a, final int d, final o b, final byte c, final C g) {
        this.h = h;
        this.e = null;
        this.g = null;
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
        if (c == 1) {
            this.g = g;
        }
    }
    
    public boolean a() {
        return this.g != null;
    }
    
    public C b() {
        return this.g;
    }
    
    public void a(final boolean f) {
        this.f = f;
    }
    
    public boolean c() {
        return this.f;
    }
    
    public void a(final y e) {
        this.e = e;
    }
    
    public void a(final o b) {
        this.b = b;
    }
    
    public y d() {
        return this.e;
    }
    
    public boolean e() {
        return this.c == 0;
    }
    
    public boolean f() {
        return this.c == 1;
    }
    
    public boolean g() {
        return this.c == 2;
    }
    
    public Object i() {
        return this.a;
    }
    
    public o j() {
        return this.b;
    }
    
    public y h() {
        return this.b.h();
    }
    
    public boolean equals(final Object o) {
        return o instanceof B && ((B)o).d == this.d;
    }
    
    public int hashCode() {
        return this.d;
    }
    
    static int a(final B b) {
        return b.d;
    }
}
