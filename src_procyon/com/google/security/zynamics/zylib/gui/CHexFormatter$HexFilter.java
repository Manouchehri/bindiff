package com.google.security.zynamics.zylib.gui;

import javax.swing.text.*;
import javax.swing.*;
import com.google.common.base.*;

class CHexFormatter$HexFilter extends DocumentFilter
{
    final /* synthetic */ CHexFormatter this$0;
    
    private CHexFormatter$HexFilter(final CHexFormatter this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void insertString(final FilterBypass filterBypass, final int n, final String s, final AttributeSet set) {
        if (this.this$0.isValid(s, 0)) {
            super.insertString(filterBypass, n, s, set);
        }
    }
    
    @Override
    public void replace(final FilterBypass filterBypass, final int n, final int n2, final String s, final AttributeSet set) {
        if (this.this$0.isValid(s, n2)) {
            super.replace(filterBypass, n, n2, s, set);
        }
    }
}
