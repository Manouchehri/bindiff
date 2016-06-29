package org.jfree.date;

public class EasterSundayRule extends AnnualDateRule
{
    public SerialDate getDate(final int n) {
        final int n2 = n % 19;
        final int n3 = n / 100;
        final int n4 = (n3 - n3 / 4 - (8 * n3 + 13) / 25 + 19 * n2 + 15) % 30;
        final int n5 = n4 - n4 / 28 * (1 - n4 / 28 * 29 / (n4 + 1) * (21 - n2) / 11);
        final int n6 = n5 - (n + n / 4 + n5 + 2 - n3 + n3 / 4) % 7;
        final int n7 = 3 + (n6 + 40) / 44;
        return SerialDate.createInstance(n6 + 28 - 31 * (n7 / 4), n7, n);
    }
}
