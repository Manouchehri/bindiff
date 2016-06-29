/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.g.al;

class O {
    private String c;
    private al d = new al();
    int a;
    int b;

    O() {
    }

    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = "0";
        this.d.a();
        this.d.e();
    }

    public void b() {
        this.c = this.d.toString();
    }

    public String toString() {
        return new StringBuffer().append("\nMinCostFlow-Statistics:\n   Time: ").append(this.c).append("\n   Augmentations : ").append(this.a).append("\n   ExtractMins: ").append(this.b).toString();
    }
}

