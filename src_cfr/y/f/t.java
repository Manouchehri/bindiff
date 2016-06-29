/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.d.n;
import y.d.y;
import y.f.R;

public class T
implements R {
    private n a;
    private y b;
    private Object c;

    @Override
    public n getOrientedBox() {
        return this.a;
    }

    public void a(n n2) {
        this.a = n2;
        this.b = n2.h();
    }

    @Override
    public y getBox() {
        return this.b;
    }

    @Override
    public Object getModelParameter() {
        return this.c;
    }

    @Override
    public void setModelParameter(Object object) {
        this.c = object;
    }
}

