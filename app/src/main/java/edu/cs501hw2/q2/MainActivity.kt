package edu.cs501hw2.q2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import edu.cs501hw2.q2.ui.theme.Q2Theme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale


//Design and build a one screen app to display a photo gallery. You need display a static grid of 6 images.
// You must use the following Composables:
//•	Row and Column to create a grid-like layout
//•	Spacer for spacing between images
//•	Add captions below each photo

val allPhotos = listOf(
    Pair(R.drawable.image1,"Instagram Logo"),
    Pair(R.drawable.image2,"PNG Logo"),
    Pair(R.drawable.image3,"Apple Logo"),
    Pair(R.drawable.image4,"Facebook Logo"),
    Pair(R.drawable.image5,"Mario"),
    Pair(R.drawable.image6,"Star Logo")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Q2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PhotoGalleryScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun PhotoGalleryScreen( modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        PhotoRow(allPhotos[0], allPhotos[1])
        Spacer(modifier = Modifier.height(8.dp))
        PhotoRow(allPhotos[2], allPhotos[3])
        Spacer(modifier = Modifier.height(8.dp))
        PhotoRow(allPhotos[4], allPhotos[5])
    }
}

@Composable
private fun PhotoRow(photo1: Pair<Int, String>, photo2: Pair<Int, String>) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ImageWithCaption(painterResource(id = photo1.first), photo1.second, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(8.dp))
        ImageWithCaption(painterResource(id = photo2.first), photo2.second, modifier = Modifier.weight(1f))
        }

}

@Composable
fun ImageWithCaption(painter: Painter, caption: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(0.7f)
        )
        Text(text = caption)
    }
}
