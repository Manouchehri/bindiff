package y.g;

import java.awt.*;

final class aa extends a
{
    aa() {
        super((X.l == null) ? (X.l = X.a("java.awt.Font")) : X.l);
    }
    
    protected Object a(final String s) {
        return Font.decode(s);
    }
    
    protected String a(final Object o) {
        final Font font = (Font)o;
        final StringBuffer sb = new StringBuffer(50);
        sb.append(font.getFamily());
        sb.append('-');
        Label_0085: {
            if (font.getStyle() == 0) {
                sb.append("PLAIN");
                if (!p.c) {
                    break Label_0085;
                }
            }
            if ((font.getStyle() & 0x1) == 0x1) {
                sb.append("BOLD");
            }
            if ((font.getStyle() & 0x2) == 0x2) {
                sb.append("ITALIC");
            }
        }
        sb.append('-');
        sb.append(font.getSize());
        return sb.toString();
    }
}
