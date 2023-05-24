@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.composesubmission

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composesubmission.model.ItemList
import com.example.composesubmission.model.ItemListURI
import com.example.composesubmission.ui.theme.ComposeSubmissionTheme
import com.example.composesubmission.ui.view.AboutScreen
import com.example.composesubmission.ui.view.DetailScreenUser
import com.example.composesubmission.ui.view.DetailScreenUserUri
import com.example.composesubmission.viewmode.MainActivityViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSubmissionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController, viewModel)
                }
            }
        }
    }
}


@Composable
fun ListScreen(navController: NavHostController, viewModel: MainActivityViewModel) {
    val (isFormVisible, setFormVisible) = remember { mutableStateOf(false) }
    val (isFavorite, setFavorite) = remember { mutableStateOf(false) }
    val (searchText, setSearchText) = remember { mutableStateOf("") }

    val data by viewModel.dataList.collectAsState()
    val dataUser by viewModel.dataListUser.collectAsState()

    val context = LocalContext.current

    val filteredData = data.filter {
        it.title.contains(searchText, ignoreCase = true)
    }

    val filteredDataUser = dataUser.filter {
        it.title.contains(searchText, ignoreCase = true)
    }

    Log.d("ListScreen", "ListScreen: ${viewModel.getIdDataList(1)},")


    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            MyAppBar(navController, searchText, isFavorite, setFavorite, setSearchText)
            if (isFavorite) {
                val allDataFavorite = filteredData.filter {
                    it.isFavorite
                }
                val allDataFavoriteUser = filteredDataUser.filter {
                    it.isFavorite
                }
                if (allDataFavorite.isEmpty() && allDataFavoriteUser.isEmpty()) {
                    ErrorText()
                }
            } else {
                if (filteredDataUser.isEmpty() && filteredData.isEmpty()) {
                    ErrorText()
                }
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                if (isFavorite) {
                    items(filteredDataUser.size) { index ->
                        val item = filteredDataUser[index]
                        val id = item.id
                        if (item.isFavorite) {
                            if (index % 2 == 0) {
                                ListItemUri(item = item, MaterialTheme.colorScheme.tertiary, viewModel, index) {
                                    navController.navigate("detailUser/$id")
                                }
                            } else {
                                ListItemUri(item = item, MaterialTheme.colorScheme.primary, viewModel, index) {
                                    navController.navigate("detailUser/$id")
                                }
                            }
                        }
                    }
                    items(filteredData.size) { index ->
                        val item = filteredData[index]
                        val id = item.id
                        if (item.isFavorite) {
                            if (index % 2 == 0) {
                                ListItem(item = item, MaterialTheme.colorScheme.tertiary, viewModel, index) {
                                    navController.navigate("detail/$id")
                                }
                            } else {
                                ListItem(item = item, MaterialTheme.colorScheme.primary, viewModel, index) {
                                    navController.navigate("detail/$id")
                                }
                            }
                        }
                    }
                } else {
                    items(filteredDataUser.size) { index ->
                        val item = filteredDataUser[index]
                        val id = item.id
                        if (index % 2 == 0) {
                            ListItemUri(item = item, MaterialTheme.colorScheme.tertiary, viewModel, index) {
                                navController.navigate("detailUser/$id")
                            }
                        } else {
                            ListItemUri(item = item, MaterialTheme.colorScheme.primary, viewModel, index) {
                                navController.navigate("detailUser/$id")
                            }
                        }
                    }
                    items(filteredData.size) { index ->
                        val item = filteredData[index]
                        val id = item.id
                        if (index % 2 == 0) {
                            ListItem(item = item, MaterialTheme.colorScheme.tertiary, viewModel, index) {
                                navController.navigate("detail/$id")
                            }
                        } else {
                            ListItem(item = item, MaterialTheme.colorScheme.primary, viewModel, index) {
                                navController.navigate("detail/$id")
                            }
                        }
                    }
                }
            }

        }

        FloatingActionButton(
            onClick = { setFormVisible(!isFormVisible) },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Item")
        }

        if (isFormVisible) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black.copy(alpha = 0.7f))
                    .clickable {
                        setFormVisible(false)
                    }, // consume click events
                contentAlignment = Alignment.Center
            ) {
                MyForm(
                    onSubmit = {image, bitmap, title, description, genre, synopsis ->
                        if(title.isEmpty() || description.isEmpty() || genre.isEmpty() || synopsis.isEmpty()) {
                            Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                        } else {
                            viewModel.addFirstDataListUser(
                                ItemListURI(
                                    viewModel.dataListUser.value.size + 1,
                                    image,
                                    bitmap,
                                    title,
                                    description,
                                    synopsis,
                                    genre,
                                )
                            )
                            setFormVisible(false)
                        }
                })
            }
        }
    }
}

