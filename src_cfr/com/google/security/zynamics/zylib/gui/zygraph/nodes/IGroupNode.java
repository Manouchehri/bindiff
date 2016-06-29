/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import java.util.List;

public interface IGroupNode
extends IViewNode {
    public void addElement(IViewNode var1);

    public List getElements();

    public boolean isCollapsed();

    public void setCollapsed(boolean var1);
}

