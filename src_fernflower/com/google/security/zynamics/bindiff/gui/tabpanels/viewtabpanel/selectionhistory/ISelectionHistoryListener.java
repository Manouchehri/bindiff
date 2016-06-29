package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;

public interface ISelectionHistoryListener {
   void finishedRedo();

   void finishedUndo();

   void snapshotAdded(SelectionSnapshot var1);

   void snapshotRemoved();

   void startedRedo();

   void startedUndo();
}
