package com.eespinor.composeanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eespinor.composeanimation.ui.theme.ComposeAnimationTheme

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
//ANIMATION 1
                    var isVisible by remember {
                        mutableStateOf(false)
                    }
//
//                    var isRound by remember {
//                        mutableStateOf(false)
//                    }
//
//                    val transition = updateTransition(
//                        targetState = isRound,
//                        label = null
//                    )
//
//                    val borderRadius by transition.animateInt(
//                        transitionSpec = { tween(2000) },
//                        label = "borderRadius",
//                        targetValueByState = { isRound ->
//                            if (isRound) 100 else 0
//                        }
//                    )
//
//                    val color by transition.animateColor(
//                        transitionSpec = { tween(1000) },
//                        label = "color",
//                        targetValueByState = { isRound ->
//                            if (isRound) Color.Green else Color.Blue
//                        }
//                    )

//ANIMATION 2
//                    val borderRadius by animateIntAsState(
//                        targetValue = if(isRound) 40 else 20,
//                        animationSpec = tween(
//                            durationMillis = 3000,
//                            delayMillis = 50
//                        ),
////                        animationSpec = spring(
////                            dampingRatio = Spring.DampingRatioHighBouncy,
////                            stiffness = Spring.StiffnessVeryLow
////                        ),
//
//                        label = ""
//                    )

                    Button(onClick = {
                        isVisible = !isVisible
                        // isRound = !isRound
                    }) {
                        Text(text = "Toggle ")
                    }
                    //ANIMATION 3
//                    val transition = rememberInfiniteTransition()
//                    val color by transition.animateColor(
//                        initialValue = Color.Blue,
//                        targetValue = Color.Green,
//                        animationSpec = infiniteRepeatable(
//                            animation = tween(2000),
//                            repeatMode = RepeatMode.Reverse
//                        ),
//                        label = "color"
//                    )
//
//
//                    Box(
//                        modifier = Modifier
//                            .size(200.dp)
//                            .background(color)
//                    )

//                    AnimatedVisibility(
//                        visible = isVisible,
//                        enter = fadeIn() + expandHorizontally(),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                    ) {
//                        Box(modifier = Modifier.background(Color.Red))
//                    }

                    AnimatedContent(
                        targetState = isVisible,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        content = { isVisible ->
                            if (isVisible) {
                                Box(modifier = Modifier.background(Color.Green))
                            } else {
                                Box(modifier = Modifier.background(Color.Red))
                            }

                        }, label = "",
                        transitionSpec = {
                            //    fadeIn() with fadeOut()
                            slideInHorizontally(
                                initialOffsetX = {
//                                    -it
                                    if (isVisible) it else -it
                                }
                            ) with slideOutHorizontally(
                                targetOffsetX = {
//                                    it
                                    if (isVisible) -it else it
                                }
                            )

                        }
                    )
                }
            }
        }
    }
}
