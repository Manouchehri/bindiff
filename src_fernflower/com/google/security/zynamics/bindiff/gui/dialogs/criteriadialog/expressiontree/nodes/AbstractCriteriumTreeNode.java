package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.zylib.gui.jtree.IconNode;
import java.util.Enumeration;
import javax.swing.JPopupMenu;

public abstract class AbstractCriteriumTreeNode extends IconNode {
   private final ICriterium criterium;

   public AbstractCriteriumTreeNode(ICriterium var1) {
      this.criterium = var1;
   }

   private boolean allowAppendAndOrOperator() {
      CriteriumType var1 = this.getCriterium().getType();
      return var1 != CriteriumType.NOT?true:this.getChildCount() == 0;
   }

   private boolean allowAppendCondition() {
      int var1 = this.getChildCount();
      CriteriumType var2 = this.getCriterium().getType();
      return var2 == CriteriumType.CONDITION && this.isRoot() && var1 == 0?true:(var2 != CriteriumType.NOT?true:this.getChildCount() == 0);
   }

   private boolean allowAppendNotOperator() {
      CriteriumType var1 = this.getCriterium().getType();
      return var1 != CriteriumType.NOT;
   }

   private boolean allowInsertAndOrOperator() {
      return this.getChildCount() > 0;
   }

   private boolean allowInsertCondition() {
      return false;
   }

   private boolean allowInsertNotOperator() {
      CriteriumType var1 = this.getCriterium().getType();
      int var2 = this.getChildCount();
      return var1 != CriteriumType.NOT && var2 == 1 && ((AbstractCriteriumTreeNode)this.children.get(0)).getCriterium().getType() != CriteriumType.NOT;
   }

   public boolean allowAppend(CriteriumType var1) {
      return this.isRoot() && this.getChildCount() > 0?false:(this.getCriterium().getType() == CriteriumType.CONDITION && !this.isRoot()?false:(var1 == CriteriumType.CONDITION?this.allowAppendCondition():(var1 != CriteriumType.AND && var1 != CriteriumType.OR?(var1 == CriteriumType.NOT?this.allowAppendNotOperator():false):this.allowAppendAndOrOperator())));
   }

   public boolean allowInsert(CriteriumType var1) {
      return this.getCriterium().getType() == CriteriumType.CONDITION && !this.isRoot()?false:(var1 == CriteriumType.CONDITION?this.allowInsertCondition():(var1 != CriteriumType.AND && var1 != CriteriumType.OR?(var1 == CriteriumType.NOT?this.allowInsertNotOperator():true):this.allowInsertAndOrOperator()));
   }

   public void deleteChildren() {
      Enumeration var1 = this.children();

      while(var1.hasMoreElements()) {
         ((AbstractCriteriumTreeNode)var1.nextElement()).deleteChildren();
      }

      this.removeAllChildren();
   }

   public ICriterium getCriterium() {
      return this.criterium;
   }

   public abstract JPopupMenu getPopupMenu();
}
