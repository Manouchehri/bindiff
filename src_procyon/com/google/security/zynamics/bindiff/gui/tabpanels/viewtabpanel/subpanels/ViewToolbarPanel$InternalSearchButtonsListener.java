package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.utils.*;

public class ViewToolbarPanel$InternalSearchButtonsListener implements ActionListener
{
    final /* synthetic */ ViewToolbarPanel this$0;
    
    public ViewToolbarPanel$InternalSearchButtonsListener(final ViewToolbarPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.clearSearchResultsButton)) {
            GraphSeacherFunctions.clearResults(this.this$0.controller.getGraphs());
            this.this$0.searchField.notifySearchFieldListener();
        }
        else if (actionEvent.getSource().equals(this.this$0.searchOptionsButton)) {
            this.this$0.searchOptionsDialog.setVisible(true);
        }
    }
}
