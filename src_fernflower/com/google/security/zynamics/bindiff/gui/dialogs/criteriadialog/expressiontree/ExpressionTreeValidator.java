package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import java.util.Enumeration;

public class ExpressionTreeValidator {
   public static boolean isValid(JCriteriumTree var0) {
      CriteriumTreeNode var1 = (CriteriumTreeNode)var0.getModel().getRoot();
      if(var1.getChildCount() != 1) {
         return false;
      } else {
         Enumeration var2 = var1.breadthFirstEnumeration();

         CriteriumType var4;
         int var5;
         do {
            if(!var2.hasMoreElements()) {
               return true;
            }

            CriteriumTreeNode var3 = (CriteriumTreeNode)var2.nextElement();
            var4 = var3.getCriterium().getType();
            var5 = var3.getChildCount();
            if((var4 == CriteriumType.AND || var4 == CriteriumType.OR) && var5 < 2) {
               return false;
            }
         } while(var4 != CriteriumType.NOT || var5 == 1);

         return false;
      }
   }
}
