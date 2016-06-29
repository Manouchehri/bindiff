package y.f;

import y.c.*;

public class ac extends a
{
    public static final Object a;
    
    public void c(final X x) {
        final ah b = this.b(x);
        if (b != null) {
            b.c(x);
        }
    }
    
    protected ah b(final X x) {
        final boolean j = X.j;
        final c c = x.c(ac.a);
        ah ah2 = null;
        if (c != null) {
            final x o = x.o();
            while (o.f()) {
                final ah ah = ah2 = (ah)c.b(o.e());
                if (j) {
                    return ah2;
                }
                if (ah2 != null) {
                    return ah;
                }
                o.g();
                if (j) {
                    break;
                }
            }
        }
        this.a();
        return ah2;
    }
    
    static {
        a = "y.layout.LayoutMultiplexer.LAYOUTER_DPKEY";
    }
}
