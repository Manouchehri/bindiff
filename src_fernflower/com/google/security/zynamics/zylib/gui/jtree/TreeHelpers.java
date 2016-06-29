package com.google.security.zynamics.zylib.gui.jtree;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeHelpers {
   private static void expandAll(JTree var0, TreePath var1, boolean var2) {
      TreeNode var3 = (TreeNode)var1.getLastPathComponent();
      if(var3.getChildCount() >= 0) {
         Enumeration var4 = var3.children();

         while(var4.hasMoreElements()) {
            TreeNode var5 = (TreeNode)var4.nextElement();
            TreePath var6 = var1.pathByAddingChild(var5);
            expandAll(var0, var6, var2);
         }
      }

      if(var2) {
         var0.expandPath(var1);
      } else {
         var0.collapsePath(var1);
      }

   }

   private static boolean isDescendant(TreePath var0, TreePath var1) {
      int var2 = var0.getPathCount();
      int var3 = var1.getPathCount();
      if(var2 <= var3) {
         return false;
      } else {
         while(var2 != var3) {
            var0 = var0.getParentPath();
            --var2;
         }

         return var0.equals(var1);
      }
   }

   public static boolean contains(JTree var0, TreeNode var1) {
      return isAncestor(var1, (TreeNode)var0.getModel().getRoot());
   }

   public static void expandAll(JTree var0, boolean var1) {
      TreeNode var2 = (TreeNode)var0.getModel().getRoot();
      expandAll(var0, new TreePath(var2), var1);
   }

   public static String getExpansionState(JTree var0, int var1) {
      TreePath var2 = var0.getPathForRow(var1);
      StringBuffer var3 = new StringBuffer();
      int var4 = var0.getRowCount();

      for(int var5 = var1; var5 < var4; ++var5) {
         TreePath var6 = var0.getPathForRow(var5);
         if(var5 != var1 && !isDescendant(var6, var2)) {
            break;
         }

         if(var0.isExpanded(var6)) {
            var3.append(",");
            var3.append(String.valueOf(var5 - var1));
         }
      }

      return var3.toString();
   }

   public static List getLastExpandedNodes(JTree var0) {
      ArrayList var1 = new ArrayList();
      int var2 = var0.getRowCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         TreePath var4 = var0.getPathForRow(var3);
         DefaultMutableTreeNode var5 = null;

         try {
            var5 = (DefaultMutableTreeNode)var4.getLastPathComponent();
         } catch (Exception var7) {
            throw new IllegalArgumentException("Cast failed! JTree must contain DefaultMuteableTreeNode or derived instances.");
         }

         if(var5.isLeaf() || !var0.isExpanded(var4)) {
            var1.add((DefaultMutableTreeNode)var5.getParent());
         }
      }

      return var1;
   }

   public static Object getNodeAt(JTree var0, int var1, int var2) {
      TreePath var3 = var0.getPathForLocation(var1, var2);
      return var3 != null?var3.getLastPathComponent():null;
   }

   public static boolean isAncestor(TreeNode var0, TreeNode var1) {
      if(var1 == var0) {
         return true;
      } else {
         for(int var2 = 0; var2 < var1.getChildCount(); ++var2) {
            if(isAncestor(var0, var1.getChildAt(var2))) {
               return true;
            }
         }

         return false;
      }
   }

   public static void restoreExpansionState(JTree var0, int var1, String var2) {
      StringTokenizer var3 = new StringTokenizer(var2, ",");

      while(var3.hasMoreTokens()) {
         int var4 = var1 + Integer.parseInt(var3.nextToken());
         var0.expandRow(var4);
      }

   }
}
