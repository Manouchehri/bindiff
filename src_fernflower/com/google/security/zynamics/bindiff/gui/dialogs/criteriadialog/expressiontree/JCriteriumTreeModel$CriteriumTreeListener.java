package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.tree.TreePath;

class JCriteriumTreeModel$CriteriumTreeListener implements ICriteriumTreeListener {
   // $FF: synthetic field
   final JCriteriumTreeModel this$0;

   private JCriteriumTreeModel$CriteriumTreeListener(JCriteriumTreeModel var1) {
      this.this$0 = var1;
   }

   public void nodeAppended(CriteriumTree var1, ICriteriumTreeNode var2, ICriteriumTreeNode var3) {
      AbstractCriteriumTreeNode var4 = JCriteriumTreeModel.access$100(this.this$0, (AbstractCriteriumTreeNode)this.this$0.getRoot(), var2.getCriterium());
      CriteriumTreeNode var5 = new CriteriumTreeNode(var3.getCriterium(), JCriteriumTreeModel.access$200(this.this$0), JCriteriumTreeModel.access$300(this.this$0));
      var4.add(var5);
      var5.setParent(var4);
      this.this$0.sortChildren(var4);
      this.this$0.nodeStructureChanged(var4);
      JCriteriumTreeModel.access$400(this.this$0).setSelectionPath(new TreePath(var5.getPath()));
   }

   public void nodeInserted(CriteriumTree var1, ICriteriumTreeNode var2, ICriteriumTreeNode var3) {
      AbstractCriteriumTreeNode var4 = JCriteriumTreeModel.access$100(this.this$0, (CriteriumTreeNode)this.this$0.getRoot(), var2.getCriterium());
      CriteriumTreeNode var5 = new CriteriumTreeNode(var3.getCriterium(), JCriteriumTreeModel.access$200(this.this$0), JCriteriumTreeModel.access$300(this.this$0));
      ArrayList var6 = new ArrayList();
      Enumeration var7 = var4.children();

      while(var7.hasMoreElements()) {
         var6.add((AbstractCriteriumTreeNode)var7.nextElement());
      }

      Iterator var8 = var6.iterator();

      while(var8.hasNext()) {
         AbstractCriteriumTreeNode var9 = (AbstractCriteriumTreeNode)var8.next();
         var5.add(var9);
         var9.setParent(var5);
      }

      var4.removeAllChildren();
      var4.add(var5);
      var5.setParent(var4);
      this.this$0.nodeStructureChanged(var4);
      JCriteriumTreeModel.access$400(this.this$0).setSelectionPath(new TreePath(var5.getPath()));
   }

   public void nodeRemoved(CriteriumTree var1, ICriteriumTreeNode var2) {
      AbstractCriteriumTreeNode var3 = JCriteriumTreeModel.access$100(this.this$0, (CriteriumTreeNode)this.this$0.getRoot(), var2.getCriterium());
      var3.deleteChildren();
      AbstractCriteriumTreeNode var4 = (AbstractCriteriumTreeNode)var3.getParent();
      var4.remove(var3);
      this.this$0.nodeStructureChanged(var3);
      JCriteriumTreeModel.access$400(this.this$0).setSelectionPath(new TreePath(var4.getPath()));
   }

   public void removedAll(CriteriumTree var1) {
      CriteriumTreeNode var2 = (CriteriumTreeNode)this.this$0.getRoot();
      var2.deleteChildren();
      this.this$0.nodeStructureChanged(var2);
      JCriteriumTreeModel.access$400(this.this$0).setSelectionPath(new TreePath(var2.getPath()));
   }

   // $FF: synthetic method
   JCriteriumTreeModel$CriteriumTreeListener(JCriteriumTreeModel var1, JCriteriumTreeModel$1 var2) {
      this(var1);
   }
}
