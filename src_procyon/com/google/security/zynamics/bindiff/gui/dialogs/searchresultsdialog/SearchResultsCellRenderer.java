package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import javax.swing.table.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

public class SearchResultsCellRenderer extends JLabel implements TableCellRenderer
{
    private static final Font INSTRUCTION_FONT;
    private Border unselectedBorder;
    private Border selectedBorder;
    
    public SearchResultsCellRenderer() {
        this.unselectedBorder = null;
        this.selectedBorder = null;
        this.setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        final SearchResult searchResult = (SearchResult)o;
        this.setFont(SearchResultsCellRenderer.INSTRUCTION_FONT);
        this.setText(searchResult.getText());
        if (b) {
            this.setBackground(table.getSelectionBackground());
            if (this.selectedBorder == null) {
                this.selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, table.getSelectionBackground());
            }
            this.setBorder(this.selectedBorder);
        }
        else {
            final Color objectMarkerColor = searchResult.getObjectMarkerColor();
            this.setBackground(objectMarkerColor);
            this.setBorder(this.unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, objectMarkerColor));
        }
        return this;
    }
    
    static {
        INSTRUCTION_FONT = new Font(GuiHelper.getMonospaceFont(), 0, 12);
    }
}
