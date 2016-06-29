/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.category.CategoryDataset;

public interface BoxAndWhiskerCategoryDataset
extends CategoryDataset {
    public Number getMeanValue(int var1, int var2);

    public Number getMeanValue(Comparable var1, Comparable var2);

    public Number getMedianValue(int var1, int var2);

    public Number getMedianValue(Comparable var1, Comparable var2);

    public Number getQ1Value(int var1, int var2);

    public Number getQ1Value(Comparable var1, Comparable var2);

    public Number getQ3Value(int var1, int var2);

    public Number getQ3Value(Comparable var1, Comparable var2);

    public Number getMinRegularValue(int var1, int var2);

    public Number getMinRegularValue(Comparable var1, Comparable var2);

    public Number getMaxRegularValue(int var1, int var2);

    public Number getMaxRegularValue(Comparable var1, Comparable var2);

    public Number getMinOutlier(int var1, int var2);

    public Number getMinOutlier(Comparable var1, Comparable var2);

    public Number getMaxOutlier(int var1, int var2);

    public Number getMaxOutlier(Comparable var1, Comparable var2);

    public List getOutliers(int var1, int var2);

    public List getOutliers(Comparable var1, Comparable var2);
}

