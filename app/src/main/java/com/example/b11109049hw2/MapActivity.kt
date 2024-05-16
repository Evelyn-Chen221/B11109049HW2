package com.example.b11109049hw2
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val placeIndex = intent.getIntExtra("placeIndex", 0)
        setContent {
            ShowMap(placeIndex, this) // 将上下文传递给 ShowMap
        }
    }
}

@Composable
fun ShowMap(placeIndex: Int, activity: ComponentActivity) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MapButton(placeIndex, activity) // 将上下文传递给 MapButton
    }
}

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun MapButton(placeIndex: Int, activity: ComponentActivity) {
    Button(
        onClick = {
            val locationUri = getLocationUri(placeIndex)
            val mapIntent = Intent(Intent.ACTION_VIEW, locationUri)
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(activity.packageManager) != null) {
                activity.startActivity(mapIntent)
            }
        }
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "查看地圖",
                fontSize = 14.sp,
            )

        }
    }
}

fun getLocationUri(placeIndex: Int): Uri {
    // 这里示例使用静态的经纬度，请替换成实际景点的座标
    val lat = getLatitude(placeIndex)
    val lng = getLongitude(placeIndex)
    val placeName = getPlaceName(placeIndex)
    return Uri.parse("geo:$lat,$lng?q=$placeName")
}

fun getLatitude(placeIndex: Int): Double {
    return when (placeIndex) {
        0 -> 24.07907 // 请替换为实际地点的纬度
        1 -> 24.19341
        2 -> 23.862515
        3 -> 24.31254
        4 -> 24.16285
        5 -> 24.13802
        6 -> 24.15258
        7 -> 24.07651
        8 -> 24.14263
        9 -> 24.14488
        // 请替换为实际地点的纬度
        // 添加更多景点的纬度
        else -> 0.0
    }
}

fun getLongitude(placeIndex: Int): Double {
    return when (placeIndex) {
        0 -> 120.54749 // 请替换为实际地点的经度
        1 -> 120.65250
        2 -> 120.912308
        3 -> 120.54870
        4 -> 120.64032
        5 -> 120.68354
        6 -> 120.58027
        7 -> 121.16852
        8 -> 120.67704
        9 -> 120.66263// 请替换为实际地点的经度
        // 添加更多景点的经度
        else -> 0.0
    }
}

fun getPlaceName(placeIndex: Int): String {
    return when (placeIndex) {
        0 -> "八卦山"
        1 -> "台中中央公園"
        2 -> "日月潭"
        3 -> "高美濕地"
        4 -> "國家歌劇院"
        5 -> "宮原眼科"
        6 -> "望高寮"
        7 -> "清境農場"
        8 -> "台中柳川"
        9 -> "審計新村"
        else -> ""
    }
}