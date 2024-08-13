package com.example.todo

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavHostController) {
    var pass by remember {
        mutableStateOf("")
    }
    Column(
        modifier =modifier
    ) {
        Box (contentAlignment = Alignment.Center
            , modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f)
        ){
            Text(text = "TODO"
                , fontFamily = FontFamily.Default
                , color = Color.White
                , fontSize = 40.sp
                , fontWeight = FontWeight.Bold
            )
        }
        TFcustom(txt = "Username", iconId = R.drawable.user)
        Spacer(modifier = Modifier.height(15.dp))
        TFpasscustom(pass = pass, onpasschnge ={pass=it} , txt = "Password")
        Spacer(modifier = Modifier.height(80.dp))
        btn(color = Color(0xFFff73fa), txt = "Sign In", onClickAction = {navController.navigate(path.Home.route)})
        Spacer(modifier = Modifier.height(15.dp))
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()){
            Text(text = "else", color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(15.dp))
        btn(color = Color(0xFF5865f2), txt = "Sign Up", onClickAction = {navController.navigate(path.SignUp.route)} )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TFcustom(txt:String, @DrawableRes iconId:Int) {
    var username = remember {
        mutableStateOf("")
    }
    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
        TextField(value = username.value
            , onValueChange = {username.value =it}
            ,label={ Text(text = txt) },
            leadingIcon = {
                Icon(painter = painterResource(id =iconId), contentDescription = "icon", modifier = Modifier.size(30.dp))
            }
            , colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedLabelColor = Color.White
//                    containerColor = Color(0xFF121212)
            )

            ,modifier= Modifier
                .fillMaxWidth(.9f)
                .height(50.dp)
                .clip(
                    RoundedCornerShape(50.dp)
                )
                .background(Color(0xFF121212))
        )

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TFpasscustom(pass:String,onpasschnge:(String)->Unit,txt:String) {
    var passvisible by remember {
        mutableStateOf(false)
    }
    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
        TextField(value = pass
            , onValueChange = onpasschnge
            ,label={ Text(text = txt) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(passvisible) VisualTransformation.None else PasswordVisualTransformation()
            ,
            trailingIcon = {
                val image=if(passvisible) R.drawable.voff else R.drawable.von
                IconButton(onClick = { passvisible=!passvisible }) {
                    Icon(painter = painterResource(id =image), contentDescription = "icon", modifier = Modifier.size(30.dp))
                }
            }
            , colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedLabelColor = Color.White
//                    containerColor = Color(0xFF121212)
            )

            ,modifier= Modifier
                .fillMaxWidth(.9f)
                .height(50.dp)
                .clip(
                    RoundedCornerShape(50.dp)
                )
                .background(Color(0xFF121212))
        )

    }
}

@Composable
fun btn(color: Color, txt:String, onClickAction: () -> Unit) {
    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
        Button(modifier = Modifier
            .fillMaxWidth(.9f)
            , onClick = onClickAction
            , colors = ButtonDefaults.buttonColors(
                containerColor = color,
                contentColor = Color.White
            )
        ) {
            Text(text = txt, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun pp() {

}
