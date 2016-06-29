package com.google.security.zynamics.zylib.gui.comboboxes.memorybox;

import com.google.common.base.*;
import javax.swing.*;

public class JMemoryBox extends JComboBox
{
    private final JMemoryBoxModel m_model;
    
    public JMemoryBox(final int n) {
        Preconditions.checkArgument(n > 0, (Object)"Error: Maximum argument must be positive");
        this.setModel(this.m_model = new JMemoryBoxModel(n));
        this.setEditable(true);
    }
    
    public void add(final String s) {
        this.m_model.add((String)Preconditions.checkNotNull(s, (Object)"Error: Text argument can not be null"));
    }
}
