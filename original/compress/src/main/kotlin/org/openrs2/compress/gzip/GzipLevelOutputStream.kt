package org.openrs2.compress.gzip

import java.io.OutputStream
import java.util.zip.GZIPOutputStream

public class GzipLevelOutputStream(output: OutputStream, level: Int) : GZIPOutputStream(output) {
    init {
        def.setLevel(level)
    }
}
