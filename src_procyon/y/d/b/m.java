package y.d.b;

import java.util.*;

public class m
{
    protected u a;
    private b b;
    private b c;
    private b d;
    private b e;
    private z f;
    private z g;
    
    public m(final b b, final b c, final d a) {
        this.b = b;
        this.c = c;
        this.f = this.c.a().c(this.b.c()).b(this.b.a().c(this.c.c()));
        this.g = this.c.b().c(this.b.c()).b(this.b.b().c(this.c.c()));
        this.a = a;
        if (this.a.c().compare(this.b, this.c) < 0) {
            this.d = this.b;
            this.e = this.c;
            if (y.d.b.c.a == 0) {
                return;
            }
        }
        this.d = this.c;
        this.e = this.b;
    }
    
    public b a() {
        return this.b;
    }
    
    public b b() {
        return this.c;
    }
    
    public z c() {
        return this.f;
    }
    
    public z d() {
        return this.g;
    }
    
    public boolean e() {
        return this.b.equals(this.c);
    }
    
    public boolean a(final b b) {
        if (this.e()) {
            return this.b.equals(b);
        }
        if (this.a.c(this.a(), this.b(), b) != 0) {
            return false;
        }
        final Comparator c = this.a.c();
        return c.compare(this.d, b) <= 0 && c.compare(b, this.e) <= 0;
    }
    
    public boolean b(final b b) {
        return !b.equals(this.b) && !b.equals(this.c) && this.a(b);
    }
    
    public b a(final m m) {
        final b b = this.b;
        final b c = this.c;
        final b a = m.a();
        final b b2 = m.b();
        if (this.e()) {
            if (m.a(b)) {
                return b;
            }
            return null;
        }
        else if (m.e()) {
            if (this.a(a)) {
                return a;
            }
            return null;
        }
        else {
            final int a2 = this.a.a(this, m.a());
            final int a3 = this.a.a(this, m.b());
            final int a4 = this.a.a(m, this.a());
            final int a5 = this.a.a(m, this.b());
            if (a2 == 0 && a3 == 0) {
                if (m.a(b)) {
                    return b;
                }
                if (m.a(c)) {
                    return c;
                }
                if (this.a(a)) {
                    return a;
                }
                if (this.a(b2)) {
                    return b2;
                }
                return null;
            }
            else {
                if (a2 != a3 && a4 != a5) {
                    return this.b(m);
                }
                return null;
            }
        }
    }
    
    public b b(final m m) {
        final b b = this.b;
        final b c = this.c;
        final b a = m.a();
        final b b2 = m.b();
        final z b3 = this.g.c(m.c()).b(m.d().c(this.f));
        if (b3.c() == 0) {
            return null;
        }
        final z b4 = c.a().c(b.b()).b(b.a().c(c.b()));
        final z b5 = b2.a().c(a.b()).b(a.a().c(b2.b()));
        return new b(b5.c(this.f).b(b4.c(m.c())), b5.c(this.g).b(b4.c(m.d())), b3);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof m)) {
            return false;
        }
        final m m = (m)o;
        return m.a().equals(this.b) && m.b().equals(this.c);
    }
    
    public int hashCode() {
        return 31 * this.b.hashCode() + this.c.hashCode();
    }
    
    public String toString() {
        return "[S: " + this.b + " - T:" + this.c + "]";
    }
}
