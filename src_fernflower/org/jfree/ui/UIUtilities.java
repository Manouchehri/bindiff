package org.jfree.ui;

import java.awt.Color;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource.CompoundBorderUIResource;
import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;
import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

public class UIUtilities {
   public static void setupUI() {
      try {
         String var0 = UIManager.getSystemLookAndFeelClassName();
         UIManager.setLookAndFeel(var0);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      UIDefaults var6 = UIManager.getDefaults();
      var6.put("PopupMenu.border", new EtchedBorderUIResource(0, var6.getColor("controlShadow"), var6.getColor("controlLtHighlight")));
      MatteBorder var1 = new MatteBorder(1, 1, 1, 1, Color.black);
      MatteBorder var2 = new MatteBorder(2, 2, 2, 2, var6.getColor("control"));
      CompoundBorderUIResource var3 = new CompoundBorderUIResource(var2, var1);
      EmptyBorderUIResource var4 = new EmptyBorderUIResource(0, 0, 0, 0);
      var6.put("SplitPane.border", var4);
      var6.put("Table.scrollPaneBorder", var4);
      var6.put("ComboBox.border", var3);
      var6.put("TextField.border", var3);
      var6.put("TextArea.border", var3);
      var6.put("CheckBox.border", var3);
      var6.put("ScrollPane.border", var4);
   }
}
