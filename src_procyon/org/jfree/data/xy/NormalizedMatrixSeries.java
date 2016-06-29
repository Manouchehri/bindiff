package org.jfree.data.xy;

public class NormalizedMatrixSeries extends MatrixSeries
{
    public static final double DEFAULT_SCALE_FACTOR = 1.0;
    private double m_scaleFactor;
    private double m_totalSum;
    
    public NormalizedMatrixSeries(final String s, final int n, final int n2) {
        super(s, n, n2);
        this.m_scaleFactor = 1.0;
        this.m_totalSum = Double.MIN_VALUE;
    }
    
    public Number getItem(final int n) {
        return new Double(this.get(this.getItemRow(n), this.getItemColumn(n)) * this.m_scaleFactor / this.m_totalSum);
    }
    
    public void setScaleFactor(final double scaleFactor) {
        this.m_scaleFactor = scaleFactor;
    }
    
    public double getScaleFactor() {
        return this.m_scaleFactor;
    }
    
    public void update(final int n, final int n2, final double n3) {
        this.m_totalSum -= this.get(n, n2);
        this.m_totalSum += n3;
        super.update(n, n2, n3);
    }
    
    public void zeroAll() {
        this.m_totalSum = 0.0;
        super.zeroAll();
    }
}
