/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.beans.PropertyChangeEvent;
import y.h.bu;

public class bH
extends PropertyChangeEvent {
    private Object a;

    public bH(bu bu2, Object object, String string, Object object2, Object object3) {
        super(bu2, string, object2, object3);
        this.a = object;
    }

    @Override
    public String getPropertyName() {
        return super.getPropertyName();
    }
}

