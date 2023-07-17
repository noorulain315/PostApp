package com.example.post.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.core.utils.*
import com.example.data.models.State
import com.example.data.models.ui.CommentUiModel
import com.example.data.models.remote.UserUiModel
import com.example.post.R
import com.example.post.ui.viewmodels.PostDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : Fragment() {

    private val args: PostDetailsFragmentArgs by navArgs()
    private val postDetailsViewModel: PostDetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(color = MaterialTheme.colors.background) {
                    PostDetailsContent()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAuthorName()
        getCommentsCount()
    }


    private fun getAuthorName() {
        if (postDetailsViewModel.userState !is State.Success) {
            postDetailsViewModel.getPostUserName(args.post.userId)
        }
    }

    private fun getCommentsCount() {
        if (postDetailsViewModel.commentState !is State.Success) {
            postDetailsViewModel.getPostCommentsCount(args.post.id)
        }
    }

    @Composable
    fun PostDetailsContent() {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(FOUR.dp)
        ) {

            Card(
                modifier = Modifier
                    .padding(EIGHT.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                shape = RectangleShape,
                elevation = TWO.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(SIXTEEN.dp)
                        .background(MaterialTheme.colors.surface)
                ) {
                    Text(
                        text = args.post.title,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onSecondary,
                        fontSize = FOURTY.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = SIXTEEN.dp),
                        text = args.post.body,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        fontSize = TWENTY.sp
                    )

                    AuthorInfoContainer()
                    CommentsInfoContainer()
                }

            }
        }
    }

    @Composable
    fun LoadingView() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SIXTEEN.dp)
        ) {
            CircularProgressIndicator()
        }
    }

    @Composable
    fun ErrorView(message: String, onViewClick: () -> Unit) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = message, fontWeight = FontWeight.Bold)
            Button(
                onClick = {
                    onViewClick()
                },
                modifier = Modifier.padding(top = TWELVE.dp),
                enabled = true,
                shape = MaterialTheme.shapes.medium,
            )
            {
                Text(text = getString(R.string.retry), color = Color.White)
            }
        }
    }

    @Composable
    fun AuthorInfoContainer() {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(FIVE.dp)
        ) {
            when (val userState = postDetailsViewModel.userState) {
                is State.Loading -> LoadingView()
                is State.Error -> ErrorView(userState.message) { getAuthorName() }
                is State.Success -> AuthorInfoView(userState.data)
            }
        }
    }

    @Composable
    fun AuthorInfoView(userUiModel: UserUiModel) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SIXTEEN.dp)
        ) {
            Text(
                text = userUiModel.name,
                color = MaterialTheme.colors.onSecondary,
                fontSize = SIXTEEN.sp
            )
        }
    }

    @Composable
    fun CommentsInfoContainer() {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(FIVE.dp)
        ) {
            when (val commentState = postDetailsViewModel.commentState) {
                is State.Loading -> LoadingView()
                is State.Error -> ErrorView(commentState.message) { getCommentsCount() }
                is State.Success -> CommentsInfoView(commentState.data)
            }
        }
    }

    @Composable
    fun CommentsInfoView(commentUiModel: CommentUiModel) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SIXTEEN.dp)
        ) {
            Text(
                text = getString(R.string.comment),
                color = MaterialTheme.colors.onSecondary,
                fontSize = SIXTEEN.sp
            )

            Text(
                modifier = Modifier.padding(start = FOUR.dp),
                text = commentUiModel.count,
                color = MaterialTheme.colors.onSecondary,
                fontSize = SIXTEEN.sp
            )
        }
    }
}