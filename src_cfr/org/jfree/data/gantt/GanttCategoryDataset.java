/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.gantt;

import org.jfree.data.category.IntervalCategoryDataset;

public interface GanttCategoryDataset
extends IntervalCategoryDataset {
    public Number getPercentComplete(int var1, int var2);

    public Number getPercentComplete(Comparable var1, Comparable var2);

    public int getSubIntervalCount(int var1, int var2);

    public int getSubIntervalCount(Comparable var1, Comparable var2);

    public Number getStartValue(int var1, int var2, int var3);

    public Number getStartValue(Comparable var1, Comparable var2, int var3);

    public Number getEndValue(int var1, int var2, int var3);

    public Number getEndValue(Comparable var1, Comparable var2, int var3);

    public Number getPercentComplete(int var1, int var2, int var3);

    public Number getPercentComplete(Comparable var1, Comparable var2, int var3);
}

