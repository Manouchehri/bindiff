/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;

public interface IUnmatchedFunctionsViewsTableListener {
    public void rowSelectionChanged(UnmatchedFunctionViewsTable var1);

    public void tableDataChanged(UnmatchedFunctionViewsTableModel var1);
}

