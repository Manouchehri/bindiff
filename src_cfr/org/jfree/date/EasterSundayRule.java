/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import org.jfree.date.AnnualDateRule;
import org.jfree.date.SerialDate;

public class EasterSundayRule
extends AnnualDateRule {
    @Override
    public SerialDate getDate(int n2) {
        int n3 = n2 % 19;
        int n4 = n2 / 100;
        int n5 = (n4 - n4 / 4 - (8 * n4 + 13) / 25 + 19 * n3 + 15) % 30;
        int n6 = n5 - n5 / 28 * (1 - n5 / 28 * 29 / (n5 + 1) * (21 - n3) / 11);
        int n7 = (n2 + n2 / 4 + n6 + 2 - n4 + n4 / 4) % 7;
        int n8 = n6 - n7;
        int n9 = 3 + (n8 + 40) / 44;
        int n10 = n8 + 28 - 31 * (n9 / 4);
        return SerialDate.createInstance(n10, n9, n2);
    }
}

