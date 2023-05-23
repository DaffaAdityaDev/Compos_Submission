package com.example.composesubmission

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composesubmission.model.ItemList
import com.example.composesubmission.ui.theme.ComposeSubmissionTheme
import com.example.composesubmission.ui.view.AboutScreen
import com.example.composesubmission.ui.view.DetailActivity
import com.example.composesubmission.ui.view.DetailScreen
import com.example.composesubmission.viewmode.MainActivityViewModel
import com.google.android.material.search.SearchBar

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

val dataList = mutableListOf<ItemList>(
    ItemList(R.drawable.ic_launcher_foreground, "Title 1", "Description 1"),
    ItemList(R.drawable.img_2self, "Title 2", "Description 2"),
    ItemList(R.drawable.ic_launcher_foreground, "Title 3", "Description 3"),
)

@Composable
fun ListScreen(navController: NavHostController, viewModel: MainActivityViewModel) {
    val (isFormVisible, setFormVisible) = remember { mutableStateOf(false) }
    val (searchText, setSearchText) = remember { mutableStateOf("") }

    if (viewModel.dataList.value.isEmpty()) {
        viewModel.setDataList(dataList)
    }
    val data by viewModel.dataList.collectAsState()

    val filteredData = data.filter {
        it.title.contains(searchText, ignoreCase = true)
    }

    Log.d("ListScreen", "data: $searchText, $filteredData")

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            MyAppBar(navController, searchText, setSearchText)
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredData.size) { index ->
                    if (index % 2 == 0) {
                        ListItem(item = filteredData[index], MaterialTheme.colorScheme.tertiary, viewModel) {
                            navController.navigate("detail/$index")
                        }
                    } else {
                        ListItem(item = filteredData[index], MaterialTheme.colorScheme.primary, viewModel) {
                            navController.navigate("detail/$index")
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { setFormVisible(!isFormVisible) },
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)
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
                MyForm(onSubmit = { title, description ->
                    viewModel.addFirstDataList(ItemList(R.drawable.ic_launcher_foreground, title, description))
                    setFormVisible(false)
                })
            }
        }
    }
}

@Composable
fun MyForm(onSubmit: (String, String) -> Unit) {
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
            BasicTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )

            Text("Description:")
            BasicTextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )

            Button(onClick = {
                onSubmit(title, description)
                title = ""
                description = ""
            }) {
                Text("Submit")
            }
        }
    }
}

@Composable
fun ListItem(item: ItemList, color: Color, viewModel : MainActivityViewModel, onClick: () -> Unit,) {
    val (isFormVisible, setFormVisible) = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            Column {
                Text(
                    text = item.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = item.description,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
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
                .background(color = Color.Black.copy(alpha = 0.7f))
                .padding(8.dp)
                .clickable {
                    setFormVisible(false)
                }, // consume click events
            contentAlignment = Alignment.Center
        ) {
            MyForm(onSubmit = { title, description ->
                viewModel.editCurrentDataList(item)
                setFormVisible(false)
            })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(navController: NavHostController, searchText: String, onSearchTextChange: (String) -> Unit) {
    val isSearchVisible = remember { mutableStateOf(false) }

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = { Text(text = "Compose Submission") },
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

@Composable
fun NavGraph(navController: NavHostController, viewModel: MainActivityViewModel ?= null) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ListScreen(navController, viewModel ?: MainActivityViewModel())
        }

        composable(
            "detail/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            DetailScreen(item = dataList[index])
        }

        composable("about") {
            AboutScreen(navController = navController)
        }
    }
}
