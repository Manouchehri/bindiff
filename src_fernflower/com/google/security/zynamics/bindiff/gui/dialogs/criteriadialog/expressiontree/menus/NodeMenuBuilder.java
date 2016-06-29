package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.menus;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AddConditionAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AppendAndOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AppendNotOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AppendOrOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.InsertAndOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.InsertNotOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.InsertOrOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.RemoveAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.RemoveAllAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import java.util.Iterator;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class NodeMenuBuilder {
   private final JPopupMenu popup = new JPopupMenu();
   private final JMenuItem insertAnd;
   private final JMenuItem insertOr;
   private final JMenuItem insertNot;
   private final JMenuItem appendAnd;
   private final JMenuItem appendOr;
   private final JMenuItem appendNot;
   private final JMenu conditionSubmenu;
   private final JMenuItem remove;
   private final JMenuItem removeAll;
   private final CriteriumTreeNode criteriumNode;

   public NodeMenuBuilder(CriteriumTreeNode var1, List var2, ExpressionTreeActionProvider var3) {
      this.criteriumNode = var1;
      this.appendAnd = new JMenuItem(new AppendAndOperatorAction(var3));
      this.appendOr = new JMenuItem(new AppendOrOperatorAction(var3));
      this.appendNot = new JMenuItem(new AppendNotOperatorAction(var3));
      this.popup.add(this.appendAnd);
      this.popup.add(this.appendOr);
      this.popup.add(this.appendNot);
      this.popup.add(new JSeparator());
      this.insertAnd = new JMenuItem(new InsertAndOperatorAction(var3));
      this.insertOr = new JMenuItem(new InsertOrOperatorAction(var3));
      this.insertNot = new JMenuItem(new InsertNotOperatorAction(var3));
      this.popup.add(this.insertAnd);
      this.popup.add(this.insertOr);
      this.popup.add(this.insertNot);
      this.popup.add(new JSeparator());
      this.conditionSubmenu = new JMenu("Create Condition");
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         ICriteriumCreator var5 = (ICriteriumCreator)var4.next();
         this.conditionSubmenu.add(new JMenuItem(new AddConditionAction(var5, var3)));
      }

      this.popup.add(this.conditionSubmenu);
      this.popup.add(new JSeparator());
      this.remove = new JMenuItem(new RemoveAction(var1, var3));
      this.popup.add(this.remove);
      this.popup.add(new JSeparator());
      this.removeAll = new JMenuItem(new RemoveAllAction(var3));
      this.popup.add(this.removeAll);
   }

   private void updateMenuState() {
      this.appendAnd.setEnabled(this.criteriumNode.allowAppend(CriteriumType.AND));
      this.appendOr.setEnabled(this.criteriumNode.allowAppend(CriteriumType.OR));
      this.appendNot.setEnabled(this.criteriumNode.allowAppend(CriteriumType.NOT));
      this.insertAnd.setEnabled(this.criteriumNode.allowInsert(CriteriumType.AND));
      this.insertOr.setEnabled(this.criteriumNode.allowInsert(CriteriumType.OR));
      this.insertNot.setEnabled(this.criteriumNode.allowInsert(CriteriumType.NOT));
      this.conditionSubmenu.setEnabled(this.criteriumNode.allowAppend(CriteriumType.CONDITION));
      this.remove.setEnabled(!this.criteriumNode.isRoot());
      this.removeAll.setEnabled(this.criteriumNode.getChildCount() != 0);
   }

   public JPopupMenu getPopup() {
      this.updateMenuState();
      return this.popup;
   }
}
