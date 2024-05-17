package com.example.b11109049hw2
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBar
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


class DetailActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val placeIndex = intent.getIntExtra("placeIndex", -1)

                DetailScreen(placeIndex){
                    onBackPressed()
                }

        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DetailScreen(placeIndex: Int,onBackClick:()->Unit) {
        val context = LocalContext.current
        val placeDescription = getDescription(placeIndex)
        val placeName= getPlaceName(placeIndex)
        Column {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    Button(onClick = {onBackClick()}) {
                        Text(text = "返回")
                    }
                }
            )
        }
        Column {
            Text(
                "\n"+placeName,
                fontSize = 50.sp,
                color = Color.Black
            )
            Image(
                painter = painterResource(id = getImageResourceId(placeIndex)),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Text(placeDescription)
            Button(onClick = {
                showMapInWebView(context, placeName)
            }) {
                Text("查看地圖")
            }
        }
    }

    private fun showMapInWebView(context: Context, placeName: String) {
        val webView = WebView(context)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        val mapUrl = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(placeName)
        webView.loadUrl(mapUrl)
        setContentView(webView)
    }


    fun getImageResourceId(index: Int): Int {
        return when (index) {
            0 -> R.drawable.first
            1 -> R.drawable.second
            2 -> R.drawable.third
            3 -> R.drawable.fourth
            4 -> R.drawable.fifth
            5 -> R.drawable.sixth
            6 -> R.drawable.seventh
            7 -> R.drawable.eighth
            8 -> R.drawable.ninth
            else -> R.drawable.tenth
        }
    }

    fun getDescription(index: Int): String {
        return when (index) {
            0 -> "八卦山位於彰化，是台灣最具代表性的山岳之一。它也是台灣的三大神山之一，象徵著台灣的文化信仰和山林景觀。八卦山的山勢起伏，山腰樹木蓊鬱，風景優美。山上有許多古老的寺廟和道觀，如日月潭文武廟、普濟寺等，吸引許多信徒和遊客前來朝拜和遊覽。登上八卦山可以俯瞰台中市區和周邊山脈，景色壯麗，是許多登山愛好者和觀光客喜愛的景點之一。\n"
            1 -> "台中中央公園是位於台中市西屯區的一個大型綠地公園，面積約67公頃，是台灣中部地區的重要城市綠肺。公園設計融合了自然景觀與現代設施，內有廣闊的草坪、人工湖、步道、自行車道，以及多處運動設施，如籃球場和羽毛球場。中央公園不僅是市民休閒娛樂的好去處，也是舉辦各種戶外活動和文化活動的理想場所。公園內的生態保護區和水資源管理系統展示了環保與可持續發展的理念，是台中市推動綠色城市的重要象徵。\n"
            2 -> "日月潭位於南投縣，是台灣最大的天然湖泊。湖泊形狀如同日月交輝，因此得名。日月潭被群山環繞，湖水清澈，景色宜人，是著名的旅遊勝地。日月潭不僅有豐富的自然美景，如涵碧樓、文武廟和慈恩塔，還有豐富的人文歷史背景，讓遊客能夠享受到自然與文化的雙重魅力。每年吸引眾多遊客前來觀光，並且是台灣重要的旅遊地標之一。\n"
            3 -> "高美溼地位於台灣台中市西海岸，是一個重要的濕地生態保護區。這裡擁有豐富的生態資源，包括多種鳥類、濕地植物和特有的生態環境。高美溼地不僅是候鳥的重要棲息地，也是台灣重要的觀鳥景點之一。這裡的濕地生態環境受到保護，吸引許多環保愛好者和遊客前來欣賞自然之美，同時也提供了重要的生態教育價值。高美溼地的保育工作努力確保這片寶貴的生態環境能夠持續存在和繁榮。\n"
            4 -> "國家歌劇院是一座重要的文化機構，位於城市的中心地帶。這座劇院是專為歌劇、芭蕾舞和音樂劇等表演藝術而建，擁有豐富的藝術歷史和遺產。國家歌劇院的建築氣派宏偉，常常成為城市地標之一，吸引著來自世界各地的觀眾。劇院內部裝潢精緻，舞台設備先進，能夠呈現高水準的表演。這裡經常舉辦各種藝術節目和表演，是藝術愛好者和文化遊客必訪的地方，也是國家文化藝術的重要象徵。\n"
            5 -> "宮原眼科位於台中市北區，是一個融合文化與歷史的特色觀光景點。這座建築原為日治時期的眼科診所，保存完整的日式建築風格，具有濃厚的懷舊氛圍。宮原眼科因其獨特的外觀與豐富的歷史背景，吸引了許多遊客前來參觀。內部陳設展示了眼科診所的歷史文物與眼鏡收藏，讓人仿佛穿越時光，感受日治時代的生活風貌。這裡也是許多文創活動舉辦的場地，展示了台灣的豐富多元文化。造訪宮原眼科，不僅可以了解台中的歷史，還能感受到其獨特的魅力與魅力。\n"
            6 -> "望高寮位於台中市，是一處享有美景的觀景台，位於海拔450公尺的地方，因其能將台中市的全景盡收眼底而聞名。從望高寮眺望，可以看到市區的建築、綠意盎然的山巒以及遠方的大甲、清水等地。夜晚時分，市區的燈光點亮，更是一片繽紛的夜景。此外，望高寮周邊也有數處步道和公園，提供民眾休閒散步或賞景的好去處。站在望高寮，不僅可以放鬆心情，還能感受到台中的壯麗景色，是遊覽台中市的絕佳景點之一。\n"
            7 -> "清境農場位於南投，是一個高山上的知名觀光景點。這裡地勢高，氣候清涼，四季分明，夏天清爽舒適，冬天則可能下起濃厚的雪。清境農場以其綿延的青草地、濃密的杉樹林和遼闊的視野吸引著許多遊客。遊客可以在這裡享受鄉村的寧靜，漫步在青翠的草地上，也可以欣賞到美麗的日出和日落。\n"
            8 -> "台中的柳川是一條風景優美的人工運河，位於市區中心。這條運河起源於日治時期，曾是運輸的重要通道，現在則成為了休閒與觀光的熱門景點。沿著柳川有著美麗的櫻花樹、綠樹成蔭的步道，讓人可以漫步欣賞河畔風光。遊客可以租借小船或是搭乘遊船，沿途欣賞河景，感受悠閒的水上氛圍。柳川兩岸還有許多美食小吃和咖啡餐廳，是台中市民及遊客喜愛的休憩勝地，尤其是櫻花盛開的季節，更是吸引大批遊客前來觀賞。\n"
            9 -> "台中的審計新村位於台中市西區，是一個具有歷史意義的特殊社區。審計新村建於1940年代，當時是供給審計人員居住的宿舍區，因此得名。這個社區的建築風格充滿日式懷舊氛圍，保留了許多當時的原始建築，包括木造和磚造建築，讓人彷彿穿越到日治時期的台灣。如今的審計新村已經轉型成為一個文化創意產業聚落，許多老宿舍被改建成藝廊、工作室、咖啡館和設計公司等。這裡的街道狹窄\n"
            else -> ""
        }
    }
}


