/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.b.d;
import y.g.an;
import y.h.cU;
import y.h.ch;
import y.h.gK;
import y.h.gL;
import y.h.gM;
import y.h.gN;
import y.h.gO;
import y.h.gP;
import y.h.gQ;
import y.h.gR;
import y.h.gS;
import y.h.hT;

public class gJ {
    gO a;
    ch b;
    cU c;
    public static final gP d = new gS();
    public static final gP e = new gS(true);
    public static final gP f = new gR();
    public static final gP g = new gR(true);
    public static final gO h = new gO(null);
    public static final gO i = new gO(null);
    public static final gO j = new gO(null);
    public static final gQ k = new gM();
    public static final gQ l = new gN();
    public static final gQ m = new gL();

    public gJ(ch ch2) {
        this.b = ch2;
        this.c = null;
        this.a = i;
    }

    public d a(double d2, an an2, long l2) {
        if (l2 < 0) {
            String string = new StringBuffer().append("preferredDuration  = ").append(l2).append(" < 0").toString();
            throw new IllegalArgumentException(string);
        }
        if (d2 > 0.0) return new hT(this.b, d2, an2, l2, this.c);
        throw new IllegalArgumentException(new StringBuffer().append("specified zoom factor <= 0: ").append(d2).toString());
    }
}

