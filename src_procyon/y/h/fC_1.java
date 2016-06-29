package y.h;

import y.d.*;

final class fC
{
    final fB a;
    final fB b;
    private boolean c;
    
    fC(final t t, final double n, final double n2) {
        this.a = new fB(this, t.a(), n);
        this.b = new fB(this, t.b(), n2);
        this.c = true;
    }
    
    boolean a() {
        return this.c;
    }
    
    void b() {
        this.c = false;
    }
    
    void a(final double n, final double n2, final byte b) {
        Label_0042: {
            switch (b) {
                case 0: {
                    this.b.b(n2);
                    if (fj.z) {
                        break Label_0042;
                    }
                    break;
                }
                case 1: {
                    this.a.b(n);
                    break;
                }
            }
        }
    }
}