@Composable
fun ErrorText() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "No Data",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
fun MyForm(onSubmit: (Uri?, Bitmap?, String, String, String, String) -> Unit) {
    var image by remember { mutableStateOf<Uri?>(null) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var synopsis by remember { mutableStateOf("") }

    val context = LocalContext.current
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        image = uri
    }

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Column {
            Text("Title:")
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Text("Description:")
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Text("Genre:")
            OutlinedTextField(
                value = genre,
                onValueChange = { genre = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Text("Synopsis:")
            OutlinedTextField(
                value = synopsis,
                onValueChange = { synopsis = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            
            Row {
                Button(onClick = {
                    launcher.launch("image/*")
                }) {
                    Text(text = "Pick image")
                }
                image?.let {
                    if (Build.VERSION.SDK_INT < 28) {
                        bitmap = MediaStore.Images
                            .Media.getBitmap(context.contentResolver,it)

                    } else {
                        val source = ImageDecoder
                            .createSource(context.contentResolver,it)
                        bitmap = ImageDecoder.decodeBitmap(source)
                    }

                    bitmap?.let {  btm ->
                        Image(bitmap = btm.asImageBitmap(),
                            contentDescription =null,
                            modifier = Modifier.size(50.dp))
                    }
                }
            }

            Button(onClick = {
                onSubmit(image, bitmap, title, description, genre, synopsis)
                title = ""
                description = ""
            }) {
                Text("Submit")
            }
        }
    }
}

@Composable
fun MyFormItemUser(
    index: Int,
    viewModel: MainActivityViewModel,
    setFormVisible: (Boolean) -> Unit,
    onSubmit: (String, String) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text("Title:")
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            )

            Text("Description:")
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        onSubmit(title, description)
                        title = ""
                        description = ""
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Submit")
                }

                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = {
                        viewModel.deleteCurrentDataListUser(index)
                        setFormVisible(false)
                    }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = Color.Red
                        )
                    }
                    if(viewModel.getIndexDataListUser(index).isFavorite) {
                        IconButton(onClick = {
                            viewModel.setFavoriteUser(index)
                        }) {
                            Icon(Icons.Outlined.Favorite, contentDescription = "Favorite", tint =  Color.Red)
                        }
                    } else {
                        IconButton(onClick = {
                            viewModel.setFavoriteUser(index)
                        }) {
                            Icon(Icons.Outlined.Favorite, contentDescription = "Favorite")
                        }
                    }

                }
            }
        }
    }
}
@Composable
fun MyFormItem(
    index: Int,
    viewModel: MainActivityViewModel,
    setFormVisible: (Boolean) -> Unit,
    onSubmit: (String, String) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text("Title:")
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            )

            Text("Description:")
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        onSubmit(title, description)
                        title = ""
                        description = ""
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Submit")
                }

                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = {
                        viewModel.deleteCurrentDataList(index)
                        setFormVisible(false)
                    }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = Color.Red
                        )
                    }
                    if(viewModel.getIndexDataList(index).isFavorite) {
                        IconButton(onClick = {
                            viewModel.setFavorite(index)
                        }) {
                            Icon(Icons.Outlined.Favorite, contentDescription = "Favorite", tint =  Color.Red)
                        }
                    } else {
                        IconButton(onClick = {
                            viewModel.setFavorite(index)
                        }) {
                            Icon(Icons.Outlined.Favorite, contentDescription = "Favorite")
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun ListItemUri(
    item: ItemListURI,
    color: Color,
    viewModel : MainActivityViewModel,
    index: Int,
    onClick: () -> Unit,) {
    val (isFormVisible, setFormVisible) = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            item.image.let {
                item.bitmap?.let {  btm ->
                    Image(bitmap = btm.asImageBitmap(),
                        contentDescription = item.title,
                        modifier = Modifier.size(150.dp))
                }
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = item.description,
                    fontSize = 16.sp,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                )
            }
            IconButton(
                onClick = {
                    setFormVisible(!isFormVisible)
                },
                modifier = Modifier
                    .padding(8.dp),
            ) {
                Icon(Icons.Default.Edit, contentDescription = "About")
            }
        }
    }

    if (isFormVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp)
                .clickable {
                    setFormVisible(false)
                }, // consume click events
            contentAlignment = Alignment.Center
        ) {
            MyFormItemUser(
                index = index,
                viewModel = viewModel,
                setFormVisible,
                onSubmit = { title, description ->
                    if (title.isEmpty() && description.isEmpty()) {
                        Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.editCurrentDataListUser(index, title, description)
                        setFormVisible(false)
                    }
                })
        }
    }
}

