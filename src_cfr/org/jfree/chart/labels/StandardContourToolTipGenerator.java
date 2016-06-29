/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.chart.labels.ContourToolTipGenerator;
import org.jfree.data.contour.ContourDataset;

public class StandardContourToolTipGenerator
implements Serializable,
ContourToolTipGenerator {
    private static final long serialVersionUID = -1881659351247502711L;
    private DecimalFormat valueForm = new DecimalFormat("##.###");

    @Override
    public String generateToolTip(ContourDataset contourDataset, int n2) {
        double d2 = contourDataset.getXValue(0, n2);
        double d3 = contourDataset.getYValue(0, n2);
        double d4 = contourDataset.getZValue(0, n2);
        String string = null;
        if (contourDataset.isDateAxis(0)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer = simpleDateFormat.format(new Date((long)d2), stringBuffer, new FieldPosition(0));
            string = stringBuffer.toString();
        } else {
            string = this.valueForm.format(d2);
        }
        if (Double.isNaN(d4)) return new StringBuffer().append("X: ").append(string).append(", Y: ").append(this.valueForm.format(d3)).append(", Z: no data").toString();
        return new StringBuffer().append("X: ").append(string).append(", Y: ").append(this.valueForm.format(d3)).append(", Z: ").append(this.valueForm.format(d4)).toString();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardContourToolTipGenerator)) {
            return false;
        }
        StandardContourToolTipGenerator standardContourToolTipGenerator = (StandardContourToolTipGenerator)object;
        if (this.valueForm == null) return false;
        return this.valueForm.equals(standardContourToolTipGenerator.valueForm);
    }
}

