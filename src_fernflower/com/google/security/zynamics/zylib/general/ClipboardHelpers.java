package com.google.security.zynamics.zylib.general;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ClipboardHelpers$1;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public final class ClipboardHelpers {
   public static void copyToClipboard(String var0) {
      Preconditions.checkNotNull(var0, "Error: String argument can not be null");
      Clipboard var1 = Toolkit.getDefaultToolkit().getSystemClipboard();
      var1.setContents(new StringSelection(var0), new ClipboardHelpers$1());
   }

   public static String getClipboardString() {
      Clipboard var0 = Toolkit.getDefaultToolkit().getSystemClipboard();
      Transferable var1 = var0.getContents((Object)null);
      boolean var2 = var1 != null && var1.isDataFlavorSupported(DataFlavor.stringFlavor);
      if(!var2) {
         return null;
      } else {
         try {
            return (String)var1.getTransferData(DataFlavor.stringFlavor);
         } catch (IOException | UnsupportedFlavorException var4) {
            return null;
         }
      }
   }
}
