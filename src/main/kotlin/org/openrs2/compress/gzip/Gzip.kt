package org.openrs2.compress.gzip

import org.openrs2.util.io.SkipOutputStream
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.SequenceInputStream
import java.util.zip.Deflater
import java.util.zip.GZIPInputStream

public object Gzip {
    private val HEADER = byteArrayOf(0x1F, 0x8B.toByte())

    public fun createHeaderlessInputStream(input: InputStream): InputStream {
        return GZIPInputStream(SequenceInputStream(ByteArrayInputStream(HEADER), input))
    }

    public fun createHeaderlessOutputStream(
        output: OutputStream,
        level: Int = Deflater.BEST_COMPRESSION
    ): OutputStream {
        return GzipLevelOutputStream(SkipOutputStream(output, HEADER.size.toLong()), level)
    }
}
