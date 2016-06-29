/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.EventObject;
import y.h.dB;
import y.h.gZ;

public class dD
extends EventObject {
    private final dB a;
    private final gZ b;
    private final int c;
    private final double d;
    private final double e;
    private final boolean f;

    public dD(dB dB2, gZ gZ2, int n2, double d2, double d3, boolean bl2) {
        super(dB2);
        this.a = dB2;
        this.b = gZ2;
        this.c = n2;
        this.d = d2;
        this.e = d3;
        this.f = bl2;
    }

    public dB a() {
        return this.a;
    }

    public gZ b() {
        return this.b;
    }

    public double c() {
        return this.d;
    }

    public double d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }
}

