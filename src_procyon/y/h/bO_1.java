package y.h;

import y.f.*;

class bO extends bS
{
    private final bQ i;
    private final Runnable j;
    private final bI k;
    
    bO(final bI k, final ch ch, final bu bu, final ah ah, final boolean b, final bQ i, final Runnable j) {
        super(k, ch, bu, ah, b);
        this.k = k;
        this.i = i;
        this.j = j;
    }
    
    protected void a(final l l) {
        this.k.a(this.e, l.C());
    }
    
    protected void a() {
        super.a();
        this.e.T();
        if (this.b != null && this.i != null) {
            this.i.a(this.b);
        }
        if (this.j != null) {
            this.j.run();
        }
    }
}
