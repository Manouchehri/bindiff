/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.D;

class E
implements PropertyChangeListener {
    private final KeyboardFocusManager a;
    private final D b;

    public E(D d2, KeyboardFocusManager keyboardFocusManager) {
        this.b = d2;
        this.a = keyboardFocusManager;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        D.a(this.b, this.a.getPermanentFocusOwner());
    }
}

