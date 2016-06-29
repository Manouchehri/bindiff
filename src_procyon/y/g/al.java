package y.g;

public class al
{
    private long a;
    private long b;
    private boolean c;
    
    public al() {
        this(true);
    }
    
    public al(final boolean b) {
        this.c = true;
        if (b) {
            this.a();
        }
    }
    
    public void a() {
        if (this.c) {
            this.a = this.f();
            this.c = false;
        }
    }
    
    public void b() {
        if (!this.c) {
            this.b += this.f() - this.a;
            this.c = true;
        }
    }
    
    public void c() {
        if (this.c) {
            this.a();
            if (!p.c) {
                return;
            }
        }
        this.b();
    }
    
    public long d() {
        if (this.c) {
            return this.b;
        }
        return this.b + this.f() - this.a;
    }
    
    public final void e() {
        this.b = 0L;
        this.a = this.f();
    }
    
    public final String toString() {
        final long d = this.d();
        final long n = d / 60000L;
        final long n2 = d - 60000L * n;
        final long n3 = n2 / 1000L;
        return "" + n + " Minutes " + n3 + " Seconds " + (n2 - 1000L * n3) + " Millisec.";
    }
    
    private long f() {
        return System.currentTimeMillis();
    }
}
