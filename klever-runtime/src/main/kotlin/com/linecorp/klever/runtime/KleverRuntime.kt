package com.linecorp.klever.runtime.dsl

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import kotlin.system.measureTimeMillis

class KleverRuntime(
        private val scriptManager: ScriptEngineManager = ScriptEngineManager()
) {
    private val logger: Logger = LoggerFactory.getLogger("KleverRuntime")

    init {
        val timestamp = measureTimeMillis { getEngine().eval("val x = 1") }
        logger.info("The init time of kotlin script engine: $timestamp")
    }

    fun getEngine() = scriptManager.getEngineByExtension("kts")!!
}
