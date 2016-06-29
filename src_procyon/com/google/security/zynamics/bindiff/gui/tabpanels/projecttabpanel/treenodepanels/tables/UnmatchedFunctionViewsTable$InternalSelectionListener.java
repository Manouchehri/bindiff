package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import javax.swing.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import javax.swing.table.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.*;
import com.google.security.zynamics.zylib.disassembly.*;

class UnmatchedFunctionViewsTable$InternalSelectionListener implements ListSelectionListener
{
    final /* synthetic */ UnmatchedFunctionViewsTable this$0;
    
    private UnmatchedFunctionViewsTable$InternalSelectionListener(final UnmatchedFunctionViewsTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void valueChanged(final ListSelectionEvent listSelectionEvent) {
        final Iterator iterator = this.this$0.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().rowSelectionChanged(this.this$0);
        }
    }
}
