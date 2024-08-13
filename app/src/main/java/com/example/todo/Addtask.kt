package com.example.todo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.todo.ui.theme.Gry
import com.example.todo.ui.theme.cscolor
import com.example.todo.ui.theme.myBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTask(navController: NavHostController) {
    var tfText by remember {
        mutableStateOf("")
    }
    var valu by remember {
        mutableStateOf("")
    }
Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier= Modifier
        .fillMaxSize()
        .background(myBlack)
) {
    Box(contentAlignment = Alignment.Center
        , modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
    ){
        Text(text = "Add Task", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
    TFcustom(txt = "title", iconId = R.drawable.title)
    Spacer(modifier = Modifier.height(15.dp))
    TextField(value = tfText
        , onValueChange ={
                 tfText=it
            }
        , modifier = Modifier
            .fillMaxWidth(.9f)
            .background(Gry, RoundedCornerShape(50.dp))
            ,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            disabledTextColor = Color.White,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedLabelColor = Color.Transparent,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            unfocusedIndicatorColor = Gry,
        ),
       placeholder = {Text("Enter text...")},
       leadingIcon = {
           Icon(painter = painterResource(id = R.drawable.des), contentDescription =null,tint=Color.Gray, modifier = Modifier.size(30.dp) )
       }
    )
    Spacer(modifier = Modifier.height(15.dp))

    Spacer(modifier = Modifier.height(20.dp))
    btn(color = cscolor, txt = "Add", onClickAction = {navController.navigate(path.Home.route)})
}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun addprev() {

}