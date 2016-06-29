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
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;

public class GraphLayoutEventHandler {
   private static void blockAllGraphsIntermediateListeners(BinDiffGraph var0) {
      var0.getIntermediateListeners().blockZyLibSelectionListeners();
      var0.getIntermediateListeners().blockZyLibVisibilityListeners();
   }

   private static void freeAllGraphsIntermediateListeners(BinDiffGraph var0) {
      var0.getIntermediateListeners().freeZyLibVisibilityListeners();
      var0.getIntermediateListeners().freeZyLibSelectionListeners();
   }

   public static void handleDoLayoutButtonEvent(BinDiffGraph var0, boolean var1) {
      try {
         GraphLayoutUpdater.executeStatic(var0, var1);
      } catch (GraphLayoutException var3) {
         Logger.logException(var3, var3.getMessage());
         CMessageBox.showError(BinDiffGraph.getParentWindow(var0), var3.getMessage());
      }

   }

   public static void handleInitialLayoutEvent(BinDiffGraph var0) {
      try {
         blockAllGraphsIntermediateListeners(var0);
         GraphLayoutInitializer.executeStatic(var0);
      } catch (GraphLayoutException var5) {
         Logger.logException(var5, var5.getMessage());
         CMessageBox.showError(BinDiffGraph.getParentWindow(var0), var5.getMessage());
      } finally {
         freeAllGraphsIntermediateListeners(var0);
      }

   }

   public static void handleProximityBrowsingActivatedEvent(BinDiffGraph var0) {
      try {
         blockAllGraphsIntermediateListeners(var0);
         ProximityBrowserActivator.executeStatic(var0);
      } catch (GraphLayoutException var5) {
         Logger.logException(var5, var5.getMessage());
         CMessageBox.showError(BinDiffGraph.getParentWindow(var0), var5.getMessage());
      } finally {
         freeAllGraphsIntermediateListeners(var0);
      }

   }

   public static void handleProximityBrowsingDeactivatedEvent(BinDiffGraph var0) {
      try {
         var0.getSettings().getProximitySettings().setProximityBrowsing(false);
         blockAllGraphsIntermediateListeners(var0);
         ProximityBrowserDeactivator.executeStatic(var0);
      } catch (GraphLayoutException var5) {
         Logger.logException(var5, var5.getMessage());
         CMessageBox.showError(BinDiffGraph.getParentWindow(var0), var5.getMessage());
      } finally {
         freeAllGraphsIntermediateListeners(var0);
      }

   }

   public static void handleProximityNodeClickedEvent(BinDiffGraph var0, ZyProximityNode var1) {
      try {
         blockAllGraphsIntermediateListeners(var0);
         ProximityNodeClickedUpdater.executeStatic(var0, var1);
      } catch (GraphLayoutException var6) {
         Logger.logException(var6, var6.getMessage());
         CMessageBox.showError(BinDiffGraph.getParentWindow(var0), var6.getMessage());
      } finally {
         freeAllGraphsIntermediateListeners(var0);
      }

   }

   public static void handleReactivateViewSynchronization(BinDiffGraph var0) {
      try {
         blockAllGraphsIntermediateListeners(var0);
         GraphReactivateViewSynchronization.executeStatic(var0);
      } catch (GraphLayoutException var5) {
         Logger.logException(var5, var5.getMessage());
         CMessageBox.showError(BinDiffGraph.getParentWindow(var0), var5.getMessage());
      } finally {
         freeAllGraphsIntermediateListeners(var0);
      }

   }

   public static void handleSelectionChangedEvent(BinDiffGraph var0, boolean var1) {
      try {
         blockAllGraphsIntermediateListeners(var0);
         GraphSelectionUpdater.executeStatic(var0);
      } catch (GraphLayoutException var6) {
         Logger.logException(var6, var6.getMessage());
         CMessageBox.showError(BinDiffGraph.getParentWindow(var0), var6.getMessage());
      } finally {
         freeAllGraphsIntermediateListeners(var0);
      }

   }

   public static void handleUnhideInvisibleNode(BinDiffGraph var0, ZyGraphNode var1) {
      try {
         blockAllGraphsIntermediateListeners(var0);
         ProximityBrowserUnhideNode.executeStatic(var0, var1);
      } catch (GraphLayoutException var6) {
         Logger.logException(var6, var6.getMessage());
         CMessageBox.showError(BinDiffGraph.getParentWindow(var0), var6.getMessage());
      } finally {
         freeAllGraphsIntermediateListeners(var0);
      }

   }
}
