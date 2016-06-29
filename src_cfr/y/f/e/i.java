/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.util.List;
import y.f.X;
import y.f.e.a.aa;
import y.f.e.a.ax;
import y.f.e.a.ay;
import y.f.e.j;

public abstract class i {
    public static final i a = new j();
    public static boolean b;

    abstract void a(ay var1);

    void a(ay ay2, X x2) {
    }

    void b(ay ay2, X x2) {
    }

    aa b(ay ay2) {
        aa aa2;
        block2 : {
            boolean bl2 = b;
            for (ax ax2 : ay2.y()) {
                if (!(ax2 instanceof aa)) continue;
                aa2 = (aa)ax2;
                if (!bl2) {
                    return aa2;
                }
                break block2;
            }
            aa2 = new aa();
        }
        aa aa3 = aa2;
        ay2.a(aa3);
        return aa3;
    }

    private i() {
    }

    i(j j2) {
        this();
    }
}

