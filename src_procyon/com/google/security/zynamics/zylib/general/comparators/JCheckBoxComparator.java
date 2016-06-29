package com.google.security.zynamics.zylib.general.comparators;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class JCheckBoxComparator implements Serializable, Comparator
{
    private static final long serialVersionUID = -2526854370340524821L;
    
    public int compare(final JCheckBox checkBox, final JCheckBox checkBox2) {
        return Boolean.valueOf(checkBox.isSelected()).compareTo(Boolean.valueOf(checkBox2.isSelected()));
    }
}
