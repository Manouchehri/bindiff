/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import java.util.Collection;

public interface ISelectableGraph {
    public void iterateSelected(INodeCallback var1);

    public void selectNodes(Collection var1, boolean var2);

    public void selectNodes(Collection var1, Collection var2);
}

