package org.jfree.data.xy;

public interface OHLCDataset extends XYDataset
{
    Number getHigh(final int p0, final int p1);
    
    double getHighValue(final int p0, final int p1);
    
    Number getLow(final int p0, final int p1);
    
    double getLowValue(final int p0, final int p1);
    
    Number getOpen(final int p0, final int p1);
    
    double getOpenValue(final int p0, final int p1);
    
    Number getClose(final int p0, final int p1);
    
    double getCloseValue(final int p0, final int p1);
    
    Number getVolume(final int p0, final int p1);
    
    double getVolumeValue(final int p0, final int p1);
}
