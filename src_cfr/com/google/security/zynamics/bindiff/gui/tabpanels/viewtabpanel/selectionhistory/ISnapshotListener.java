/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

public interface ISnapshotListener {
    public void addedNode(ZyGraphNode var1);

    public void finished();

    public void removedNode(ZyGraphNode var1);
}

