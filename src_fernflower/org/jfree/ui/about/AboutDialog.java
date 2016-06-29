package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import org.jfree.ui.about.AboutPanel;
import org.jfree.ui.about.ContributorsPanel;
import org.jfree.ui.about.LibraryPanel;
import org.jfree.ui.about.ProjectInfo;
import org.jfree.ui.about.SystemPropertiesPanel;

public class AboutDialog extends JDialog {
   public static final Dimension PREFERRED_SIZE = new Dimension(560, 360);
   public static final Border STANDARD_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
   private ResourceBundle resources;
   private String application;
   private String version;
   private String copyright;
   private String info;
   private Image logo;
   private List contributors;
   private String licence;

   public AboutDialog(String var1, ProjectInfo var2) {
      this.init(var1, var2.getName(), "Version " + var2.getVersion(), var2.getInfo(), var2.getLogo(), var2.getCopyright(), var2.getLicenceText(), var2.getContributors(), var2);
   }

   public AboutDialog(Frame var1, String var2, ProjectInfo var3) {
      super(var1);
      this.init(var2, var3.getName(), "Version " + var3.getVersion(), var3.getInfo(), var3.getLogo(), var3.getCopyright(), var3.getLicenceText(), var3.getContributors(), var3);
   }

   public AboutDialog(Dialog var1, String var2, ProjectInfo var3) {
      super(var1);
      this.init(var2, var3.getName(), "Version " + var3.getVersion(), var3.getInfo(), var3.getLogo(), var3.getCopyright(), var3.getLicenceText(), var3.getContributors(), var3);
   }

   private void init(String var1, String var2, String var3, String var4, Image var5, String var6, String var7, List var8, ProjectInfo var9) {
      this.setTitle(var1);
      this.application = var2;
      this.version = var3;
      this.copyright = var6;
      this.info = var4;
      this.logo = var5;
      this.contributors = var8;
      this.licence = var7;
      String var10 = "org.jfree.ui.about.resources.AboutResources";
      this.resources = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
      JPanel var11 = new JPanel(new BorderLayout());
      var11.setBorder(STANDARD_BORDER);
      JTabbedPane var12 = this.createTabs(var9);
      var11.add(var12);
      this.setContentPane(var11);
      this.pack();
   }

   public Dimension getPreferredSize() {
      return PREFERRED_SIZE;
   }

   private JTabbedPane createTabs(ProjectInfo var1) {
      JTabbedPane var2 = new JTabbedPane();
      JPanel var3 = this.createAboutPanel(var1);
      var3.setBorder(STANDARD_BORDER);
      String var4 = this.resources.getString("about-frame.tab.about");
      var2.add(var4, var3);
      SystemPropertiesPanel var5 = new SystemPropertiesPanel();
      var5.setBorder(STANDARD_BORDER);
      String var6 = this.resources.getString("about-frame.tab.system");
      var2.add(var6, var5);
      return var2;
   }

   private JPanel createAboutPanel(ProjectInfo var1) {
      JPanel var2 = new JPanel(new BorderLayout());
      AboutPanel var3 = new AboutPanel(this.application, this.version, this.copyright, this.info, this.logo);
      boolean var4 = false;
      JTabbedPane var5 = new JTabbedPane();
      String var7;
      if(this.contributors != null) {
         ContributorsPanel var6 = new ContributorsPanel(this.contributors);
         var6.setBorder(STANDARD_BORDER);
         var7 = this.resources.getString("about-frame.tab.contributors");
         var5.add(var7, var6);
         var4 = true;
      }

      if(this.licence != null) {
         JPanel var8 = this.createLicencePanel();
         var8.setBorder(STANDARD_BORDER);
         var7 = this.resources.getString("about-frame.tab.licence");
         var5.add(var7, var8);
         var4 = true;
      }

      if(var1 != null) {
         LibraryPanel var9 = new LibraryPanel(var1);
         var9.setBorder(STANDARD_BORDER);
         var7 = this.resources.getString("about-frame.tab.libraries");
         var5.add(var7, var9);
         var4 = true;
      }

      var2.add(var3, "North");
      if(var4) {
         var2.add(var5);
      }

      return var2;
   }

   private JPanel createLicencePanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      JTextArea var2 = new JTextArea(this.licence);
      var2.setLineWrap(true);
      var2.setWrapStyleWord(true);
      var2.setCaretPosition(0);
      var2.setEditable(false);
      var1.add(new JScrollPane(var2));
      return var1;
   }
}
