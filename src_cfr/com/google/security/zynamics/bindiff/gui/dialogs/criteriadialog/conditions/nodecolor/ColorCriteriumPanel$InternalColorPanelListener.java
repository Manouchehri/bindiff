/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel$1;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import com.google.security.zynamics.zylib.gui.ColorPanel.IColorPanelListener;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ColorCriteriumPanel$InternalColorPanelListener
extends MouseAdapter
implements IColorPanelListener {
    final /* synthetic */ ColorCriteriumPanel this$0;

    private ColorCriteriumPanel$InternalColorPanelListener(ColorCriteriumPanel colorCriteriumPanel) {
        this.this$0 = colorCriteriumPanel;
    }

    @Override
    public void changedColor(ColorPanel colorPanel) {
        ColorCriteriumPanel.access$100(this.this$0).update();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 1) return;
        ColorPanel colorPanel = (ColorPanel)mouseEvent.getSource();
        Color color = colorPanel.getColor();
        if (color == null) return;
        ColorCriteriumPanel.access$200(this.this$0).setColor(color);
    }

    /* synthetic */ ColorCriteriumPanel$InternalColorPanelListener(ColorCriteriumPanel colorCriteriumPanel, ColorCriteriumPanel$1 colorCriteriumPanel$1) {
        this(colorCriteriumPanel);
    }
}

