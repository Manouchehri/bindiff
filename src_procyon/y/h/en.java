package y.h;

import y.d.*;

public final class en
{
    final boolean a;
    private final el b;
    private final el c;
    private final boolean d;
    
    public el a() {
        return this.c;
    }
    
    public el b() {
        return this.b;
    }
    
    void a(final double n, final double n2) {
        this.b.a(n, n2);
        this.c.a(n, n2);
    }
    
    public en(final el b, final el c) {
        final boolean z = fj.z;
        final double n = b.b().a - c.b().a;
        final double n2 = b.b().b - c.b().b;
        Label_0130: {
            if (n == 0.0 && (n2 != 0.0 || b.c() != c.c())) {
                this.a = true;
                this.d = true;
                if (!z) {
                    break Label_0130;
                }
            }
            if (n2 == 0.0 && (n != 0.0 || b.d() != c.d())) {
                this.a = false;
                this.d = true;
                if (!z) {
                    break Label_0130;
                }
            }
            this.d = false;
            this.a = true;
        }
        this.b = b;
        this.c = c;
    }
    
    gz a(final gy gy, final t t, final double n, final double n2, final double n3) {
        if (!this.d) {
            return gz.b;
        }
        if (this.a == (gy.c() == 1)) {
            final t b = gy.b();
            if (this.a) {
                final double n4 = b.a - this.b.a(n);
                if (Math.abs(n4) < n3) {
                    final double min = Math.min(this.b.b(n2), this.c.b(n2));
                    final double max = Math.max(this.b.b(n2), this.c.b(n2));
                    if (min < gy.f() && max > gy.e()) {
                        if (gy instanceof id) {
                            return new dZ(this, 0.5 * gy.a(), null, true, t.a + n + n4, gy.g(), gy);
                        }
                        return gz.a(0.5 * gy.a(), gy, true, t.a + n + n4, gy.g());
                    }
                }
            }
            else {
                final double n5 = b.b - this.b.b(n2);
                if (Math.abs(n5) < n3) {
                    final double min2 = Math.min(this.b.a(n), this.c.a(n));
                    final double max2 = Math.max(this.b.a(n), this.c.a(n));
                    if (min2 < gy.f() && max2 > gy.e()) {
                        if (gy instanceof id) {
                            return new ea(this, 0.5 * gy.a(), null, false, t.b + n2 + n5, gy.g(), gy);
                        }
                        return gz.a(0.5 * gy.a(), gy, false, t.b + n2 + n5, gy.g());
                    }
                }
            }
        }
        return gz.b;
    }
    
    static el a(final en en) {
        return en.b;
    }
    
    static el b(final en en) {
        return en.c;
    }
}
