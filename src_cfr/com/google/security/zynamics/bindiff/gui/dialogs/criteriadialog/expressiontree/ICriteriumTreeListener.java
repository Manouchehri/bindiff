/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;

public interface ICriteriumTreeListener {
    public void nodeAppended(CriteriumTree var1, ICriteriumTreeNode var2, ICriteriumTreeNode var3);

    public void nodeInserted(CriteriumTree var1, ICriteriumTreeNode var2, ICriteriumTreeNode var3);

    public void nodeRemoved(CriteriumTree var1, ICriteriumTreeNode var2);

    public void removedAll(CriteriumTree var1);
}

