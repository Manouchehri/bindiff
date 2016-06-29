package y.f.f.c;

import y.c.*;
import java.util.*;

public class g
{
    private q b;
    private int c;
    private short d;
    private g e;
    private g f;
    private D g;
    private int h;
    private int i;
    private int j;
    public static int a;
    
    public g(final q b, final int c, final short d) {
        this.i = 0;
        this.j = 0;
        this.b = b;
        this.c = c;
        this.d = d;
        this.g = new D();
    }
    
    public void a(final q q) {
        this.g.add(q);
    }
    
    public q a() {
        return this.b;
    }
    
    public int b() {
        return this.c;
    }
    
    public short c() {
        return this.d;
    }
    
    public void a(final g e, final g f) {
        this.e = e;
        this.f = f;
    }
    
    public g d() {
        return this.e;
    }
    
    public g e() {
        return this.f;
    }
    
    public q f() {
        return (q)this.g.f();
    }
    
    public q g() {
        return (q)this.g.i();
    }
    
    public D h() {
        return this.g;
    }
    
    public void a(final int h) {
        this.h = h;
    }
    
    public int i() {
        return this.h;
    }
    
    public String toString() {
        final int a = y.f.f.c.g.a;
        final StringBuffer sb = new StringBuffer();
        String s = "";
        final Iterator iterator = this.g.iterator();
        String s2 = null;
        while (iterator.hasNext()) {
            sb.append(s);
            sb.append(iterator.next());
            s2 = "-";
            if (a != 0) {
                return s2;
            }
            s = s2;
            if (a != 0) {
                break;
            }
        }
        sb.toString();
        return s2;
    }
    
    public int j() {
        return this.i;
    }
    
    public int k() {
        return this.j;
    }
    
    public void b(final int i) {
        this.i = i;
    }
    
    public void c(final int j) {
        this.j = j;
    }
}
