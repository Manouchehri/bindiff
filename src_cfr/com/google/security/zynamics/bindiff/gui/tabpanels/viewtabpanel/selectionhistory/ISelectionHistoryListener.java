/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;

public interface ISelectionHistoryListener {
    public void finishedRedo();

    public void finishedUndo();

    public void snapshotAdded(SelectionSnapshot var1);

    public void snapshotRemoved();

    public void startedRedo();

    public void startedUndo();
}

