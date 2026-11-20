package com.raja.fans

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.raja.fans.ui.MatchesScreen
import com.raja.fans.ui.NewsScreen
import com.raja.fans.ui.RajaTheme
import com.raja.fans.ui.SquadScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RajaTheme {
                // اتجاه الواجهة من اليمين إلى اليسار للعربية
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    RajaApp()
                }
            }
        }
    }
}

private data class Tab(val title: String, val icon: ImageVector)

private val tabs = listOf(
    Tab("الأخبار", Icons.Filled.Home),
    Tab("المباريات", Icons.Filled.SportsSoccer),
    Tab("التشكيلة", Icons.Filled.Groups),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RajaApp() {
    var selected by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("الرجاء البيضاوي") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
            )
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, tab ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = { selected = index },
                        icon = { Icon(tab.icon, contentDescription = tab.title) },
                        label = { Text(tab.title) },
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        val modifier = Modifier.padding(padding)
        when (selected) {
            0 -> NewsScreen(modifier)
            1 -> MatchesScreen(modifier)
            else -> SquadScreen(modifier)
        }
    }
}
