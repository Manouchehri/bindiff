package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ResourceBundle;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import org.jfree.ui.about.SystemProperties;
import org.jfree.ui.about.SystemPropertiesPanel$1;
import org.jfree.ui.about.SystemPropertiesPanel$PopupListener;

public class SystemPropertiesPanel extends JPanel {
   private JTable table;
   private JPopupMenu copyPopupMenu;
   private JMenuItem copyMenuItem;
   private SystemPropertiesPanel$PopupListener copyPopupListener;

   public SystemPropertiesPanel() {
      String var1 = "org.jfree.ui.about.resources.AboutResources";
      ResourceBundle var2 = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
      this.setLayout(new BorderLayout());
      this.table = SystemProperties.createSystemPropertiesTable();
      this.add(new JScrollPane(this.table));
      this.copyPopupMenu = new JPopupMenu();
      String var3 = var2.getString("system-properties-panel.popup-menu.copy");
      KeyStroke var4 = (KeyStroke)var2.getObject("system-properties-panel.popup-menu.copy.accelerator");
      this.copyMenuItem = new JMenuItem(var3);
      this.copyMenuItem.setAccelerator(var4);
      this.copyMenuItem.getAccessibleContext().setAccessibleDescription(var3);
      this.copyMenuItem.addActionListener(new SystemPropertiesPanel$1(this));
      this.copyPopupMenu.add(this.copyMenuItem);
      this.copyPopupListener = new SystemPropertiesPanel$PopupListener(this);
      this.table.addMouseListener(this.copyPopupListener);
   }

   public void copySystemPropertiesToClipboard() {
      StringBuffer var1 = new StringBuffer();
      ListSelectionModel var2 = this.table.getSelectionModel();
      int var3 = var2.getMinSelectionIndex();
      int var4 = var2.getMaxSelectionIndex();
      if(var3 != -1 && var4 != -1) {
         for(int var5 = var3; var5 <= var4; ++var5) {
            for(int var6 = 0; var6 < this.table.getColumnCount(); ++var6) {
               var1.append(this.table.getValueAt(var5, var6));
               if(var6 != 2) {
                  var1.append("\t");
               }
            }

            var1.append("\n");
         }
      }

      StringSelection var7 = new StringSelection(var1.toString());
      Clipboard var8 = Toolkit.getDefaultToolkit().getSystemClipboard();
      var8.setContents(var7, var7);
   }

   protected final JPopupMenu getCopyPopupMenu() {
      return this.copyPopupMenu;
   }

   protected final JTable getTable() {
      return this.table;
   }
}
