package dev.archivolt.schema

import kotlin.test.Test
import kotlin.test.assertEquals

class SmokeTest {
    @Test
    fun `runs on the configured JDK toolchain`() {
        val expected = System.getProperty("archivolt.jdk").toInt()
        assertEquals(expected, Runtime.version().feature())
    }
}
