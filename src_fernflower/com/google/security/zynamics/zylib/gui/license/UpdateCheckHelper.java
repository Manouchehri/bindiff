package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.license.UpdateCheckHelper$1;
import java.awt.Window;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class UpdateCheckHelper {
   public static String UPDATE_CHECK_BASE_URL = "http://www.zynamics.com/updates";

   public static void checkForUpdatesWithUi(Window var0, String var1, String var2) {
      checkForUpdatesWithUi(var0, var1, var2, "stable");
   }

   public static void checkForUpdatesWithUi(Window var0, String var1, String var2, String var3) {
      URL var4;
      try {
         var4 = new URL(String.format("%s/%s/%s", new Object[]{UPDATE_CHECK_BASE_URL, var1.toLowerCase(), var3.toLowerCase()}));
      } catch (MalformedURLException var10) {
         throw new RuntimeException("Malformed URL template", var10);
      }

      ArrayList var5 = new ArrayList();
      UpdateCheckHelper$1 var6 = new UpdateCheckHelper$1(var5, var4);
      CEndlessProgressDialog.show(var0, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), "Checking for updates...", var6);
      Exception var7 = var6.getException();
      if(var7 instanceof FileNotFoundException) {
         CMessageBox.showWarning(var0, "Could not check for updates. The update site is unavailable.");
      } else if(var5.isEmpty()) {
         CMessageBox.showWarning(var0, "Could not check for updates. The update site returned no data.");
      } else if(var5.size() >= 2 && ((String)var5.get(1)).matches("\\d{4}-\\d\\d-\\d\\d")) {
         String var8 = (String)var5.get(0);
         int var9 = versionCompare(var2, var8);
         if(var9 < 0) {
            CMessageBox.showInformation(var0, String.format("A newer version (%s) is available.", new Object[]{var8}));
         } else if(var9 >= 0) {
            CMessageBox.showInformation(var0, String.format("Your version of zynamics %s is up to date.", new Object[]{var1}));
         }
      } else {
         CMessageBox.showWarning(var0, "Could not check for updates. Could not parse the response.");
      }
   }

   public static int versionCompare(String var0, String var1) {
      String[] var2 = var0.trim().split("\\.|-|\\s+");
      String[] var3 = var1.trim().split("\\.|-|\\s+");
      int var4 = 0;

      for(int var5 = 0; var4 == 0 && var5 < Math.min(var2.length, var3.length); ++var5) {
         try {
            var4 = Integer.parseInt(var2[var5]) - Integer.parseInt(var3[var5]);
         } catch (NumberFormatException var7) {
            var4 = var2[var5].compareToIgnoreCase(var3[var5]);
         }
      }

      return var4 < -1?-1:(var4 > 1?1:var4);
   }
}
