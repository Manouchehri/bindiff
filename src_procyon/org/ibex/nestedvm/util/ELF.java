package org.ibex.nestedvm.util;

import java.io.*;

public class ELF
{
    private static final int ELF_MAGIC = 2135247942;
    public static final int ELFCLASSNONE = 0;
    public static final int ELFCLASS32 = 1;
    public static final int ELFCLASS64 = 2;
    public static final int ELFDATANONE = 0;
    public static final int ELFDATA2LSB = 1;
    public static final int ELFDATA2MSB = 2;
    public static final int SHT_SYMTAB = 2;
    public static final int SHT_STRTAB = 3;
    public static final int SHT_NOBITS = 8;
    public static final int SHF_WRITE = 1;
    public static final int SHF_ALLOC = 2;
    public static final int SHF_EXECINSTR = 4;
    public static final int PF_X = 1;
    public static final int PF_W = 2;
    public static final int PF_R = 4;
    public static final int PT_LOAD = 1;
    public static final short ET_EXEC = 2;
    public static final short EM_MIPS = 8;
    private Seekable data;
    public ELF$ELFIdent ident;
    public ELF$ELFHeader header;
    public ELF$PHeader[] pheaders;
    public ELF$SHeader[] sheaders;
    private byte[] stringTable;
    private boolean sectionReaderActive;
    private ELF$Symtab _symtab;
    
    private void readFully(final byte[] array) {
        int i = array.length;
        int n = 0;
        while (i > 0) {
            final int read = this.data.read(array, n, i);
            if (read == -1) {
                throw new IOException("EOF");
            }
            n += read;
            i -= read;
        }
    }
    
    private int readIntBE() {
        final byte[] array = new byte[4];
        this.readFully(array);
        return (array[0] & 0xFF) << 24 | (array[1] & 0xFF) << 16 | (array[2] & 0xFF) << 8 | (array[3] & 0xFF) << 0;
    }
    
    private int readInt() {
        int intBE = this.readIntBE();
        if (this.ident != null && this.ident.data == 1) {
            intBE = ((intBE << 24 & 0xFF000000) | (intBE << 8 & 0xFF0000) | (intBE >>> 8 & 0xFF00) | (intBE >> 24 & 0xFF));
        }
        return intBE;
    }
    
    private short readShortBE() {
        final byte[] array = new byte[2];
        this.readFully(array);
        return (short)((array[0] & 0xFF) << 8 | (array[1] & 0xFF) << 0);
    }
    
    private short readShort() {
        short shortBE = this.readShortBE();
        if (this.ident != null && this.ident.data == 1) {
            shortBE = (short)(((shortBE << 8 & 0xFF00) | (shortBE >> 8 & 0xFF)) & 0xFFFF);
        }
        return shortBE;
    }
    
    private byte readByte() {
        final byte[] array = { 0 };
        this.readFully(array);
        return array[0];
    }
    
    public ELF(final String s) {
        this(new Seekable$File(s, false));
    }
    
    public ELF(final Seekable data) {
        this.data = data;
        this.ident = new ELF$ELFIdent(this);
        this.header = new ELF$ELFHeader(this);
        this.pheaders = new ELF$PHeader[this.header.phnum];
        for (short n = 0; n < this.header.phnum; ++n) {
            data.seek(this.header.phoff + n * this.header.phentsize);
            this.pheaders[n] = new ELF$PHeader(this);
        }
        this.sheaders = new ELF$SHeader[this.header.shnum];
        for (short n2 = 0; n2 < this.header.shnum; ++n2) {
            data.seek(this.header.shoff + n2 * this.header.shentsize);
            this.sheaders[n2] = new ELF$SHeader(this);
        }
        if (this.header.shstrndx < 0 || this.header.shstrndx >= this.header.shnum) {
            throw new ELF$ELFException(this, "Bad shstrndx");
        }
        data.seek(this.sheaders[this.header.shstrndx].offset);
        this.readFully(this.stringTable = new byte[this.sheaders[this.header.shstrndx].size]);
        for (short n3 = 0; n3 < this.header.shnum; ++n3) {
            final ELF$SHeader elf$SHeader = this.sheaders[n3];
            elf$SHeader.name = this.getString(elf$SHeader.nameidx);
        }
    }
    
    private String getString(final int n) {
        return this.getString(n, this.stringTable);
    }
    
    private String getString(int n, final byte[] array) {
        final StringBuffer sb = new StringBuffer();
        if (n < 0 || n >= array.length) {
            return "<invalid strtab entry>";
        }
        while (n >= 0 && n < array.length && array[n] != 0) {
            sb.append((char)array[n++]);
        }
        return sb.toString();
    }
    
    public ELF$SHeader sectionWithName(final String s) {
        for (int i = 0; i < this.sheaders.length; ++i) {
            if (this.sheaders[i].name.equals(s)) {
                return this.sheaders[i];
            }
        }
        return null;
    }
    
    public ELF$Symtab getSymtab() {
        if (this._symtab != null) {
            return this._symtab;
        }
        if (this.sectionReaderActive) {
            throw new ELF$ELFException(this, "Can't read the symtab while a section reader is active");
        }
        final ELF$SHeader sectionWithName = this.sectionWithName(".symtab");
        if (sectionWithName == null || sectionWithName.type != 2) {
            return null;
        }
        final ELF$SHeader sectionWithName2 = this.sectionWithName(".strtab");
        if (sectionWithName2 == null || sectionWithName2.type != 3) {
            return null;
        }
        final byte[] array = new byte[sectionWithName2.size];
        final DataInputStream dataInputStream = new DataInputStream(sectionWithName2.getInputStream());
        dataInputStream.readFully(array);
        dataInputStream.close();
        return this._symtab = new ELF$Symtab(this, sectionWithName.offset, sectionWithName.size, array);
    }
    
    private static String toHex(final int n) {
        return "0x" + Long.toString(n & 0xFFFFFFFFL, 16);
    }
    
    static int access$000(final ELF elf) {
        return elf.readIntBE();
    }
    
    static byte access$100(final ELF elf) {
        return elf.readByte();
    }
    
    static short access$200(final ELF elf) {
        return elf.readShort();
    }
    
    static int access$300(final ELF elf) {
        return elf.readInt();
    }
    
    static String access$400(final int n) {
        return toHex(n);
    }
    
    static boolean access$500(final ELF elf) {
        return elf.sectionReaderActive;
    }
    
    static boolean access$502(final ELF elf, final boolean sectionReaderActive) {
        return elf.sectionReaderActive = sectionReaderActive;
    }
    
    static Seekable access$600(final ELF elf) {
        return elf.data;
    }
    
    static String access$700(final ELF elf, final int n, final byte[] array) {
        return elf.getString(n, array);
    }
}