@Composable
fun ListItem(
    item: ItemList,
    color: Color,
    viewModel : MainActivityViewModel,
    index: Int,
    onClick: () -> Unit,) {
    val (isFormVisible, setFormVisible) = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.title,
                modifier = Modifier
                    .size(150.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = item.description,
                    fontSize = 16.sp,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                )
            }
            IconButton(
                onClick = {
                    setFormVisible(!isFormVisible)
                },
                modifier = Modifier
                    .padding(8.dp),
            ) {
                Icon(Icons.Default.Edit, contentDescription = "About")
            }
        }
    }

    if (isFormVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp)
                .clickable {
                    setFormVisible(false)
                }, // consume click events
            contentAlignment = Alignment.Center
        ) {
            MyFormItem(
                index = index,
                viewModel = viewModel,
                setFormVisible,
                onSubmit = { title, description ->
                    if (title.isEmpty() && description.isEmpty()) {
                        Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.editCurrentDataList(index, title, description)
                        setFormVisible(false)
                    }
            })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    navController: NavHostController,
    searchText: String,
    favorite: Boolean,
    setFavorite: (Boolean) -> Unit,
    onSearchTextChange: (String) -> Unit) {
    val isSearchVisible = remember { mutableStateOf(false) }

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = { Text(text = "Compose Komik") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),

        ),
        actions = {
            Row(
                modifier = Modifier
                    .padding(end = 8.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (isSearchVisible.value) {
                TextField(
                    value = searchText,
                    onValueChange = onSearchTextChange,
                    modifier = Modifier
                        .weight(1f)
                        .clickable(
                            onClick = { },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    placeholder = { Text("Search") },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    maxLines = 1,)
                } else {
                    IconButton(
                        onClick = { isSearchVisible.value = true },
                        modifier = Modifier.weight(1f, fill = false)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
                if(favorite) {
                    IconButton(
                        onClick = {
                        setFavorite(!favorite)
                    }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Red)
                    }
                } else {
                    IconButton(
                        onClick = {
                        setFavorite(!favorite)
                    }) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                    }
                }

                IconButton(onClick = { navController.navigate("about") }) {
                    Icon(Icons.Default.Person, contentDescription = "About")
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeSubmissionTheme {
        val navController = rememberNavController()
        val viewModel = MainActivityViewModel()
        NavGraph(navController = navController, viewModel = viewModel)
        ListScreen(navController = navController, viewModel = viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun MyFormItemPreview() {
    ComposeSubmissionTheme {
        MyFormItem(
            index = 0,
            viewModel = MainActivityViewModel(),
            setFormVisible = {},
            onSubmit = { title, description -> }
        )
    }
}
@Composable
fun NavGraph(navController: NavHostController, viewModel: MainActivityViewModel ?= null) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ListScreen(navController, viewModel ?: MainActivityViewModel())
        }

        composable(
            "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            if (viewModel != null) {
                DetailScreenUser(item = viewModel.getIdDataList(id), navController = navController)
            }
        }

        composable(
            "detailUser/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            if (viewModel != null) {
                DetailScreenUserUri(item = viewModel.getIdDataListUser(id), navController = navController)
            }
        }

        composable("about") {
            AboutScreen(navController = navController)
        }
    }
}
