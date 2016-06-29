/*
 * Decompiled with CFR 0_115.
 */
package y.e;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import y.e.c;
import y.h.bu;
import y.h.cV;
import y.h.ch;
import y.h.gF;
import y.h.gI;
import y.h.hk;

public abstract class e
extends c {
    private boolean b;
    private boolean c;
    private double d = 10.0;

    protected e() {
        this(false);
    }

    protected e(boolean bl2) {
        this.b = bl2;
        this.c = true;
    }

    public boolean c() {
        return this.c;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(bu bu2, OutputStream outputStream) {
        ch ch2 = (ch)bu2.S();
        ch ch3 = ch2;
        if (ch3 == null) {
            ch3 = this.a(bu2);
        }
        try {
            this.a(ch3, outputStream);
            return;
        }
        finally {
            if (ch2 == null) {
                bu2.c(ch3);
            }
        }
    }

    public void a(ch ch2, OutputStream outputStream) {
        BufferedImage bufferedImage;
        cV cV2;
        Dimension dimension = ch2.getCanvasSize();
        long l2 = (long)dimension.width * (long)dimension.height;
        if (l2 > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(new StringBuffer().append("Image size of ").append(dimension.width).append("x").append(dimension.height).append("=").append(l2).append("px exceeds maximum size of ").append(Integer.MAX_VALUE).append("px.").toString());
        }
        try {
            bufferedImage = this.a(dimension.width, dimension.height);
        }
        catch (OutOfMemoryError var7_6) {
            int n2 = (int)Math.ceil((double)(dimension.width * dimension.height) / 1048576.0);
            throw new OutOfMemoryError(new StringBuffer().append("Not enough memory for temporary image of size ").append(dimension.width).append('x').append(dimension.height).append(" (").append(n2).append("MPixels).  Approximately ").append(n2 * 4).append("MByte required.").toString());
        }
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        if (!this.c()) {
            graphics2D.setRenderingHint(hk.a, hk.b);
        }
        if (this.b) {
            gF.a(graphics2D);
        }
        if ((cV2 = this.a(ch2, graphics2D)) != null) {
            graphics2D.setRenderingHint(hk.z, cV2);
        }
        ch2.paintVisibleContent(graphics2D);
        if (this.b) {
            gF.b(graphics2D);
        }
        try {
            this.a(bufferedImage, outputStream);
            return;
        }
        catch (OutOfMemoryError var9_10) {
            int n3 = (int)Math.ceil((double)(dimension.width * dimension.height) / 1048576.0);
            throw new OutOfMemoryError(new StringBuffer().append("Not enough memory to encode image of size ").append(bufferedImage.getWidth()).append('x').append(bufferedImage.getHeight()).append(" (").append(n3).append("MPixels). Approximately ").append(n3 * 4).append("MByte required.").toString());
        }
    }

    protected cV a(ch ch2, Graphics2D graphics2D) {
        cV cV2 = new cV();
        cV2.b(true);
        cV2.a(ch2);
        cV2.a(graphics2D.getTransform());
        return cV2;
    }

    protected abstract BufferedImage a(int var1, int var2);

    public ch a(bu bu2) {
        ch ch2 = new ch(bu2);
        Rectangle rectangle = bu2.a();
        Dimension dimension = new Dimension(rectangle.width, rectangle.height);
        ch2.setSize(dimension);
        ch2.setPreferredSize(dimension);
        ch2.zoomToArea((double)rectangle.x - this.d, (double)rectangle.y - this.d, (double)rectangle.width + 2.0 * this.d, (double)rectangle.height + 2.0 * this.d);
        ch2.setPaintDetailThreshold(0.0);
        return ch2;
    }

    protected abstract void a(BufferedImage var1, OutputStream var2);

    public void a(boolean bl2) {
        this.b = bl2;
    }
}

