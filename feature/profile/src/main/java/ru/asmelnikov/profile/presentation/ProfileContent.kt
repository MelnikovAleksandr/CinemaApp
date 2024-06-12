package ru.asmelnikov.profile.presentation

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.asmelnikov.domain.models.User
import ru.asmelnikov.profile.presentation.components.ProfileImage

@Composable
fun ProfileContent(
    user: User,
    profileImage: String,
    isPhotoUploading: Boolean,
    onSignOutClick: () -> Unit,
    onSaveProfileImage: (Uri?) -> Unit,
) {
    val context = LocalContext.current
    val versionName = context.packageManager.getPackageInfo(context.packageName, 0).versionName
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage(
            profileImage = profileImage,
            onSaveProfileImage = onSaveProfileImage,
            isPhotoUploading = isPhotoUploading
        )

        user.name?.let { Text(text = it, color = MaterialTheme.colorScheme.onBackground) }
        user.email?.let { Text(text = it, color = MaterialTheme.colorScheme.onBackground) }
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier.size(width = 250.dp, height = 40.dp),
            onClick = onSignOutClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(color = 0xFF1B1B1A),
                contentColor = Color.White
            )
        ) {
            Text(text = "Sign Out")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Ver. $versionName", color = MaterialTheme.colorScheme.onBackground)
    }
}
