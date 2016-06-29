/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CColorChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CColorChooser$SelectedColorActionListener
implements ActionListener {
    Color m_color;
    final /* synthetic */ CColorChooser this$0;

    CColorChooser$SelectedColorActionListener(CColorChooser cColorChooser) {
        this.this$0 = cColorChooser;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.m_color = this.this$0.getColor();
    }

    public Color getColor() {
        return this.m_color;
    }
}

