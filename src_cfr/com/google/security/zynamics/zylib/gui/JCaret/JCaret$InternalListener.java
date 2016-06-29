/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JCaret;

import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JCaret$InternalListener
implements ActionListener {
    final /* synthetic */ JCaret this$0;

    private JCaret$InternalListener(JCaret jCaret) {
        this.this$0 = jCaret;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JCaret.access$102(this.this$0, !JCaret.access$100(this.this$0));
        JCaret.access$200(this.this$0);
    }

    /* synthetic */ JCaret$InternalListener(JCaret jCaret, JCaret$1 jCaret$1) {
        this(jCaret);
    }
}

