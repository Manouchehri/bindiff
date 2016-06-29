/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.BitSet;
import y.f.X;

class aU
extends BitSet {
    public aU() {
    }

    public aU(int n2) {
        super(n2);
    }

    @Override
    public int nextSetBit(int n2) {
        boolean bl2 = X.j;
        int n3 = this.size();
        int n4 = n2;
        do {
            if (n4 >= n3) return -1;
            int n5 = (int)this.get(n4) ? 1 : 0;
            if (bl2) return n5;
            if (n5 != 0) {
                return n4;
            }
            ++n4;
        } while (!bl2);
        return -1;
    }

    @Override
    public int cardinality() {
        int n2;
        boolean bl2 = X.j;
        int n3 = this.size();
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = (int)this.get(i2) ? 1 : 0;
            if (bl2) return n2;
            if (n2 == 0) continue;
            ++n4;
            if (!bl2) continue;
        }
        n2 = n4;
        return n2;
    }

    @Override
    public void clear(int n2, int n3) {
        boolean bl2 = X.j;
        int n4 = n2;
        do {
            if (n4 >= n3) return;
            this.clear(n4);
            ++n4;
        } while (!bl2);
    }

    @Override
    public void set(int n2, int n3) {
        boolean bl2 = X.j;
        int n4 = n2;
        do {
            if (n4 >= n3) return;
            this.set(n4);
            ++n4;
        } while (!bl2);
    }
}

