package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

public class SearchResultsCellRenderer extends JLabel implements TableCellRenderer {
   private static final Font INSTRUCTION_FONT = new Font(GuiHelper.getMonospaceFont(), 0, 12);
   private Border unselectedBorder = null;
   private Border selectedBorder = null;

   public SearchResultsCellRenderer() {
      this.setOpaque(true);
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      SearchResult var7 = (SearchResult)var2;
      this.setFont(INSTRUCTION_FONT);
      this.setText(var7.getText());
      if(var3) {
         this.setBackground(var1.getSelectionBackground());
         if(this.selectedBorder == null) {
            this.selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, var1.getSelectionBackground());
         }

         this.setBorder(this.selectedBorder);
      } else {
         Color var8 = var7.getObjectMarkerColor();
         this.setBackground(var8);
         this.unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, var8);
         this.setBorder(this.unselectedBorder);
      }

      return this;
   }
}
