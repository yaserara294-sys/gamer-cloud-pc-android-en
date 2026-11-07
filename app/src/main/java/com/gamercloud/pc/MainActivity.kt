
package com.gamercloud.pc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Dark = Color(0xFF080D18)
private val Panel = Color(0xFF111D30)
private val Blue = Color(0xFF087BFF)
private val Cyan = Color(0xFF00D9FF)
private val White = Color.White
private val Gray = Color(0xFF9AAAC0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamerCloudHome()
        }
    }
}

@Composable
fun GamerCloudHome() {
    var selected by remember { mutableStateOf("Inicio") }

    MaterialTheme {
        Scaffold(
            containerColor = Dark,
            bottomBar = {
                NavigationBar(
                    containerColor = Panel
                ) {
                    listOf("Inicio", "Juegos", "Servidores", "Perfil").forEach {
                        NavigationBarItem(
                            selected = selected == it,
                            onClick = { selected = it },
                            icon = {
                                Text(
                                    when (it) {
                                        "Inicio" -> "⌂"
                                        "Juegos" -> "🎮"
                                        "Servidores" -> "☁"
                                        else -> "👤"
                                    }
                                )
                            },
                            label = { Text(it) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Cyan,
                                selectedTextColor = Cyan,
                                indicatorColor = Blue.copy(alpha = 0.2f),
                                unselectedTextColor = Gray
                            )
                        )
                    }
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Dark)
                    .padding(padding)
                    .padding(20.dp)
            ) {
                Text(
                    "GAMER CLOUD PC",
                    color = Cyan,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    "TU PC GAMING EN LA NUBE",
                    color = Gray,
                    fontSize = 11.sp
                )

                Spacer(Modifier.height(28.dp))

                Text(
                    "Bienvenido, Gamer",
                    color = White,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(20.dp))

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Panel
                    ),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.padding(20.dp)) {
                        Text("ESTADO DEL SERVIDOR", color = Gray)
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "● DESCONECTADO",
                            color = Color(0xFFFF5555),
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(20.dp))

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(58.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue
                            ),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(
                                "JUGAR",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }

                Spacer(Modifier.height(24.dp))

                Text(
                    "MI PLATAFORMA",
                    color = Cyan,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(12.dp))

                DashboardItem("🎮", "Biblioteca de juegos")
                DashboardItem("☁", "Mi PC virtual")
                DashboardItem("💾", "Almacenamiento")
                DashboardItem("⚙", "Configuración")
            }
        }
    }
}

@Composable
fun DashboardItem(icon: String, title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Panel
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier.padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, fontSize = 23.sp)
            Spacer(Modifier.width(15.dp))
            Text(
                title,
                color = White,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
