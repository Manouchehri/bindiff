/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;

public interface IMouseState {
    public CStateFactory getStateFactory();

    public IMouseStateChange mouseDragged(MouseEvent var1, AbstractZyGraph var2);

    public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2);

    public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2);

    public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2);
}

