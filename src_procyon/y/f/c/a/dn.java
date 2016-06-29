package y.f.c.a;

import java.util.*;

final class dn implements aU
{
    final List a;
    final aV b;
    boolean c;
    
    dn(final aV b) {
        this.a = new ArrayList();
        this.b = b;
    }
    
    public aU a() {
        return new dn(this.b);
    }
    
    public aQ a(final int n) {
        return this.a.get(n);
    }
    
    public aQ a(final byte b, final int n) {
        if (this.a.size() > n) {
            final do do1 = new do(this, b, n);
            this.a.add(n, do1);
            this.c = true;
            return do1;
        }
        if (this.a.size() == n) {
            final do do2 = new do(this, b, n);
            this.a.add(do2);
            return do2;
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
        final boolean x = N.x;
        if (this.c) {
            int i = 0;
            while (i < this.a.size()) {
                ((do)this.a.get(i)).a = i;
                ++i;
                if (x) {
                    return;
                }
                if (x) {
                    break;
                }
            }
            this.c = false;
        }
    }
}
