package com.jackl.jackprojects.naivenetwork.post.presentation.main_feed.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ModeComment
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import coil.compose.AsyncImage
import com.jackl.jackprojects.naivenetwork.R
import com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components.NaiveIconButton
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Paddings
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Spacers
import com.jackl.jackprojects.naivenetwork.core.util.Constants.POST_DESCRIPTION_MAX_LINE
import com.jackl.jackprojects.naivenetwork.post.domain.models.Post

@Composable
fun Post(
    post: Post,
    liked: Boolean,
    onLikeClicked: () -> Unit,
    onShareClicked: () -> Unit,
    onCommentClick: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge)
            .clickable {
                onClick()
            }
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(MaterialTheme.shapes.extraLarge)
        ) {
            AsyncImage(
                model = post.imageUrl,
                // Todo Loading 이미지로 교체
                placeholder = painterResource(id = R.drawable.bg1),
                contentDescription = stringResource(id = R.string.post_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.extraLarge)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(Paddings.extra),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                NaiveIconButton(
                    icon = if (liked) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = stringResource(id = R.string.favorite),
                    tint = if (liked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                    onClick = onLikeClicked,
                )

                NaiveIconButton(
                    icon = Icons.Outlined.Share,
                    contentDescription = stringResource(id = R.string.share),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    onClick = onShareClicked
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Paddings.large)
                .padding(vertical = Paddings.large)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Paddings.medium),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.username, post.username),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Row {
                    Icon(
                        imageVector = Icons.Outlined.ModeComment,
                        contentDescription = stringResource(id = R.string.comments),
                        modifier = Modifier
                            .clickable {
                                onCommentClick()
                            },
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Spacer(modifier = Modifier.width(Spacers.tiny))
                    Text(
                        text = stringResource(id = R.string.comments_count, post.commentCount),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
            Spacer(modifier = Modifier.height(Spacers.tiny))
            Text(
                text = post.description,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = POST_DESCRIPTION_MAX_LINE,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun PostPreview() {
    NaiveNetworkTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(Paddings.extra)
        ) {
            items(10) {
                Post(
                    post = Post(
                        imageUrl = "imageurl",
                        username = "Jack",
                        commentCount = 43,
                        description = "저번 주말동안 서울 여기저기 놀러다니면서 시간을 보냈어요. 다음에도 또 가고 싶네요. 호호호",
                    ),
                    onClick = {},
                    onShareClicked = {},
                    onLikeClicked = {},
                    onCommentClick = {},
                    liked = true,
                )
                Spacer(modifier = Modifier.height(Spacers.medium))
            }
        }
    }
}
