/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CColorChooser$RecentColorsColorChooserPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.colorchooser.ColorSelectionModel;

class CColorChooser$RecentColorsColorChooserPanel$1
extends MouseAdapter {
    final /* synthetic */ Color val$col;
    final /* synthetic */ CColorChooser$RecentColorsColorChooserPanel this$1;

    CColorChooser$RecentColorsColorChooserPanel$1(CColorChooser$RecentColorsColorChooserPanel recentColorsColorChooserPanel, Color color) {
        this.this$1 = recentColorsColorChooserPanel;
        this.val$col = color;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 1) {
            return;
        }
        this.this$1.getColorSelectionModel().setSelectedColor(this.val$col);
    }
}

