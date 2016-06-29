package com.google.security.zynamics.zylib.gui.UrlLabel;

import com.google.security.zynamics.zylib.gui.UrlLabel.UrlLabel;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

final class UrlLabel$1 extends MouseAdapter {
   public void mouseClicked(MouseEvent var1) {
      UrlLabel var2 = (UrlLabel)var1.getSource();
      if(UrlLabel.access$000(var2) != null) {
         try {
            Desktop.getDesktop().browse(UrlLabel.access$000(var2).toURI());
         } catch (URISyntaxException var4) {
            System.out.println(var4);
         } catch (IOException var5) {
            System.out.println(var5);
         }

      }
   }

   public void mouseEntered(MouseEvent var1) {
      var1.getComponent().setCursor(Cursor.getPredefinedCursor(12));
   }
}
