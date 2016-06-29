package org.jfree.ui;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import org.jfree.ui.BevelArrowIcon;
import org.jfree.ui.SortableTableModel;

public class SortButtonRenderer implements TableCellRenderer {
   public static final int NONE = 0;
   public static final int DOWN = 1;
   public static final int UP = 2;
   private int pressedColumn = -1;
   private JButton normalButton;
   private JButton ascendingButton;
   private JButton descendingButton;
   private boolean useLabels;
   private JLabel normalLabel;
   private JLabel ascendingLabel;
   private JLabel descendingLabel;

   public SortButtonRenderer() {
      this.pressedColumn = -1;
      this.useLabels = UIManager.getLookAndFeel().getID().equals("Aqua");
      Border var1 = UIManager.getBorder("TableHeader.cellBorder");
      if(this.useLabels) {
         this.normalLabel = new JLabel();
         this.normalLabel.setHorizontalAlignment(10);
         this.ascendingLabel = new JLabel();
         this.ascendingLabel.setHorizontalAlignment(10);
         this.ascendingLabel.setHorizontalTextPosition(2);
         this.ascendingLabel.setIcon(new BevelArrowIcon(1, false, false));
         this.descendingLabel = new JLabel();
         this.descendingLabel.setHorizontalAlignment(10);
         this.descendingLabel.setHorizontalTextPosition(2);
         this.descendingLabel.setIcon(new BevelArrowIcon(0, false, false));
         this.normalLabel.setBorder(var1);
         this.ascendingLabel.setBorder(var1);
         this.descendingLabel.setBorder(var1);
      } else {
         this.normalButton = new JButton();
         this.normalButton.setMargin(new Insets(0, 0, 0, 0));
         this.normalButton.setHorizontalAlignment(10);
         this.ascendingButton = new JButton();
         this.ascendingButton.setMargin(new Insets(0, 0, 0, 0));
         this.ascendingButton.setHorizontalAlignment(10);
         this.ascendingButton.setHorizontalTextPosition(2);
         this.ascendingButton.setIcon(new BevelArrowIcon(1, false, false));
         this.ascendingButton.setPressedIcon(new BevelArrowIcon(1, false, true));
         this.descendingButton = new JButton();
         this.descendingButton.setMargin(new Insets(0, 0, 0, 0));
         this.descendingButton.setHorizontalAlignment(10);
         this.descendingButton.setHorizontalTextPosition(2);
         this.descendingButton.setIcon(new BevelArrowIcon(0, false, false));
         this.descendingButton.setPressedIcon(new BevelArrowIcon(0, false, true));
         this.normalButton.setBorder(var1);
         this.ascendingButton.setBorder(var1);
         this.descendingButton.setBorder(var1);
      }

   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      if(var1 == null) {
         throw new NullPointerException("Table must not be null.");
      } else {
         SortableTableModel var8 = (SortableTableModel)var1.getModel();
         int var9 = var1.convertColumnIndexToModel(var6);
         boolean var10 = var8.getSortingColumn() == var9;
         boolean var11 = var8.isAscending();
         JTableHeader var12 = var1.getTableHeader();
         boolean var13 = var9 == this.pressedColumn;
         Object var7;
         if(this.useLabels) {
            JLabel var14 = this.getRendererLabel(var10, var11);
            var14.setText(var2 == null?"":var2.toString());
            var7 = var14;
         } else {
            JButton var15 = this.getRendererButton(var10, var11);
            var15.setText(var2 == null?"":var2.toString());
            var15.getModel().setPressed(var13);
            var15.getModel().setArmed(var13);
            var7 = var15;
         }

         if(var12 != null) {
            ((JComponent)var7).setForeground(var12.getForeground());
            ((JComponent)var7).setBackground(var12.getBackground());
            ((JComponent)var7).setFont(var12.getFont());
         }

         return (Component)var7;
      }
   }

   private JButton getRendererButton(boolean var1, boolean var2) {
      return var1?(var2?this.ascendingButton:this.descendingButton):this.normalButton;
   }

   private JLabel getRendererLabel(boolean var1, boolean var2) {
      return var1?(var2?this.ascendingLabel:this.descendingLabel):this.normalLabel;
   }

   public void setPressedColumn(int var1) {
      this.pressedColumn = var1;
   }
}
