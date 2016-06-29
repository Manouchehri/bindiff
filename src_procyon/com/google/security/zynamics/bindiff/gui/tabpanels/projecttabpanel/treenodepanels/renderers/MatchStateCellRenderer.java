package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import com.google.common.base.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;

public class MatchStateCellRenderer extends AbstractTableCellRenderer
{
    private final Color textColor;
    private final Color matchedColor;
    private final Color primaryUnmatchedColor;
    private final Color secondaryUnmatchedColor;
    
    public MatchStateCellRenderer(final Color color, final Color color2, final Color color3, final Color color4) {
        this.textColor = (Color)Preconditions.checkNotNull(color);
        this.matchedColor = (Color)Preconditions.checkNotNull(color2);
        this.primaryUnmatchedColor = (Color)Preconditions.checkNotNull(color3);
        this.secondaryUnmatchedColor = (Color)Preconditions.checkNotNull(color4);
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        Preconditions.checkArgument(o instanceof EMatchState, (Object)"Value must be an EMatchState");
        this.buildAndSetToolTip(table, n);
        final EMatchState eMatchState = (EMatchState)o;
        Color color;
        if (eMatchState == EMatchState.PRIMARY_UNMATCHED) {
            color = this.primaryUnmatchedColor;
        }
        else if (eMatchState == EMatchState.SECONDRAY_UNMATCHED) {
            color = this.secondaryUnmatchedColor;
        }
        else {
            color = this.matchedColor;
        }
        this.setIcon(new BackgroundIcon("", 2, this.textColor, color, table.getSelectionBackground(), b, -1, 0, table.getColumnModel().getColumn(n2).getWidth() - 1, table.getRowHeight() - 1));
        return this;
    }
}
