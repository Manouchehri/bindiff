/*
 * Decompiled with CFR 0_115.
 */
package y.h;

final class gE {
    float a;
    float b;
    float c;
    float d;

    public gE(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
    }

    public float a(float f2) {
        return ((this.d * f2 + this.c) * f2 + this.b) * f2 + this.a;
    }
}

