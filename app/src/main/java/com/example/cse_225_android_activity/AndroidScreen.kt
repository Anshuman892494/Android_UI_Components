package com.example.cse_225_android_activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.statusBarsPadding

// Colors
val SoftGreenBg = Color(0xFFE8F5E9)
val DarkGreenHeader = Color(0xFF388E3C)

@Composable
fun AndroidComponentsScreen() {

    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("Languages") }

    val categories = listOf("Languages", "Frameworks", "Databases")

    val languages = listOf(
        "Java",
        "Kotlin",
        "Python",
        "C++",
        "JavaScript"
    )

    val technologies = listOf(
        "Android",
        "Flutter",
        "React",
        "Firebase",
        "MongoDB",
        "NodeJS"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFA5D6A7), Color.White)
                )
            )
    ) {

        Column {

            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkGreenHeader)
                    .statusBarsPadding()
                    .padding(16.dp)
            ) {

                Text(
                    text = "CSE 225 - Android UI Components",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Column(modifier = Modifier.padding(16.dp)) {

                // Dropdown
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {

                    Box {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text("Select Category")

                            IconButton(onClick = { expanded = true }) {
                                Icon(Icons.Default.ArrowDropDown, null)
                            }
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {

                            categories.forEach { category ->

                                DropdownMenuItem(
                                    text = { Text(category) },
                                    trailingIcon = {
                                        if (category == selectedCategory) {
                                            Icon(
                                                Icons.Default.Check,
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onClick = {
                                        selectedCategory = category
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Programming Languages
                Text(
                    "Programming Languages",
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    shape = RoundedCornerShape(12.dp)
                ) {

                    Column {

                        languages.forEach { lang ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text("• ", fontSize = 18.sp)
                                Text(lang)
                            }

                            Divider()
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Technology Grid
                Text(
                    "Technology Grid",
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.fillMaxHeight(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(technologies) { tech ->

                        Card(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.aspectRatio(1f)
                        ) {

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {

                                Box(
                                    modifier = Modifier
                                        .size(45.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(SoftGreenBg),
                                    contentAlignment = Alignment.Center
                                ) {

                                    val logo = when (tech) {
                                        "Android" -> R.drawable.android_logo
                                        "Flutter" -> R.drawable.flutter_logo
                                        "React" -> R.drawable.react_logo
                                        "Firebase" -> R.drawable.firebase_logo
                                        "MongoDB" -> R.drawable.mongodb_logo
                                        "NodeJS" -> R.drawable.nodejs_logo
                                        else -> R.drawable.android_logo
                                    }

                                    Image(
                                        painter = painterResource(id = logo),
                                        contentDescription = tech,
                                        modifier = Modifier.size(28.dp),
                                        contentScale = ContentScale.Fit
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    tech,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}