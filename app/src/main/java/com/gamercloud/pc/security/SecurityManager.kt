
package com.gamercloud.pc.security

import java.security.MessageDigest
import java.security.SecureRandom
import java.util.Base64

data class UserSession(
    val userId: String,
    val accessToken: String,
    val expiresAt: Long
)

class SecurityManager {

    private val random = SecureRandom()

    fun generateSecureToken(): String {
        val bytes = ByteArray(32)
        random.nextBytes(bytes)

        return Base64.getUrlEncoder()
            .withoutPadding()
            .encodeToString(bytes)
    }

    fun sha256(value: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(value.toByteArray())

        return hash.joinToString("") {
            "%02x".format(it)
        }
    }

    fun createSession(
        userId: String,
        durationMillis: Long = 3600000L
    ): UserSession? {

        if (userId.isBlank()) return null
        if (durationMillis <= 0) return null

        val now = System.currentTimeMillis()

        return UserSession(
            userId = userId,
            accessToken = generateSecureToken(),
            expiresAt = now + durationMillis
        )
    }

    fun isSessionValid(session: UserSession): Boolean {
        return session.userId.isNotBlank() &&
            session.accessToken.isNotBlank() &&
            session.expiresAt > System.currentTimeMillis()
    }
}
