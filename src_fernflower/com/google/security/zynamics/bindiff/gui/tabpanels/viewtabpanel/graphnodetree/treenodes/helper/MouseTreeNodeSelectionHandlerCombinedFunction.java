package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphRootTreeNode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class MouseTreeNodeSelectionHandlerCombinedFunction {
   private static void selectGraphNode(CombinedCallGraphFunctionTreeNode var0) {
      CombinedCallGraphRootTreeNode var1 = var0.getRootNode();
      CombinedCallGraphBaseTreeNode var2 = (CombinedCallGraphBaseTreeNode)var0.getParent();
      CombinedGraph var3 = var1.getGraph();
      CombinedDiffNode var4 = var0.getCombinedDiffNode();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      Iterator var7 = var3.getNodes().iterator();

      while(var7.hasNext()) {
         CombinedDiffNode var8 = (CombinedDiffNode)var7.next();
         var6.add(var8);
      }

      if(!var4.isSelected()) {
         var2.setLastSelectedGraphNode(var4);
         var6.remove(var4);
         var5.add(var4);
      } else {
         var2.setLastSelectedGraphNode((CombinedDiffNode)null);
      }

      var3.selectNodes(var5, var6);
   }

   private static void selectGraphNodeCtrl(CombinedCallGraphFunctionTreeNode var0) {
      CombinedCallGraphRootTreeNode var1 = var0.getRootNode();
      CombinedCallGraphBaseTreeNode var2 = (CombinedCallGraphBaseTreeNode)var0.getParent();
      CombinedGraph var3 = var1.getGraph();
      CombinedDiffNode var4 = var0.getCombinedDiffNode();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      Iterator var7 = var3.getNodes().iterator();

      while(var7.hasNext()) {
         CombinedDiffNode var8 = (CombinedDiffNode)var7.next();
         if(var8.isSelected()) {
            var5.add(var8);
         } else {
            var6.add(var8);
         }
      }

      if(!var4.isSelected()) {
         var2.setLastSelectedGraphNode(var4);
         var5.add(var4);
         var6.remove(var4);
      } else {
         var2.setLastSelectedGraphNode((CombinedDiffNode)null);
         var6.add(var4);
         var5.remove(var4);
      }

      var3.selectNodes(var5, var6);
   }

   private static void selectGraphNodeCtrlShift(CombinedCallGraphFunctionTreeNode var0) {
      CombinedCallGraphRootTreeNode var1 = var0.getRootNode();
      CombinedCallGraphBaseTreeNode var2 = (CombinedCallGraphBaseTreeNode)var0.getParent();
      CombinedGraph var3 = var1.getGraph();
      CombinedDiffNode var4 = var0.getCombinedDiffNode();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      CombinedDiffNode var7 = var2.getLastSelectedGraphNode();
      if(var7 == null) {
         selectGraphNode(var0);
      } else if(var4.equals(var7)) {
         selectGraphNodeCtrl(var0);
      } else {
         Iterator var8 = var3.getNodes().iterator();

         while(var8.hasNext()) {
            CombinedDiffNode var9 = (CombinedDiffNode)var8.next();
            if(var9.isSelected()) {
               var5.add(var9);
            } else {
               var6.add(var9);
            }
         }

         ArrayList var13 = new ArrayList();
         boolean var14 = false;

         for(int var10 = 1; var10 < var2.getChildCount(); ++var10) {
            CombinedCallGraphFunctionTreeNode var11 = (CombinedCallGraphFunctionTreeNode)var2.getChildAt(var10);
            CombinedDiffNode var12 = var11.getCombinedDiffNode();
            if(var12.equals(var7)) {
               var14 = true;
               if(var13.size() != 0) {
                  var13.add(var11.getCombinedDiffNode());
                  break;
               }
            }

            if(var12.equals(var4)) {
               var14 = true;
               if(var13.size() != 0) {
                  var13.add(var11.getCombinedDiffNode());
                  break;
               }
            }

            if(var14) {
               var13.add(var11.getCombinedDiffNode());
            }
         }

         Iterator var15 = var13.iterator();

         while(var15.hasNext()) {
            CombinedDiffNode var16 = (CombinedDiffNode)var15.next();
            var5.add(var16);
            var6.remove(var16);
         }

         var3.selectNodes(var5, var6);
      }

   }

   private static void selectGraphNodeShift(CombinedCallGraphFunctionTreeNode var0) {
      CombinedCallGraphRootTreeNode var1 = var0.getRootNode();
      CombinedCallGraphBaseTreeNode var2 = (CombinedCallGraphBaseTreeNode)var0.getParent();
      CombinedGraph var3 = var1.getGraph();
      CombinedDiffNode var4 = var0.getCombinedDiffNode();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      CombinedDiffNode var7 = var2.getLastSelectedGraphNode();
      var5.clear();
      var6.clear();
      if(var7 != null && !var4.equals(var7)) {
         Iterator var8 = var3.getNodes().iterator();

         while(var8.hasNext()) {
            CombinedDiffNode var9 = (CombinedDiffNode)var8.next();
            var6.add(var9);
         }

         ArrayList var13 = new ArrayList();
         boolean var14 = false;

         for(int var10 = 1; var10 < var2.getChildCount(); ++var10) {
            CombinedCallGraphFunctionTreeNode var11 = (CombinedCallGraphFunctionTreeNode)var2.getChildAt(var10);
            CombinedDiffNode var12 = var11.getCombinedDiffNode();
            if(var12.equals(var7)) {
               var14 = true;
               if(var13.size() != 0) {
                  var13.add(var11.getCombinedDiffNode());
                  break;
               }
            }

            if(var12.equals(var4)) {
               var14 = true;
               if(var13.size() != 0) {
                  var13.add(var11.getCombinedDiffNode());
                  break;
               }
            }

            if(var14) {
               var13.add(var11.getCombinedDiffNode());
            }
         }

         Iterator var15 = var13.iterator();

         while(var15.hasNext()) {
            CombinedDiffNode var16 = (CombinedDiffNode)var15.next();
            var5.add(var16);
            var6.remove(var16);
         }

         var3.selectNodes(var5, var6);
      } else {
         selectGraphNode(var0);
      }

   }

   public static void handleMouseSelectionEvent(MouseEvent var0, CombinedCallGraphFunctionTreeNode var1) {
      boolean var2 = var0.isShiftDown();
      boolean var3 = var0.isControlDown();
      boolean var4 = var0.getID() == 501;
      boolean var5 = var0.getID() == 502;
      if(var4 && var2 && var3) {
         selectGraphNodeCtrlShift(var1);
      } else if(var5 && var3 && !var2) {
         selectGraphNodeCtrl(var1);
      } else if(var4 && !var3 && var2) {
         selectGraphNodeShift(var1);
      } else if(var4 && !var3 && !var2) {
         selectGraphNode(var1);
      }

   }
}
