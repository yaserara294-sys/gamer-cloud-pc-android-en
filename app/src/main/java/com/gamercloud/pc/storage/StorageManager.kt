
package com.gamercloud.pc.storage

enum class StoragePlan(
    val capacityGb: Long
) {
    FREE(100),
    PREMIUM(200)
}

data class StorageInfo(
    val plan: StoragePlan,
    val usedBytes: Long
) {
    val capacityBytes: Long
        get() = plan.capacityGb * 1024L * 1024L * 1024L

    val availableBytes: Long
        get() = (capacityBytes - usedBytes).coerceAtLeast(0)

    val usagePercentage: Int
        get() = if (capacityBytes == 0L) {
            0
        } else {
            ((usedBytes * 100) / capacityBytes)
                .coerceIn(0, 100).toInt()
        }

    val isFull: Boolean
        get() = usedBytes >= capacityBytes
}

class StorageManager {

    private var currentPlan = StoragePlan.FREE
    private var usedBytes = 0L

    fun getStorageInfo(): StorageInfo {
        return StorageInfo(
            plan = currentPlan,
            usedBytes = usedBytes
        )
    }

    fun changePlan(plan: StoragePlan) {
        currentPlan = plan
    }

    fun addUsage(bytes: Long): Boolean {
        if (bytes <= 0) return false

        if (bytes > getStorageInfo().availableBytes) {
            return false
        }

        usedBytes += bytes
        return true
    }

    fun removeUsage(bytes: Long): Boolean {
        if (bytes <= 0 || bytes > usedBytes) {
            return false
        }

        usedBytes -= bytes
        return true
    }

    fun resetUsage() {
        usedBytes = 0L
    }
}
