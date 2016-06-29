/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Map;

public class AttributedStringUtilities {
    private AttributedStringUtilities() {
    }

    public static boolean equal(AttributedString attributedString, AttributedString attributedString2) {
        if (attributedString == null) {
            if (attributedString2 != null) return false;
            return true;
        }
        if (attributedString2 == null) {
            return false;
        }
        AttributedCharacterIterator attributedCharacterIterator = attributedString.getIterator();
        AttributedCharacterIterator attributedCharacterIterator2 = attributedString2.getIterator();
        char c2 = attributedCharacterIterator.first();
        char c3 = attributedCharacterIterator2.first();
        int n2 = 0;
        do {
            int n3;
            if (c2 != '\uffff') {
                int n4;
                Map<AttributedCharacterIterator.Attribute, Object> map;
                n3 = attributedCharacterIterator.getRunLimit();
                if (n3 != (n4 = attributedCharacterIterator2.getRunLimit())) {
                    return false;
                }
                Map<AttributedCharacterIterator.Attribute, Object> map2 = attributedCharacterIterator.getAttributes();
                if (!map2.equals(map = attributedCharacterIterator2.getAttributes())) {
                    return false;
                }
            } else {
                if (c3 != '\uffff') return false;
                return true;
            }
            for (int i2 = n2; i2 < n3; ++i2) {
                if (c2 != c3) {
                    return false;
                }
                c2 = attributedCharacterIterator.next();
                c3 = attributedCharacterIterator2.next();
            }
            n2 = n3;
        } while (true);
    }
}

