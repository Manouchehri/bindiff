package y.f.c.a;

import y.f.*;
import y.c.*;

class cb implements bO
{
    private am a;
    private df[] b;
    private f c;
    
    public cb(final am a) {
        this.a = a;
        (this.b = new df[12])[0] = new cE(a, 0, false);
        this.b[1] = new cE(a, 0, false);
        this.b[2] = new cE(a, 0, true);
        this.b[3] = new cE(a, 1, false);
        this.b[4] = new cE(a, 1, false);
        this.b[5] = new cE(a, 1, true);
        this.b[6] = new cE(a, 2, false);
        this.b[7] = new cE(a, 2, false);
        this.b[8] = new cE(a, 2, true);
        this.b[9] = new cE(a, 3, false);
        this.b[10] = new cE(a, 3, false);
        this.b[11] = new cE(a, 3, true);
    }
    
    public df a(final int n) {
        return this.b[(4 + n & 0x3) * 3];
    }
    
    public df c(final int n) {
        return this.b[2 + (4 + n & 0x3) * 3];
    }
    
    public df b(final int n) {
        return this.b[1 + (4 + n & 0x3) * 3];
    }
    
    public double d(int n) {
        n = (4 + n & 0x3);
        return ((n & 0x1) == 0x1) ? this.a.getHeight() : this.a.getWidth();
    }
    
    public f a() {
        return this.c;
    }
    
    public p b() {
        return (this.c == null) ? null : this.c.k();
    }
    
    public void a(final d d) {
        if (this.c == null) {
            this.c = new f();
        }
        this.c.add(d);
    }
}
