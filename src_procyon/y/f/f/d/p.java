package y.f.f.d;

import y.f.f.c.*;
import y.c.*;

public class p
{
    private D a;
    
    public p() {
        this.a = new D();
    }
    
    public p(final g g) {
        this();
        this.a(g);
    }
    
    public void a(final g g) {
        this.a.add(g);
    }
    
    public C a() {
        return this.a.m();
    }
    
    public g b() {
        return (g)this.a().d();
    }
    
    public static void a(final y.f.f.c.p p4, final p p5, final p p6, final int n) {
        final boolean p7 = o.p;
        final C a = p5.a();
    Label_0095_Outer:
        while (a.f()) {
            final g g = (g)a.d();
            final C a2 = p6.a();
            while (true) {
                while (a2.f()) {
                    p4.a(g, (g)a2.d(), n);
                    a2.g();
                    if (!p7) {
                        if (p7) {
                            break;
                        }
                        continue Label_0095_Outer;
                    }
                    else {
                        if (p7) {
                            break Label_0095_Outer;
                        }
                        continue Label_0095_Outer;
                    }
                }
                a.g();
                continue;
            }
        }
    }
    
    public String toString() {
        final boolean p = o.p;
        final StringBuffer sb = new StringBuffer();
        final C a = this.a();
        while (a.f()) {
            final StringBuffer append = sb.append(((g)a.d()).toString() + "  ");
            if (p) {
                return append.toString();
            }
            a.g();
            if (p) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
}
