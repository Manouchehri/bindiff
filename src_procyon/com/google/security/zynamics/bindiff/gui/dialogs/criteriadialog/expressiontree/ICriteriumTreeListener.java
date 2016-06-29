package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;

public interface ICriteriumTreeListener
{
    void nodeAppended(final CriteriumTree p0, final ICriteriumTreeNode p1, final ICriteriumTreeNode p2);
    
    void nodeInserted(final CriteriumTree p0, final ICriteriumTreeNode p1, final ICriteriumTreeNode p2);
    
    void nodeRemoved(final CriteriumTree p0, final ICriteriumTreeNode p1);
    
    void removedAll(final CriteriumTree p0);
}
