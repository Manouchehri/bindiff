/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import org.jfree.data.category.CategoryDataset;

public interface StatisticalCategoryDataset
extends CategoryDataset {
    public Number getMeanValue(int var1, int var2);

    public Number getMeanValue(Comparable var1, Comparable var2);

    public Number getStdDevValue(int var1, int var2);

    public Number getStdDevValue(Comparable var1, Comparable var2);
}

