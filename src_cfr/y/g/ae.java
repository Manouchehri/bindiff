/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.awt.Color;
import y.g.X;
import y.g.a;

final class ae
extends a {
    ae() {
        Class class_ = X.i == null ? (X.i = X.a("java.awt.Color")) : X.i;
        super(class_);
    }

    @Override
    protected Object a(String string) {
        return Color.decode(new StringBuffer().append("0x").append(string.substring(1)).toString());
    }

    @Override
    protected String a(Object object) {
        Color color = (Color)object;
        StringBuffer stringBuffer = new StringBuffer(7);
        stringBuffer.append('#');
        String string = Integer.toHexString(color.getRed());
        if (string.length() == 1) {
            stringBuffer.append('0');
        }
        stringBuffer.append(string);
        string = Integer.toHexString(color.getGreen());
        if (string.length() == 1) {
            stringBuffer.append('0');
        }
        stringBuffer.append(string);
        string = Integer.toHexString(color.getBlue());
        if (string.length() == 1) {
            stringBuffer.append('0');
        }
        stringBuffer.append(string);
        return stringBuffer.toString();
    }
}

