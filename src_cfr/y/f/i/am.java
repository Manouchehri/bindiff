/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

class aM {
    public boolean a;
    private Object b;
    private Object c;
    private double d;

    aM() {
    }

    public void a(Object object) {
        this.b = object;
    }

    public Object a() {
        return this.b;
    }

    public void b(Object object) {
        this.c = object;
    }

    public Object b() {
        return this.c;
    }

    public void a(double d2) {
        this.d = d2;
    }

    public double c() {
        return this.d;
    }

    static double a(aM aM2, double d2) {
        aM2.d = d2;
        return aM2.d;
    }

    static double a(aM aM2) {
        return aM2.d;
    }
}

