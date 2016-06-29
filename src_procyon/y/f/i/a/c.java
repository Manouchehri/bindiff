package y.f.i.a;

import y.c.*;

class c
{
    private d a;
    private int b;
    
    private c(final d a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final c c = (c)o;
        if (this.b != c.b) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(c.a)) {
                return true;
            }
        }
        else if (c.a == null) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : 0) + this.b;
    }
    
    c(final d d, final int n, final b b) {
        this(d, n);
    }
    
    static d a(final c c) {
        return c.a;
    }
    
    static int b(final c c) {
        return c.b;
    }
    
    static int a(final c c, final int b) {
        return c.b = b;
    }
}
