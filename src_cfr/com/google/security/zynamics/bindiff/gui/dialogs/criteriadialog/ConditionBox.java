/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumWrapper;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;

public class ConditionBox
extends JComboBox {
    public ConditionBox(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ICriteriumCreator iCriteriumCreator = (ICriteriumCreator)iterator.next();
            this.addItem(new CriteriumWrapper(iCriteriumCreator).toString());
        }
    }
}

