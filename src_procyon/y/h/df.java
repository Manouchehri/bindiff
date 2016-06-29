package y.h;

import java.net.*;
import java.awt.geom.*;
import y.g.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import y.e.*;
import java.util.*;
import javax.swing.*;

public class df extends fj
{
    private static final Hashtable a;
    private static final WeakHashMap b;
    private static final Set c;
    private static OutputStream d;
    private static final Component e;
    private static final MediaTracker f;
    private URL g;
    private Image h;
    private BufferedImage i;
    private static final BufferedImage k;
    
    public df() {
    }
    
    public df(final fj fj) {
        super(fj);
        if (fj instanceof df) {
            final df df = (df)fj;
            this.h = df.h;
            this.i = df.i;
            this.g = df.g;
        }
    }
    
    public boolean contains(double n, double n2) {
        if (this.i != null) {
            n -= this.getX();
            n2 -= this.getY();
            n *= this.i.getWidth() / this.getWidth();
            n2 *= this.i.getHeight() / this.getHeight();
            return n >= 0.0 && n2 >= 0.0 && n < this.i.getWidth() && n2 < this.i.getHeight() && (this.i.getRGB((int)n, (int)n2) >> 24 & 0xFF) > 127;
        }
        return super.contains(n, n2);
    }
    
    public void a(final boolean b) {
        this.b(b);
        this.invalidatePortPositions();
        this.setEdgesDirty();
    }
    
    private void b(final boolean b) {
        final boolean z = fj.z;
        if (!b) {
            this.i = null;
            if (!z) {
                return;
            }
        }
        if (this.h == null) {
            this.i = df.k;
            return;
        }
        synchronized (df.b) {
            this.i = df.b.get(this.h);
        }
        if (this.i == null) {
            if (this.h == null) {
                this.i = df.k;
                if (!z) {
                    return;
                }
            }
            if (this.h instanceof BufferedImage) {
                this.i = (BufferedImage)this.h;
                if (!z) {
                    return;
                }
            }
            final int n = (int)(this.h.getWidth(df.e) * 1.0);
            final int n2 = (int)(this.h.getHeight(df.e) * 1.0);
            if (n > 0 && n2 > 0) {
                final BufferedImage bufferedImage = new BufferedImage(n, n2, 2);
                final Graphics2D graphics = bufferedImage.createGraphics();
                graphics.drawImage(this.h, AffineTransform.getScaleInstance(1.0, 1.0), null);
                graphics.setComposite(AlphaComposite.getInstance(5, 1.0f));
                graphics.setColor(new Color(128, 128, 128));
                graphics.fillRect(0, 0, n, n2);
                graphics.dispose();
                final Color color = new Color(128, 128, 128, 0);
                final Color color2 = new Color(0, 0, 0, 0);
                final BufferedImage i = new BufferedImage(n, n2, 13, new IndexColorModel(1, 2, new byte[] { (byte)color2.getRed(), (byte)color.getRed() }, new byte[] { (byte)color2.getGreen(), (byte)color.getGreen() }, new byte[] { (byte)color2.getBlue(), (byte)color.getBlue() }, 0));
                final Graphics2D graphics2 = i.createGraphics();
                try {
                    graphics2.drawImage(bufferedImage, 0, 0, null, null);
                }
                finally {
                    graphics2.dispose();
                }
                this.i = i;
            }
            synchronized (df.b) {
                df.b.put(this.h, this.i);
            }
        }
    }
    
    public boolean a() {
        return this.i != null;
    }
    
    public fj createCopy(final fj fj) {
        return new df(fj);
    }
    
    public static Image a(final URL url) {
        return df.a.get(url);
    }
    
    public void paintNode(final Graphics2D graphics2D) {
        if (this.h != null) {
            graphics2D.drawImage(this.h, (int)this.x, (int)this.y, (int)this.width, (int)this.height, null);
        }
        if (fj.b(this, graphics2D)) {
            this.paintHotSpots(graphics2D);
        }
        if (fj.b(graphics2D, false)) {
            this.paintPorts(graphics2D);
        }
        if (fj.c(graphics2D, false)) {
            this.paintText(graphics2D);
        }
    }
    
