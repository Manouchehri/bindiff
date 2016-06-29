package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;

public interface ICriterium
{
    void addListener(final ICriteriumListener p0);
    
    String getCriteriumDescription();
    
    JPanel getCriteriumPanel();
    
    Icon getIcon();
    
    CriteriumType getType();
    
    void removeAllListener();
    
    void removeListener(final ICriteriumListener p0);
    
    boolean matches(final ZyGraphNode p0);
}
