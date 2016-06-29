package com.google.security.zynamics.zylib.gui.textfields;

import javax.swing.text.*;

public class JTextFieldLimit extends DefaultStyledDocument
{
    private static final long serialVersionUID = -8124048672190684534L;
    private final int limit;
    
    public JTextFieldLimit() {
        this(30000);
    }
    
    public JTextFieldLimit(final int limit) {
        this.limit = limit;
    }
    
    @Override
    public void insertString(final int n, final String s, final AttributeSet set) {
        if (s == null) {
            return;
        }
        if (this.getLength() + s.length() <= this.limit) {
            super.insertString(n, s, set);
        }
    }
}
