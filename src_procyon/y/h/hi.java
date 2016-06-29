package y.h;

import java.awt.*;
import java.awt.font.*;

class hi
{
    double a;
    float b;
    float c;
    String d;
    
    hi(final String d, final Font font, final FontRenderContext fontRenderContext) {
        this.d = d;
        final TextLayout textLayout = new TextLayout(d, font, fontRenderContext);
        this.a = font.getStringBounds(this.d, fontRenderContext).getWidth();
        this.b = textLayout.getAscent();
        this.c = textLayout.getDescent();
    }
}
