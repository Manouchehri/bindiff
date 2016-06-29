/*
 * Decompiled with CFR 0_115.
 */
package y.e;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageWriter;
import y.e.c;
import y.e.d;
import y.e.e;
import y.h.M;
import y.h.bu;
import y.h.ch;
import y.h.w;

public class b
extends e {
    @Override
    protected void a(BufferedImage bufferedImage, OutputStream outputStream) {
        ImageWriter imageWriter = d.a("gif");
        if (imageWriter == null) throw new IOException(d.b("gif"));
        d.a(imageWriter, bufferedImage, outputStream, null);
        if (c.a == 0) return;
        throw new IOException(d.b("gif"));
    }

    @Override
    protected BufferedImage a(int n2, int n3) {
        return new BufferedImage(n2, n3, 2);
    }

    @Override
    public ch a(bu bu2) {
        ch ch2 = super.a(bu2);
        M m2 = new M(ch2);
        m2.setColor(new Color(255, 255, 255, 0));
        ch2.setBackgroundRenderer(m2);
        return ch2;
    }
}

