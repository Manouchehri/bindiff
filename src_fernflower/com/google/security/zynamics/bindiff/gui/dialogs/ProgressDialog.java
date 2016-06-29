package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog;
import java.awt.Dimension;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JDialog;

public class ProgressDialog {
   private static void initializeWindowIcons(JDialog var0) {
      ArrayList var1 = new ArrayList();
      var1.add(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
      var1.add(ImageUtils.getImageIcon("data/appicons/bindiff-32x32-rgba.png").getImage());
      var1.add(ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png").getImage());
      var0.setIconImages(var1);
   }

   public static CEndlessProgressDialog show(Window var0, String var1, CEndlessHelperThread var2) {
      CEndlessProgressDialog var3 = new CEndlessProgressDialog(var0, "BinDiff", var1, var2);
      initializeWindowIcons(var3);
      var3.setSize(400, var3.getPreferredSize().height);
      var3.setMinimumSize(new Dimension(400, var3.getPreferredSize().height));
      var3.setMaximumSize(new Dimension(Math.max(400, var3.getPreferredSize().width), var3.getPreferredSize().height));
      var3.setDefaultCloseOperation(2);
      var2.start();
      var3.setVisible(true);
      if(var2.getException() != null) {
         throw var2.getException();
      } else {
         return var3;
      }
   }

   public static CStandardProgressDialog show(Window var0, String var1, CStandardHelperThread var2) {
      CStandardProgressDialog var3 = new CStandardProgressDialog(var0, "BinDiff", var1, var2);
      initializeWindowIcons(var3);
      var3.setSize(400, 122);
      var3.setMinimumSize(new Dimension(400, 122));
      var2.start();
      var3.setVisible(true);
      return var3;
   }
}
