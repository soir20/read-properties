#!/usr/bin/env kotlin

import java.io.FileInputStream
import java.util.*

if (args.size != 2) {
    val argsStr = args.contentToString()
    throw IllegalArgumentException("Expected 2 arguments, provided: $argsStr")
}

val fileName = args[0]
val property = args[1]
if (!fileName.endsWith(".properties")) {
    throw IllegalArgumentException("File $fileName is not a properties file")
}

FileInputStream(fileName).use { stream ->
    val properties = Properties()
    properties.load(stream)

    val value = properties.getProperty(property)
    println("value=$value")
}