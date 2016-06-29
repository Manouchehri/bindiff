package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import java.util.List;

public interface ICriteriumTreeNode {
   List getChildren();

   ICriterium getCriterium();

   ICriteriumTreeNode getParent();

   void setParent(ICriteriumTreeNode var1);
}
