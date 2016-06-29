package org.jfree.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StrokeChooserPanel extends JPanel
{
    private JComboBox selector;
    
    public StrokeChooserPanel(final StrokeSample selectedItem, final StrokeSample[] array) {
        this.setLayout(new BorderLayout());
        (this.selector = new JComboBox((E[])array)).setSelectedItem(selectedItem);
        this.selector.setRenderer(new StrokeSample(new BasicStroke(1.0f)));
        this.add(this.selector);
        this.selector.addActionListener(new StrokeChooserPanel$1(this));
    }
    
    protected final JComboBox getSelector() {
        return this.selector;
    }
    
    public Stroke getSelectedStroke() {
        return ((StrokeSample)this.selector.getSelectedItem()).getStroke();
    }
}
