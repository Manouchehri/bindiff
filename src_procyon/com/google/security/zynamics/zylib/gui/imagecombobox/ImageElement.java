package com.google.security.zynamics.zylib.gui.imagecombobox;

import javax.swing.*;

public class ImageElement
{
    private final Object m_object;
    private final ImageIcon m_icon;
    
    public ImageElement(final Object object, final ImageIcon icon) {
        this.m_object = object;
        this.m_icon = icon;
    }
    
    public ImageIcon getIcon() {
        return this.m_icon;
    }
    
    public Object getObject() {
        return this.m_object;
    }
}
