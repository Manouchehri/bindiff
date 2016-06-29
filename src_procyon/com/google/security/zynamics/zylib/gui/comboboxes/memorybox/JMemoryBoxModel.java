package com.google.security.zynamics.zylib.gui.comboboxes.memorybox;

import javax.swing.*;

public class JMemoryBoxModel extends DefaultComboBoxModel
{
    private final int m_maximum;
    
    public JMemoryBoxModel(final int maximum) {
        this.m_maximum = maximum;
    }
    
    public void add(final String selectedItem) {
        this.removeElement(selectedItem);
        this.insertElementAt(selectedItem, 0);
        while (this.getSize() > this.m_maximum) {
            this.removeElementAt(this.m_maximum);
        }
        this.setSelectedItem(selectedItem);
    }
}
