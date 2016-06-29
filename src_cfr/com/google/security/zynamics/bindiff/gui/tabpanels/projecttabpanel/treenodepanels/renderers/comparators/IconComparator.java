/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.swing.Icon;

public class IconComparator
implements Comparator {
    public int compare(Icon icon, Icon icon2) {
        Preconditions.checkNotNull(icon);
        Preconditions.checkNotNull(icon2);
        return icon.toString().compareTo(icon2.toString());
    }
}

