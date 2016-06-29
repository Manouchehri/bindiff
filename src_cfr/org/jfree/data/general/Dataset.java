/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;

public interface Dataset {
    public void addChangeListener(DatasetChangeListener var1);

    public void removeChangeListener(DatasetChangeListener var1);

    public DatasetGroup getGroup();

    public void setGroup(DatasetGroup var1);
}

