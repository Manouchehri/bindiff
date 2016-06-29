package y.d.b;

import java.util.*;
import y.d.*;

public class o extends c implements l
{
    private static final o b;
    private Comparator c;
    private Comparator d;
    private Comparator e;
    
    public o() {
        this.c = new p();
        this.d = new r();
        this.e = new s();
    }
    
    public Object a(final double n, final double n2) {
        return new t(n, n2);
    }
    
    public Object a(final z z, final z z2) {
        return new t(z.e(), z2.e());
    }
    
    public z k(final Object o) {
        return new y(((t)o).a());
    }
    
    public z l(final Object o) {
        return new y(((t)o).b());
    }
    
    public Object c(final Object o, final Object o2) {
        return new m((t)o, (t)o2);
    }
    
    public boolean e(final Object o, final Object o2) {
        return ((m)o).a((t)o2);
    }
    
    public Object c(final Object o) {
        return ((m)o).c();
    }
    
    public Object d(final Object o) {
        return ((m)o).d();
    }
    
    public Object f(final Object o, final Object o2) {
        final m m = (m)o;
        final m i = (m)o2;
        return y.d.a.a(new a(m.c(), m.d()), new a(i.c(), i.d()));
    }
    
    public Object g(final Object o, final Object o2) {
        return m.a((m)o, (m)o2);
    }
    
    public Comparator b() {
        return new q();
    }
    
    public Object i(final Object o, final Object o2) {
        return new y.d.z((t)o2, (t)o);
    }
    
    public double h(final Object o, final Object o2) {
        return y.d.z.d((y.d.z)o, (y.d.z)o2);
    }
    
    public Comparator c() {
        return this.c;
    }
    
    public Comparator d() {
        return this.d;
    }
    
    public Comparator e() {
        return this.e;
    }
    
    public int c(final Object o, final Object o2, final Object o3) {
        final t t = (t)o;
        final t t2 = (t)o2;
        final t t3 = (t)o3;
        return this.a(t.a(), t.b(), t2.a(), t2.b(), t3.a(), t3.b());
    }
    
    public int a(final double n, final double n2, double n3, double n4, double n5, double n6) {
        n3 -= n;
        n4 -= n2;
        n5 -= n;
        n6 -= n2;
        final double n7 = n5 * n4 - n6 * n3;
        return (n7 < 0.0) ? 1 : ((n7 > 0.0) ? -1 : 0);
    }
    
    static {
        b = new o();
    }
}
