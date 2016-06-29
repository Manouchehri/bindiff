package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;

public interface IMouseState {
   CStateFactory getStateFactory();

   IMouseStateChange mouseDragged(MouseEvent var1, AbstractZyGraph var2);

   IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2);

   IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2);

   IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2);
}
