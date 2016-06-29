package org.jfree.util;

import java.io.*;
import java.awt.image.*;
import java.awt.*;

public class WaitingImageObserver implements ImageObserver, Serializable, Cloneable
{
    static final long serialVersionUID = -807204410581383550L;
    private boolean lock;
    private Image image;
    private boolean error;
    
    public WaitingImageObserver(final Image image) {
        if (image == null) {
            throw new NullPointerException();
        }
        this.image = image;
        this.lock = true;
    }
    
    public synchronized boolean imageUpdate(final Image image, final int n, final int n2, final int n3, final int n4, final int n5) {
        if ((n & 0x20) == 0x20) {
            this.lock = false;
            this.error = false;
            this.notifyAll();
            return false;
        }
        if ((n & 0x80) == 0x80 || (n & 0x40) == 0x40) {
            this.lock = false;
            this.error = true;
            this.notifyAll();
            return false;
        }
        return true;
    }
    
    public synchronized void waitImageLoaded() {
        if (!this.lock) {
            return;
        }
        final BufferedImage bufferedImage = new BufferedImage(1, 1, 1);
        final Graphics graphics = bufferedImage.getGraphics();
        while (this.lock) {
            if (graphics.drawImage(this.image, 0, 0, bufferedImage.getWidth(this), bufferedImage.getHeight(this), this)) {
                return;
            }
            try {
                this.wait(500L);
            }
            catch (InterruptedException ex) {
                Log.info("WaitingImageObserver.waitImageLoaded(): InterruptedException thrown", ex);
            }
        }
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean isLoadingComplete() {
        return !this.lock;
    }
    
    public boolean isError() {
        return this.error;
    }
}
