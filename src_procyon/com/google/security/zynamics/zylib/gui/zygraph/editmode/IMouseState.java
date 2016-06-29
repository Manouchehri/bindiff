package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;

public interface IMouseState
{
    CStateFactory getStateFactory();
    
    IMouseStateChange mouseDragged(final MouseEvent p0, final AbstractZyGraph p1);
    
    IMouseStateChange mouseMoved(final MouseEvent p0, final AbstractZyGraph p1);
    
    IMouseStateChange mousePressed(final MouseEvent p0, final AbstractZyGraph p1);
    
    IMouseStateChange mouseReleased(final MouseEvent p0, final AbstractZyGraph p1);
}
