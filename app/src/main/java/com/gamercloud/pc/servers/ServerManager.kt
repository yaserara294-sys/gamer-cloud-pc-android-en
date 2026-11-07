
package com.gamercloud.pc.servers

data class GameServer(
    val id: String,
    val name: String,
    val address: String,
    val port: Int,
    val plan: String,
    val online: Boolean = false
)

class ServerManager {

    private val servers = mutableListOf<GameServer>()

    fun addServer(server: GameServer): Boolean {
        if (server.id.isBlank()) return false
        if (server.address.isBlank()) return false
        if (server.port !in 1..65535) return false

        if (servers.any { it.id == server.id }) {
            return false
        }

        servers.add(server)
        return true
    }

    fun getServers(): List<GameServer> {
        return servers.toList()
    }

    fun getServer(id: String): GameServer? {
        return servers.find { it.id == id }
    }

    fun removeServer(id: String): Boolean {
        return servers.removeAll { it.id == id }
    }

    fun updateServerStatus(
        id: String,
        online: Boolean
    ): Boolean {
        val index = servers.indexOfFirst { it.id == id }

        if (index == -1) return false

        servers[index] = servers[index].copy(
            online = online
        )

        return true
    }
}
