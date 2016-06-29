package y.f.i.a;

import java.util.*;

public class h
{
    private final boolean a;
    private final ArrayList b;
    private final HashMap c;
    private M d;
    private M e;
    private List f;
    
    public h(final ai ai) {
        this.b = new ArrayList();
        this.c = new HashMap();
        this.a = ai.g();
        this.a(ai);
        this.f = new ArrayList();
    }
    
    public void a(final ai ai) {
        if (ai.g() != this.a) {
            throw new IllegalArgumentException("segment is not " + (this.a ? "vertical!" : "horizontal!"));
        }
        this.b.add(ai);
        if (this.d != null) {
            this.d = M.b(this.d, ai.c());
            this.e = M.b(this.e, ai.b());
            if (ab.a == 0) {
                return;
            }
        }
        this.d = ai.c();
        this.e = ai.b();
    }
    
    public M a() {
        return this.d;
    }
    
    public int b() {
        return this.b.size();
    }
    
    public boolean c() {
        return this.a;
    }
    
    List d() {
        return this.b;
    }
    
    public ai a(final int n) {
        return this.b.get(n);
    }
    
    public int e() {
        return this.f.size();
    }
    
    public void a(final ah ah) {
        this.f.add(ah);
    }
    
    public ah b(final int n) {
        return this.f.get(n);
    }
    
    public double b(final ai ai) {
        final Double n = this.c.get(ai);
        return (n == null) ? Double.NaN : n;
    }
    
    public void a(final ai ai, final double n) {
        this.c.put(ai, new Double(n));
    }
    
    void a(final h h) {
        if (h == this) {
            return;
        }
        if (this.a != h.a) {
            throw new IllegalStateException("cannot splice channels!");
        }
        this.b.addAll(h.b);
        this.d = M.b(this.d, h.d);
        this.e = M.b(this.e, h.e);
    }
    
    public String toString() {
        final int a = ab.a;
        final StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < this.b.size()) {
            final ai ai = this.b.get(i);
            sb.append('\n');
            sb.append('\t');
            final StringBuffer sb2 = sb.append(ai);
            if (a != 0) {
                return sb2.toString();
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        final StringBuffer sb2 = new StringBuffer().append("Channel{isVertical=").append(this.a).append(", width=").append(this.d).append(", length=").append(this.e).append(", segments=").append(sb.toString()).append('}');
        return sb2.toString();
    }
}
