/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.f.aE;
import y.f.ax;
import y.f.y;

public class S {
    public static final S a = new S();
    public static final S b = new S();
    public static final S c = new S();
    public static final S d = new S();

    private S() {
    }

    public static S a(y y2) {
        if (y.a == y2) {
            return a;
        }
        if (y.c == y2) {
            return b;
        }
        if (y.d == y2) {
            return d;
        }
        if (y.b != y2) return null;
        return c;
    }

    public static S a(aE aE2) {
        if (aE2.c()) {
            return a;
        }
        if (aE2.d()) {
            return b;
        }
        if (aE2.e()) {
            return c;
        }
        if (!aE2.f()) return null;
        return d;
    }

    public static S a(ax ax2) {
        return S.a(ax2.e());
    }
}

