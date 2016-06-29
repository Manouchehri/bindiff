/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import org.jfree.data.time.DynamicTimeSeriesCollection;

public class DynamicTimeSeriesCollection$ValueSequence {
    float[] dataPoints;
    private final DynamicTimeSeriesCollection this$0;

    public DynamicTimeSeriesCollection$ValueSequence(DynamicTimeSeriesCollection dynamicTimeSeriesCollection) {
        this(dynamicTimeSeriesCollection, DynamicTimeSeriesCollection.access$000(dynamicTimeSeriesCollection));
    }

    public DynamicTimeSeriesCollection$ValueSequence(DynamicTimeSeriesCollection dynamicTimeSeriesCollection, int n2) {
        this.this$0 = dynamicTimeSeriesCollection;
        this.dataPoints = new float[n2];
        int n3 = 0;
        while (n3 < n2) {
            this.dataPoints[n3] = 0.0f;
            ++n3;
        }
    }

    public void enterData(int n2, float f2) {
        this.dataPoints[n2] = f2;
    }

    public float getData(int n2) {
        return this.dataPoints[n2];
    }
}

