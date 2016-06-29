/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.f.f.a.a.e;
import y.f.f.a.a.h;

public class o
implements h {
    String a = "";

    @Override
    public void a(e e2) {
        this.a = new StringBuffer().append(this.a).append(e2.toString()).toString();
    }

    public String toString() {
        return this.a;
    }
}

