package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTable;

public class CopyCellAction extends AbstractAction {
   private static final long serialVersionUID = 7553173268247700514L;
   private final JTable m_table;
   private final int m_x;
   private final int m_y;

   public CopyCellAction(JTable var1, int var2, int var3) {
      super("Copy Cell");
      this.m_table = var1;
      this.m_x = var2;
      this.m_y = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = this.m_table.columnAtPoint(new Point(this.m_x, this.m_y));
      int var3 = this.m_table.rowAtPoint(new Point(this.m_x, this.m_y));
      if(var2 != -1 && var3 != -1) {
         ClipboardHelpers.copyToClipboard(this.m_table.getValueAt(var3, var2).toString());
      }
   }
}
