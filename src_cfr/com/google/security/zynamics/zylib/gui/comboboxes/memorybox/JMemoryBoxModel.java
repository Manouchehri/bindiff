/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.comboboxes.memorybox;

import javax.swing.DefaultComboBoxModel;

public class JMemoryBoxModel
extends DefaultComboBoxModel {
    private final int m_maximum;

    public JMemoryBoxModel(int n2) {
        this.m_maximum = n2;
    }

    public void add(String string) {
        this.removeElement(string);
        this.insertElementAt(string, 0);
        do {
            if (this.getSize() <= this.m_maximum) {
                this.setSelectedItem(string);
                return;
            }
            this.removeElementAt(this.m_maximum);
        } while (true);
    }
}

