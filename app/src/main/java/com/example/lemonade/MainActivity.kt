package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}


@Composable
fun LemonadeImage(modifier: Modifier = Modifier) {
    var change by remember { mutableIntStateOf(1) }

    val imageResource = when (change) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textDescription = when (change) {
        1 -> R.string.tree
        2 -> R.string.lemon
        3 -> R.string.lemondrink
        else -> R.string.lemonrestart
    }
    Text(
        text = stringResource(R.string.lemonade),
        fontSize = 35.sp,
        modifier = modifier
            .background(color = Color.Yellow)
            .fillMaxWidth()
            .absolutePadding(top = 15.dp, bottom = 15.dp),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Button(onClick = {
            change = when (change) {
                1 -> 2
                2 -> 3
                3 -> 4
                else -> 1
            }
        }, modifier = modifier,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
            shape = RoundedCornerShape(30.dp)){
            Image(
                painter = painterResource(imageResource),
                contentDescription = "null", // Replace with your actual string resource
                modifier = Modifier.size(150.dp) // Adjust size as needed
            )
        }
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = stringResource(textDescription)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeImage()
}
