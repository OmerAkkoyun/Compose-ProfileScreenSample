package com.omerakkoyun.profilescreencompose

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omerakkoyun.profilescreencompose.dummy.DummyHelper
import com.omerakkoyun.profilescreencompose.model.ItemModel
import com.omerakkoyun.profilescreencompose.ui.theme.ProfileScreenComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileScreenComposeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .background(color = Color.Red)
                ) { innerPadding ->
                    ProfileScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(innerPadding: PaddingValues) {
    val scrollState = rememberScrollState()
    val myColor = colorResource(id = R.color.mainColor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Üst kısımdaki Box (profil alanı)
        Box(
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
                .background(color = myColor)
        ) {
            // Profil başlık ve resim içerikleri
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Image(
                    imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button",
                    modifier = Modifier.align(Alignment.CenterStart).size(32.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(
                    text = "Profile", color = Color.White, fontSize = 32.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Image(
                painterResource(id = R.drawable.arc_3),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )

            Image(
                painterResource(id = R.drawable.img_user),
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.Crop
            )
        }

        // Profil adı
        Text(
            text = "Ömer AKKOYUN",
            fontWeight = FontWeight.Bold,
            color = myColor,
            fontSize = 26.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        )

        // Profil email
        Text(
            text = "omer_13_34@hotmail.com", fontWeight = FontWeight.Normal, color = Color(android.graphics.Color.parseColor("#747679")), fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 20.dp)
        )


        // Menü elemanlarını profilin altından başlayıp tüm sayfayı dolduracak şekilde ayarlıyoruz
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 16.dp, top = 30.dp) // İstenirse altına boşluk eklenebilir
        ) {
            for (item in DummyHelper.getItems()) {
                ItemMenu(item = item)
                Spacer(modifier = Modifier.height(20.dp)) // Elemanlar arasına boşluk
            }

        }
    }
}



@Composable
fun ItemMenu(item: ItemModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 34.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painterResource(id = item.icon), contentDescription = item.name)
        Text(
            text = item.name, fontWeight = FontWeight.Normal, color = Color(android.graphics.Color.parseColor("#747679")), fontSize = 18.sp,
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        )
        Image(painterResource(id = R.drawable.arrow), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileScreenComposeTheme {
        ProfileScreen(PaddingValues(16.dp))
    }
}
