/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.Window;

final class GraphLayoutUpdater$InternalGraphViewUpdater
implements Runnable {
    private final GraphLayoutCalculator layoutCalculator;
    private final Window window;

    public GraphLayoutUpdater$InternalGraphViewUpdater(GraphLayoutCalculator graphLayoutCalculator, Window window) {
        this.layoutCalculator = graphLayoutCalculator;
        this.window = window;
    }

    @Override
    public void run() {
        try {
            GraphViewUpdater graphViewUpdater = new GraphViewUpdater(this.layoutCalculator);
            graphViewUpdater.execute();
            return;
        }
        catch (GraphLayoutException var1_2) {
            CMessageBox.showWarning(this.window, "Couldn't update graph layout.");
            Logger.logException(var1_2, "Couldn't update graph layout.");
        }
    }
}

