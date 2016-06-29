/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.g.al;

class L {
    private String f;
    private al g = new al();
    int a;
    int b;
    int c;
    int d;
    int e;

    L() {
    }

    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = "0";
        this.g.a();
        this.g.e();
    }

    public void b() {
        this.f = this.g.toString();
    }

    public String toString() {
        return new StringBuffer().append("\nMaxFlow-Statistics:\n   Time: ").append(this.f).append("\n   Pushes: ").append(this.b).append("\n   Inspections: ").append(this.c).append("\n   Relabels: ").append(this.a).append("\n   GlobalRelabels: ").append(this.d).append("\n   Gaps: ").append(this.e).toString();
    }
}

