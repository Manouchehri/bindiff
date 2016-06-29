/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutInitializer;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphReactivateViewSynchronization;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphSelectionUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserActivator;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserDeactivator;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUnhideNode;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityNodeClickedUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;

public class GraphLayoutEventHandler {
    private static void blockAllGraphsIntermediateListeners(BinDiffGraph binDiffGraph) {
        binDiffGraph.getIntermediateListeners().blockZyLibSelectionListeners();
        binDiffGraph.getIntermediateListeners().blockZyLibVisibilityListeners();
    }

    private static void freeAllGraphsIntermediateListeners(BinDiffGraph binDiffGraph) {
        binDiffGraph.getIntermediateListeners().freeZyLibVisibilityListeners();
        binDiffGraph.getIntermediateListeners().freeZyLibSelectionListeners();
    }

    public static void handleDoLayoutButtonEvent(BinDiffGraph binDiffGraph, boolean bl2) {
        try {
            GraphLayoutUpdater.executeStatic(binDiffGraph, bl2);
            return;
        }
        catch (GraphLayoutException var2_2) {
            Logger.logException(var2_2, var2_2.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), var2_2.getMessage());
        }
    }

    public static void handleInitialLayoutEvent(BinDiffGraph binDiffGraph) {
        try {
            GraphLayoutEventHandler.blockAllGraphsIntermediateListeners(binDiffGraph);
            GraphLayoutInitializer.executeStatic(binDiffGraph);
            return;
        }
        catch (GraphLayoutException var1_1) {
            Logger.logException(var1_1, var1_1.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), var1_1.getMessage());
            return;
        }
        finally {
            GraphLayoutEventHandler.freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }

    public static void handleProximityBrowsingActivatedEvent(BinDiffGraph binDiffGraph) {
        try {
            GraphLayoutEventHandler.blockAllGraphsIntermediateListeners(binDiffGraph);
            ProximityBrowserActivator.executeStatic(binDiffGraph);
            return;
        }
        catch (GraphLayoutException var1_1) {
            Logger.logException(var1_1, var1_1.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), var1_1.getMessage());
            return;
        }
        finally {
            GraphLayoutEventHandler.freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }

    public static void handleProximityBrowsingDeactivatedEvent(BinDiffGraph binDiffGraph) {
        try {
            binDiffGraph.getSettings().getProximitySettings().setProximityBrowsing(false);
            GraphLayoutEventHandler.blockAllGraphsIntermediateListeners(binDiffGraph);
            ProximityBrowserDeactivator.executeStatic(binDiffGraph);
            return;
        }
        catch (GraphLayoutException var1_1) {
            Logger.logException(var1_1, var1_1.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), var1_1.getMessage());
            return;
        }
        finally {
            GraphLayoutEventHandler.freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }

    public static void handleProximityNodeClickedEvent(BinDiffGraph binDiffGraph, ZyProximityNode zyProximityNode) {
        try {
            GraphLayoutEventHandler.blockAllGraphsIntermediateListeners(binDiffGraph);
            ProximityNodeClickedUpdater.executeStatic(binDiffGraph, zyProximityNode);
            return;
        }
        catch (GraphLayoutException var2_2) {
            Logger.logException(var2_2, var2_2.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), var2_2.getMessage());
            return;
        }
        finally {
            GraphLayoutEventHandler.freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }

    public static void handleReactivateViewSynchronization(BinDiffGraph binDiffGraph) {
        try {
            GraphLayoutEventHandler.blockAllGraphsIntermediateListeners(binDiffGraph);
            GraphReactivateViewSynchronization.executeStatic(binDiffGraph);
            return;
        }
        catch (GraphLayoutException var1_1) {
            Logger.logException(var1_1, var1_1.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), var1_1.getMessage());
            return;
        }
        finally {
            GraphLayoutEventHandler.freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }

    public static void handleSelectionChangedEvent(BinDiffGraph binDiffGraph, boolean bl2) {
        try {
            GraphLayoutEventHandler.blockAllGraphsIntermediateListeners(binDiffGraph);
            GraphSelectionUpdater.executeStatic(binDiffGraph);
            return;
        }
        catch (GraphLayoutException var2_2) {
            Logger.logException(var2_2, var2_2.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), var2_2.getMessage());
            return;
        }
        finally {
            GraphLayoutEventHandler.freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }

    public static void handleUnhideInvisibleNode(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        try {
            GraphLayoutEventHandler.blockAllGraphsIntermediateListeners(binDiffGraph);
            ProximityBrowserUnhideNode.executeStatic(binDiffGraph, zyGraphNode);
            return;
        }
        catch (GraphLayoutException var2_2) {
            Logger.logException(var2_2, var2_2.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), var2_2.getMessage());
            return;
        }
        finally {
            GraphLayoutEventHandler.freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }
}

