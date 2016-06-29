/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JTable;

public class IconCellRenderer
extends AbstractTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        Preconditions.checkArgument(object instanceof Icon, "Value must be an Icon.");
        this.setHorizontalAlignment(0);
        this.setIcon((Icon)object);
        return this;
    }
}

