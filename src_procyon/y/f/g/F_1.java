package y.f.g;

import java.util.*;
import y.f.c.a.*;

final class F implements aU
{
    final List a;
    final aV b;
    boolean c;
    
    F(final aV b) {
        this.a = new ArrayList();
        this.b = b;
    }
    
    public aU a() {
        return new F(this.b);
    }
    
    public aQ a(final int n) {
        return this.a.get(n);
    }
    
    public aQ a(final byte b, final int n) {
        if (this.a.size() > n) {
            final G g = new G(this, b, n);
            this.a.add(n, g);
            this.c = true;
            return g;
        }
        if (this.a.size() == n) {
            final G g2 = new G(this, b, n);
            this.a.add(g2);
            return g2;
        }
        throw new IndexOutOfBoundsException();
    }
    
    public void b(final int n) {
        if (n < this.a.size() - 1) {
            this.c = true;
        }
        this.a.remove(n).a = -1;
    }
    
    public int b() {
        return this.a.size();
    }
    
    void c() {
        final boolean d = y.f.g.d.d;
        if (this.c) {
            int i = 0;
            while (i < this.a.size()) {
                ((G)this.a.get(i)).a = i;
                ++i;
                if (d) {
                    return;
                }
                if (d) {
                    break;
                }
            }
            this.c = false;
        }
    }
}
