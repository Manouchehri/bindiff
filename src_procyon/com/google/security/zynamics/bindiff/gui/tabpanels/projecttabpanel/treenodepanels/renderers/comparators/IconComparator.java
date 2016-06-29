package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import java.util.*;
import javax.swing.*;
import com.google.common.base.*;

public class IconComparator implements Comparator
{
    public int compare(final Icon icon, final Icon icon2) {
        Preconditions.checkNotNull(icon);
        Preconditions.checkNotNull(icon2);
        return icon.toString().compareTo(icon2.toString());
    }
}
