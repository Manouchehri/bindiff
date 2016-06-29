/*
 * Decompiled with CFR 0_115.
 */
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

public class CMonospaceRenderer
extends JLabel
implements TableCellRenderer {
    private static final long serialVersionUID = -9211438577833845874L;
    private static final Font INSTRUCTION_FONT = new Font(GuiHelper.getMonospaceFont(), 0, 12);
    private Border unselectedBorder = null;
    private Border selectedBorder = null;

    public CMonospaceRenderer() {
        this.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        this.setFont(INSTRUCTION_FONT);
        this.setText(object.toString());
        if (bl2) {
            this.setBackground(jTable.getSelectionBackground());
            if (this.selectedBorder == null) {
                this.selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, jTable.getSelectionBackground());
            }
            this.setBorder(this.selectedBorder);
            return this;
        }
        this.setBackground(Color.WHITE);
        if (this.unselectedBorder == null) {
            this.unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, jTable.getBackground());
        }
        this.setBorder(this.unselectedBorder);
        return this;
    }
}

