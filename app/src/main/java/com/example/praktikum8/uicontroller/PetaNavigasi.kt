package com.example.praktikum8.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.praktikum8.uicontroller.route.DestinasiEntry
import com.example.praktikum8.uicontroller.route.DestinasiHome
import com.example.praktikum8.view.EntrySiswaScreen
import com.example.praktikum8.view.HomeScreen

@Composable
fun DataSiswaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    HostNavigasi(
        navController = navController,
        modifier = modifier
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { idSiswa ->
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(DestinasiDetail.routeWithArgs,arguments = listOf(navArgument(DestinasiDetail
            .itemIdArg) {
            type = navType.IntType })
        ){
            DetailSiswaScreen(navigateToEditItem = {navController.navigate("${DestinasiEdit.route}/$it")},
                navigateBack = {navController.navigate(DestinasiHome.route) })
        }
        composable(DestinasiEdit.routeWithArgs, arguments = lisOf(navArgument(DestinasiEdit.itemIdArg
        ){
            type = NavType.IntType })) {
            EditSiswaScreen (navigateBack = {navController.navigate(DestinasiHome.route)},
                onNavigateUp ={navController.navigateUp()})
        }
    }
}