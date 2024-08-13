package com.example.todo

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.todo.ui.theme.myBlack
import kotlinx.coroutines.delay

@Composable
fun AnimatedTodoText(navController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        delay(500L)
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)

                }
            )
        )
        delay(2000L)
        scale.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(1f).getInterpolation(it)
                }
            )
        )
        navController.navigate(path.Login.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(myBlack),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "TODO",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.scale(scale.value)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedTodoTextPreview() {

}