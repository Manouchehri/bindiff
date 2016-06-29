package com.google.security.zynamics.zylib.gui.tables;

import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

public class CMonospaceRenderer extends JLabel implements TableCellRenderer
{
    private static final long serialVersionUID = -9211438577833845874L;
    private static final Font INSTRUCTION_FONT;
    private Border unselectedBorder;
    private Border selectedBorder;
    
    public CMonospaceRenderer() {
        this.unselectedBorder = null;
        this.selectedBorder = null;
        this.setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.setFont(CMonospaceRenderer.INSTRUCTION_FONT);
        this.setText(o.toString());
        if (b) {
            this.setBackground(table.getSelectionBackground());
            if (this.selectedBorder == null) {
                this.selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, table.getSelectionBackground());
            }
            this.setBorder(this.selectedBorder);
        }
        else {
            this.setBackground(Color.WHITE);
            if (this.unselectedBorder == null) {
                this.unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, table.getBackground());
            }
            this.setBorder(this.unselectedBorder);
        }
        return this;
    }
    
    static {
        INSTRUCTION_FONT = new Font(GuiHelper.getMonospaceFont(), 0, 12);
    }
}
