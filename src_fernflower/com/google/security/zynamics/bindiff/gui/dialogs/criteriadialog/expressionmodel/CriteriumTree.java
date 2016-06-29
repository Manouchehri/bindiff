package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root.RootCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.Iterator;

public class CriteriumTree {
   private final ListenerProvider listeners = new ListenerProvider();
   private final CriteriumTreeNode rootNode = new CriteriumTreeNode(new RootCriterium());

   public void addListener(ICriteriumTreeListener var1) {
      this.listeners.addListener(var1);
   }

   public void appendNode(ICriteriumTreeNode var1) {
      this.appendNode(this.rootNode, var1);
   }

   public void appendNode(ICriteriumTreeNode var1, ICriteriumTreeNode var2) {
      CriteriumTreeNode.append(var1, var2);
      Iterator var3 = this.listeners.iterator();

      while(var3.hasNext()) {
         ICriteriumTreeListener var4 = (ICriteriumTreeListener)var3.next();

         try {
            var4.nodeAppended(this, var1, var2);
         } catch (Exception var6) {
            Logger.logException(var6, "Append Tree Node.");
         }
      }

   }

   public ICriteriumTreeNode getRoot() {
      return this.rootNode;
   }

   public ICriterium getRootCriterium() {
      return this.rootNode.getCriterium();
   }

   public void insertNode(ICriteriumTreeNode var1) {
      this.insertNode(this.rootNode, var1);
   }

   public void insertNode(ICriteriumTreeNode var1, ICriteriumTreeNode var2) {
      CriteriumTreeNode.insert(var1, var2);
      Iterator var3 = this.listeners.iterator();

      while(var3.hasNext()) {
         ICriteriumTreeListener var4 = (ICriteriumTreeListener)var3.next();

         try {
            var4.nodeInserted(this, var1, var2);
         } catch (Exception var6) {
            Logger.logException(var6, "Insert Tree Node.");
         }
      }

   }

   public void removeAll() {
      if(this.rootNode.getChildren().size() == 1) {
         this.removeNode((ICriteriumTreeNode)this.rootNode.getChildren().get(0));
      }

      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         ICriteriumTreeListener var2 = (ICriteriumTreeListener)var1.next();

         try {
            var2.removedAll(this);
         } catch (Exception var4) {
            Logger.logException(var4, "Remove all Tree Nodes");
         }
      }

   }

   public void removeListener(ICriteriumTreeListener var1) {
      this.listeners.removeListener(var1);
   }

   public void removeNode(ICriteriumTreeNode var1) {
      CriteriumTreeNode.remove(var1);
      ICriteriumTreeNode var2 = var1.getParent();
      var2.getChildren().remove(var1);
      Iterator var3 = this.listeners.iterator();

      while(var3.hasNext()) {
         ICriteriumTreeListener var4 = (ICriteriumTreeListener)var3.next();

         try {
            var4.nodeRemoved(this, var1);
         } catch (Exception var6) {
            Logger.logException(var6, "Remove Tree Node");
         }
      }

   }
}
