package com.example.neflixclone


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState()),

            ) {

                TopAppBar()
                ContentChooser()
                FeaturesMovieSection()
                AddMovies(movieType = "Watch it Again")
                AddMovies(movieType = "Latest Movies")
                AddMovies(movieType = "Drama Movies")
                AddMovies(movieType = "Action Movies")
                AddMovies(movieType = "Watch it Again")
                AddMovies(movieType = "Drama Movies")
                AddMovies(movieType = "Action Movies")
                AddMovies(movieType = "New Release Movies")
            }
        }
    }
}

@Preview
@Composable
fun TopAppBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.netflixicon), contentDescription = "AppIcon",
            modifier = Modifier
                .size(43.dp),
        )

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
//            Image(painter = painterResource(id = R.drawable.searching), contentDescription = "search",
//                modifier = Modifier
//                    .padding(end = 12.dp)
//                    .size(36.dp))
            var inputText by remember { mutableStateOf("") }

            TextField(value = inputText, onValueChange = {newText ->
                inputText = newText
            },
                leadingIcon = {
                    Icon(
                        imageVector =Icons.Default.Search ,
                        contentDescription = null)})

            Image(painter = painterResource(id = R.drawable.user_circle), contentDescription = "profile",
                modifier = Modifier
                    .padding(6.dp)
                    .size(36.dp)

            )
        }

    }

}
@Composable
fun ContentChooser(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 0.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "TV Shows",
            color = Color.LightGray,
            fontSize = 17.sp,

        )
        Text(
            text = "Movies",
            color = Color.LightGray,
            fontSize = 17.sp,
        )
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Categories",
                color = Color.LightGray,
                fontSize = 17.sp,
            )
            Image(painter = painterResource(id = R.drawable.drop_down), contentDescription = "dropDown")
        }

    }
}
@Composable
fun FeaturesMovieSection(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.movie), contentDescription = "",
            modifier = Modifier
                .padding(top = 40.dp, start = 80.dp, end = 80.dp, bottom = 40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 60.dp, end = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Adventure",color = Color.White)
            Text(text = "Thriller",color = Color.White)
            Text(text = "Drama",color = Color.White)
            Text(text = "Indian",color = Color.White)
        }
        Row(
            modifier = Modifier
                .padding(top = 20.dp, start = 80.dp, end = 80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.addbtn), contentDescription = ""
                )
                Text(text = "My List", color = Color.LightGray, fontSize = 10.sp)
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(text = "Play", color = Color.Black, fontSize = 18.sp)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.info), contentDescription = ""
                )
                Text(text = "Info", color = Color.LightGray, fontSize = 10.sp)
            }
        }
    }
}

@Composable
fun AddMovies(movieType:String) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = movieType,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            LazyRow {
                itemsIndexed(getRandomMovieList()) { index, item ->
                    MovieItemUiModel(imageRes = item.image)
                }
            }
        }
    }
@Composable
fun MovieItemUiModel(
    imageRes : Int
){
    Image(painter = painterResource(id = imageRes), contentDescription = "",
        modifier = Modifier
            .height(140.dp)
            .width(100.dp)
            .padding(end = 2.dp))
}


fun getRandomMovieList() : List<MovieItemModel>{
    val listOfMovies = mutableListOf<MovieItemModel>()
    listOfMovies.add(MovieItemModel(R.drawable.image3))
    listOfMovies.add(MovieItemModel(R.drawable.image3))
    listOfMovies.add(MovieItemModel(R.drawable.movie2))
    listOfMovies.add(MovieItemModel(R.drawable.movie))
    listOfMovies.add(MovieItemModel(R.drawable.movie2))
    listOfMovies.add(MovieItemModel(R.drawable.movie))
    listOfMovies.add(MovieItemModel(R.drawable.image3))
    listOfMovies.add(MovieItemModel(R.drawable.movie))
    listOfMovies.add(MovieItemModel(R.drawable.movie2))
    listOfMovies.add(MovieItemModel(R.drawable.movie))
    listOfMovies.add(MovieItemModel(R.drawable.movie2))

    listOfMovies.shuffle()

    return listOfMovies
}
data class MovieItemModel(
    val image : Int
)
