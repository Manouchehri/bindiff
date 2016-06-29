package y.f.c.a;

public class bs
{
    private byte a;
    private byte b;
    private byte c;
    private byte d;
    private byte e;
    
    public bs(final byte b) {
        this.e(b);
        this.a(b);
        this.c(b);
        this.d(b);
        this.b(b);
    }
    
    public byte a() {
        return this.b;
    }
    
    private boolean f(final byte b) {
        return b == 1 || b == 0 || b == 2;
    }
    
    public void a(final byte b) {
        if (!this.f(b)) {
            throw new IllegalArgumentException();
        }
        this.b = b;
    }
    
    public byte b() {
        return this.d;
    }
    
    public void b(final byte d) {
        if (!this.f(d)) {
            throw new IllegalArgumentException();
        }
        this.d = d;
    }
    
    public byte c() {
        return this.c;
    }
    
    public void c(final byte c) {
        if (!this.f(c)) {
            throw new IllegalArgumentException();
        }
        this.c = c;
    }
    
    public byte d() {
        return this.e;
    }
    
    public void d(final byte e) {
        if (!this.f(e)) {
            throw new IllegalArgumentException();
        }
        this.e = e;
    }
    
    public byte e() {
        return this.a;
    }
    
    public void e(final byte a) {
        if (!this.f(a)) {
            throw new IllegalArgumentException();
        }
        this.a = a;
    }
}
