/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;
import javax.swing.JCheckBox;

public class JCheckBoxComparator
implements Serializable,
Comparator {
    private static final long serialVersionUID = -2526854370340524821L;

    public int compare(JCheckBox jCheckBox, JCheckBox jCheckBox2) {
        return Boolean.valueOf(jCheckBox.isSelected()).compareTo(jCheckBox2.isSelected());
    }
}

