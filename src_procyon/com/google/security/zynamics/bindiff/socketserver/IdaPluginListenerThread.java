package com.google.security.zynamics.bindiff.socketserver;

import com.google.common.base.*;
import java.nio.*;
import java.io.*;
import java.net.*;

public class IdaPluginListenerThread extends Thread
{
    private static final String NO_ACKNOWLEDGE = "nak";
    private static final String ACKNOWLEDGE = "ack";
    private final SocketServer server;
    
    public IdaPluginListenerThread(final SocketServer socketServer) {
        this.server = (SocketServer)Preconditions.checkNotNull(socketServer);
    }
    
    private byte[] receiveChars(final InputStream inputStream) {
        final byte[] array = new byte[4];
        if (inputStream.read(array, 0, 4) != 4) {
            throw new IOException("Premature end of stream.");
        }
        final int int1 = ByteBuffer.wrap(array).order(ByteOrder.LITTLE_ENDIAN).getInt();
        final byte[] array2 = new byte[int1];
        if (inputStream.read(array2, 0, int1) != int1) {
            throw new IOException("Unexpected end of stream.");
        }
        return array2;
    }
    
    private void send(final OutputStream outputStream, final String s) {
        try (final PrintStream printStream = new PrintStream(outputStream)) {
            printStream.print(s);
            if (printStream.checkError()) {
                throw new IOException("Writing to socket server's output stream failed.");
            }
        }
    }
    
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try (final Socket accept = this.server.getSocket().accept();
                 final InputStream inputStream = accept.getInputStream();
                 final OutputStream outputStream = accept.getOutputStream()) {
                if (!accept.isConnected()) {
                    throw new IOException("Could not connect to BinDiff plugin.");
                }
                try {
                    this.server.handleReceivedByteBuffer(this.receiveChars(inputStream));
                }
                catch (IOException ex3) {
                    this.send(outputStream, "nak");
                }
                this.send(outputStream, "ack");
            }
            catch (IOException | SecurityException ex4) {
                final SecurityException ex2;
                final SecurityException ex = ex2;
                this.server.handleError(ex, ex.getMessage());
            }
        }
    }
}
