/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.f.C;
import y.f.E;
import y.f.T;
import y.f.aG;

public class D
extends T
implements C {
    private E a;
    private aG b = aG.g(0);

    @Override
    public E getLabelModel() {
        return this.a;
    }

    public void a(E e2) {
        this.a = e2;
    }

    public void a(aG aG2) {
        if (aG2 == null) {
            throw new IllegalArgumentException("null");
        }
        this.b = aG2;
    }

    @Override
    public aG getPreferredPlacementDescriptor() {
        return this.b;
    }
}

