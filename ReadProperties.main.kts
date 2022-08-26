#!/usr/bin/env kotlin

import java.io.FileInputStream
import java.util.Arrays
import java.util.Properties

if (args.size != 2) {
    val argsStr = Arrays.toString(args)
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
    println("::set-output name=value::$value")
}