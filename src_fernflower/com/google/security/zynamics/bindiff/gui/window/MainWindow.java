package com.google.security.zynamics.bindiff.gui.window;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$1;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$InternalWindowListener;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$InternalWorkspaceListener;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
   private final CWindowFunctions controller;
   private final MainWindow$InternalWorkspaceListener workspaceListener = new MainWindow$InternalWorkspaceListener(this, (MainWindow$1)null);
   private final MainWindow$InternalWindowListener windowListener = new MainWindow$InternalWindowListener(this, (MainWindow$1)null);
   private String titlePath;

   public MainWindow(Workspace var1) {
      Preconditions.checkNotNull(var1);
      var1.addListener(this.workspaceListener);
      this.controller = new CWindowFunctions(this, var1);
      this.initWindow();
      this.addWindowListener(this.windowListener);
      this.addComponentListener(new MainWindow$1(this));
   }

   private boolean hasChangedScreenResolution() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      GeneralSettingsConfigItem var2 = var1.getMainSettings();
      int var3 = Toolkit.getDefaultToolkit().getScreenSize().width;
      int var4 = Toolkit.getDefaultToolkit().getScreenSize().height;
      var2.setScreenWidth(var3);
      var2.setScreenHeight(var4);
      return var2.getScreenWidth() != var3 || var2.getScreenHeight() != var4;
   }

   private void initWindow() {
      this.setDefaultCloseOperation(0);
      GuiUtils.setWindowIcons(this, "data/appicons/bindiff-16x16-rgba.png", "data/appicons/bindiff-32x32-rgba.png", "data/appicons/bindiff-48x48-rgba.png");
      boolean var1 = BinDiffConfigFile.getInstance().getMainSettings().getWindowStateWasMaximized();
      if(!var1 && !this.hasChangedScreenResolution()) {
         GeneralSettingsConfigItem var2 = BinDiffConfigFile.getInstance().getMainSettings();
         int var3 = var2.getWindowXPos();
         int var4 = var2.getWindowYPos();
         int var5 = var2.getWindowWidth();
         int var6 = var2.getWindowHeight();
         this.setLocation(var3, var4);
         this.setSize(var5, var6);
         this.setPreferredSize(new Dimension(var5, var6));
      } else {
         this.setLocation(100, 100);
         this.setSize(800, 600);
         this.setPreferredSize(new Dimension(800, 600));
         this.setExtendedState(6);
      }

      this.add(this.controller.getTabbedPanel(), "Center");
      this.pack();
   }

   private void updateEllipsis() {
      if(this.titlePath != null && this.getGraphics() != null) {
         FontMetrics var1 = this.getGraphics().getFontMetrics();
         int var2 = this.titlePath.length();
         Insets var3 = this.getInsets();
         int var4 = var3.right - var3.left + 100 + var1.stringWidth(" - BinDiff");

         String var5;
         for(var5 = this.titlePath; var2 >= 12 && var1.stringWidth(var5) > this.getWidth() - var4; --var2) {
            var5 = FileUtils.getPathEllipsis(this.titlePath, var2);
         }

         this.setTitle(var5);
      }
   }

   public CWindowFunctions getController() {
      return this.controller;
   }

   public void setTitle(String var1) {
      // $FF: Couldn't be decompiled
   }

   public void updateTitle(Workspace var1, TabPanel var2) {
      this.titlePath = null;
      if(var2 instanceof WorkspaceTabPanel) {
         if(var1 != null && var1.isLoaded()) {
            this.setTitle(var1.getWorkspaceFilePath());
            this.titlePath = var1.getWorkspaceFilePath();
            this.updateEllipsis();
         } else {
            this.setTitle("");
         }
      } else {
         String var3;
         if(var2 instanceof FunctionDiffViewTabPanel) {
            var3 = ((FunctionDiffViewTabPanel)var2).getTitle();
            this.setTitle(var3);
         } else if(var2 instanceof ViewTabPanel) {
            var3 = String.format("%s - %s", new Object[]{((ViewTabPanel)var2).getTitle(), ((ViewTabPanel)var2).getView().getGraphs().getDiff().getDiffName()});
            this.setTitle(var3);
         }
      }

   }

   // $FF: synthetic method
   static void access$200(MainWindow var0) {
      var0.updateEllipsis();
   }

   // $FF: synthetic method
   static MainWindow$InternalWindowListener access$300(MainWindow var0) {
      return var0.windowListener;
   }

   // $FF: synthetic method
   static CWindowFunctions access$400(MainWindow var0) {
      return var0.controller;
   }

   // $FF: synthetic method
   static String access$502(MainWindow var0, String var1) {
      return var0.titlePath = var1;
   }
}
