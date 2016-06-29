/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.category;

import org.jfree.data.category.CategoryDataset;

public interface IntervalCategoryDataset
extends CategoryDataset {
    public Number getStartValue(int var1, int var2);

    public Number getStartValue(Comparable var1, Comparable var2);

    public Number getEndValue(int var1, int var2);

    public Number getEndValue(Comparable var1, Comparable var2);
}

