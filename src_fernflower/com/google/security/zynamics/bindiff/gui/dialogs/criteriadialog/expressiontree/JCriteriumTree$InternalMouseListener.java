package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class JCriteriumTree$InternalMouseListener extends MouseAdapter {
   // $FF: synthetic field
   final JCriteriumTree this$0;

   private JCriteriumTree$InternalMouseListener(JCriteriumTree var1) {
      this.this$0 = var1;
   }

   public void mousePressed(MouseEvent var1) {
      JCriteriumTree.access$102(this.this$0, this.this$0.getPathForLocation(var1.getX(), var1.getY()));
      if(var1.isPopupTrigger()) {
         JCriteriumTree.access$200(this.this$0, var1);
      }

   }

   public void mouseReleased(MouseEvent var1) {
      JCriteriumTree.access$102(this.this$0, this.this$0.getPathForLocation(var1.getX(), var1.getY()));
      if(var1.isPopupTrigger()) {
         JCriteriumTree.access$200(this.this$0, var1);
      }

   }

   // $FF: synthetic method
   JCriteriumTree$InternalMouseListener(JCriteriumTree var1, JCriteriumTree$1 var2) {
      this(var1);
   }
}
