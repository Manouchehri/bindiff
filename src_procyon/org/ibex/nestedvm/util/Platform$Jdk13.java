package org.ibex.nestedvm.util;

import java.net.*;

class Platform$Jdk13 extends Platform$Jdk12
{
    void _socketHalfClose(final Socket socket, final boolean b) {
        if (b) {
            socket.shutdownOutput();
        }
        else {
            socket.shutdownInput();
        }
    }
    
    void _socketSetKeepAlive(final Socket socket, final boolean keepAlive) {
        socket.setKeepAlive(keepAlive);
    }
}
