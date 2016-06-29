package com.keypoint;

import java.awt.*;
import java.util.zip.*;
import java.awt.image.*;
import java.io.*;

public class PngEncoder
{
    public static final boolean ENCODE_ALPHA = true;
    public static final boolean NO_ALPHA = false;
    public static final int FILTER_NONE = 0;
    public static final int FILTER_SUB = 1;
    public static final int FILTER_UP = 2;
    public static final int FILTER_LAST = 2;
    protected static final byte[] IHDR;
    protected static final byte[] IDAT;
    protected static final byte[] IEND;
    protected static final byte[] PHYS;
    protected byte[] pngBytes;
    protected byte[] priorRow;
    protected byte[] leftBytes;
    protected Image image;
    protected int width;
    protected int height;
    protected int bytePos;
    protected int maxPos;
    protected CRC32 crc;
    protected long crcValue;
    protected boolean encodeAlpha;
    protected int filter;
    protected int bytesPerPixel;
    private int xDpi;
    private int yDpi;
    private static float INCH_IN_METER_UNIT;
    protected int compressionLevel;
    
    public PngEncoder() {
        this(null, false, 0, 0);
    }
    
    public PngEncoder(final Image image) {
        this(image, false, 0, 0);
    }
    
    public PngEncoder(final Image image, final boolean b) {
        this(image, b, 0, 0);
    }
    
    public PngEncoder(final Image image, final boolean b, final int n) {
        this(image, b, n, 0);
    }
    
    public PngEncoder(final Image image, final boolean encodeAlpha, final int filter, final int compressionLevel) {
        this.crc = new CRC32();
        this.xDpi = 0;
        this.yDpi = 0;
        this.image = image;
        this.encodeAlpha = encodeAlpha;
        this.setFilter(filter);
        if (compressionLevel >= 0 && compressionLevel <= 9) {
            this.compressionLevel = compressionLevel;
        }
    }
    
    public void setImage(final Image image) {
        this.image = image;
        this.pngBytes = null;
    }
    
    public Image getImage() {
        return this.image;
    }
    
