package com.example.data.mapper

import com.example.data.models.remote.PostRemote
import com.example.data.models.remote.mappers.PostEntityMapper
import org.junit.Assert
import org.junit.Test

class RemoteToEntityMapperTest {

    @Test
    fun `When post  load successfully`() {
        val postRemote = PostRemote("A good day indeed", 1, "Morning", 2)
        val postEntity = PostEntityMapper().mapToPostEntityModel(postRemote)

        Assert.assertEquals(postEntity.id, postRemote.id)
        Assert.assertEquals(postEntity.body, postRemote.body)
        Assert.assertEquals(postEntity.title, postRemote.title)
        Assert.assertEquals(postEntity.userId, postRemote.userId)

    }
}