package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

public class CMonospaceRenderer extends JLabel implements TableCellRenderer {
   private static final long serialVersionUID = -9211438577833845874L;
   private static final Font INSTRUCTION_FONT = new Font(GuiHelper.getMonospaceFont(), 0, 12);
   private Border unselectedBorder = null;
   private Border selectedBorder = null;

   public CMonospaceRenderer() {
      this.setOpaque(true);
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.setFont(INSTRUCTION_FONT);
      this.setText(var2.toString());
      if(var3) {
         this.setBackground(var1.getSelectionBackground());
         if(this.selectedBorder == null) {
            this.selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, var1.getSelectionBackground());
         }

         this.setBorder(this.selectedBorder);
      } else {
         this.setBackground(Color.WHITE);
         if(this.unselectedBorder == null) {
            this.unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, var1.getBackground());
         }

         this.setBorder(this.unselectedBorder);
      }

      return this;
   }
}
