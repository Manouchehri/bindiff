package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.Launcher;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.resources.Constants;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.CDialogAboutEx;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.license.UpdateCheckHelper;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TabPanelFunctions {
   private static final ImageIcon BINDIFF_ABOUT_IMAGE = ImageUtils.getImageIcon("data/appimages/bindiff-about-image.png");
   private static final ImageIcon BINDIFF_APPIMAGE_16x16 = ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png");
   private static final ImageIcon BINDIFF_APPIMAGE_48x48 = ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png");
   private final Workspace workspace;
   private final MainWindow window;

   public TabPanelFunctions(MainWindow var1, Workspace var2) {
      this.window = (MainWindow)Preconditions.checkNotNull(var1);
      this.workspace = (Workspace)Preconditions.checkNotNull(var2);
   }

   public MainWindow getMainWindow() {
      return this.window;
   }

   public void checkForUpdates() {
      UpdateCheckHelper.checkForUpdatesWithUi(this.window, "BinDiff", "4.2.0");
   }

   public void exitBinDiff() {
      this.window.getController().exitBinDiff();
   }

   public Workspace getWorkspace() {
      return this.workspace;
   }

   public void reportABug() {
      try {
         Desktop.getDesktop().browse((new URL("http://bugs.zynamics.com/BinDiff")).toURI());
      } catch (MalformedURLException var2) {
         assert false : "Malformed URL";
      } catch (URISyntaxException var3) {
         assert false : "URL could not be converted to URI";
      } catch (IOException var4) {
         JOptionPane.showMessageDialog(this.window, "Couldn\' open URL \"http://bugs.zynamics.com/BinDiff\"!", "BinDiff", 0);
      }

   }

   public void showAboutDialog() {
      ArrayList var1 = new ArrayList();

      try {
         var1.add(new Pair("zynamics Website", new URL("http://www.zynamics.com")));
         var1.add(new Pair("BinDiff Product Site", new URL("http://www.zynamics.com/bindiff.html")));
         var1.add(new Pair("Report Bugs", new URL("mailto:zynamics-support@google.com")));
      } catch (MalformedURLException var6) {
         assert false : "Malformed URL in About dialog.";
      }

      String var2 = "BinDiff 4.2\n\nCopyright ©2004-2011 zynamics GmbH\nCopyright ©2011-2015 Google Inc.\n";
      String var3 = "\nParts of this software were created by third parties and have different licensing requirements.\nPlease see the manual file for a complete list.\n";
      Image var4 = BINDIFF_ABOUT_IMAGE.getImage();
      CDialogAboutEx var5 = new CDialogAboutEx(this.window, new ImageIcon(var4), "BinDiff 4.2", "BinDiff 4.2\n\nCopyright ©2004-2011 zynamics GmbH\nCopyright ©2011-2015 Google Inc.\n", "\nParts of this software were created by third parties and have different licensing requirements.\nPlease see the manual file for a complete list.\n", var1);
      var5.setIconImage(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
      var5.setSize(var5.getWidth() - 8, var5.getHeight());
      GuiHelper.centerChildToParent(this.window, var5, true);
      var5.setVisible(true);
   }

   public void showHelp() {
      try {
         String var2 = String.valueOf(FileUtils.findLocalRootPath(TabPanelFunctions.class));
         char var3 = File.separatorChar;
         String var4 = Constants.MANUAL_FILE;
         String var1 = (new StringBuilder(1 + String.valueOf(var2).length() + String.valueOf(var4).length())).append(var2).append(var3).append(var4).toString();
         Desktop.getDesktop().browse((new File(var1)).getCanonicalFile().toURI());
      } catch (MalformedURLException var5) {
         assert false : "Malformed URL";
      } catch (IOException var6) {
         Logger.logException(var6, "Couldn\'t open help content.");
         CMessageBox.showError(this.window, "Couldn\'t open help content.");
      }

   }

   public void showLicenseDialog() {
      // $FF: Couldn't be decompiled
   }
}
