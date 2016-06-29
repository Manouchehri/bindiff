/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.urls;

import java.io.Serializable;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.util.ObjectUtilities;

public class StandardPieURLGenerator
implements Serializable,
PieURLGenerator {
    private static final long serialVersionUID = 1626966402065883419L;
    private String prefix = "index.html";
    private String categoryParameterName = "category";
    private String indexParameterName = "pieIndex";

    public StandardPieURLGenerator() {
        this("index.html");
    }

    public StandardPieURLGenerator(String string) {
        this(string, "category");
    }

    public StandardPieURLGenerator(String string, String string2) {
        this(string, string2, "pieIndex");
    }

    public StandardPieURLGenerator(String string, String string2, String string3) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        if (string2 == null) {
            throw new IllegalArgumentException("Null 'categoryParameterName' argument.");
        }
        this.prefix = string;
        this.categoryParameterName = string2;
        this.indexParameterName = string3;
    }

    @Override
    public String generateURL(PieDataset pieDataset, Comparable comparable, int n2) {
        String string = this.prefix;
        string = string.indexOf("?") > -1 ? new StringBuffer().append(string).append("&amp;").append(this.categoryParameterName).append("=").append(comparable.toString()).toString() : new StringBuffer().append(string).append("?").append(this.categoryParameterName).append("=").append(comparable.toString()).toString();
        if (this.indexParameterName == null) return string;
        return new StringBuffer().append(string).append("&amp;").append(this.indexParameterName).append("=").append(String.valueOf(n2)).toString();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardPieURLGenerator)) {
            return false;
        }
        StandardPieURLGenerator standardPieURLGenerator = (StandardPieURLGenerator)object;
        if (!this.prefix.equals(standardPieURLGenerator.prefix)) {
            return false;
        }
        if (!this.categoryParameterName.equals(standardPieURLGenerator.categoryParameterName)) {
            return false;
        }
        if (ObjectUtilities.equal(this.indexParameterName, standardPieURLGenerator.indexParameterName)) return true;
        return false;
    }
}

