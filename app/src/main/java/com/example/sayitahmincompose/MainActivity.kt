package com.example.sayitahmincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sayitahmincompose.ui.theme.SayiTahminComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayiTahminComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                SayfaGecisleri()
                }
            }
        }
    }
}
@Composable
fun SayfaGecisleri(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "ana_sayfa" ){
        composable("ana_sayfa"){
            AnaSayfa(navController = navController)
        }
        composable("tahmin_ekrani"){
            TahminEKrani(navController = navController)
        }
        composable("sonuc_ekrani/{sonuc}", arguments = listOf(
            navArgument("sonuc"){type= NavType.BoolType }
        )){
            val sonuc=it.arguments?.getBoolean("sonuc")!!
            SonucEkrani(sonuc = sonuc)
        }
    }

}
@Composable
fun AnaSayfa(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Tahmin Et",
        fontSize = 80.sp)
        Image(painter = painterResource(id = R.drawable.guess), contentDescription ="", modifier = Modifier.size(150.dp) )
        Button(onClick = { navController.navigate("tahmin_ekrani") },
            colors =ButtonDefaults.buttonColors(
                backgroundColor = Color.Green,
                contentColor = Color.Blue
            )
        ) {
            Text(text = "Haydi Başlayalım")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SayiTahminComposeTheme {
        SayfaGecisleri()
    }
}