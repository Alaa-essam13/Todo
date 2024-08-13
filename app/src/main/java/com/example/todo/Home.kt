package com.example.todo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.todo.ui.theme.Gry
import com.example.todo.ui.theme.cscolor
import com.example.todo.ui.theme.myBlack

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavHostController) {
    val tasks by remember {
        mutableStateOf(
            listOf(
                task("Task 1", "Description 1", 15),
                task("Task 2", "Description 2", 30),
                task("Task 3", "Description 3", 45)
            )
        )
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= modifier
            .fillMaxSize()
            .background(myBlack)
    ){
        Topsec()
        Spacer(modifier = Modifier.height(15.dp))
        SecondSec()
        Spacer(modifier = Modifier.height(15.dp))
        searchsection()
        Spacer(modifier = Modifier.height(15.dp))
        Todolist(navController=navController,
            items = tasks, onDelete = {
            task->tasks.filter { it!=task }
        })
        Bottombtn(navController=navController)
        
    }
}

@Composable
fun Topsec() {
    Row (modifier = Modifier
        .fillMaxWidth(.95f)
        .height(40.dp)
        .padding(top = 10.dp)
        , horizontalArrangement = Arrangement.SpaceBetween
    ){
//           Spacer(modifier = Modifier.width(180.dp))
        Box (modifier = Modifier.size(35.dp)){

        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier.height(40.dp)){
            Text(text = "Home"
                , color = Color.White
                , textAlign = TextAlign.Center
                , fontSize = 16.sp
            )
        }
        Icon(painter = painterResource(id = R.drawable.setting), contentDescription = "Settings", modifier = Modifier
            .size(35.dp)
            .padding(top = 5.dp), tint = Color.White)
    }
}

@Composable
fun SecondSec() {
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)){
        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(.65f)
            .padding(start = 10.dp)){
            Text(text = "Welcome back", color = Color.White, fontSize =18.sp, fontFamily = FontFamily.Default)
            Text(text = "Alaa Essam", color = Color.White, fontSize =18.sp, fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold )
        }
        Image(
            painter = painterResource(id = R.drawable.mypic),
            contentDescription ="my picture",
            modifier= Modifier
                .size(90.dp)
                .weight(33f)
                .align(Alignment.CenterVertically)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 2.dp,
                    color = cscolor,
                    shape = CircleShape
                )
                .clip(CircleShape)
        )
    }
}

@Composable
fun searchsection() {
    TFcustom(txt = "search", iconId =R.drawable.search )
}

@Composable
fun Todolist(items: List<task>, onDelete: (task) -> Unit, navController: NavHostController) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.85f)
    ) {
        items(items.size) { index ->
            var isSwiped by remember { mutableStateOf(false) }

            Box(modifier = Modifier.fillMaxWidth()) {

                // Task item
                itminlist(navController=navController,
                    item = items[index],
                    modifier = Modifier
                        .offset(x = if (isSwiped) (-80).dp else 0.dp)
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures { change, dragAmount ->
                                if (dragAmount < -50) {
                                    isSwiped = true
                                } else if (dragAmount > 50) {
                                    isSwiped = false
                                }
                                change.consume()
                            }
                        }
                )
                if (isSwiped) {
                    Box (contentAlignment = Alignment.CenterEnd, modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(.95f)
                        .padding(top = 10.dp)
                       ){
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.Red
                            ),
                            onClick = { onDelete(items[index]) }
                        ) {
                            Icon(painter = painterResource(id = R.drawable.garbage), contentDescription =null )
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Composable
fun itminlist(item: task, modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .background(Gry)
            .padding(15.dp)
            .clickable { navController.navigate(path.Timer.route) }
        ,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = item.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = item.discription, color = Color.LightGray)
    }
}


@Composable
fun Bottombtn(navController: NavHostController) {
    Box (contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize()){
        IconButton(
            onClick = { navController.navigate(path.AddTask.route) }
            ,colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color(0xFFff73fa)
        ),modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        ) {
           Icon(painter = painterResource(id = R.drawable.plus), tint = Color.White, modifier = Modifier.size(30.dp), contentDescription =null )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun homeprev() {

}