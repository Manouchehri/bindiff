package org.jfree.data.function;

public class NormalDistributionFunction2D implements Function2D
{
    private double mean;
    private double std;
    
    public NormalDistributionFunction2D(final double mean, final double std) {
        this.mean = mean;
        this.std = std;
    }
    
    public double getMean() {
        return this.mean;
    }
    
    public double getStandardDeviation() {
        return this.std;
    }
    
    public double getValue(final double n) {
        return Math.exp(-1.0 * (n - this.mean) * (n - this.mean) / (2.0 * this.std * this.std)) / Math.sqrt(6.283185307179586 * this.std * this.std);
    }
}
