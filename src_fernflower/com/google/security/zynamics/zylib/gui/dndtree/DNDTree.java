package com.google.security.zynamics.zylib.gui.dndtree;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class DNDTree extends JTree {
   private static final long serialVersionUID = -2933192344665054732L;
   Insets autoscrollInsets = new Insets(20, 20, 20, 20);

   public DNDTree() {
      this.setAutoscrolls(true);
      this.setRootVisible(false);
      this.setShowsRootHandles(false);
      this.getSelectionModel().setSelectionMode(1);
      this.setEditable(false);
   }

   public static DefaultMutableTreeNode makeDeepCopy(DefaultMutableTreeNode var0) {
      DefaultMutableTreeNode var1 = new DefaultMutableTreeNode(var0.getUserObject());
      Enumeration var2 = var0.children();

      while(var2.hasMoreElements()) {
         var1.add(makeDeepCopy((DefaultMutableTreeNode)var2.nextElement()));
      }

      return var1;
   }

   public void autoscroll(Point var1) {
      Insets var2 = this.getAutoscrollInsets();
      Rectangle var3 = this.getVisibleRect();
      Rectangle var4 = new Rectangle(var3.x + var2.left, var3.y + var2.top, var3.width - (var2.left + var2.right), var3.height - (var2.top + var2.bottom));
      if(!var4.contains(var1)) {
         Rectangle var5 = new Rectangle(var1.x - var2.left, var1.y - var2.top, var2.left + var2.right, var2.top + var2.bottom);
         this.scrollRectToVisible(var5);
      }

   }

   public Insets getAutoscrollInsets() {
      return this.autoscrollInsets;
   }
}
