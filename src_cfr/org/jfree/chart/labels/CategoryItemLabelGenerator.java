/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import org.jfree.data.category.CategoryDataset;

public interface CategoryItemLabelGenerator {
    public String generateRowLabel(CategoryDataset var1, int var2);

    public String generateColumnLabel(CategoryDataset var1, int var2);

    public String generateLabel(CategoryDataset var1, int var2, int var3);
}