    public void write(final ObjectOutputStream d) {
        final boolean z = fj.z;
        Label_0027: {
            if (this.a()) {
                d.writeByte(1);
                if (!z) {
                    break Label_0027;
                }
            }
            d.writeByte(0);
        }
        super.write(d);
        d.writeObject(this.g);
        if (df.d != d) {
            df.c.clear();
            df.d = d;
        }
        if (this.g != null && df.c.contains(this.g)) {
            d.writeBoolean(false);
            if (!z) {
                return;
            }
        }
        d.writeBoolean(true);
        if (this.h == null) {
            d.writeInt(0);
            d.writeInt(0);
            d.write(new byte[0]);
            if (!z) {
                return;
            }
        }
        try {
            final int width = this.h.getWidth(df.e);
            final int height = this.h.getHeight(df.e);
            final int[] array = new int[width * height];
            new PixelGrabber(this.h, 0, 0, width, height, array, 0, width).grabPixels();
            d.writeInt(width);
            d.writeInt(height);
            final byte[] array2 = new byte[array.length * 4];
            int i = 0;
            while (true) {
                while (i < array.length) {
                    final int n = array[i];
                    final int n2 = i * 4;
                    array2[n2 + 3] = (byte)(n & 0xFF);
                    array2[n2 + 2] = (byte)(n >>> 8 & 0xFF);
                    array2[n2 + 1] = (byte)(n >>> 16 & 0xFF);
                    array2[n2] = (byte)(n >>> 24 & 0xFF);
                    ++i;
                    if (z) {
                        if (this.g != null) {
                            df.c.add(this.g);
                        }
                        return;
                    }
                    if (z) {
                        break;
                    }
                }
                d.write(array2);
                continue;
            }
        }
        catch (InterruptedException ex) {
            y.g.o.a((Object)"grabbing interrupted while serializing");
        }
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final byte byte1 = objectInputStream.readByte();
        switch (byte1) {
            case 0:
            case 1: {
                super.read(objectInputStream);
                this.g = (URL)objectInputStream.readObject();
                Label_0318: {
                    Label_0300: {
                        if (objectInputStream.readBoolean()) {
                            final int int1 = objectInputStream.readInt();
                            final int int2 = objectInputStream.readInt();
                            final byte[] array = new byte[int1 * int2 * 4];
                            int i = 0;
                            while (true) {
                            Label_0265_Outer:
                                while (i < array.length - 1) {
                                    final int read;
                                    final int n = read = objectInputStream.read(array, i, array.length - i);
                                    if (z) {
                                        final int[] array2 = new int[read];
                                        int j = 0;
                                        while (true) {
                                            while (j < array2.length) {
                                                final int n2 = j * 4;
                                                array2[j] = ((array[n2] & 0xFF) << 24) + ((array[n2 + 1] & 0xFF) << 16) + ((array[n2 + 2] & 0xFF) << 8) + ((array[n2 + 3] & 0xFF) << 0);
                                                ++j;
                                                if (!z) {
                                                    if (z) {
                                                        break;
                                                    }
                                                    continue Label_0265_Outer;
                                                }
                                                else {
                                                    if (this.g != null) {
                                                        df.a.put(this.g, this.h);
                                                    }
                                                    a(this.h);
                                                    if (z) {
                                                        break Label_0300;
                                                    }
                                                    break Label_0318;
                                                }
                                            }
                                            this.h = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(int1, int2, array2, 0, int1));
                                            continue;
                                        }
                                    }
                                    if (read < 0) {
                                        throw new EOFException("Unexpected end of file");
                                    }
                                    i += n;
                                    if (z) {
                                        break;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                    if (this.g != null) {
                        this.h = a(this.g);
                    }
                }
                this.a(byte1 == 1);
                if (z) {
                    break;
                }
                return;
            }
        }
        throw new a();
    }
    
    private static Image a(final Image image) {
        synchronized (df.f) {
            df.f.addImage(image, 0);
            try {
                df.f.waitForID(0, 5000L);
            }
            catch (InterruptedException ex) {
                o.a((Object)"INTERRUPTED while loading Image");
            }
            final int statusID = df.f.statusID(0, false);
            df.f.removeImage(image, 0);
            switch (statusID) {
                case 2: {
                    return null;
                }
                case 4: {
                    return null;
                }
                default: {
                    return image;
                }
            }
        }
    }
    
    static {
        a = new Hashtable(11);
        b = new WeakHashMap(11);
        c = new HashSet(11);
        df.d = null;
        e = new JLabel();
        f = new MediaTracker(df.e);
        BufferedImage i;
        try {
            i = new BufferedImage(1, 1, 12);
        }
        catch (Exception ex) {
            i = new BufferedImage(8, 8, 2);
        }
        k = i;
        for (int j = 0; j < df.k.getHeight(); ++j) {
            for (int l = 0; l < df.k.getWidth(); ++l) {
                df.k.setRGB(l, j, Color.black.getRGB());
            }
        }
    }
}
