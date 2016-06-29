package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.layout.commands.*;

public class GraphLayoutEventHandler
{
    private static void blockAllGraphsIntermediateListeners(final BinDiffGraph binDiffGraph) {
        binDiffGraph.getIntermediateListeners().blockZyLibSelectionListeners();
        binDiffGraph.getIntermediateListeners().blockZyLibVisibilityListeners();
    }
    
    private static void freeAllGraphsIntermediateListeners(final BinDiffGraph binDiffGraph) {
        binDiffGraph.getIntermediateListeners().freeZyLibVisibilityListeners();
        binDiffGraph.getIntermediateListeners().freeZyLibSelectionListeners();
    }
    
    public static void handleDoLayoutButtonEvent(final BinDiffGraph binDiffGraph, final boolean b) {
        try {
            GraphLayoutUpdater.executeStatic(binDiffGraph, b);
        }
        catch (GraphLayoutException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), ex.getMessage());
        }
    }
    
    public static void handleInitialLayoutEvent(final BinDiffGraph binDiffGraph) {
        try {
            blockAllGraphsIntermediateListeners(binDiffGraph);
            GraphLayoutInitializer.executeStatic(binDiffGraph);
        }
        catch (GraphLayoutException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), ex.getMessage());
        }
        finally {
            freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }
    
    public static void handleProximityBrowsingActivatedEvent(final BinDiffGraph binDiffGraph) {
        try {
            blockAllGraphsIntermediateListeners(binDiffGraph);
            ProximityBrowserActivator.executeStatic(binDiffGraph);
        }
        catch (GraphLayoutException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), ex.getMessage());
        }
        finally {
            freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }
    
    public static void handleProximityBrowsingDeactivatedEvent(final BinDiffGraph binDiffGraph) {
        try {
            binDiffGraph.getSettings().getProximitySettings().setProximityBrowsing(false);
            blockAllGraphsIntermediateListeners(binDiffGraph);
            ProximityBrowserDeactivator.executeStatic(binDiffGraph);
        }
        catch (GraphLayoutException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), ex.getMessage());
        }
        finally {
            freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }
    
    public static void handleProximityNodeClickedEvent(final BinDiffGraph binDiffGraph, final ZyProximityNode zyProximityNode) {
        try {
            blockAllGraphsIntermediateListeners(binDiffGraph);
            ProximityNodeClickedUpdater.executeStatic(binDiffGraph, zyProximityNode);
        }
        catch (GraphLayoutException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), ex.getMessage());
        }
        finally {
            freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }
    
    public static void handleReactivateViewSynchronization(final BinDiffGraph binDiffGraph) {
        try {
            blockAllGraphsIntermediateListeners(binDiffGraph);
            GraphReactivateViewSynchronization.executeStatic(binDiffGraph);
        }
        catch (GraphLayoutException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), ex.getMessage());
        }
        finally {
            freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }
    
    public static void handleSelectionChangedEvent(final BinDiffGraph binDiffGraph, final boolean b) {
        try {
            blockAllGraphsIntermediateListeners(binDiffGraph);
            GraphSelectionUpdater.executeStatic(binDiffGraph);
        }
        catch (GraphLayoutException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), ex.getMessage());
        }
        finally {
            freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }
    
    public static void handleUnhideInvisibleNode(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        try {
            blockAllGraphsIntermediateListeners(binDiffGraph);
            ProximityBrowserUnhideNode.executeStatic(binDiffGraph, zyGraphNode);
        }
        catch (GraphLayoutException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(BinDiffGraph.getParentWindow(binDiffGraph), ex.getMessage());
        }
        finally {
            freeAllGraphsIntermediateListeners(binDiffGraph);
        }
    }
}
