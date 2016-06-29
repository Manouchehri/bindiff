/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import java.util.Collection;

public class SelectionHistoryTreeNodeWrapper {
    private final SelectionSnapshot operation;
    private final int count;

    public SelectionHistoryTreeNodeWrapper(SelectionSnapshot selectionSnapshot, int n2) {
        this.operation = selectionSnapshot;
        this.count = n2;
    }

    public String toString() {
        return String.format("%d-%s (%d)", this.count, this.operation.getDescription(), this.operation.getSelection().size());
    }
}

