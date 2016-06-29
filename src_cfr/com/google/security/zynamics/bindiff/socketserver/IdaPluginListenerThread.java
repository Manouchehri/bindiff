/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.socketserver;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.socketserver.SocketServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class IdaPluginListenerThread
extends Thread {
    private static final String NO_ACKNOWLEDGE = "nak";
    private static final String ACKNOWLEDGE = "ack";
    private final SocketServer server;

    public IdaPluginListenerThread(SocketServer socketServer) {
        this.server = (SocketServer)Preconditions.checkNotNull(socketServer);
    }

    private byte[] receiveChars(InputStream inputStream) {
        int n2 = 4;
        byte[] arrby = new byte[4];
        if (inputStream.read(arrby, 0, 4) != 4) {
            throw new IOException("Premature end of stream.");
        }
        int n3 = ByteBuffer.wrap(arrby).order(ByteOrder.LITTLE_ENDIAN).getInt();
        byte[] arrby2 = new byte[n3];
        if (inputStream.read(arrby2, 0, n3) == n3) return arrby2;
        throw new IOException("Unexpected end of stream.");
    }

    private void send(OutputStream outputStream, String string) {
        PrintStream printStream = new PrintStream(outputStream);
        Throwable throwable = null;
        try {
            printStream.print(string);
            if (!printStream.checkError()) return;
            throw new IOException("Writing to socket server's output stream failed.");
        }
        catch (Throwable var5_6) {
            throwable = var5_6;
            throw var5_6;
        }
        finally {
            if (printStream != null) {
                if (throwable != null) {
                    try {
                        printStream.close();
                    }
                    catch (Throwable var5_5) {
                        throwable.addSuppressed(var5_5);
                    }
                } else {
                    printStream.close();
                }
            }
        }
    }

    @Override
    public void run() {
        while (!IdaPluginListenerThread.interrupted()) {
            try {
                Socket socket = this.server.getSocket().accept();
                Throwable throwable = null;
                try {
                    InputStream inputStream = socket.getInputStream();
                    Throwable throwable2 = null;
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        Throwable throwable3 = null;
                        try {
                            if (!socket.isConnected()) {
                                throw new IOException("Could not connect to BinDiff plugin.");
                            }
                            try {
                                this.server.handleReceivedByteBuffer(this.receiveChars(inputStream));
                            }
                            catch (IOException var7_13) {
                                this.send(outputStream, "nak");
                            }
                            this.send(outputStream, "ack");
                            continue;
                        }
                        catch (Throwable var7_15) {
                            throwable3 = var7_15;
                            throw var7_15;
                        }
                        finally {
                            if (outputStream == null) continue;
                            if (throwable3 != null) {
                                try {
                                    outputStream.close();
                                }
                                catch (Throwable var7_14) {
                                    throwable3.addSuppressed(var7_14);
                                }
                                continue;
                            }
                            outputStream.close();
                            continue;
                        }
                    }
                    catch (Throwable var5_10) {
                        throwable2 = var5_10;
                        throw var5_10;
                    }
                    finally {
                        if (inputStream == null) continue;
                        if (throwable2 != null) {
                            try {
                                inputStream.close();
                            }
                            catch (Throwable var5_9) {
                                throwable2.addSuppressed(var5_9);
                            }
                            continue;
                        }
                        inputStream.close();
                        continue;
                    }
                }
                catch (Throwable var3_6) {
                    throwable = var3_6;
                    throw var3_6;
                }
                finally {
                    if (socket == null) continue;
                    if (throwable != null) {
                        try {
                            socket.close();
                        }
                        catch (Throwable var3_5) {
                            throwable.addSuppressed(var3_5);
                        }
                        continue;
                    }
                    socket.close();
                }
            }
            catch (IOException | SecurityException var1_2) {
                this.server.handleError(var1_2, var1_2.getMessage());
                continue;
            }
        }
    }
}

