package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.resources.*;

final class GraphSearchField$CZoomToAddressAction extends AbstractAction
{
    final /* synthetic */ GraphSearchField this$0;
    
    private GraphSearchField$CZoomToAddressAction(final GraphSearchField this$0) {
        this.this$0 = this$0;
    }
    
    private boolean jumpToAddress(final IAddress address, final ESide eSide) {
        final String s = (eSide == ESide.PRIMARY) ? this.this$0.priHexField.getText() : this.this$0.secHexField.getText();
        if (!s.isEmpty()) {
            if (eSide == ESide.PRIMARY) {
                this.this$0.priJumpCombo.add(s);
                this.this$0.priHexField.setCaretPosition(s.length());
            }
            else {
                this.this$0.secJumpCombo.add(s);
                this.this$0.secHexField.setCaretPosition(s.length());
            }
        }
        BinDiffGraph combinedGraph = this.this$0.graphs.getCombinedGraph();
        if (this.this$0.controller.getGraphSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            combinedGraph = ((eSide == ESide.PRIMARY) ? this.this$0.graphs.getPrimaryGraph() : this.this$0.graphs.getSecondaryGraph());
        }
        if (combinedGraph instanceof SingleGraph) {
            final SingleDiffNode searchAddress = GraphAddressSearcher.searchAddress((SingleGraph)combinedGraph, address);
            if (searchAddress != null) {
                GraphZoomer.zoomToNode(combinedGraph, searchAddress);
            }
            return searchAddress != null;
        }
        if (combinedGraph instanceof CombinedGraph) {
            final CombinedDiffNode searchAddress2 = GraphAddressSearcher.searchAddress((CombinedGraph)combinedGraph, eSide, address);
            if (searchAddress2 != null) {
                GraphZoomer.zoomToNode(combinedGraph, searchAddress2);
            }
            return searchAddress2 != null;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.this$0.priHexField && this.this$0.priHexField.getText() != null) {
            if (this.this$0.priHexField.getText().isEmpty()) {
                this.this$0.priHexField.setBackground(GraphSearchField.BACKGROUND_COLOR_SUCCESS);
                return;
            }
            this.this$0.priHexField.setBackground(this.jumpToAddress(new CAddress(this.this$0.priHexField.getText(), 16), ESide.PRIMARY) ? GraphSearchField.BACKGROUND_COLOR_SUCCESS : GraphSearchField.BACKGROUND_COLOR_FAIL);
            this.this$0.priHexField.setFocusable(false);
            this.this$0.priHexField.setFocusable(true);
            this.this$0.priHexField.grabFocus();
            this.this$0.priHexField.updateUI();
        }
        if (actionEvent.getSource() == this.this$0.secHexField && this.this$0.secHexField.getText() != null) {
            if (this.this$0.secHexField.getText().isEmpty()) {
                this.this$0.secHexField.setBackground(GraphSearchField.BACKGROUND_COLOR_SUCCESS);
                return;
            }
            this.this$0.secHexField.setBackground(this.jumpToAddress(new CAddress(this.this$0.secHexField.getText(), 16), ESide.SECONDARY) ? GraphSearchField.BACKGROUND_COLOR_SUCCESS : GraphSearchField.BACKGROUND_COLOR_FAIL);
            this.this$0.secHexField.setFocusable(false);
            this.this$0.secHexField.setFocusable(true);
            this.this$0.secHexField.grabFocus();
            this.this$0.secHexField.updateUI();
        }
    }
}
