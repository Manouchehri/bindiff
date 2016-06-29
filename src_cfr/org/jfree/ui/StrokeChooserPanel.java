/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import org.jfree.ui.StrokeChooserPanel$1;
import org.jfree.ui.StrokeSample;

public class StrokeChooserPanel
extends JPanel {
    private JComboBox selector;

    public StrokeChooserPanel(StrokeSample strokeSample, StrokeSample[] arrstrokeSample) {
        this.setLayout(new BorderLayout());
        this.selector = new JComboBox<StrokeSample>(arrstrokeSample);
        this.selector.setSelectedItem(strokeSample);
        this.selector.setRenderer(new StrokeSample(new BasicStroke(1.0f)));
        this.add(this.selector);
        this.selector.addActionListener(new StrokeChooserPanel$1(this));
    }

    protected final JComboBox getSelector() {
        return this.selector;
    }

    public Stroke getSelectedStroke() {
        StrokeSample strokeSample = (StrokeSample)this.selector.getSelectedItem();
        return strokeSample.getStroke();
    }
}

