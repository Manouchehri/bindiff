/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater$InternalGraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.types.common.ICancelableCommand;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.awt.Window;
import javax.swing.SwingUtilities;

public class GraphLayoutUpdater
implements ICommand {
    private final BinDiffGraph referenceGraph;
    private final boolean showProgress;

    public GraphLayoutUpdater(BinDiffGraph binDiffGraph, boolean bl2) {
        this.referenceGraph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.showProgress = bl2;
    }

    private static Window getParentWindow(BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) return BinDiffGraph.getParentWindow(binDiffGraph.getCombinedGraph());
        return BinDiffGraph.getParentWindow(binDiffGraph.getPrimaryGraph());
    }

    public static void executeStatic(BinDiffGraph binDiffGraph, boolean bl2) {
        Object object;
        GraphLayoutCalculator graphLayoutCalculator = new GraphLayoutCalculator(binDiffGraph);
        Window window = GraphLayoutUpdater.getParentWindow(binDiffGraph.getPrimaryGraph());
        try {
            if (bl2) {
                object = new CUnlimitedProgressDialog(window, "BinDiff", "Calculating the new graph layout...", graphLayoutCalculator);
                object.setVisible(true);
                if (object.wasCanceled()) {
                    return;
                }
                if (object.getException() != null) {
                    throw object.getException();
                }
            } else {
                graphLayoutCalculator.execute();
            }
        }
        catch (Exception var4_5) {
            throw new GraphLayoutException(var4_5, "Couldn't calculate graph layout.");
        }
        if (bl2) {
            SwingUtilities.invokeLater(new GraphLayoutUpdater$InternalGraphViewUpdater(graphLayoutCalculator, window));
            return;
        }
        object = new GraphViewUpdater(graphLayoutCalculator);
        object.execute();
    }

    @Override
    public void execute() {
        GraphLayoutUpdater.executeStatic(this.referenceGraph, this.showProgress);
    }
}

