package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import javax.swing.*;

public class GraphLayoutUpdater implements ICommand
{
    private final BinDiffGraph referenceGraph;
    private final boolean showProgress;
    
    public GraphLayoutUpdater(final BinDiffGraph binDiffGraph, final boolean showProgress) {
        this.referenceGraph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.showProgress = showProgress;
    }
    
    private static Window getParentWindow(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            return BinDiffGraph.getParentWindow(binDiffGraph.getPrimaryGraph());
        }
        return BinDiffGraph.getParentWindow(binDiffGraph.getCombinedGraph());
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph, final boolean b) {
        final GraphLayoutCalculator graphLayoutCalculator = new GraphLayoutCalculator(binDiffGraph);
        final Window parentWindow = getParentWindow(binDiffGraph.getPrimaryGraph());
        try {
            if (b) {
                final CUnlimitedProgressDialog cUnlimitedProgressDialog = new CUnlimitedProgressDialog(parentWindow, "BinDiff", "Calculating the new graph layout...", graphLayoutCalculator);
                cUnlimitedProgressDialog.setVisible(true);
                if (cUnlimitedProgressDialog.wasCanceled()) {
                    return;
                }
                if (cUnlimitedProgressDialog.getException() != null) {
                    throw cUnlimitedProgressDialog.getException();
                }
            }
            else {
                graphLayoutCalculator.execute();
            }
        }
        catch (Exception ex) {
            throw new GraphLayoutException(ex, "Couldn't calculate graph layout.");
        }
        if (b) {
            SwingUtilities.invokeLater(new GraphLayoutUpdater$InternalGraphViewUpdater(graphLayoutCalculator, parentWindow));
        }
        else {
            new GraphViewUpdater(graphLayoutCalculator).execute();
        }
    }
    
    @Override
    public void execute() {
        executeStatic(this.referenceGraph, this.showProgress);
    }
}
