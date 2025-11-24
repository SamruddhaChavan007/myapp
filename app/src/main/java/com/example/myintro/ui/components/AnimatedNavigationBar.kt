package com.example.myintro.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateIntOffset
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myintro.datamodels.BottomDestination

@Composable
fun AnimatedNavigationBar(
    navController: NavHostController,
    items: List<BottomDestination>,
    barColor: Color = Color.White,
    circleColor: Color = Color.White,
    selectedColor: Color = Color.Black,
    unselectedColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    circleRadius: Dp = 26.dp,
    cornerRadius: Dp = 25.dp,
    modifier: Modifier = Modifier
) {
    // Derive selected index from the back stack
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route ?: items.first().route
    val selectedIndex = items.indexOfFirst { it.route == currentRoute }.coerceAtLeast(0)

    var barSize by remember { mutableStateOf(IntSize(0, 0)) }

    // Center offset for Arrangement.SpaceAround
    val offsetStep = remember(barSize, items) {
        if (barSize.width == 0) 0f else barSize.width.toFloat() / (items.size * 2)
    }
    val targetOffset = remember(selectedIndex, offsetStep) {
        if (offsetStep == 0f) 0f else offsetStep + selectedIndex * 2 * offsetStep
    }

    val circlePx = with(LocalDensity.current) { circleRadius.toPx().toInt() }
    val transition = updateTransition(targetState = targetOffset, label = "cutout-offset")
    val springSpec = spring<Float>(dampingRatio = 0.5f, stiffness = Spring.StiffnessVeryLow)

    val cutoutOffset by transition.animateFloat(
        transitionSpec = { if (initialState == 0f) snap() else springSpec },
        label = "cutout"
    ) { it }

    val circleOffset by transition.animateIntOffset(
        transitionSpec = {
            if (initialState == 0f) snap()
            else spring(springSpec.dampingRatio, springSpec.stiffness)
        },
        label = "circle"
    ) { IntOffset(it.toInt() - circlePx, -circlePx) }

    val barShape = remember(cutoutOffset, circleRadius, cornerRadius) {
        BarShape(offset = cutoutOffset, circleRadius = circleRadius, cornerRadius = cornerRadius)
    }

    Box(modifier = modifier) {
        // Floating selected circle
        Circle(
            modifier = Modifier
                .offset { circleOffset }
                .zIndex(1f),
            color = circleColor,
            radius = circleRadius,
            button = items[selectedIndex],
            iconColor = selectedColor
        )

        // Bar with cutout
        Row(
            modifier = Modifier
                .onPlaced { barSize = it.size }
                .fillMaxWidth()
                .height(78.dp)
                .background(barColor.copy(alpha = 0.6f), shape = barShape)
                .animateContentSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = index == selectedIndex
                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        val alpha = if (isSelected) 0f else 1f
                        Icon(item.icon, item.label, modifier = Modifier.alpha(alpha))
                    },
                    label = { Text(item.label) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = selectedColor,
                        selectedTextColor = selectedColor,
                        unselectedIconColor = unselectedColor,
                        unselectedTextColor = unselectedColor,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

// ---------- Internal bits (shape & circle) ----------

private class BarShape(
    private val offset: Float,
    private val circleRadius: Dp,
    private val cornerRadius: Dp,
    private val circleGap: Dp = 5.dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(getPath(size, density))
    }

    private fun getPath(size: Size, density: Density): Path {
        val cutoutCenterX = offset
        val cutoutRadius = density.run { (circleRadius + circleGap).toPx() }
        val cornerRadiusPx = density.run { cornerRadius.toPx() }
        val cornerDiameter = cornerRadiusPx * 2

        return Path().apply {
            val cutoutEdgeOffset = cutoutRadius * 1.5f
            val cutoutLeftX = cutoutCenterX - cutoutEdgeOffset
            val cutoutRightX = cutoutCenterX + cutoutEdgeOffset

            // bottom left
            moveTo(0f, size.height)
            // top left corner (respect overlap with cutout)
            if (cutoutLeftX > 0) {
                val realLeftCornerDiameter =
                    if (cutoutLeftX >= cornerRadiusPx) cornerDiameter else cutoutLeftX * 2
                arcTo(
                    rect = Rect(0f, 0f, realLeftCornerDiameter, realLeftCornerDiameter),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
            }
            lineTo(cutoutLeftX, 0f)
            // cutout
            cubicTo(
                cutoutCenterX - cutoutRadius, 0f,
                cutoutCenterX - cutoutRadius, cutoutRadius,
                cutoutCenterX, cutoutRadius
            )
            cubicTo(
                cutoutCenterX + cutoutRadius, cutoutRadius,
                cutoutCenterX + cutoutRadius, 0f,
                cutoutRightX, 0f
            )
            // top right corner
            if (cutoutRightX < size.width) {
                val realRightCornerDiameter =
                    if (cutoutRightX <= size.width - cornerRadiusPx) cornerDiameter
                    else (size.width - cutoutRightX) * 2
                arcTo(
                    rect = Rect(
                        size.width - realRightCornerDiameter, 0f,
                        size.width, realRightCornerDiameter
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
            }
            // bottom right
            lineTo(size.width, size.height)
            close()
        }
    }
}

@Composable
private fun Circle(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    radius: Dp,
    button: BottomDestination,
    iconColor: Color,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(radius * 2)
            .clip(CircleShape)
            .background(color.copy(alpha = 0.8f)),
    ) {
        AnimatedContent(targetState = button.icon, label = "circle-icon") { targetIcon ->
            Icon(targetIcon, button.label, tint = iconColor)
        }
    }
}