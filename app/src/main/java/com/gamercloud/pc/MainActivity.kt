package com.gamercloud.pc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GamerCloudApp()
        }
    }
}

private val Background = Color(0xFF080D18)
private val Blue = Color(0xFF168BFF)
private val White = Color(0xFFFFFFFF)

@Composable
fun GamerCloudApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "GAMER CLOUD PC",
                    color = Blue,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "TU PC GAMING EN LA NUBE",
                    color = White,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(45.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue
                    )
                ) {
                    Text(
                        text = "JUGAR",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "SERVIDOR DESCONECTADO",
                    color = Color(0xFFFF5252),
                    fontSize = 13.sp
                )
            }
        }
    }
}
