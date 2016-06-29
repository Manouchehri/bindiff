package y.f.f.d;

import y.f.f.b.*;
import y.f.*;
import y.c.*;

class E implements M
{
    private h a;
    private int b;
    private int c;
    private int d;
    
    public E(final int c) {
        this.b = 0;
        this.c = c;
    }
    
    public boolean a() {
        return false;
    }
    
    public void a(final h a) {
        final boolean p = o.p;
        y.g.o.a(this, "Kandinsky Node Model !");
        this.a = a;
        this.d = 1;
        final X x = (X)a.a();
        final x o = a.a().o();
        while (o.f()) {
            final q e = o.e();
            if (p) {
                return;
            }
            if (a.d(e)) {
                x.b(o.e(), this.c * 1.5, this.c * 1.5);
                final int[][] i = a.i(e);
                this.d = Math.max(this.d, i[0][0]);
                this.d = Math.max(this.d, i[1][0]);
                this.d = Math.max(this.d, i[2][0]);
                this.d = Math.max(this.d, i[3][0]);
                this.d = Math.max(this.d, i[0][2]);
                this.d = Math.max(this.d, i[1][2]);
                this.d = Math.max(this.d, i[2][2]);
                this.d = Math.max(this.d, i[3][2]);
            }
            o.g();
            if (p) {
                break;
            }
        }
        this.b = 2;
    }
    
    public boolean a(final q q) {
        return this.a.d(q);
    }
    
    public int b(final q q) {
        return this.b;
    }
    
    public int c(final q q) {
        return this.b;
    }
    
    public boolean d(final q q) {
        return this.a(q);
    }
    
    public double b() {
        return 2 * this.d;
    }
    
    public boolean c() {
        return true;
    }
    
    public int e(final q q) {
        return this.d;
    }
    
    public int f(final q q) {
        return this.d;
    }
    
    public void d() {
    }
}
