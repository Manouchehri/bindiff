package com.google.security.zynamics.zylib.gui.JHint;

import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.zylib.resources.*;

public class JHintIcon extends JPanel
{
    private static final long serialVersionUID = 6381830838383637854L;
    private static final ImageIcon HELP_ICON;
    private final String m_message;
    private JHintDialog m_dialog;
    private static final boolean m_isCursorOverDialog = false;
    
    public JHintIcon(final String s) {
        super(new BorderLayout());
        this.m_message = s;
        this.add(new JLabel(JHintIcon.HELP_ICON));
        this.setToolTipText(s);
    }
    
    public JHintDialog getM_dialog() {
        return this.m_dialog;
    }
    
    public String getM_message() {
        return this.m_message;
    }
    
    public boolean isM_isCursorOverDialog() {
        return false;
    }
    
    public void setM_dialog(final JHintDialog dialog) {
        this.m_dialog = dialog;
    }
    
    static {
        HELP_ICON = new ImageIcon(Constants.class.getResource("help.png"));
    }
}
