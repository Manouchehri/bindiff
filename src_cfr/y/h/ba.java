/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.MouseEvent;
import y.h.bw;
import y.h.gU;
import y.h.gX;

class bA
extends gX {
    private final bw a;

    bA(bw bw2, gU gU2) {
        super(gU2);
        this.a = bw2;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.a.d(true);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }
}

