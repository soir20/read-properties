#!/usr/bin/env kotlin

import java.io.FileInputStream
import java.util.Arrays
import java.util.Properties

if (args.size != 1) {
    val argsStr = Arrays.toString(args)
    throw IllegalArgumentException("Expected 1 argument, provided: $argsStr")
}

val fileName = args[0]
if (!fileName.endsWith(".properties")) {
    throw IllegalArgumentException("File $fileName is not a properties file")
}

FileInputStream(fileName).use { stream ->
    val properties = Properties()
    properties.load(stream)

    properties.entries.forEach{ (key, value) ->
        println("::set-output name=$key::$value")
    }
}