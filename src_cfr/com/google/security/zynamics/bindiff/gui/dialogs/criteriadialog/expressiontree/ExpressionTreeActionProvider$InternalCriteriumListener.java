/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider$1;

class ExpressionTreeActionProvider$InternalCriteriumListener
implements ICriteriumListener {
    final /* synthetic */ ExpressionTreeActionProvider this$0;

    private ExpressionTreeActionProvider$InternalCriteriumListener(ExpressionTreeActionProvider expressionTreeActionProvider) {
        this.this$0 = expressionTreeActionProvider;
    }

    @Override
    public void criteriumChanged() {
        ExpressionTreeActionProvider.access$100(this.this$0).updateUI();
    }

    /* synthetic */ ExpressionTreeActionProvider$InternalCriteriumListener(ExpressionTreeActionProvider expressionTreeActionProvider, ExpressionTreeActionProvider$1 expressionTreeActionProvider$1) {
        this(expressionTreeActionProvider);
    }
}

