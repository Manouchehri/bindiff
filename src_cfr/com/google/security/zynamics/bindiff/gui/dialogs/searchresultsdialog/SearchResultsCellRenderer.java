/*
 * Decompiled with CFR 0_115.
 */
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

public class SearchResultsCellRenderer
extends JLabel
implements TableCellRenderer {
    private static final Font INSTRUCTION_FONT = new Font(GuiHelper.getMonospaceFont(), 0, 12);
    private Border unselectedBorder = null;
    private Border selectedBorder = null;

    public SearchResultsCellRenderer() {
        this.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        SearchResult searchResult = (SearchResult)object;
        this.setFont(INSTRUCTION_FONT);
        this.setText(searchResult.getText());
        if (!bl2) {
            Color color = searchResult.getObjectMarkerColor();
            this.setBackground(color);
            this.unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, color);
            this.setBorder(this.unselectedBorder);
            return this;
        }
        this.setBackground(jTable.getSelectionBackground());
        if (this.selectedBorder == null) {
            this.selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, jTable.getSelectionBackground());
        }
        this.setBorder(this.selectedBorder);
        return this;
    }
}

