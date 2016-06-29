package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;

public interface ICriteriumTreeListener {
   void nodeAppended(CriteriumTree var1, ICriteriumTreeNode var2, ICriteriumTreeNode var3);

   void nodeInserted(CriteriumTree var1, ICriteriumTreeNode var2, ICriteriumTreeNode var3);

   void nodeRemoved(CriteriumTree var1, ICriteriumTreeNode var2);

   void removedAll(CriteriumTree var1);
}
