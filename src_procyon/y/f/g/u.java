package y.f.g;

import java.util.*;
import y.d.*;

class u extends m
{
    static final Comparator a;
    private final int b;
    private final m c;
    
    u(final t t, final t t2, final int b) {
        super(t, t2);
        this.c = null;
        this.b = b;
    }
    
    u(final t t, final t t2, final int b, final m c) {
        super(t, t2);
        this.b = b;
        this.c = c;
    }
    
    public boolean b() {
        return this.c().b == this.d().b;
    }
    
    public int l() {
        return this.b;
    }
    
    public m m() {
        return this.c;
    }
    
    public String toString() {
        return this.c() + " " + this.d() + " priority: " + this.b;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final u u = (u)o;
        return this.b == u.b && this.c().equals(u.c()) && this.d().equals(u.d());
    }
    
    public int hashCode() {
        return 31 * (31 * this.b + this.c().hashCode()) + this.d().hashCode();
    }
    
    static {
        a = new s(null);
    }
}
