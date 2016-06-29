package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.utils.*;

class SelectionHistoryTreeGroupNode$2 extends AbstractAction
{
    final /* synthetic */ SelectionHistoryTreeGroupNode this$0;
    
    SelectionHistoryTreeGroupNode$2(final SelectionHistoryTreeGroupNode this$0, final String s) {
        this.this$0 = this$0;
        super(s);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<SingleDiffNode> iterator = this.this$0.snapshot.getSingleGraphSelection().iterator();
        while (iterator.hasNext()) {
            sb.append(((RawFunction)iterator.next().getRawNode()).getName());
            sb.append("\n");
        }
        ClipboardHelpers.copyToClipboard(sb.toString());
    }
}
