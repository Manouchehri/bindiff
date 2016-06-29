/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import y.b.d;
import y.b.n;

class m
implements d {
    private final d a;
    private n b;

    m(d d2, n n2) {
        this.a = d2;
        this.b = n2;
    }

    @Override
    public void initAnimation() {
        this.a.initAnimation();
    }

    @Override
    public void calcFrame(double d2) {
        this.a.calcFrame(this.b.a(d2));
    }

    @Override
    public void disposeAnimation() {
        this.a.disposeAnimation();
    }

    @Override
    public long preferredDuration() {
        return this.a.preferredDuration();
    }
}

