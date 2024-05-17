package com.example.b11109049hw2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b11109049hw2.ui.theme.B11109049HW2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            B11109049HW2Theme {
                PlacesList()
            }
        }
    }
}


@Composable
fun PlacesList() {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(places.size) { index ->
            PlaceCard(placeName = places[index], placeImageId = placeImages[index], onClick = {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("placeIndex", index)
                context.startActivity(intent)
            })
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}

@Composable
fun PlaceCard(placeName: String, placeImageId: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {

            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = placeName,
                    fontSize = 50.sp,
                    color = Color.Black
                )
            }
        }
    }
}

val placeImages = listOf(
    R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.fourth,
    R.drawable.fifth, R.drawable.sixth, R.drawable.seventh, R.drawable.eighth,
    R.drawable.ninth, R.drawable.tenth
)

val places = listOf(
    "八卦山", "台中中央公園", "日月潭", "高美濕地", "國家歌劇院",
    "宮原眼科", "望高寮", "清境農場", "台中柳川", "審計新村"
)

@Preview
@Composable
fun PreviewPlacesList() {
    B11109049HW2Theme {
        PlacesList()
    }
}
