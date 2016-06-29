package y.h;

import y.f.*;

class bL implements Runnable
{
    private final bS a;
    
    bL(final bS a) {
        this.a = a;
    }
    
    public void run() {
        if (bS.a(this.a) != null) {
            bS.b(this.a).a(this.a.a, bS.a(this.a));
        }
        this.a.a(this.a.a);
    }
}
