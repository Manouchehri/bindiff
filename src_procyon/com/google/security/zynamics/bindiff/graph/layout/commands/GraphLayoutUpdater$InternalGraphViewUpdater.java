package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.exceptions.*;

final class GraphLayoutUpdater$InternalGraphViewUpdater implements Runnable
{
    private final GraphLayoutCalculator layoutCalculator;
    private final Window window;
    
    public GraphLayoutUpdater$InternalGraphViewUpdater(final GraphLayoutCalculator layoutCalculator, final Window window) {
        this.layoutCalculator = layoutCalculator;
        this.window = window;
    }
    
    @Override
    public void run() {
        try {
            new GraphViewUpdater(this.layoutCalculator).execute();
        }
        catch (GraphLayoutException ex) {
            CMessageBox.showWarning(this.window, "Couldn't update graph layout.");
            Logger.logException(ex, "Couldn't update graph layout.");
        }
    }
}
