package y.h;

import java.util.*;

public final class aM
{
    private final aY c;
    Map a;
    Set b;
    
    private aM() {
        this.c = new aY("DEFAULT");
        this.c.k = new gr();
        this.c.i = new fK();
        this.a = new HashMap();
        this.b = Collections.unmodifiableSet(this.a.keySet());
    }
    
    aY a() {
        return this.c;
    }
    
    public void a(final aF af, final String s) {
        final aY ay = this.a.get(s);
        if (ay != null) {
            if (aF.a(af) != ay) {
                aF.a(af, ay);
                if (aF.a(af).o != null) {
                    aF.a(af).o.a(af);
                }
                af.setDirty();
                if (fj.z) {
                    throw new IllegalArgumentException();
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }
    
    aM(final aG ag) {
        this();
    }
}
