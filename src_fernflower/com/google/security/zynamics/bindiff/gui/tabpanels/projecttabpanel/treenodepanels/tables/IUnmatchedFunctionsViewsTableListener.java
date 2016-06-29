package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;

public interface IUnmatchedFunctionsViewsTableListener {
   void rowSelectionChanged(UnmatchedFunctionViewsTable var1);

   void tableDataChanged(UnmatchedFunctionViewsTableModel var1);
}
