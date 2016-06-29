/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import org.jfree.util.Log;

public class WaitingImageObserver
implements ImageObserver,
Serializable,
Cloneable {
    static final long serialVersionUID = -807204410581383550L;
    private boolean lock;
    private Image image;
    private boolean error;

    public WaitingImageObserver(Image image) {
        if (image == null) {
            throw new NullPointerException();
        }
        this.image = image;
        this.lock = true;
    }

    @Override
    public synchronized boolean imageUpdate(Image image, int n2, int n3, int n4, int n5, int n6) {
        if ((n2 & 32) == 32) {
            this.lock = false;
            this.error = false;
            this.notifyAll();
            return false;
        }
        if ((n2 & 128) != 128) {
            if ((n2 & 64) != 64) return true;
        }
        this.lock = false;
        this.error = true;
        this.notifyAll();
        return false;
    }

    public synchronized void waitImageLoaded() {
        if (!this.lock) {
            return;
        }
        BufferedImage bufferedImage = new BufferedImage(1, 1, 1);
        Graphics graphics = bufferedImage.getGraphics();
        while (this.lock) {
            if (graphics.drawImage(this.image, 0, 0, bufferedImage.getWidth(this), bufferedImage.getHeight(this), this)) {
                return;
            }
            try {
                this.wait(500);
            }
            catch (InterruptedException var3_3) {
                Log.info("WaitingImageObserver.waitImageLoaded(): InterruptedException thrown", var3_3);
                continue;
            }
        }
    }

    public Object clone() {
        return (WaitingImageObserver)super.clone();
    }

    public boolean isLoadingComplete() {
        if (this.lock) return false;
        return true;
    }

    public boolean isError() {
        return this.error;
    }
}

