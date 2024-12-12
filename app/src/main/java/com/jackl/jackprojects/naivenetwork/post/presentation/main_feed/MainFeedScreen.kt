package com.jackl.jackprojects.naivenetwork.post.presentation.main_feed

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Paddings
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Spacers
import com.jackl.jackprojects.naivenetwork.post.domain.models.Post
import com.jackl.jackprojects.naivenetwork.post.presentation.main_feed.components.Post

@Composable
fun MainFeedScreen(

) {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = Paddings.large)
        ) {
            items(10) {
                Post(
                    post = Post(
                        username = "김형석",
                        imageUrl = "",
                        description = "오늘 날씨가 너무 좋아서 밤낮으로 산책을 갔어요.",
                        commentCount = 102
                    ),
                    liked = false,
                    onLikeClicked = { /*TODO*/ },
                    onShareClicked = { /*TODO*/ },
                    onCommentClick = { /*TODO*/ },
                    onClick = { /*TODO*/ }
                )
                Spacer(modifier = Modifier.height(Spacers.medium))
            }
        }
    }
}

@Composable
@PreviewLightDark
fun MainFeedScreenPreview() {
    NaiveNetworkTheme {
        MainFeedScreen()
    }
}