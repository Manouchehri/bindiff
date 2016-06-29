package y.d.b;

import y.g.*;

public class y implements z
{
    private static y a;
    private static y b;
    private double c;
    
    public y(final double c) {
        this.c = c;
    }
    
    public z a() {
        return y.a;
    }
    
    public z b() {
        return y.b;
    }
    
    public z a(final z z) {
        return new y(this.c + ((y)z).e());
    }
    
    public z b(final z z) {
        return new y(this.c - ((y)z).e());
    }
    
    public z c(final z z) {
        return new y(this.c * ((y)z).e());
    }
    
    public z d(final z z) {
        return new y(this.c / ((y)z).e());
    }
    
    public z d() {
        return new y(-this.c);
    }
    
    public z e(final z z) {
        return y.b;
    }
    
    public int c() {
        if (this.c < 0.0) {
            return -1;
        }
        if (this.c > 0.0) {
            return 1;
        }
        return 0;
    }
    
    public int f(final z z) {
        if (z == this) {
            return 0;
        }
        return e.a(this.c, ((y)z).e());
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof y && this.c == ((y)o).e());
    }
    
    public double e() {
        return this.c;
    }
    
    public String toString() {
        return "" + this.c;
    }
    
    static {
        y.a = new y(0.0);
        y.b = new y(1.0);
    }
}
