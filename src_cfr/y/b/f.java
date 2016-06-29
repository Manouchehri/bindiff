/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import y.b.a;
import y.b.c;
import y.b.e;

class f
implements Runnable {
    private final c[] a;
    private final a b;
    private final e c;

    f(e e2, c[] arrc, a a2) {
        this.c = e2;
        this.a = arrc;
        this.b = a2;
    }

    @Override
    public void run() {
        int n2 = e.a;
        int n3 = 0;
        int n4 = this.a.length;
        do {
            if (n3 >= n4) return;
            this.a[n3].animationPerformed(this.b);
            ++n3;
        } while (n2 == 0);
    }
}

