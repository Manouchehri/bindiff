/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.ui.ArrowPanel;

public class Spinner
extends JPanel
implements MouseListener {
    private int value;
    private JTextField textField;
    private JPanel buttonPanel;
    private ArrowPanel upButton;
    private ArrowPanel downButton;

    public Spinner(int n2) {
        super(new BorderLayout());
        this.value = n2;
        this.textField = new JTextField(Integer.toString(this.value));
        this.textField.setHorizontalAlignment(4);
        this.add(this.textField);
        this.buttonPanel = new JPanel(new GridLayout(2, 1, 0, 1));
        this.upButton = new ArrowPanel(0);
        this.upButton.addMouseListener(this);
        this.downButton = new ArrowPanel(1);
        this.downButton.addMouseListener(this);
        this.buttonPanel.add(this.upButton);
        this.buttonPanel.add(this.downButton);
        this.add((Component)this.buttonPanel, "East");
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == this.upButton) {
            ++this.value;
            this.textField.setText(Integer.toString(this.value));
            this.firePropertyChange("value", this.value - 1, this.value);
            return;
        }
        if (mouseEvent.getSource() != this.downButton) return;
        --this.value;
        this.textField.setText(Integer.toString(this.value));
        this.firePropertyChange("value", this.value + 1, this.value);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }
}

