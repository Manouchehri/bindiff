/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.BitSet;
import y.f.d.a;

class B
extends BitSet {
    public B() {
    }

    public B(int n2) {
        super(n2);
    }

    @Override
    public int nextSetBit(int n2) {
        int n3 = a.f;
        int n4 = this.size();
        int n5 = n2;
        do {
            if (n5 >= n4) return -1;
            int n6 = (int)this.get(n5) ? 1 : 0;
            if (n3 != 0) return n6;
            if (n6 != 0) {
                return n5;
            }
            ++n5;
        } while (n3 == 0);
        return -1;
    }

    @Override
    public int cardinality() {
        int n2;
        int n3 = a.f;
        int n4 = this.size();
        int n5 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            n2 = (int)this.get(i2) ? 1 : 0;
            if (n3 != 0) return n2;
            if (n2 == 0) continue;
            ++n5;
            if (n3 == 0) continue;
        }
        n2 = n5;
        return n2;
    }

    @Override
    public void clear(int n2, int n3) {
        int n4 = a.f;
        int n5 = n2;
        do {
            if (n5 >= n3) return;
            this.clear(n5);
            ++n5;
        } while (n4 == 0);
    }

    @Override
    public void set(int n2, int n3) {
        int n4 = a.f;
        int n5 = n2;
        do {
            if (n5 >= n3) return;
            this.set(n5);
            ++n5;
        } while (n4 == 0);
    }
}

