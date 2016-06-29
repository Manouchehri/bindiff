/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

class l {
    l a;
    l b;
    l c;
    Object d;
    byte e;

    public l(Object object) {
        this.d = object;
    }

    void a(l l2) {
        this.b = l2;
        if (l2 == null) return;
        l2.a = this;
    }

    void b(l l2) {
        this.c = l2;
        if (l2 == null) return;
        l2.a = this;
    }

    public String toString() {
        return new StringBuffer().append(this.d.toString()).append(" / ").append(this.e).toString();
    }
}

