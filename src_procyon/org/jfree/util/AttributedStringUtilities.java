package org.jfree.util;

import java.text.*;

public class AttributedStringUtilities
{
    public static boolean equal(final AttributedString attributedString, final AttributedString attributedString2) {
        if (attributedString == null) {
            return attributedString2 == null;
        }
        if (attributedString2 == null) {
            return false;
        }
        final AttributedCharacterIterator iterator = attributedString.getIterator();
        final AttributedCharacterIterator iterator2 = attributedString2.getIterator();
        char c = iterator.first();
        char c2 = iterator2.first();
        int n = 0;
        while (c != '\uffff') {
            final int runLimit = iterator.getRunLimit();
            if (runLimit != iterator2.getRunLimit()) {
                return false;
            }
            if (!iterator.getAttributes().equals(iterator2.getAttributes())) {
                return false;
            }
            for (int i = n; i < runLimit; ++i) {
                if (c != c2) {
                    return false;
                }
                c = iterator.next();
                c2 = iterator2.next();
            }
            n = runLimit;
        }
        return c2 == '\uffff';
    }
}
