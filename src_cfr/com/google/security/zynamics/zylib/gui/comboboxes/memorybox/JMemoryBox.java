/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.comboboxes.memorybox;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.JMemoryBoxModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class JMemoryBox
extends JComboBox {
    private final JMemoryBoxModel m_model;

    public JMemoryBox(int n2) {
        Preconditions.checkArgument(n2 > 0, "Error: Maximum argument must be positive");
        this.m_model = new JMemoryBoxModel(n2);
        this.setModel(this.m_model);
        this.setEditable(true);
    }

    public void add(String string) {
        this.m_model.add((String)Preconditions.checkNotNull(string, "Error: Text argument can not be null"));
    }
}

