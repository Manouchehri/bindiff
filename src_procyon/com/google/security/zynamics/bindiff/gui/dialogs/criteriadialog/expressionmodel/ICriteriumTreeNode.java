package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public interface ICriteriumTreeNode
{
    List getChildren();
    
    ICriterium getCriterium();
    
    ICriteriumTreeNode getParent();
    
    void setParent(final ICriteriumTreeNode p0);
}
