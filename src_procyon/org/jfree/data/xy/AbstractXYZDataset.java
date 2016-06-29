package org.jfree.data.xy;

public abstract class AbstractXYZDataset extends AbstractXYDataset implements XYZDataset
{
    public double getZValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number z = this.getZ(n, n2);
        if (z != null) {
            doubleValue = z.doubleValue();
        }
        return doubleValue;
    }
}
