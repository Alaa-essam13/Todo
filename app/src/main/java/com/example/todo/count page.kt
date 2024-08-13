package com.example.todo

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.todo.ui.theme.myBlack
import kotlinx.coroutines.delay

@Composable
fun mainsecreen(navController: NavHostController) {
    var isplayed by remember {
        mutableStateOf(false)
    }

Column(
    Modifier
        .fillMaxSize()
        .background(myBlack)) {
Row (
    Modifier
        .fillMaxWidth()
        .padding(15.dp)
        .height(50.dp)
){
    IconButton(onClick = { navController.navigate(path.Home.route) }) {
        Icon(painter = painterResource(id = R.drawable.back)
            , contentDescription =null,
            tint = Color.White,
            modifier = Modifier.size(25.dp)

            )
    }
}
    EllipCircleButton(isRotating=isplayed)
Box (contentAlignment = Alignment.Center,
    modifier = Modifier
        .fillMaxSize()
){
    Row (horizontalArrangement = Arrangement.Center
    ) {

        IconButton(onClick = {
            navController.navigate(path.Home.route)
                             },
            modifier = Modifier
            .clip(CircleShape)
            .size(50.dp)
            , colors = IconButtonDefaults.iconButtonColors(
                containerColor =  Color.Green
            )
            ) {

            Icon(painter = painterResource(id = R.drawable.check), contentDescription =null, modifier = Modifier.size(30.dp), tint = Color.Black )
        }

        Spacer(modifier = Modifier.width(25.dp))
        IconButton(modifier = Modifier
            .clip(CircleShape)
            .size(50.dp)
            , colors = IconButtonDefaults.iconButtonColors(
                containerColor = if(!isplayed)Color.Red else Color.Gray
            )
            , onClick = { isplayed=!isplayed }) {

            Icon(painter = if(!isplayed)painterResource(id = R.drawable.play)else painterResource(id = R.drawable.pause), contentDescription =null, modifier = Modifier.size(30.dp), tint = Color.Black )
        }
    }
}
}
}

@Composable
fun EllipCircleButton(isRotating: Boolean) {

    var rotationAngle by remember { mutableStateOf(0f) }
    var scale by remember { mutableStateOf(1f) }
    val rotation = animateFloatAsState(
        targetValue = rotationAngle,
        animationSpec = tween(durationMillis = 10)
    )
    val scaleAnim = animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(durationMillis = 500)
    )
    var sec by remember {
        mutableStateOf(0)
    }
    var minu by remember {
        mutableStateOf(0)
    }
    val animatedseconds = animateIntAsState(
        targetValue = sec
        , animationSpec = tween(durationMillis = 500))
    val animatedmin = animateIntAsState(
        targetValue = minu
        , animationSpec = tween(durationMillis = 500))
    // Coroutine to continuously rotate
    LaunchedEffect(isRotating) {
        if (isRotating) {
            while (true) {
                rotationAngle += 5f
                scale = if (scale == 1f) 1.5f else 1f
                delay(20) // Control the speed of the rotation
            }
        }
    }
    LaunchedEffect(isRotating) {
        while (isRotating){
            delay(1000)
            if (sec==59) {
                sec = -1
                minu++
            }
            sec+=1
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.88f)
            .size(150.dp)
    ) {
        if (isRotating) {
            BlobShape(
                isRotate = isRotating,
                modifier = Modifier.size(150.dp * scaleAnim.value),
                color = Color(0xFFBB86FC),
                rotatenum = rotation.value + 10f
            )
            BlobShape(
                isRotate = isRotating,
                modifier = Modifier.size(150.dp * scaleAnim.value),
                color = Color(0xFFBB86FC),
                rotatenum = -rotation.value + 55f
            )
            BlobShape(
                isRotate = isRotating,
                modifier = Modifier.size(150.dp * scaleAnim.value),
                color = Color(0xFFBB86FC),
                rotatenum = -rotation.value + 99f
            )
            BlobShape(
                isRotate = isRotating,
                modifier = Modifier.size(150.dp * scaleAnim.value),
                color = Color(0xFFBB86FC),
                rotatenum = rotation.value + 180f
            )
            BlobShape(
                isRotate = isRotating,
                modifier = Modifier.size(150.dp * scaleAnim.value),
                color = Color(0xFFBB86FC),
                rotatenum = rotation.value + 250f
            )
            BlobShape(
                isRotate = isRotating,
                modifier = Modifier.size(150.dp * scaleAnim.value),
                color = Color(0xFFBB86FC),
                rotatenum = -rotation.value + 300f
            )
            drawcir(color = Color(0xFFBB86FC), modifier = Modifier.size(205.dp))
        }else{
            drawcir(color = Color(0xFFBB86FC), modifier = Modifier.size(195.dp))
            drawcir(color = Color(0xFFBB86FC), modifier = Modifier.size(185.dp))
            drawcir(color = Color(0xFFBB86FC), modifier = Modifier.size(175.dp))
            drawcir(color = Color(0xFFBB86FC), modifier = Modifier.size(165.dp))
            drawcir(color = Color(0xFFBB86FC), modifier = Modifier.size(150.dp))

        }

        Text(text = if(animatedmin.value<10) {
            "0" + animatedmin.value.toString()
        }else{ animatedmin.value.toString()} +":"+
                if(animatedseconds.value<10) {
                    "0" + animatedseconds.value.toString()
                }else{
                    animatedseconds.value.toString()
                }, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black)
    }
}

@Composable
fun BlobShape(isRotate: Boolean, modifier: Modifier = Modifier, color: Color, rotatenum: Float = 0f) {
        Canvas(modifier = modifier) {
            rotate(rotatenum, pivot = center) {
                val path = androidx.compose.ui.graphics.Path().apply {
                    moveTo(size.width * .5f, size.height * 0f)
                    cubicTo(
                        size.width * .5f, size.height * 0f,
                        size.width * 1f, size.height * 0f,
                        size.width * 1f, size.height * .6f
                    )
                    cubicTo(
                        size.width * 0.5f, size.height * 2f,
                        size.width * -1.2f, size.height * -.1f,
                        size.width * .5f, size.height * 0f
                    )
                    close()
                }

                drawPath(
                    path = path,
                    color = color.copy(alpha = 0.5f), // Set alpha for blending effect
                )
            }
        }

}

@Composable
fun drawcir(modifier: Modifier = Modifier,color:Color) {
    Canvas(modifier = modifier) {
        drawCircle(
            color = color.copy(alpha = .5f),
            radius = size.minDimension/2,
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Cprev() {
//    EllipCircleButton()

}