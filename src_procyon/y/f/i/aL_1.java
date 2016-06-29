package y.f.i;

import y.c.*;

class aL
{
    private D a;
    private final aK b;
    
    public aL(final aK b) {
        this.b = b;
        this.a = new D();
    }
    
    public void a(q q) {
        final int f = v.f;
        aM am = (aM)aK.b(this.b).b(q);
        if (am.a) {
            return;
        }
        int i = 0;
        while (i == 0) {
            q = (q)am.b();
            if (q != null) {
                am = (aM)aK.b(this.b).b(q);
                if (aK.c(this.b).d(q)) {
                    continue;
                }
                aK.a(this.b, this.a, aM.a(am));
                if (f == 0) {
                    continue;
                }
            }
            i = 1;
            if (f != 0) {
                break;
            }
        }
    }
    
    public boolean b(q q) {
        final int f = v.f;
        aM am = (aM)aK.b(this.b).b(q);
        if (!am.a) {
            return false;
        }
        int i = 0;
        while (i == 0) {
            q = (q)am.b();
            if (q != null) {
                am = (aM)aK.b(this.b).b(q);
                if (aK.c(this.b).d(q)) {
                    continue;
                }
                aK.b(this.b, this.a, aM.a(am));
                if (f == 0) {
                    continue;
                }
            }
            i = 1;
            if (f != 0) {
                break;
            }
        }
        return this.a();
    }
    
    private boolean a() {
        final int f = v.f;
        boolean b = true;
        int n = 0;
        final C m = this.a.m();
        m.j();
        while (m.f()) {
            final boolean b2 = b;
            if (f != 0 || !b2) {
                return b2;
            }
            final aN an = (aN)m.d();
            n += an.c;
            if (an.c > 0 && an.b < n) {
                b = false;
            }
            if (an.b < an.c) {
                b = false;
            }
            m.h();
            if (f != 0) {
                goto Label_0105;
            }
        }
        goto Label_0105;
    }
}
