package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;

public class ConditionBox extends JComboBox
{
    public ConditionBox(final List list) {
        final Iterator<ICriteriumCreator> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.addItem(new CriteriumWrapper(iterator.next()).toString());
        }
    }
}
