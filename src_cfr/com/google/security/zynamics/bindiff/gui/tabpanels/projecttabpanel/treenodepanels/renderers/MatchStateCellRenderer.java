/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.BackgroundIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MatchStateCellRenderer
extends AbstractTableCellRenderer {
    private final Color textColor;
    private final Color matchedColor;
    private final Color primaryUnmatchedColor;
    private final Color secondaryUnmatchedColor;

    public MatchStateCellRenderer(Color color, Color color2, Color color3, Color color4) {
        this.textColor = (Color)Preconditions.checkNotNull(color);
        this.matchedColor = (Color)Preconditions.checkNotNull(color2);
        this.primaryUnmatchedColor = (Color)Preconditions.checkNotNull(color3);
        this.secondaryUnmatchedColor = (Color)Preconditions.checkNotNull(color4);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        Preconditions.checkArgument(object instanceof EMatchState, "Value must be an EMatchState");
        this.buildAndSetToolTip(jTable, n2);
        EMatchState eMatchState = (EMatchState)((Object)object);
        Color color = eMatchState == EMatchState.PRIMARY_UNMATCHED ? this.primaryUnmatchedColor : (eMatchState == EMatchState.SECONDRAY_UNMATCHED ? this.secondaryUnmatchedColor : this.matchedColor);
        this.setIcon(new BackgroundIcon("", 2, this.textColor, color, jTable.getSelectionBackground(), bl2, -1, 0, jTable.getColumnModel().getColumn(n3).getWidth() - 1, jTable.getRowHeight() - 1));
        return this;
    }
}

