/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.b;
import y.f.h.a.h;
import y.f.h.a.i;
import y.f.h.a.q;

class p {
    h a = new h(null, null, null);

    p() {
        this.a.a(this.a);
        this.a.b(this.a);
    }

    public Iterator a() {
        return new q(this);
    }

    h a(i i2) {
        return this.a.c.a(i2);
    }

    i b() {
        return this.a.b.a();
    }

    i c() {
        return this.a.c.a();
    }

    public String toString() {
        String string;
        boolean bl2 = b.g;
        String string2 = "[";
        Iterator iterator = this.a();
        while (iterator.hasNext()) {
            string = string2;
            if (bl2) return string;
            if (string != "[") {
                string2 = new StringBuffer().append(string2).append(", ").toString();
            }
            string2 = new StringBuffer().append(string2).append("(").append(iterator.next().toString()).append(")").toString();
            if (!bl2) continue;
        }
        string = new StringBuffer().append(string2).append("]").toString();
        return string;
    }
}

