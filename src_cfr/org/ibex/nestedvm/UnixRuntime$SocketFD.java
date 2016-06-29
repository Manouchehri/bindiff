/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SocketFStat;
import org.ibex.nestedvm.util.Platform;

class UnixRuntime$SocketFD
extends Runtime$FD {
    public static final int TYPE_STREAM = 0;
    public static final int TYPE_DGRAM = 1;
    public static final int LISTEN = 2;
    int flags;
    int options;
    Socket s;
    ServerSocket ss;
    DatagramSocket ds;
    InetAddress bindAddr;
    int bindPort = -1;
    InetAddress connectAddr;
    int connectPort = -1;
    DatagramPacket dp;
    InputStream is;
    OutputStream os;
    private static final byte[] EMPTY = new byte[0];

    public int type() {
        return this.flags & 1;
    }

    public boolean listen() {
        if ((this.flags & 2) == 0) return false;
        return true;
    }

    public UnixRuntime$SocketFD(int n2) {
        this.flags = n2;
        if (n2 != 1) return;
        this.dp = new DatagramPacket(EMPTY, 0);
    }

    public void setOptions() {
        try {
            if (this.s == null) return;
            if (this.type() != 0) return;
            if (this.listen()) return;
            Platform.socketSetKeepAlive(this.s, (this.options & 8) != 0);
            return;
        }
        catch (SocketException var1_1) {
            var1_1.printStackTrace();
        }
    }

    @Override
    public void _close() {
        try {
            if (this.s != null) {
                this.s.close();
            }
            if (this.ss != null) {
                this.ss.close();
            }
            if (this.ds == null) return;
            this.ds.close();
            return;
        }
        catch (IOException var1_1) {
            // empty catch block
        }
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (this.type() == 1) {
            return this.recvfrom(arrby, n2, n3, null, null);
        }
        if (this.is == null) {
            throw new Runtime$ErrnoException(32);
        }
        try {
            int n4 = this.is.read(arrby, n2, n3);
            if (n4 < 0) {
                return 0;
            }
            int n5 = n4;
            return n5;
        }
        catch (IOException var4_5) {
            throw new Runtime$ErrnoException(5);
        }
    }

    public int recvfrom(byte[] arrby, int n2, int n3, InetAddress[] arrinetAddress, int[] arrn) {
        if (this.type() == 0) {
            return this.read(arrby, n2, n3);
        }
        if (n2 != 0) {
            throw new IllegalArgumentException("off must be 0");
        }
        this.dp.setData(arrby);
        this.dp.setLength(n3);
        try {
            if (this.ds == null) {
                this.ds = new DatagramSocket();
            }
            this.ds.receive(this.dp);
        }
        catch (IOException var6_6) {
            var6_6.printStackTrace();
            throw new Runtime$ErrnoException(5);
        }
        if (arrinetAddress == null) return this.dp.getLength();
        arrinetAddress[0] = this.dp.getAddress();
        arrn[0] = this.dp.getPort();
        return this.dp.getLength();
    }

    @Override
    public int write(byte[] arrby, int n2, int n3) {
        if (this.type() == 1) {
            return this.sendto(arrby, n2, n3, null, -1);
        }
        if (this.os == null) {
            throw new Runtime$ErrnoException(32);
        }
        try {
            this.os.write(arrby, n2, n3);
            return n3;
        }
        catch (IOException var4_4) {
            throw new Runtime$ErrnoException(5);
        }
    }

    public int sendto(byte[] arrby, int n2, int n3, InetAddress inetAddress, int n4) {
        if (n2 != 0) {
            throw new IllegalArgumentException("off must be 0");
        }
        if (this.type() == 0) {
            return this.write(arrby, n2, n3);
        }
        if (inetAddress == null) {
            inetAddress = this.connectAddr;
            n4 = this.connectPort;
            if (inetAddress == null) {
                throw new Runtime$ErrnoException(128);
            }
        }
        this.dp.setAddress(inetAddress);
        this.dp.setPort(n4);
        this.dp.setData(arrby);
        this.dp.setLength(n3);
        try {
            if (this.ds == null) {
                this.ds = new DatagramSocket();
            }
            this.ds.send(this.dp);
            return this.dp.getLength();
        }
        catch (IOException var6_6) {
            var6_6.printStackTrace();
            if (!"Network is unreachable".equals(var6_6.getMessage())) throw new Runtime$ErrnoException(5);
            throw new Runtime$ErrnoException(118);
        }
    }

    @Override
    public int flags() {
        return 2;
    }

    @Override
    public Runtime$FStat _fstat() {
        return new Runtime$SocketFStat();
    }
}

