package com.example.post.ui.fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.fragment.findNavController
import com.example.core.utils.*
import com.example.data.models.State
import com.example.data.models.ui.PostUiModel
import com.example.post.R
import com.example.post.ui.viewmodels.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostsFragment : Fragment() {
    private val postsViewModel: PostsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(color = MaterialTheme.colors.background) {
                    PostContent()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllPosts()
    }

    private fun getAllPosts() {
        if (postsViewModel.postsState !is State.Success) {
            postsViewModel.getAllPosts()
        }
    }

    @Composable
    fun PostContent() {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(FIVE.dp)
        ) {
            when (val postState = postsViewModel.postsState) {
                is State.Loading -> LoadingView()
                is State.Error -> ErrorView(postState.message)
                is State.Success -> PostsListView(postState.data)
            }
        }
    }

    @Composable
    fun LoadingView() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }

    @Composable
    fun ErrorView(message: String) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = message, fontWeight = FontWeight.Bold)
            Button(
                onClick = {
                    getAllPosts()
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
    fun PostsListView(posts: List<PostUiModel>) {
        LazyColumn {
            items(posts) { item ->
                Card(
                    modifier = Modifier
                        .padding(EIGHT.dp)
                        .fillMaxWidth()
                        .clickable {
                            showFullPostAlert(item)
                        },
                    shape = RectangleShape,
                    elevation = TWO.dp
                ) {
                    Column(
                        modifier = Modifier
                            .padding(SIXTEEN.dp)
                            .background(MaterialTheme.colors.surface)
                    ) {
                        Text(text = item.title, fontWeight = FontWeight.Bold, fontSize = SIXTEEN.sp)
                    }

                }

            }
        }
    }

    private fun navigateToDetailsScreen(post: PostUiModel) {
        val action = PostsFragmentDirections.actionPostsFragmentToPostDetailsFragment(post)
        findNavController().navigate(action)
    }

    private fun showFullPostAlert(post: PostUiModel) {
        val clickListenerCancel = DialogInterface.OnClickListener { dialog, _ ->
            navigateToDetailsScreen(post)
            dialog.dismiss()
        }
        DialogUtil.getAlertDialog(
            requireContext(),
            R.array.show_full_post_alert,
            clickListenerCancel
        )
            .setCancelable(false)
            .show()
    }
}