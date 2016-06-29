/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.net.Socket;
import org.ibex.nestedvm.util.Platform$Jdk12;

class Platform$Jdk13
extends Platform$Jdk12 {
    Platform$Jdk13() {
    }

    @Override
    void _socketHalfClose(Socket socket, boolean bl2) {
        if (bl2) {
            socket.shutdownOutput();
            return;
        }
        socket.shutdownInput();
    }

    @Override
    void _socketSetKeepAlive(Socket socket, boolean bl2) {
        socket.setKeepAlive(bl2);
    }
}

