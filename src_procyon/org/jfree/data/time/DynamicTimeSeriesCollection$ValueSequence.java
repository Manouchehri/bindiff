package org.jfree.data.time;

public class DynamicTimeSeriesCollection$ValueSequence
{
    float[] dataPoints;
    private final DynamicTimeSeriesCollection this$0;
    
    public DynamicTimeSeriesCollection$ValueSequence(final DynamicTimeSeriesCollection collection) {
        this(collection, DynamicTimeSeriesCollection.access$000(collection));
    }
    
    public DynamicTimeSeriesCollection$ValueSequence(final DynamicTimeSeriesCollection this$0, final int n) {
        this.this$0 = this$0;
        this.dataPoints = new float[n];
        for (int i = 0; i < n; ++i) {
            this.dataPoints[i] = 0.0f;
        }
    }
    
    public void enterData(final int n, final float n2) {
        this.dataPoints[n] = n2;
    }
    
    public float getData(final int n) {
        return this.dataPoints[n];
    }
}
