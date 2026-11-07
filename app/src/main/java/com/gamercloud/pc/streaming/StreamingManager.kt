
package com.gamercloud.pc.streaming

enum class StreamingQuality {
    LOW,
    MEDIUM,
    HIGH,
    ULTRA
}

data class StreamingConfig(
    val width: Int = 1920,
    val height: Int = 1080,
    val fps: Int = 60,
    val bitrateMbps: Int = 20,
    val quality: StreamingQuality = StreamingQuality.HIGH
)

enum class StreamingStatus {
    DISCONNECTED,
    CONNECTING,
    CONNECTED,
    STREAMING,
    ERROR
}

class StreamingManager {

    private var config = StreamingConfig()
    private var status = StreamingStatus.DISCONNECTED

    fun getConfig(): StreamingConfig {
        return config
    }

    fun getStatus(): StreamingStatus {
        return status
    }

    fun updateConfig(newConfig: StreamingConfig): Boolean {
        if (newConfig.width !in 640..3840) return false
        if (newConfig.height !in 480..2160) return false
        if (newConfig.fps !in listOf(30, 60, 90, 120)) return false
        if (newConfig.bitrateMbps !in 5..100) return false

        config = newConfig
        return true
    }

    fun setStatus(newStatus: StreamingStatus) {
        status = newStatus
    }

    fun disconnect() {
        status = StreamingStatus.DISCONNECTED
    }
}
