package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;

public class ShowInCallGraphAction extends AbstractAction
{
    private final AbstractTable table;
    
    public ShowInCallGraphAction(final AbstractTable abstractTable) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final HashSet<Pair> set = new HashSet<Pair>();
        final int[] selectedRows = this.table.getSelectedRows();
        for (int length = selectedRows.length, i = 0; i < length; ++i) {
            set.add(AbstractTable.getViewAddressPair(this.table, selectedRows[i]));
        }
        this.table.getController().showInCallgraph(this.table.getDiff(), set);
    }
}
