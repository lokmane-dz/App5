package me.lokmvne.app5.presentation.Screens

import android.content.Context
import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import me.lokmvne.app5.presentation.MainViewModel

@Composable
fun GetProductInfoScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    context: Context,
    lifecycleScope: LifecycleCoroutineScope
) {
    val roundedCornerValue = 40.dp
    val lifecycleOwner = LocalLifecycleOwner.current
    val mainViewModel = hiltViewModel<MainViewModel>()
    val barcodes = mainViewModel.barcodes.collectAsState()
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE
            )
            imageCaptureMode = ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY
            imageCaptureFlashMode = ImageCapture.FLASH_MODE_OFF
            cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        }
    }

    val previewView = PreviewView(context).apply {
        this.controller = controller
        controller.bindToLifecycle(lifecycleOwner)
    }.apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(100.dp)
                .border(
                    2.dp,
                    MaterialTheme.colorScheme.tertiary,
                    RoundedCornerShape(roundedCornerValue)
                )
        ) {
            AndroidView(
                factory = {
                    previewView
                },
                modifier = modifier.clip(RoundedCornerShape(roundedCornerValue))
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                onClick = {
                    lifecycleScope.launch {
                        mainViewModel.takePhoto(
                            controller = controller,
                            onPhotoTaken = { mainViewModel.onTakePhoto(it) },
                            context = context
                        )
                    }
                }
            ) {
                Text(text = "Scan")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                onClick = {
                    mainViewModel.reset()
                }
            ) {
                Text(text = "Reset")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            items(barcodes.value) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "" + it.displayValue)
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(modifier = Modifier.padding(horizontal = 20.dp))
            }
        }
    }
}