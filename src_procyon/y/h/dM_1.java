package y.h;

import y.c.*;

class dM implements o
{
    private final d a;
    private final dI b;
    
    dM(final dI b, final d a) {
        this.b = b;
        this.a = a;
    }
    
    public void onGraphEvent(final l l) {
        if (l.a() == 5 && l.b().equals(this.a)) {
            dI.c(this.b);
        }
    }
}
