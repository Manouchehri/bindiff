/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.imagemap;

import org.jfree.chart.imagemap.URLTagFragmentGenerator;

public class StandardURLTagFragmentGenerator
implements URLTagFragmentGenerator {
    @Override
    public String generateURLFragment(String string) {
        return new StringBuffer().append(" href=\"").append(string).append("\"").toString();
    }
}

