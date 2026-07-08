package de.feuerwehrbiebertal.app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import de.feuerwehrbiebertal.app.R
import de.feuerwehrbiebertal.app.ui.screens.EinsatzberichtDetailScreen
import de.feuerwehrbiebertal.app.ui.screens.EinsatzberichteListScreen
import de.feuerwehrbiebertal.app.ui.screens.FahrzeugDetailScreen
import de.feuerwehrbiebertal.app.ui.screens.FahrzeugeScreen
import de.feuerwehrbiebertal.app.ui.screens.HomeScreen
import de.feuerwehrbiebertal.app.ui.screens.KontaktScreen
import de.feuerwehrbiebertal.app.ui.screens.NewsDetailScreen
import de.feuerwehrbiebertal.app.ui.screens.NewsListScreen
import de.feuerwehrbiebertal.app.ui.screens.SchutzbereichDetailScreen

private data class BottomTab(
    val route: String,
    val label: String,
    val icon: @Composable () -> Unit
)

private val bottomTabs = listOf(
    BottomTab(Routes.HOME, "Start") { Icon(Icons.Filled.Home, contentDescription = "Start") },
    BottomTab(Routes.NEWS_GRAPH, "Meldungen") { Icon(Icons.Filled.Newspaper, contentDescription = "Meldungen") },
    BottomTab(Routes.EINSAETZE_GRAPH, "Einsätze") { Icon(Icons.Filled.LocalFireDepartment, contentDescription = "Einsätze") },
    BottomTab(Routes.FAHRZEUGE_GRAPH, "Fahrzeuge") {
        Icon(painterResource(id = R.drawable.ic_fire_truck), contentDescription = "Fahrzeuge")
    },
    BottomTab(Routes.KONTAKT, "Kontakt") { Icon(Icons.Filled.Phone, contentDescription = "Kontakt") }
)

object Routes {
    const val HOME = "home"

    const val NEWS_GRAPH = "news_graph"
    const val NEWS_LIST = "news"
    const val NEWS_DETAIL = "news/{slug}"

    const val EINSAETZE_GRAPH = "einsaetze_graph"
    const val EINSAETZE_LIST = "einsaetze"
    const val EINSAETZE_DETAIL = "einsaetze/{slug}"

    const val FAHRZEUGE_GRAPH = "fahrzeuge_graph"
    const val FAHRZEUGE_LIST = "fahrzeuge"
    const val FAHRZEUG_DETAIL = "fahrzeuge/{slug}"
    const val SCHUTZBEREICH_DETAIL = "schutzbereiche/{slug}"

    const val KONTAKT = "kontakt"
}

@Composable
fun FeuerwehrBiebertalApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                bottomTabs.forEach { tab ->
                    val selected = currentDestination?.hierarchy?.any { it.route == tab.route } == true
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = tab.icon,
                        label = { Text(tab.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.HOME) {
                HomeScreen(
                    onNewsClick = { slug -> navController.navigate("news/$slug") },
                    onAlleMeldungenClick = {
                        navController.navigate(Routes.NEWS_GRAPH) {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }

            navigation(startDestination = Routes.NEWS_LIST, route = Routes.NEWS_GRAPH) {
                composable(Routes.NEWS_LIST) {
                    NewsListScreen(onNewsClick = { slug -> navController.navigate("news/$slug") })
                }
                composable(
                    Routes.NEWS_DETAIL,
                    arguments = listOf(navArgument("slug") { type = NavType.StringType })
                ) { backStackEntry ->
                    val slug = backStackEntry.arguments?.getString("slug").orEmpty()
                    NewsDetailScreen(slug = slug, onBack = { navController.popBackStack() })
                }
            }

            navigation(startDestination = Routes.EINSAETZE_LIST, route = Routes.EINSAETZE_GRAPH) {
                composable(Routes.EINSAETZE_LIST) {
                    EinsatzberichteListScreen(onItemClick = { slug -> navController.navigate("einsaetze/$slug") })
                }
                composable(
                    Routes.EINSAETZE_DETAIL,
                    arguments = listOf(navArgument("slug") { type = NavType.StringType })
                ) { backStackEntry ->
                    val slug = backStackEntry.arguments?.getString("slug").orEmpty()
                    EinsatzberichtDetailScreen(slug = slug, onBack = { navController.popBackStack() })
                }
            }

            navigation(startDestination = Routes.FAHRZEUGE_LIST, route = Routes.FAHRZEUGE_GRAPH) {
                composable(Routes.FAHRZEUGE_LIST) {
                    FahrzeugeScreen(
                        onFahrzeugClick = { slug -> navController.navigate("fahrzeuge/$slug") },
                        onSchutzbereichClick = { slug -> navController.navigate("schutzbereiche/$slug") }
                    )
                }
                composable(
                    Routes.FAHRZEUG_DETAIL,
                    arguments = listOf(navArgument("slug") { type = NavType.StringType })
                ) { backStackEntry ->
                    val slug = backStackEntry.arguments?.getString("slug").orEmpty()
                    FahrzeugDetailScreen(slug = slug, onBack = { navController.popBackStack() })
                }
                composable(
                    Routes.SCHUTZBEREICH_DETAIL,
                    arguments = listOf(navArgument("slug") { type = NavType.StringType })
                ) { backStackEntry ->
                    val slug = backStackEntry.arguments?.getString("slug").orEmpty()
                    SchutzbereichDetailScreen(slug = slug, onBack = { navController.popBackStack() })
                }
            }

            composable(Routes.KONTAKT) {
                KontaktScreen()
            }
        }
    }
}
