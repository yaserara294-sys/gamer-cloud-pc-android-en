
package com.gamercloud.pc.settings

data class AppSettings(
    val language: String = "es",
    val resolution: String = "1920x1080",
    val fps: Int = 60,
    val graphicsQuality: String = "HIGH",
    val soundEnabled: Boolean = true,
    val touchControlsEnabled: Boolean = true,
    val bluetoothControllerEnabled: Boolean = true,
    val autoConnect: Boolean = false
)

class SettingsManager {

    private var settings = AppSettings()

    fun getSettings(): AppSettings {
        return settings
    }

    fun updateSettings(newSettings: AppSettings): Boolean {
        if (newSettings.language !in listOf("es", "en")) {
            return false
        }

        if (newSettings.resolution !in listOf(
                "1280x720",
                "1920x1080",
                "2560x1440",
                "3840x2160"
            )) {
            return false
        }

        if (newSettings.fps !in listOf(30, 60, 90, 120)) {
            return false
        }

        if (newSettings.graphicsQuality !in listOf(
                "LOW", "MEDIUM", "HIGH", "ULTRA"
            )) {
            return false
        }

        settings = newSettings
        return true
    }

    fun resetSettings() {
        settings = AppSettings()
    }
}
