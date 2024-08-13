package com.example.todo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.ui.theme.btncolor
import com.example.todo.ui.theme.myBlack
import com.example.todo.ui.theme.secbtncolor


@Composable
fun Signup(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var pass by remember {
        mutableStateOf("")
    }
    var repass by remember {
        mutableStateOf("")
    }
    Column (modifier = modifier
        .fillMaxSize()
        .background(myBlack)
    ){
        Box (contentAlignment = Alignment.Center
            , modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f)
        ){
            Text(text ="SignUp"
                , fontFamily = FontFamily.Default
                , color = Color.White
                , fontSize = 40.sp
                , fontWeight = FontWeight.Bold)
        }
        TFcustom(txt = "Email@example.co", iconId =R.drawable.mail)
        Spacer(modifier = Modifier.height(25.dp))
        TFcustom(txt = "Username", iconId =R.drawable.user)
        Spacer(modifier = Modifier.height(25.dp))
        TFpasscustom(pass = pass, onpasschnge = {pass=it}, txt = "Password")
        Spacer(modifier = Modifier.height(25.dp))
        TFpasscustom(pass = repass, onpasschnge = {repass=it}, txt = "Re-type Password")
        Spacer(modifier = Modifier.height(25.dp))
        btn(color = btncolor, txt = "Signup", onClickAction = {navController.navigate(path.Home.route)})
        Spacer(modifier = Modifier.height(25.dp))
        btn(color = secbtncolor, txt = "Login", onClickAction = {navController.navigate(path.Login.route)})
    }
}











@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prev() {
    TodoTheme {

    }
}