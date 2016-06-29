/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSeacherFunctions;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.IGraphSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.regex.PatternSyntaxException;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxEditor;
import javax.swing.Icon;

final class GraphSearchField$CSearchAction
extends AbstractAction {
    final /* synthetic */ GraphSearchField this$0;

    private GraphSearchField$CSearchAction(GraphSearchField graphSearchField) {
        this.this$0 = graphSearchField;
    }

    private void centerNextSearchHit(boolean bl2, boolean bl3) {
        String string = GraphSearchField.access$500(this.this$0).getText();
        if (!GraphSeacherFunctions.getHasChanged(GraphSearchField.access$1100(this.this$0), string)) {
            this.iterateObjectResults(bl2, bl3);
            return;
        }
        if (!string.equals("")) {
            this.iterateObjectResults(bl2, bl3);
        } else {
            GraphSeacherFunctions.clearResults(GraphSearchField.access$1100(this.this$0));
            for (IGraphSearchFieldListener iGraphSearchFieldListener : GraphSearchField.access$1200(this.this$0)) {
                iGraphSearchFieldListener.cleaned();
            }
        }
        GraphSearchField.access$1100(this.this$0).updateViews();
    }

    private void iterateObjectResults(boolean bl2, boolean bl3) {
        if (GraphSeacherFunctions.isEmpty(GraphSearchField.access$1100(this.this$0))) return;
        GraphSeacherFunctions.iterateObjectResults(GraphSearchField.access$1100(this.this$0), bl2, bl3);
        GraphSearchField.access$1100(this.this$0).updateViews();
    }

    private void search(boolean bl2) {
        String string = GraphSearchField.access$500(this.this$0).getText();
        if (!GraphSeacherFunctions.getHasChanged(GraphSearchField.access$1100(this.this$0), string)) return;
        if (!"".equals(string)) {
            GraphSearchField.access$1300(this.this$0).add(string);
            GraphSearchField.access$500(this.this$0).setCaretPosition(GraphSearchField.access$500(this.this$0).getText().length());
        }
        try {
            for (IGraphSearchFieldListener iGraphSearchFieldListener : GraphSearchField.access$1200(this.this$0)) {
                iGraphSearchFieldListener.cleaned();
            }
            GraphSeacherFunctions.search(GraphSearchField.access$1100(this.this$0), string);
            if (GraphSeacherFunctions.isEmpty(GraphSearchField.access$1100(this.this$0))) {
                GraphSearchField.access$1300(this.this$0).getEditor().getEditorComponent().setBackground(GraphSearchField.access$1400());
                GraphSearchField.access$1600(this.this$0).setIcon(GraphSearchField.access$1500());
            } else {
                GraphSearchField.access$1300(this.this$0).getEditor().getEditorComponent().setBackground(GraphSearchField.access$1700());
                GraphSearchField.access$1600(this.this$0).setIcon(GraphSearchField.access$1800());
            }
            GraphSeacherFunctions.highlightSubObjectResults(GraphSearchField.access$1100(this.this$0));
            GraphSeacherFunctions.jumpToFirstResultObject(GraphSearchField.access$1100(this.this$0).getFocusedGraph(), bl2);
            this.this$0.notifySearchFieldListener();
            GraphSearchField.access$1100(this.this$0).updateViews();
            return;
        }
        catch (PatternSyntaxException var3_4) {
            CMessageBox.showInformation(GraphSearchField.access$1900(this.this$0).getMainWindow(), String.format("Invalid Regular Expression '%s'", string));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean bl2;
        if (actionEvent.getSource() != GraphSearchField.access$500(this.this$0)) return;
        if (GraphSearchField.access$500(this.this$0).getText() == null) return;
        if (GraphSearchField.access$500(this.this$0).getText().isEmpty()) {
            GraphSeacherFunctions.clearResults(GraphSearchField.access$1100(this.this$0));
            GraphSearchField.access$500(this.this$0).setBackground(GraphSearchField.access$1700());
            GraphSearchField.access$1600(this.this$0).setIcon(GraphSearchField.access$1500());
            Iterator iterator = GraphSearchField.access$1200(this.this$0).iterator();
            while (iterator.hasNext()) {
                IGraphSearchFieldListener iGraphSearchFieldListener = (IGraphSearchFieldListener)iterator.next();
                iGraphSearchFieldListener.cleaned();
            }
            return;
        }
        boolean bl3 = actionEvent.getModifiers() == 2 || actionEvent.getModifiers() == 3;
        boolean bl4 = bl2 = actionEvent.getModifiers() == 1 || actionEvent.getModifiers() == 3;
        if (GraphSeacherFunctions.getHasChanged(GraphSearchField.access$1100(this.this$0), GraphSearchField.access$500(this.this$0).getText())) {
            this.search(bl2);
            return;
        }
        this.centerNextSearchHit(bl3, bl2);
    }

    /* synthetic */ GraphSearchField$CSearchAction(GraphSearchField graphSearchField, GraphSearchField$1 graphSearchField$1) {
        this(graphSearchField);
    }
}

