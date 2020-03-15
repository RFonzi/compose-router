package com.example.lifelike.composable.loggedin

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.toModifier
import androidx.ui.foundation.Box
import androidx.ui.graphics.Color
import androidx.ui.graphics.painter.ImagePainter
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.res.loadImageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.lifelike.R
import com.example.lifelike.entity.Photo


interface FullScreenPhoto {

    companion object {
        @Composable
        fun Content(photo: Photo) {
            val image = loadImageResource(R.drawable.placeholder)
            val typography = MaterialTheme.typography()

            Surface(color = Color.DarkGray) {
                Container(modifier = LayoutPadding(32.dp)) {
                    Column {
                        Container(modifier = LayoutFlexible(0.8f), expanded = true) {
                            image.resource.resource?.let {
                                Box(modifier = LayoutHeight.Fill + LayoutWidth.Fill + ImagePainter(it).toModifier())
                            }
                        }

                        Spacer(modifier = LayoutHeight(32.dp))
                        Text(
                            text = photo.title,
                            style = typography.subtitle1.copy(
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun FullScreenPhotoPreview() {
    FullScreenPhoto.Content(Photo(167))
}
