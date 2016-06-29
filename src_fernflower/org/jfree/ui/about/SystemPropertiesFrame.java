package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.jfree.ui.about.SystemPropertiesPanel;

public class SystemPropertiesFrame extends JFrame implements ActionListener {
   private static final String COPY_COMMAND = "COPY";
   private static final String CLOSE_COMMAND = "CLOSE";
   private SystemPropertiesPanel panel;

   public SystemPropertiesFrame(boolean var1) {
      String var2 = "org.jfree.ui.about.resources.AboutResources";
      ResourceBundle var3 = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
      String var4 = var3.getString("system-frame.title");
      this.setTitle(var4);
      this.setDefaultCloseOperation(2);
      if(var1) {
         this.setJMenuBar(this.createMenuBar(var3));
      }

      JPanel var5 = new JPanel(new BorderLayout());
      this.panel = new SystemPropertiesPanel();
      this.panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      var5.add(this.panel, "Center");
      JPanel var6 = new JPanel(new BorderLayout());
      var6.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
      String var7 = var3.getString("system-frame.button.close");
      Character var8 = (Character)var3.getObject("system-frame.button.close.mnemonic");
      JButton var9 = new JButton(var7);
      var9.setMnemonic(var8.charValue());
      var9.setActionCommand("CLOSE");
      var9.addActionListener(this);
      var6.add(var9, "East");
      var5.add(var6, "South");
      this.setContentPane(var5);
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("CLOSE")) {
         this.dispose();
      } else if(var2.equals("COPY")) {
         this.panel.copySystemPropertiesToClipboard();
      }

   }

   private JMenuBar createMenuBar(ResourceBundle var1) {
      JMenuBar var2 = new JMenuBar();
      String var3 = var1.getString("system-frame.menu.file");
      Character var4 = (Character)var1.getObject("system-frame.menu.file.mnemonic");
      JMenu var5 = new JMenu(var3, true);
      var5.setMnemonic(var4.charValue());
      var3 = var1.getString("system-frame.menu.file.close");
      var4 = (Character)var1.getObject("system-frame.menu.file.close.mnemonic");
      JMenuItem var6 = new JMenuItem(var3, var4.charValue());
      var6.setActionCommand("CLOSE");
      var6.addActionListener(this);
      var5.add(var6);
      var3 = var1.getString("system-frame.menu.edit");
      var4 = (Character)var1.getObject("system-frame.menu.edit.mnemonic");
      JMenu var7 = new JMenu(var3);
      var7.setMnemonic(var4.charValue());
      var3 = var1.getString("system-frame.menu.edit.copy");
      var4 = (Character)var1.getObject("system-frame.menu.edit.copy.mnemonic");
      JMenuItem var8 = new JMenuItem(var3, var4.charValue());
      var8.setActionCommand("COPY");
      var8.addActionListener(this);
      var7.add(var8);
      var2.add(var5);
      var2.add(var7);
      return var2;
   }
}
