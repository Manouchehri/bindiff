package org.jfree.chart.labels;

import java.io.*;
import org.jfree.data.contour.*;
import java.util.*;
import java.text.*;

public class StandardContourToolTipGenerator implements Serializable, ContourToolTipGenerator
{
    private static final long serialVersionUID = -1881659351247502711L;
    private DecimalFormat valueForm;
    
    public StandardContourToolTipGenerator() {
        this.valueForm = new DecimalFormat("##.###");
    }
    
    public String generateToolTip(final ContourDataset contourDataset, final int n) {
        final double xValue = contourDataset.getXValue(0, n);
        final double yValue = contourDataset.getYValue(0, n);
        final double zValue = contourDataset.getZValue(0, n);
        String s;
        if (contourDataset.isDateAxis(0)) {
            s = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").format(new Date((long)xValue), new StringBuffer(), new FieldPosition(0)).toString();
        }
        else {
            s = this.valueForm.format(xValue);
        }
        if (!Double.isNaN(zValue)) {
            return "X: " + s + ", Y: " + this.valueForm.format(yValue) + ", Z: " + this.valueForm.format(zValue);
        }
        return "X: " + s + ", Y: " + this.valueForm.format(yValue) + ", Z: no data";
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StandardContourToolTipGenerator)) {
            return false;
        }
        final StandardContourToolTipGenerator standardContourToolTipGenerator = (StandardContourToolTipGenerator)o;
        return this.valueForm != null && this.valueForm.equals(standardContourToolTipGenerator.valueForm);
    }
}
