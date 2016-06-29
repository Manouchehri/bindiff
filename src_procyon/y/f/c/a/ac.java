package y.f.c.a;

import java.util.*;

final class ac implements aU
{
    final List a;
    final aV b;
    boolean c;
    
    ac(final aV b) {
        this.a = new ArrayList();
        this.b = b;
    }
    
    public aU a() {
        return new ac(this.b);
    }
    
    public aQ a(final int n) {
        return this.a.get(n);
    }
    
    public aQ a(final byte b, final int n) {
        if (this.a.size() > n) {
            final ad ad = new ad(this, b, n);
            this.a.add(n, ad);
            this.c = true;
            return ad;
        }
        if (this.a.size() == n) {
            final ad ad2 = new ad(this, b, n);
            this.a.add(ad2);
            return ad2;
        }
        throw new IndexOutOfBoundsException();
    }
    
    public void b(final int n) {
        if (n < this.a.size() - 1) {
            this.c = true;
        }
        this.a.remove(n).b = -1;
    }
    
    public int b() {
        return this.a.size();
    }
    
    void c() {
        final boolean x = N.x;
        if (this.c) {
            int i = 0;
            while (i < this.a.size()) {
                ((ad)this.a.get(i)).b = i;
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
