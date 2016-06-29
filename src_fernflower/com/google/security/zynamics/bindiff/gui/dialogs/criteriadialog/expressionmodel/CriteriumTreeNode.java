package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CriteriumTreeNode implements ICriteriumTreeNode {
   private final List children = new ArrayList();
   private ICriteriumTreeNode parent;
   private final ICriterium criterium;

   public CriteriumTreeNode(ICriterium var1) {
      this.criterium = var1;
   }

   public static void append(ICriteriumTreeNode var0, ICriteriumTreeNode var1) {
      var0.getChildren().add(var1);
      var1.setParent(var0);
   }

   public static void insert(ICriteriumTreeNode var0, ICriteriumTreeNode var1) {
      Iterator var2 = var0.getChildren().iterator();

      while(var2.hasNext()) {
         ICriteriumTreeNode var3 = (ICriteriumTreeNode)var2.next();
         var1.getChildren().add(var3);
         var3.setParent(var1);
      }

      var0.getChildren().clear();
      var0.getChildren().add(var1);
      var1.setParent(var0);
   }

   public static void remove(ICriteriumTreeNode var0) {
      Iterator var1 = var0.getChildren().iterator();

      while(var1.hasNext()) {
         ICriteriumTreeNode var2 = (ICriteriumTreeNode)var1.next();
         remove(var2);
      }

      var0.getChildren().clear();
   }

   public List getChildren() {
      return this.children;
   }

   public ICriterium getCriterium() {
      return this.criterium;
   }

   public ICriteriumTreeNode getParent() {
      return this.parent;
   }

   public void setParent(ICriteriumTreeNode var1) {
      this.parent = var1;
   }
}
