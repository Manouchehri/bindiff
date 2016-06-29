package y.g;

import java.awt.*;

final class ae extends a
{
    ae() {
        super((X.i == null) ? (X.i = X.a("java.awt.Color")) : X.i);
    }
    
    protected Object a(final String s) {
        return Color.decode("0x" + s.substring(1));
    }
    
    protected String a(final Object o) {
        final Color color = (Color)o;
        final StringBuffer sb = new StringBuffer(7);
        sb.append('#');
        final String hexString = Integer.toHexString(color.getRed());
        if (hexString.length() == 1) {
            sb.append('0');
        }
        sb.append(hexString);
        final String hexString2 = Integer.toHexString(color.getGreen());
        if (hexString2.length() == 1) {
            sb.append('0');
        }
        sb.append(hexString2);
        final String hexString3 = Integer.toHexString(color.getBlue());
        if (hexString3.length() == 1) {
            sb.append('0');
        }
        sb.append(hexString3);
        return sb.toString();
    }
}
