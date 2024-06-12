package ru.asmelnikov.profile.presentation.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileImage(
    isPhotoUploading: Boolean,
    profileImage: String,
    onSaveProfileImage: (Uri?) -> Unit,
) {
    var uri by remember {
        mutableStateOf<Uri?>(null)
    }
    val image = if (uri != null) uri.toString() else profileImage
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            uri = it
            onSaveProfileImage(it)
        }
    )
    Column {
        Box(modifier = Modifier.size(150.dp)) {
            AsyncImage(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center),
                model = image, contentDescription = "Profile Image",
                contentScale = ContentScale.Crop
            )

            if (isPhotoUploading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(28.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    strokeWidth = 3.dp
                )
            } else {
                IconButton(
                    modifier = Modifier.align(
                        Alignment.BottomEnd
                    ),
                    onClick = {
                        photoPicker.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Icon",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }

            }
        }
    }
}