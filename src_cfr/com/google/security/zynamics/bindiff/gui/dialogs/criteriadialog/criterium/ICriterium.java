/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.JPanel;

public interface ICriterium {
    public void addListener(ICriteriumListener var1);

    public String getCriteriumDescription();

    public JPanel getCriteriumPanel();

    public Icon getIcon();

    public CriteriumType getType();

    public void removeAllListener();

    public void removeListener(ICriteriumListener var1);

    public boolean matches(ZyGraphNode var1);
}

