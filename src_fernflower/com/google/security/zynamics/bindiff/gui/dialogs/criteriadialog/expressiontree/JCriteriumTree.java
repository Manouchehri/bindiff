package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.TreeNodeRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

public class JCriteriumTree extends JTree {
   private final JCriteriumTree$InternalMouseListener mouseListener = new JCriteriumTree$InternalMouseListener(this, (JCriteriumTree$1)null);
   private final JCriteriumTreeModel model;
   private TreePath currentCriteriumPath = null;

   public JCriteriumTree(CriteriumTree var1, List var2) {
      this.model = new JCriteriumTreeModel(this, var1, var2);
      this.setRootVisible(true);
      this.setModel(this.model);
      this.setCellRenderer(new TreeNodeRenderer());
      this.addMouseListener(this.mouseListener);
      this.updateUI();
   }

   private void showPopupMenu(MouseEvent var1) {
      AbstractCriteriumTreeNode var2 = (AbstractCriteriumTreeNode)TreeHelpers.getNodeAt(this, var1.getX(), var1.getY());
      if(var2 != null) {
         JPopupMenu var3 = var2.getPopupMenu();
         if(var3 != null) {
            var3.show(this, var1.getX(), var1.getY());
         }
      }

   }

   public void delete() {
      this.removeMouseListener(this.mouseListener);
   }

   public TreePath getCurrentCriteriumPath() {
      return this.currentCriteriumPath;
   }

   public JCriteriumTreeModel getModel() {
      return this.model;
   }

   public void setCurrentCriteriumPath(TreePath var1) {
      this.currentCriteriumPath = var1;
   }

   // $FF: synthetic method
   static TreePath access$102(JCriteriumTree var0, TreePath var1) {
      return var0.currentCriteriumPath = var1;
   }

   // $FF: synthetic method
   static void access$200(JCriteriumTree var0, MouseEvent var1) {
      var0.showPopupMenu(var1);
   }
}
