/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import y.h.bB;

final class bC
implements ContainerListener {
    private final bB a;

    bC(bB bB2) {
        this.a = bB2;
    }

    @Override
    public void componentRemoved(ContainerEvent containerEvent) {
        Component component = containerEvent.getChild();
        this.a.b(component);
    }

    @Override
    public void componentAdded(ContainerEvent containerEvent) {
        Component component = containerEvent.getChild();
        this.a.a(component);
    }
}

