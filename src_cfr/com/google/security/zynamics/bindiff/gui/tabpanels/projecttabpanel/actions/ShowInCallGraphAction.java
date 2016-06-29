/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.general.Pair;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;

public class ShowInCallGraphAction
extends AbstractAction {
    private final AbstractTable table;

    public ShowInCallGraphAction(AbstractTable abstractTable) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        HashSet<Pair> hashSet = new HashSet<Pair>();
        Object object = this.table.getSelectedRows();
        int n2 = object.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                object = this.table.getDiff();
                this.table.getController().showInCallgraph((Diff)object, hashSet);
                return;
            }
            int n4 = object[n3];
            hashSet.add(AbstractTable.getViewAddressPair(this.table, n4));
            ++n3;
        } while (true);
    }
}

