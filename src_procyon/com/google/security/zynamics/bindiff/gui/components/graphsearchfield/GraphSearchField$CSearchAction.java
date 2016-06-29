package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import java.util.*;
import java.util.regex.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.resources.*;

final class GraphSearchField$CSearchAction extends AbstractAction
{
    final /* synthetic */ GraphSearchField this$0;
    
    private GraphSearchField$CSearchAction(final GraphSearchField this$0) {
        this.this$0 = this$0;
    }
    
    private void centerNextSearchHit(final boolean b, final boolean b2) {
        final String text = this.this$0.searchField.getText();
        if (GraphSeacherFunctions.getHasChanged(this.this$0.graphs, text)) {
            if (!text.equals("")) {
                this.iterateObjectResults(b, b2);
            }
            else {
                GraphSeacherFunctions.clearResults(this.this$0.graphs);
                final Iterator iterator = this.this$0.listeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cleaned();
                }
            }
            this.this$0.graphs.updateViews();
        }
        else {
            this.iterateObjectResults(b, b2);
        }
    }
    
    private void iterateObjectResults(final boolean b, final boolean b2) {
        if (!GraphSeacherFunctions.isEmpty(this.this$0.graphs)) {
            GraphSeacherFunctions.iterateObjectResults(this.this$0.graphs, b, b2);
            this.this$0.graphs.updateViews();
        }
    }
    
    private void search(final boolean b) {
        final String text = this.this$0.searchField.getText();
        if (GraphSeacherFunctions.getHasChanged(this.this$0.graphs, text)) {
            if (!"".equals(text)) {
                this.this$0.searchCombo.add(text);
                this.this$0.searchField.setCaretPosition(this.this$0.searchField.getText().length());
            }
            try {
                final Iterator iterator = this.this$0.listeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cleaned();
                }
                GraphSeacherFunctions.search(this.this$0.graphs, text);
                if (GraphSeacherFunctions.isEmpty(this.this$0.graphs)) {
                    this.this$0.searchCombo.getEditor().getEditorComponent().setBackground(GraphSearchField.BACKGROUND_COLOR_FAIL);
                    this.this$0.clearSearchResultsButton.setIcon(GraphSearchField.ICON_CLEAR_GRAY);
                }
                else {
                    this.this$0.searchCombo.getEditor().getEditorComponent().setBackground(GraphSearchField.BACKGROUND_COLOR_SUCCESS);
                    this.this$0.clearSearchResultsButton.setIcon(GraphSearchField.ICON_CLEAR);
                }
                GraphSeacherFunctions.highlightSubObjectResults(this.this$0.graphs);
                GraphSeacherFunctions.jumpToFirstResultObject(this.this$0.graphs.getFocusedGraph(), b);
                this.this$0.notifySearchFieldListener();
                this.this$0.graphs.updateViews();
            }
            catch (PatternSyntaxException ex) {
                CMessageBox.showInformation(this.this$0.controller.getMainWindow(), String.format("Invalid Regular Expression '%s'", text));
            }
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.this$0.searchField && this.this$0.searchField.getText() != null) {
            if (this.this$0.searchField.getText().isEmpty()) {
                GraphSeacherFunctions.clearResults(this.this$0.graphs);
                this.this$0.searchField.setBackground(GraphSearchField.BACKGROUND_COLOR_SUCCESS);
                this.this$0.clearSearchResultsButton.setIcon(GraphSearchField.ICON_CLEAR_GRAY);
                final Iterator iterator = this.this$0.listeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cleaned();
                }
                return;
            }
            final boolean b = actionEvent.getModifiers() == 2 || actionEvent.getModifiers() == 3;
            final boolean b2 = actionEvent.getModifiers() == 1 || actionEvent.getModifiers() == 3;
            if (GraphSeacherFunctions.getHasChanged(this.this$0.graphs, this.this$0.searchField.getText())) {
                this.search(b2);
            }
            else {
                this.centerNextSearchHit(b, b2);
            }
        }
    }
}
