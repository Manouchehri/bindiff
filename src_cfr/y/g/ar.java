/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Random;
import y.g.p;

public class ar
extends Random {
    public ar() {
    }

    public ar(long l2) {
        super(l2);
    }

    @Override
    public int nextInt(int n2) {
        int n3;
        boolean bl2 = p.c;
        if (n2 <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        block0 : do {
            int n4 = this.next(31);
            int n5 = n4 % n2;
            n3 = n4 - n5 + (n2 - 1);
            do {
                if (n3 < 0) continue block0;
                n3 = n5;
            } while (bl2);
            break;
        } while (true);
        return n3;
    }

    public double a(double d2, double d3) {
        return this.nextDouble() * (d3 - d2) + d2;
    }

    public int a(int n2, int n3) {
        return this.nextInt(n3 - n2) + n2;
    }

    public void a(Object[] arrobject) {
        int n2;
        int n3;
        Object object;
        boolean bl2;
        block3 : {
            bl2 = p.c;
            for (n3 = 0; n3 < arrobject.length; ++n3) {
                n2 = this.nextInt(arrobject.length);
                object = arrobject[n3];
                arrobject[n3] = arrobject[n2];
                arrobject[n2] = object;
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            n3 = arrobject.length - 1;
        }
        do {
            if (n3 < 0) return;
            n2 = this.nextInt(arrobject.length);
            object = arrobject[n3];
            arrobject[n3] = arrobject[n2];
            arrobject[n2] = object;
            --n3;
        } while (!bl2);
    }
}

