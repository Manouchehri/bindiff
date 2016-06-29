package com.google.security.zynamics.zylib.gui.jtree;

import com.google.security.zynamics.zylib.gui.jtree.IconNode;
import java.awt.Component;
import java.util.Hashtable;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class IconNodeRenderer extends DefaultTreeCellRenderer {
   public Component getTreeCellRendererComponent(JTree var1, Object var2, boolean var3, boolean var4, boolean var5, int var6, boolean var7) {
      super.getTreeCellRendererComponent(var1, var2, var3, var4, var5, var6, var7);
      if(!(var2 instanceof IconNode)) {
         return this;
      } else {
         Icon var8 = ((IconNode)var2).getIcon();
         if(var8 == null) {
            Hashtable var9 = (Hashtable)var1.getClientProperty("JTree.icons");
            String var10 = ((IconNode)var2).getIconName();
            if(var9 != null && var10 != null) {
               var8 = (Icon)var9.get(var10);
               if(var8 != null) {
                  this.setIcon(var8);
               }
            }
         } else {
            this.setIcon(var8);
         }

         return this;
      }
   }
}
