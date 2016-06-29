/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.g.al;

class P {
    private String d;
    private al e = new al();
    int a;
    int b;
    int c;

    P() {
    }

    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = "0";
        this.e.a();
        this.e.e();
    }

    public void b() {
        this.d = this.e.toString();
    }

    public String toString() {
        return new StringBuffer().append("\nMinCostFlow-Statistics:\n   Time: ").append(this.d).append("\n   Scalings: ").append(this.a).append("\n   Augmentations : ").append(this.b).append("\n   ExtractMins: ").append(this.c).toString();
    }
}

