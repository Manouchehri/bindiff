package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphRootTreeNode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class MouseTreeNodeSelectionHandlerSingleFunction {
   private static void selectGraphNode(SingleCallGraphFunctionTreeNode var0) {
      SingleCallGraphRootTreeNode var1 = var0.getRootNode();
      SingleCallGraphBaseTreeNode var2 = (SingleCallGraphBaseTreeNode)var0.getParent();
      SingleGraph var3 = var1.getGraph();
      SingleDiffNode var4 = var0.getSingleDiffNode();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      Iterator var7 = var3.getNodes().iterator();

      while(var7.hasNext()) {
         SingleDiffNode var8 = (SingleDiffNode)var7.next();
         var6.add(var8);
      }

      if(!var4.isSelected()) {
         var2.setLastSelectedGraphNode(var4);
         var6.remove(var4);
         var5.add(var4);
      } else {
         var2.setLastSelectedGraphNode((SingleDiffNode)null);
      }

      var3.selectNodes(var5, var6);
   }

   private static void selectGraphNodeCtrl(SingleCallGraphFunctionTreeNode var0) {
      SingleCallGraphRootTreeNode var1 = var0.getRootNode();
      SingleCallGraphBaseTreeNode var2 = (SingleCallGraphBaseTreeNode)var0.getParent();
      SingleGraph var3 = var1.getGraph();
      SingleDiffNode var4 = var0.getSingleDiffNode();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      Iterator var7 = var3.getNodes().iterator();

      while(var7.hasNext()) {
         SingleDiffNode var8 = (SingleDiffNode)var7.next();
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
         var2.setLastSelectedGraphNode((SingleDiffNode)null);
         var6.add(var4);
         var5.remove(var4);
      }

      var3.selectNodes(var5, var6);
   }

   private static void selectGraphNodeCtrlShift(SingleCallGraphFunctionTreeNode var0) {
      SingleCallGraphRootTreeNode var1 = var0.getRootNode();
      SingleCallGraphBaseTreeNode var2 = (SingleCallGraphBaseTreeNode)var0.getParent();
      SingleGraph var3 = var1.getGraph();
      SingleDiffNode var4 = var0.getSingleDiffNode();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      SingleDiffNode var7 = var2.getLastSelectedGraphNode();
      if(var7 == null) {
         selectGraphNode(var0);
      } else if(var4.equals(var7)) {
         selectGraphNodeCtrl(var0);
      } else {
         Iterator var8 = var3.getNodes().iterator();

         while(var8.hasNext()) {
            SingleDiffNode var9 = (SingleDiffNode)var8.next();
            if(var9.isSelected()) {
               var5.add(var9);
            } else {
               var6.add(var9);
            }
         }

         ArrayList var13 = new ArrayList();
         boolean var14 = false;

         for(int var10 = 1; var10 < var2.getChildCount(); ++var10) {
            SingleCallGraphFunctionTreeNode var11 = (SingleCallGraphFunctionTreeNode)var2.getChildAt(var10);
            SingleDiffNode var12 = var11.getSingleDiffNode();
            if(var12.equals(var7)) {
               var14 = true;
               if(var13.size() != 0) {
                  var13.add(var11.getSingleDiffNode());
                  break;
               }
            }

            if(var12.equals(var4)) {
               var14 = true;
               if(var13.size() != 0) {
                  var13.add(var11.getSingleDiffNode());
                  break;
               }
            }

            if(var14) {
               var13.add(var11.getSingleDiffNode());
            }
         }

         Iterator var15 = var13.iterator();

         while(var15.hasNext()) {
            SingleDiffNode var16 = (SingleDiffNode)var15.next();
            var5.add(var16);
            var6.remove(var16);
         }

         var3.selectNodes(var5, var6);
      }

   }

   private static void selectGraphNodeShift(SingleCallGraphFunctionTreeNode var0) {
      SingleCallGraphRootTreeNode var1 = var0.getRootNode();
      SingleCallGraphBaseTreeNode var2 = (SingleCallGraphBaseTreeNode)var0.getParent();
      SingleGraph var3 = var1.getGraph();
      SingleDiffNode var4 = var0.getSingleDiffNode();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      SingleDiffNode var7 = var2.getLastSelectedGraphNode();
      var5.clear();
      var6.clear();
      if(var7 != null && !var4.equals(var7)) {
         Iterator var8 = var3.getNodes().iterator();

         while(var8.hasNext()) {
            SingleDiffNode var9 = (SingleDiffNode)var8.next();
            var6.add(var9);
         }

         ArrayList var13 = new ArrayList();
         boolean var14 = false;

         for(int var10 = 1; var10 < var2.getChildCount(); ++var10) {
            SingleCallGraphFunctionTreeNode var11 = (SingleCallGraphFunctionTreeNode)var2.getChildAt(var10);
            SingleDiffNode var12 = var11.getSingleDiffNode();
            if(var12.equals(var7)) {
               var14 = true;
               if(var13.size() != 0) {
                  var13.add(var11.getSingleDiffNode());
                  break;
               }
            }

            if(var12.equals(var4)) {
               var14 = true;
               if(var13.size() != 0) {
                  var13.add(var11.getSingleDiffNode());
                  break;
               }
            }

            if(var14) {
               var13.add(var11.getSingleDiffNode());
            }
         }

         Iterator var15 = var13.iterator();

         while(var15.hasNext()) {
            SingleDiffNode var16 = (SingleDiffNode)var15.next();
            var5.add(var16);
            var6.remove(var16);
         }

         var3.selectNodes(var5, var6);
      } else {
         selectGraphNode(var0);
      }

   }

   public static void handleMouseSelectionEvent(MouseEvent var0, SingleCallGraphFunctionTreeNode var1) {
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
