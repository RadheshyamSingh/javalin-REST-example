package com.radhe.javalinrestapi.utils

import java.io.BufferedReader
import java.io.InputStreamReader

object ResourceUtil {

    fun getPort(key: String): Int {
        val map = readConfigFile()
        return map[key]?.toInt() ?: return -1
    }

    private fun readConfigFile(): MutableMap<String, String> {
        val serverInfo = javaClass.classLoader.getResource("server.config")
        val bufferedReader = BufferedReader(InputStreamReader(serverInfo.openStream()));

        var inputLine = bufferedReader.readLine()
        val map = mutableMapOf<String, String>()

        while (inputLine != null) {
            val texts = inputLine.split(":")
            map.put(texts[0], texts[1])
            inputLine = bufferedReader.readLine()
        }

        bufferedReader.close()
        return map
    }
}