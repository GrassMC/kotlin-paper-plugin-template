package io.github.grassmc.template

import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class KotlinPaperTemplatePlugin : JavaPlugin() {
    override fun onEnable() {
        slF4JLogger.info("Hello, Paper!")
    }

    override fun onDisable() {
        slF4JLogger.info("Goodbye, Paper!")
    }
}
