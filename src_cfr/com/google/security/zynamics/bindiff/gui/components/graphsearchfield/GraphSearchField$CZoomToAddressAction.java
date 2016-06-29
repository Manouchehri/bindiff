/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphAddressSearcher;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class GraphSearchField$CZoomToAddressAction
extends AbstractAction {
    final /* synthetic */ GraphSearchField this$0;

    private GraphSearchField$CZoomToAddressAction(GraphSearchField graphSearchField) {
        this.this$0 = graphSearchField;
    }

    private boolean jumpToAddress(IAddress iAddress, ESide eSide) {
        String string;
        String string2 = string = eSide == ESide.PRIMARY ? GraphSearchField.access$600(this.this$0).getText() : GraphSearchField.access$700(this.this$0).getText();
        if (!string.isEmpty()) {
            if (eSide == ESide.PRIMARY) {
                GraphSearchField.access$2000(this.this$0).add(string);
                GraphSearchField.access$600(this.this$0).setCaretPosition(string.length());
            } else {
                GraphSearchField.access$2100(this.this$0).add(string);
                GraphSearchField.access$700(this.this$0).setCaretPosition(string.length());
            }
        }
        BinDiffGraph binDiffGraph = GraphSearchField.access$1100(this.this$0).getCombinedGraph();
        if (GraphSearchField.access$1900(this.this$0).getGraphSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            BinDiffGraph binDiffGraph2 = binDiffGraph = eSide == ESide.PRIMARY ? GraphSearchField.access$1100(this.this$0).getPrimaryGraph() : GraphSearchField.access$1100(this.this$0).getSecondaryGraph();
        }
        if (binDiffGraph instanceof SingleGraph) {
            SingleDiffNode singleDiffNode = GraphAddressSearcher.searchAddress((SingleGraph)binDiffGraph, iAddress);
            if (singleDiffNode != null) {
                GraphZoomer.zoomToNode(binDiffGraph, singleDiffNode);
            }
            if (singleDiffNode == null) return false;
            return true;
        }
        if (!(binDiffGraph instanceof CombinedGraph)) return true;
        CombinedDiffNode combinedDiffNode = GraphAddressSearcher.searchAddress(binDiffGraph, eSide, iAddress);
        if (combinedDiffNode != null) {
            GraphZoomer.zoomToNode(binDiffGraph, combinedDiffNode);
        }
        if (combinedDiffNode == null) return false;
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CAddress cAddress;
        if (actionEvent.getSource() == GraphSearchField.access$600(this.this$0) && GraphSearchField.access$600(this.this$0).getText() != null) {
            if (GraphSearchField.access$600(this.this$0).getText().isEmpty()) {
                GraphSearchField.access$600(this.this$0).setBackground(GraphSearchField.access$1700());
                return;
            }
            GraphSearchField.access$600(this.this$0).setBackground(this.jumpToAddress(cAddress = new CAddress(GraphSearchField.access$600(this.this$0).getText(), 16), ESide.PRIMARY) ? GraphSearchField.access$1700() : GraphSearchField.access$1400());
            GraphSearchField.access$600(this.this$0).setFocusable(false);
            GraphSearchField.access$600(this.this$0).setFocusable(true);
            GraphSearchField.access$600(this.this$0).grabFocus();
            GraphSearchField.access$600(this.this$0).updateUI();
        }
        if (actionEvent.getSource() != GraphSearchField.access$700(this.this$0)) return;
        if (GraphSearchField.access$700(this.this$0).getText() == null) return;
        if (GraphSearchField.access$700(this.this$0).getText().isEmpty()) {
            GraphSearchField.access$700(this.this$0).setBackground(GraphSearchField.access$1700());
            return;
        }
        GraphSearchField.access$700(this.this$0).setBackground(this.jumpToAddress(cAddress = new CAddress(GraphSearchField.access$700(this.this$0).getText(), 16), ESide.SECONDARY) ? GraphSearchField.access$1700() : GraphSearchField.access$1400());
        GraphSearchField.access$700(this.this$0).setFocusable(false);
        GraphSearchField.access$700(this.this$0).setFocusable(true);
        GraphSearchField.access$700(this.this$0).grabFocus();
        GraphSearchField.access$700(this.this$0).updateUI();
    }

    /* synthetic */ GraphSearchField$CZoomToAddressAction(GraphSearchField graphSearchField, GraphSearchField$1 graphSearchField$1) {
        this(graphSearchField);
    }
}

