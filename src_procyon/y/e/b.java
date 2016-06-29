package y.e;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import y.h.*;

public class b extends e
{
    protected void a(final BufferedImage bufferedImage, final OutputStream outputStream) {
        final ImageWriter a = y.e.d.a("gif");
        if (a != null) {
            y.e.d.a(a, bufferedImage, outputStream, null);
            if (y.e.c.a == 0) {
                return;
            }
        }
        throw new IOException(y.e.d.b("gif"));
    }
    
    protected BufferedImage a(final int n, final int n2) {
        return new BufferedImage(n, n2, 2);
    }
    
    public ch a(final bu bu) {
        final ch a = super.a(bu);
        final M backgroundRenderer = new M(a);
        backgroundRenderer.setColor(new Color(255, 255, 255, 0));
        a.setBackgroundRenderer(backgroundRenderer);
        return a;
    }
}
