
package com.gamercloud.pc.games

data class Game(
    val id: String,
    val name: String,
    val platform: String,
    val executable: String,
    val installed: Boolean = false,
    val supportsMods: Boolean = false
)

class GameManager {

    private val games = mutableListOf<Game>()

    fun addGame(game: Game): Boolean {
        if (game.id.isBlank() || game.name.isBlank()) {
            return false
        }

        if (games.any { it.id == game.id }) {
            return false
        }

        games.add(game)
        return true
    }

    fun getGames(): List<Game> {
        return games.toList()
    }

    fun getGame(id: String): Game? {
        return games.find { it.id == id }
    }

    fun removeGame(id: String): Boolean {
        return games.removeAll { it.id == id }
    }

    fun getInstalledGames(): List<Game> {
        return games.filter { it.installed }
    }

    fun getGamesWithMods(): List<Game> {
        return games.filter { it.supportsMods }
    }

    fun registerDefaultGames() {
        addGame(
            Game(
                id = "ats",
                name = "American Truck Simulator",
                platform = "Steam",
                executable = "amtrucks.exe",
                supportsMods = true
            )
        )

        addGame(
            Game(
                id = "ets2",
                name = "Euro Truck Simulator 2",
                platform = "Steam",
                executable = "eurotrucks2.exe",
                supportsMods = true
            )
        )

        addGame(
            Game(
                id = "nfs-heat",
                name = "Need for Speed Heat",
                platform = "EA",
                executable = "NeedForSpeedHeat.exe"
            )
        )
    }
}
