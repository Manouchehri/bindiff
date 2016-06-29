/*
 * Decompiled with CFR 0_115.
 */
package com.keypoint;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class PngEncoder {
    public static final boolean ENCODE_ALPHA = true;
    public static final boolean NO_ALPHA = false;
    public static final int FILTER_NONE = 0;
    public static final int FILTER_SUB = 1;
    public static final int FILTER_UP = 2;
    public static final int FILTER_LAST = 2;
    protected static final byte[] IHDR = new byte[]{73, 72, 68, 82};
    protected static final byte[] IDAT = new byte[]{73, 68, 65, 84};
    protected static final byte[] IEND = new byte[]{73, 69, 78, 68};
    protected static final byte[] PHYS = new byte[]{112, 72, 89, 115};
    protected byte[] pngBytes;
    protected byte[] priorRow;
    protected byte[] leftBytes;
    protected Image image;
    protected int width;
    protected int height;
    protected int bytePos;
    protected int maxPos;
    protected CRC32 crc = new CRC32();
    protected long crcValue;
    protected boolean encodeAlpha;
    protected int filter;
    protected int bytesPerPixel;
    private int xDpi = 0;
    private int yDpi = 0;
    private static float INCH_IN_METER_UNIT = 0.0254f;
    protected int compressionLevel;

    public PngEncoder() {
        this(null, false, 0, 0);
    }

    public PngEncoder(Image image) {
        this(image, false, 0, 0);
    }

    public PngEncoder(Image image, boolean bl2) {
        this(image, bl2, 0, 0);
    }

    public PngEncoder(Image image, boolean bl2, int n2) {
        this(image, bl2, n2, 0);
    }

    public PngEncoder(Image image, boolean bl2, int n2, int n3) {
        this.image = image;
        this.encodeAlpha = bl2;
        this.setFilter(n2);
        if (n3 < 0) return;
        if (n3 > 9) return;
        this.compressionLevel = n3;
    }

    public void setImage(Image image) {
        this.image = image;
        this.pngBytes = null;
    }

    public Image getImage() {
        return this.image;
    }

    public byte[] pngEncode(boolean bl2) {
        byte[] arrby = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        if (this.image == null) {
            return null;
        }
        this.width = this.image.getWidth(null);
        this.height = this.image.getHeight(null);
        this.pngBytes = new byte[(this.width + 1) * this.height * 3 + 200];
        this.maxPos = 0;
        this.bytePos = this.writeBytes(arrby, 0);
        this.writeHeader();
        this.writeResolution();
        if (this.writeImageData()) {
            this.writeEnd();
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.maxPos);
            return this.pngBytes;
        }
        this.pngBytes = null;
        return this.pngBytes;
    }

    public byte[] pngEncode() {
        return this.pngEncode(this.encodeAlpha);
    }

    public void setEncodeAlpha(boolean bl2) {
        this.encodeAlpha = bl2;
    }

    public boolean getEncodeAlpha() {
        return this.encodeAlpha;
    }

    public void setFilter(int n2) {
        this.filter = 0;
        if (n2 > 2) return;
        this.filter = n2;
    }

    public int getFilter() {
        return this.filter;
    }

    public void setCompressionLevel(int n2) {
        if (n2 < 0) return;
        if (n2 > 9) return;
        this.compressionLevel = n2;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    protected byte[] resizeByteArray(byte[] arrby, int n2) {
        byte[] arrby2 = new byte[n2];
        int n3 = arrby.length;
        System.arraycopy(arrby, 0, arrby2, 0, Math.min(n3, n2));
        return arrby2;
    }

    protected int writeBytes(byte[] arrby, int n2) {
        this.maxPos = Math.max(this.maxPos, n2 + arrby.length);
        if (arrby.length + n2 > this.pngBytes.length) {
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.pngBytes.length + Math.max(1000, arrby.length));
        }
        System.arraycopy(arrby, 0, this.pngBytes, n2, arrby.length);
        return n2 + arrby.length;
    }

    protected int writeBytes(byte[] arrby, int n2, int n3) {
        this.maxPos = Math.max(this.maxPos, n3 + n2);
        if (n2 + n3 > this.pngBytes.length) {
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.pngBytes.length + Math.max(1000, n2));
        }
        System.arraycopy(arrby, 0, this.pngBytes, n3, n2);
        return n3 + n2;
    }

    protected int writeInt2(int n2, int n3) {
        byte[] arrby = new byte[]{(byte)(n2 >> 8 & 255), (byte)(n2 & 255)};
        return this.writeBytes(arrby, n3);
    }

    protected int writeInt4(int n2, int n3) {
        byte[] arrby = new byte[]{(byte)(n2 >> 24 & 255), (byte)(n2 >> 16 & 255), (byte)(n2 >> 8 & 255), (byte)(n2 & 255)};
        return this.writeBytes(arrby, n3);
    }

    protected int writeByte(int n2, int n3) {
        byte[] arrby = new byte[]{(byte)n2};
        return this.writeBytes(arrby, n3);
    }

    protected void writeHeader() {
        int n2 = this.bytePos = this.writeInt4(13, this.bytePos);
        this.bytePos = this.writeBytes(IHDR, this.bytePos);
        this.width = this.image.getWidth(null);
        this.height = this.image.getHeight(null);
        this.bytePos = this.writeInt4(this.width, this.bytePos);
        this.bytePos = this.writeInt4(this.height, this.bytePos);
        this.bytePos = this.writeByte(8, this.bytePos);
        this.bytePos = this.writeByte(this.encodeAlpha ? 6 : 2, this.bytePos);
        this.bytePos = this.writeByte(0, this.bytePos);
        this.bytePos = this.writeByte(0, this.bytePos);
        this.bytePos = this.writeByte(0, this.bytePos);
        this.crc.reset();
        this.crc.update(this.pngBytes, n2, this.bytePos - n2);
        this.crcValue = this.crc.getValue();
        this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
    }

    protected void filterSub(byte[] arrby, int n2, int n3) {
        int n4 = this.bytesPerPixel;
        int n5 = n2 + n4;
        int n6 = n3 * this.bytesPerPixel;
        int n7 = n4;
        int n8 = 0;
        int n9 = n5;
        while (n9 < n2 + n6) {
            this.leftBytes[n7] = arrby[n9];
            arrby[n9] = (byte)((arrby[n9] - this.leftBytes[n8]) % 256);
            n7 = (n7 + 1) % 15;
            n8 = (n8 + 1) % 15;
            ++n9;
        }
    }

    protected void filterUp(byte[] arrby, int n2, int n3) {
        int n4 = n3 * this.bytesPerPixel;
        int n5 = 0;
        while (n5 < n4) {
            byte by2 = arrby[n2 + n5];
            arrby[n2 + n5] = (byte)((arrby[n2 + n5] - this.priorRow[n5]) % 256);
            this.priorRow[n5] = by2;
            ++n5;
        }
    }

    protected boolean writeImageData() {
        int n2 = this.height;
        int n3 = 0;
        this.bytesPerPixel = this.encodeAlpha ? 4 : 3;
        Deflater deflater = new Deflater(this.compressionLevel);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream((OutputStream)byteArrayOutputStream, deflater);
        try {
            do {
                if (n2 <= 0) {
                    deflaterOutputStream.close();
                    byte[] arrby = byteArrayOutputStream.toByteArray();
                    int n4 = arrby.length;
                    this.crc.reset();
                    this.bytePos = this.writeInt4(n4, this.bytePos);
                    this.bytePos = this.writeBytes(IDAT, this.bytePos);
                    this.crc.update(IDAT);
                    this.bytePos = this.writeBytes(arrby, n4, this.bytePos);
                    this.crc.update(arrby, 0, n4);
                    this.crcValue = this.crc.getValue();
                    this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
                    deflater.finish();
                    return true;
                }
                int n5 = Math.min(32767 / (this.width * (this.bytesPerPixel + 1)), n2);
                n5 = Math.max(n5, 1);
                int[] arrn = new int[this.width * n5];
                PixelGrabber pixelGrabber = new PixelGrabber(this.image, 0, n3, this.width, n5, arrn, 0, this.width);
                try {
                    pixelGrabber.grabPixels();
                }
                catch (Exception var14_14) {
                    System.err.println("interrupted waiting for pixels!");
                    return false;
                }
                if ((pixelGrabber.getStatus() & 128) != 0) {
                    System.err.println("image fetch aborted or errored");
                    return false;
                }
                byte[] arrby = new byte[this.width * n5 * this.bytesPerPixel + n5];
                if (this.filter == 1) {
                    this.leftBytes = new byte[16];
                }
                if (this.filter == 2) {
                    this.priorRow = new byte[this.width * this.bytesPerPixel];
                }
                int n6 = 0;
                int n7 = 1;
                for (int i2 = 0; i2 < this.width * n5; ++i2) {
                    if (i2 % this.width == 0) {
                        arrby[n6++] = (byte)this.filter;
                        n7 = n6;
                    }
                    arrby[n6++] = (byte)(arrn[i2] >> 16 & 255);
                    arrby[n6++] = (byte)(arrn[i2] >> 8 & 255);
                    arrby[n6++] = (byte)(arrn[i2] & 255);
                    if (this.encodeAlpha) {
                        arrby[n6++] = (byte)(arrn[i2] >> 24 & 255);
                    }
                    if (i2 % this.width != this.width - 1 || this.filter == 0) continue;
                    if (this.filter == 1) {
                        this.filterSub(arrby, n7, this.width);
                    }
                    if (this.filter != 2) continue;
                    this.filterUp(arrby, n7, this.width);
                }
                deflaterOutputStream.write(arrby, 0, n6);
                n3 += n5;
                n2 -= n5;
            } while (true);
        }
        catch (IOException var13_12) {
            System.err.println(var13_12.toString());
            return false;
        }
    }

    protected void writeEnd() {
        this.bytePos = this.writeInt4(0, this.bytePos);
        this.bytePos = this.writeBytes(IEND, this.bytePos);
        this.crc.reset();
        this.crc.update(IEND);
        this.crcValue = this.crc.getValue();
        this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
    }

    public void setXDpi(int n2) {
        this.xDpi = Math.round((float)n2 / INCH_IN_METER_UNIT);
    }

    public int getXDpi() {
        return Math.round((float)this.xDpi * INCH_IN_METER_UNIT);
    }

    public void setYDpi(int n2) {
        this.yDpi = Math.round((float)n2 / INCH_IN_METER_UNIT);
    }

    public int getYDpi() {
        return Math.round((float)this.yDpi * INCH_IN_METER_UNIT);
    }

    public void setDpi(int n2, int n3) {
        this.xDpi = Math.round((float)n2 / INCH_IN_METER_UNIT);
        this.yDpi = Math.round((float)n3 / INCH_IN_METER_UNIT);
    }

    protected void writeResolution() {
        if (this.xDpi <= 0) return;
        if (this.yDpi <= 0) return;
        int n2 = this.bytePos = this.writeInt4(9, this.bytePos);
        this.bytePos = this.writeBytes(PHYS, this.bytePos);
        this.bytePos = this.writeInt4(this.xDpi, this.bytePos);
        this.bytePos = this.writeInt4(this.yDpi, this.bytePos);
        this.bytePos = this.writeByte(1, this.bytePos);
        this.crc.reset();
        this.crc.update(this.pngBytes, n2, this.bytePos - n2);
        this.crcValue = this.crc.getValue();
        this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
    }
}

