/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import java.util.EventObject;
import y.c.i;
import y.h.a.v;

public class t
extends EventObject {
    private byte a;
    private Object b;
    private Object c;

    public t(v v2, byte by2, i i2, Object object) {
        super(v2);
        this.a = by2;
        this.c = i2;
        this.b = object;
    }

    public t(v v2, byte by2, Object object, Object object2) {
        super(v2);
        this.a = by2;
        this.c = object;
        this.b = object2;
    }

    public byte a() {
        return this.a;
    }

    public Object b() {
        return this.b;
    }
}

