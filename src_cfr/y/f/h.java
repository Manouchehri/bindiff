/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.f.G;
import y.f.aG;
import y.f.y;

class H {
    private final aG a;
    private final y b;

    private H(aG aG2, y y2) {
        this.a = aG2;
        this.b = y2;
    }

    H(aG aG2, y y2, G g2) {
        this(aG2, y2);
    }

    static aG a(H h2) {
        return h2.a;
    }

    static y b(H h2) {
        return h2.b;
    }
}

