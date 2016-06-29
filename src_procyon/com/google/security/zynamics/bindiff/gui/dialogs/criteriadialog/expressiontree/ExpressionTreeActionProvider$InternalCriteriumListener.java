package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import javax.swing.tree.*;

class ExpressionTreeActionProvider$InternalCriteriumListener implements ICriteriumListener
{
    final /* synthetic */ ExpressionTreeActionProvider this$0;
    
    private ExpressionTreeActionProvider$InternalCriteriumListener(final ExpressionTreeActionProvider this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void criteriumChanged() {
        this.this$0.jtree.updateUI();
    }
}
