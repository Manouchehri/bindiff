package y.h;

import y.d.*;

public class em extends el
{
    private fL c;
    
    public em(final fL c, final t t, final byte b) {
        super(t, b);
        this.c = c;
    }
    
    public fL a() {
        return this.c;
    }
    
    public void a(final double n, final double n2) {
        final aB d = this.c.d();
        fj fj = null;
        Label_0041: {
            if (d.getSourcePort() == this.c) {
                fj = d.getSourceRealizer();
                if (!y.h.fj.z) {
                    break Label_0041;
                }
            }
            fj = d.getTargetRealizer();
        }
        this.c.b(this.a(n) - fj.getCenterX(), this.b(n2) - fj.getCenterY());
    }
}
