package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Iterator;
import java.util.List;

class CriteriumExecuter$CriteriumFilter implements ICollectionFilter {
   private final CriteriumTree tree;

   public CriteriumExecuter$CriteriumFilter(CriteriumTree var1) {
      this.tree = var1;
   }

   private boolean qualifies(ICriteriumTreeNode var1, ZyGraphNode var2) {
      List var3 = var1.getChildren();
      if(var1.equals(this.tree.getRoot())) {
         if(var3.size() != 1) {
            throw new IllegalStateException("Root node has more or less than one child criterium.");
         } else {
            return this.qualifies((ICriteriumTreeNode)var3.get(0), var2);
         }
      } else {
         ICriteriumTreeNode var5;
         Iterator var6;
         if(var1.getCriterium().getType() == CriteriumType.AND) {
            if(var3.size() < 2) {
               throw new IllegalStateException("AND operator has less than two child criteria.");
            } else {
               var6 = var1.getChildren().iterator();

               do {
                  if(!var6.hasNext()) {
                     return true;
                  }

                  var5 = (ICriteriumTreeNode)var6.next();
               } while(this.qualifies(var5, var2));

               return false;
            }
         } else if(var1.getCriterium().getType() == CriteriumType.OR) {
            if(var3.size() < 2) {
               throw new IllegalStateException("AND operator has less than two child criteria.");
            } else {
               var6 = var1.getChildren().iterator();

               do {
                  if(!var6.hasNext()) {
                     return false;
                  }

                  var5 = (ICriteriumTreeNode)var6.next();
               } while(!this.qualifies(var5, var2));

               return true;
            }
         } else if(var1.getCriterium().getType() == CriteriumType.NOT) {
            if(var3.size() != 1) {
               throw new IllegalStateException("NOT operator has more or less than one child criterium.");
            } else {
               return !this.qualifies((ICriteriumTreeNode)var3.get(0), var2);
            }
         } else if(var1 instanceof CriteriumTreeNode) {
            CriteriumTreeNode var4 = (CriteriumTreeNode)var1;
            return var4.getCriterium().matches(var2);
         } else {
            throw new IllegalStateException("Unknown criterium.");
         }
      }
   }

   public boolean qualifies(ZyGraphNode var1) {
      return this.qualifies(this.tree.getRoot(), var1);
   }
}
