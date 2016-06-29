/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import y.h.F;
import y.h.ch;
import y.h.fj;

class H
implements KeyListener {
    private final F a;

    H(F f2) {
        this.a = f2;
    }

    private void a(KeyEvent keyEvent) {
        if (!this.a.isActive()) return;
        if ((keyEvent.getModifiers() & this.a.getModifierMask()) != 0 == F.b(this.a)) return;
        if (this.a.lastMoveEvent == null) return;
        if (this.a.lastDragEvent == null) return;
        if (this.a.lastMoveEvent.getWhen() < this.a.lastDragEvent.getWhen()) {
            if (this.a.lastReleaseEvent != null) {
                if (this.a.lastReleaseEvent.getWhen() >= this.a.lastDragEvent.getWhen()) return;
            }
            this.a.mouseDragged(new MouseEvent(this.a.lastDragEvent.getComponent(), this.a.lastDragEvent.getID(), this.a.lastDragEvent.getWhen() + 1, keyEvent.getModifiersEx(), this.a.lastDragEvent.getX(), this.a.lastDragEvent.getY(), 0, false));
            if (!fj.z) return;
        }
        if (this.a.lastReleaseEvent != null) {
            if (this.a.lastReleaseEvent.getWhen() >= this.a.lastMoveEvent.getWhen()) return;
        }
        this.a.mouseMoved(new MouseEvent(this.a.lastMoveEvent.getComponent(), this.a.lastMoveEvent.getID(), this.a.lastMoveEvent.getWhen() + 1, keyEvent.getModifiersEx(), this.a.lastMoveEvent.getX(), this.a.lastMoveEvent.getY(), 0, false));
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.a(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        this.a(keyEvent);
        if (!F.c(this.a) && F.d(this.a) && F.e(this.a) != 0 && keyEvent.getKeyCode() == F.e(this.a)) {
            this.a.n();
        }
        if (F.d(this.a)) return;
        this.a.view.removeKeyListener(this);
        F.a(this.a, null);
    }
}

