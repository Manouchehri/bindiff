package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.gui.tables.*;
import com.google.common.base.*;
import javax.swing.table.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class AbstractTable$InternalSelectionListener implements ListSelectionListener
{
    final /* synthetic */ AbstractTable this$0;
    
    private AbstractTable$InternalSelectionListener(final AbstractTable this$0) {
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
