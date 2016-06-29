package y.f.c.a;

import y.c.*;

class i
{
    private y a;
    private Object b;
    private aU c;
    private double[][] d;
    private boolean e;
    private final f f;
    
    public i(final f f, final q q, final int n) {
        this.f = f;
        this.e = true;
        this.a = new y(q);
        this.b = new Integer(n);
    }
    
    public Object a() {
        return this.b;
    }
    
    public aU b() {
        return this.c;
    }
    
    public y c() {
        return this.a;
    }
    
    public void a(final aU c) {
        this.c = c;
        this.e = true;
    }
    
    public void a(final q q) {
        this.a.add(q);
    }
    
    public double d() {
        final boolean x = N.x;
        double n = 0.0;
        double max = 0.0;
        this.e();
        if (this.d != null) {
            int i = 0;
            while (i < this.c.b()) {
                if (i > 0) {
                    n += 30.0;
                }
                n += this.d[i][0];
                max = Math.max(max, this.d[i][1]);
                ++i;
                if (x) {
                    break;
                }
            }
        }
        return n * n + max * max;
    }
    
    public double[][] e() {
        final boolean x = N.x;
        if (this.c == null) {
            return null;
        }
        if (!this.e) {
            return this.d;
        }
        this.d = new double[this.c.b()][2];
        int i = 0;
    Label_0193_Outer:
        while (i < this.c.b()) {
            final aQ a = this.c.a(i);
            double max = 0.0;
            double n = 0.0;
            if (!x) {
                p p = a.d().k();
                while (true) {
                    while (p != null) {
                        final q q = (q)p.c();
                        max = Math.max(max, y.f.c.a.f.a(this.f, q));
                        n += y.f.c.a.f.b(this.f, q);
                        p = p.a();
                        if (!x) {
                            if (x) {
                                break;
                            }
                            continue Label_0193_Outer;
                        }
                        else {
                            if (x) {
                                break Label_0193_Outer;
                            }
                            continue Label_0193_Outer;
                        }
                    }
                    this.d[i][0] = max;
                    this.d[i][1] = n + (a.d().size() - 1) * 30.0;
                    ++i;
                    continue;
                }
            }
            return this.d;
        }
        this.e = false;
        return this.d;
    }
}
