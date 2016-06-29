/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import java.util.List;

public interface ICriteriumTreeNode {
    public List getChildren();

    public ICriterium getCriterium();

    public ICriteriumTreeNode getParent();

    public void setParent(ICriteriumTreeNode var1);
}

