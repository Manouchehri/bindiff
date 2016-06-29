/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.xy.XYDataset;

public interface BoxAndWhiskerXYDataset
extends XYDataset {
    public Number getMeanValue(int var1, int var2);

    public Number getMedianValue(int var1, int var2);

    public Number getQ1Value(int var1, int var2);

    public Number getQ3Value(int var1, int var2);

    public Number getMinRegularValue(int var1, int var2);

    public Number getMaxRegularValue(int var1, int var2);

    public Number getMinOutlier(int var1, int var2);

    public Number getMaxOutlier(int var1, int var2);

    public List getOutliers(int var1, int var2);

    public double getOutlierCoefficient();

    public double getFaroutCoefficient();
}