    public byte[] pngEncode(final boolean b) {
        final byte[] array = { -119, 80, 78, 71, 13, 10, 26, 10 };
        if (this.image == null) {
            return null;
        }
        this.width = this.image.getWidth(null);
        this.height = this.image.getHeight(null);
        this.pngBytes = new byte[(this.width + 1) * this.height * 3 + 200];
        this.maxPos = 0;
        this.bytePos = this.writeBytes(array, 0);
        this.writeHeader();
        this.writeResolution();
        if (this.writeImageData()) {
            this.writeEnd();
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.maxPos);
        }
        else {
            this.pngBytes = null;
        }
        return this.pngBytes;
    }
    
    public byte[] pngEncode() {
        return this.pngEncode(this.encodeAlpha);
    }
    
    public void setEncodeAlpha(final boolean encodeAlpha) {
        this.encodeAlpha = encodeAlpha;
    }
    
    public boolean getEncodeAlpha() {
        return this.encodeAlpha;
    }
    
    public void setFilter(final int filter) {
        this.filter = 0;
        if (filter <= 2) {
            this.filter = filter;
        }
    }
    
    public int getFilter() {
        return this.filter;
    }
    
    public void setCompressionLevel(final int compressionLevel) {
        if (compressionLevel >= 0 && compressionLevel <= 9) {
            this.compressionLevel = compressionLevel;
        }
    }
    
    public int getCompressionLevel() {
        return this.compressionLevel;
    }
    
    protected byte[] resizeByteArray(final byte[] array, final int n) {
        final byte[] array2 = new byte[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    protected int writeBytes(final byte[] array, final int n) {
        this.maxPos = Math.max(this.maxPos, n + array.length);
        if (array.length + n > this.pngBytes.length) {
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.pngBytes.length + Math.max(1000, array.length));
        }
        System.arraycopy(array, 0, this.pngBytes, n, array.length);
        return n + array.length;
    }
    
    protected int writeBytes(final byte[] array, final int n, final int n2) {
        this.maxPos = Math.max(this.maxPos, n2 + n);
        if (n + n2 > this.pngBytes.length) {
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.pngBytes.length + Math.max(1000, n));
        }
        System.arraycopy(array, 0, this.pngBytes, n2, n);
        return n2 + n;
    }
    
    protected int writeInt2(final int n, final int n2) {
        return this.writeBytes(new byte[] { (byte)(n >> 8 & 0xFF), (byte)(n & 0xFF) }, n2);
    }
    
    protected int writeInt4(final int n, final int n2) {
        return this.writeBytes(new byte[] { (byte)(n >> 24 & 0xFF), (byte)(n >> 16 & 0xFF), (byte)(n >> 8 & 0xFF), (byte)(n & 0xFF) }, n2);
    }
    
    protected int writeByte(final int n, final int n2) {
        return this.writeBytes(new byte[] { (byte)n }, n2);
    }
    
    protected void writeHeader() {
        final int writeInt4 = this.writeInt4(13, this.bytePos);
        this.bytePos = writeInt4;
        final int n = writeInt4;
        this.bytePos = this.writeBytes(PngEncoder.IHDR, this.bytePos);
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
        this.crc.update(this.pngBytes, n, this.bytePos - n);
        this.crcValue = this.crc.getValue();
        this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
    }
    
    protected void filterSub(final byte[] array, final int n, final int n2) {
        final int bytesPerPixel = this.bytesPerPixel;
        final int n3 = n + bytesPerPixel;
        final int n4 = n2 * this.bytesPerPixel;
        int n5 = bytesPerPixel;
        int n6 = 0;
        for (int i = n3; i < n + n4; ++i) {
            this.leftBytes[n5] = array[i];
            array[i] = (byte)((array[i] - this.leftBytes[n6]) % 256);
            n5 = (n5 + 1) % 15;
            n6 = (n6 + 1) % 15;
        }
    }
    
    protected void filterUp(final byte[] array, final int n, final int n2) {
        for (int n3 = n2 * this.bytesPerPixel, i = 0; i < n3; ++i) {
            final byte b = array[n + i];
            array[n + i] = (byte)((array[n + i] - this.priorRow[i]) % 256);
            this.priorRow[i] = b;
        }
    }
    
    protected boolean writeImageData() {
        int i = this.height;
        int n = 0;
        this.bytesPerPixel = (this.encodeAlpha ? 4 : 3);
        final Deflater deflater = new Deflater(this.compressionLevel);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        final DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
        try {
            while (i > 0) {
                final int max = Math.max(Math.min(32767 / (this.width * (this.bytesPerPixel + 1)), i), 1);
                final int[] array = new int[this.width * max];
                final PixelGrabber pixelGrabber = new PixelGrabber(this.image, 0, n, this.width, max, array, 0, this.width);
                try {
                    pixelGrabber.grabPixels();
                }
                catch (Exception ex2) {
                    System.err.println("interrupted waiting for pixels!");
                    return false;
                }
                if ((pixelGrabber.getStatus() & 0x80) != 0x0) {
                    System.err.println("image fetch aborted or errored");
                    return false;
                }
                final byte[] array2 = new byte[this.width * max * this.bytesPerPixel + max];
                if (this.filter == 1) {
                    this.leftBytes = new byte[16];
                }
                if (this.filter == 2) {
                    this.priorRow = new byte[this.width * this.bytesPerPixel];
                }
                int n2 = 0;
                int n3 = 1;
                for (int j = 0; j < this.width * max; ++j) {
                    if (j % this.width == 0) {
                        array2[n2++] = (byte)this.filter;
                        n3 = n2;
                    }
                    array2[n2++] = (byte)(array[j] >> 16 & 0xFF);
                    array2[n2++] = (byte)(array[j] >> 8 & 0xFF);
                    array2[n2++] = (byte)(array[j] & 0xFF);
                    if (this.encodeAlpha) {
                        array2[n2++] = (byte)(array[j] >> 24 & 0xFF);
                    }
                    if (j % this.width == this.width - 1 && this.filter != 0) {
                        if (this.filter == 1) {
                            this.filterSub(array2, n3, this.width);
                        }
                        if (this.filter == 2) {
                            this.filterUp(array2, n3, this.width);
                        }
                    }
                }
                deflaterOutputStream.write(array2, 0, n2);
                n += max;
                i -= max;
            }
            deflaterOutputStream.close();
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            final int length = byteArray.length;
            this.crc.reset();
            this.bytePos = this.writeInt4(length, this.bytePos);
            this.bytePos = this.writeBytes(PngEncoder.IDAT, this.bytePos);
            this.crc.update(PngEncoder.IDAT);
            this.bytePos = this.writeBytes(byteArray, length, this.bytePos);
            this.crc.update(byteArray, 0, length);
            this.crcValue = this.crc.getValue();
            this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
            deflater.finish();
            return true;
        }
        catch (IOException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }
    
    protected void writeEnd() {
        this.bytePos = this.writeInt4(0, this.bytePos);
        this.bytePos = this.writeBytes(PngEncoder.IEND, this.bytePos);
        this.crc.reset();
        this.crc.update(PngEncoder.IEND);
        this.crcValue = this.crc.getValue();
        this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
    }
    
    public void setXDpi(final int n) {
        this.xDpi = Math.round(n / PngEncoder.INCH_IN_METER_UNIT);
    }
    
    public int getXDpi() {
        return Math.round(this.xDpi * PngEncoder.INCH_IN_METER_UNIT);
    }
    
    public void setYDpi(final int n) {
        this.yDpi = Math.round(n / PngEncoder.INCH_IN_METER_UNIT);
    }
    
    public int getYDpi() {
        return Math.round(this.yDpi * PngEncoder.INCH_IN_METER_UNIT);
    }
    
    public void setDpi(final int n, final int n2) {
        this.xDpi = Math.round(n / PngEncoder.INCH_IN_METER_UNIT);
        this.yDpi = Math.round(n2 / PngEncoder.INCH_IN_METER_UNIT);
    }
    
    protected void writeResolution() {
        if (this.xDpi > 0 && this.yDpi > 0) {
            final int writeInt4 = this.writeInt4(9, this.bytePos);
            this.bytePos = writeInt4;
            final int n = writeInt4;
            this.bytePos = this.writeBytes(PngEncoder.PHYS, this.bytePos);
            this.bytePos = this.writeInt4(this.xDpi, this.bytePos);
            this.bytePos = this.writeInt4(this.yDpi, this.bytePos);
            this.bytePos = this.writeByte(1, this.bytePos);
            this.crc.reset();
            this.crc.update(this.pngBytes, n, this.bytePos - n);
            this.crcValue = this.crc.getValue();
            this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
        }
    }
    
    static {
        IHDR = new byte[] { 73, 72, 68, 82 };
        IDAT = new byte[] { 73, 68, 65, 84 };
        IEND = new byte[] { 73, 69, 78, 68 };
        PHYS = new byte[] { 112, 72, 89, 115 };
        PngEncoder.INCH_IN_METER_UNIT = 0.0254f;
    }
}
