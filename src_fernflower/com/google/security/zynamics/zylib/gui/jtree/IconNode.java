package com.google.security.zynamics.zylib.gui.jtree;

import com.google.common.base.Preconditions;
import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

public class IconNode extends DefaultMutableTreeNode {
   private static final long serialVersionUID = -7079996631145030853L;
   protected Icon icon;
   protected String iconName;

   public IconNode() {
      this((Object)null);
   }

   public IconNode(Object var1) {
      this(var1, true, (Icon)null);
   }

   public IconNode(Object var1, boolean var2, Icon var3) {
      super(var1, var2);
      this.icon = null;
      this.icon = var3;
   }

   public Icon getIcon() {
      return this.icon;
   }

   public String getIconName() {
      if(this.iconName != null) {
         return this.iconName;
      } else if(this.userObject == null) {
         return null;
      } else {
         String var1 = this.userObject.toString();
         int var2 = var1.lastIndexOf(".");
         if(var2 != -1) {
            ++var2;
            return var1.substring(var2);
         } else {
            return null;
         }
      }
   }

   public void setIcon(Icon var1) {
      this.icon = (Icon)Preconditions.checkNotNull(var1, "Error: icon argument can not be null");
   }

   public void setIconName(String var1) {
      this.iconName = (String)Preconditions.checkNotNull(var1, "Error: name argument can not be null");
   }
}
