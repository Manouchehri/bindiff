/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import java.util.List;
import y.b.d;
import y.b.e;
import y.b.p;

abstract class s
extends p {
    long f = 0;

    s() {
    }

    @Override
    public void disposeAnimation() {
        int n2 = e.a;
        if (this.a.isEmpty()) {
            this.b = false;
            return;
        }
        for (int i2 = this.a.size() - 1; i2 > -1; --i2) {
            ((d)this.a.get(i2)).disposeAnimation();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.b = false;
    }

    @Override
    public long preferredDuration() {
        int n2 = e.a;
        if (!this.c) return this.f;
        this.f = 0;
        for (d d2 : this.a) {
            if (d2.preferredDuration() <= this.f) continue;
            this.f = d2.preferredDuration();
            if (n2 != 0) return this.f;
            if (n2 == 0) continue;
        }
        this.c = false;
        return this.f;
    }
}

