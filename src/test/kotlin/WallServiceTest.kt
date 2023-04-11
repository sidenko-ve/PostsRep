import dataClasses.Comments
import dataClasses.Likes
import dataClasses.Post
import dataClasses.Reposts
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class WallServiceTest {

    @BeforeEach
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val comment = Comments(
            5
        )
        val like = Likes(5, true, true, true)
        val reposts = Reposts(5, true)
        val photo = Photo(1,1,"somePhoto")
        val video = Video(12,1,"videoTitle", 50)
        val attachm = arrayOf(photo,video)
        val post = Post(
            0,
            1,
            1,
            1,
            1122,
            "text",
            1,
            1,
            comments = comment,
            like = like,
            reposts = reposts,
            postType = "",
            signerId = 2,
            postponedId = 1,
            attachments = attachm,
            copyHistory = emptyArray(),
            copyright = null,
            donut = null,
            geo = null,
            views = null
        )

        WallService.add(post)
        assertTrue(post.id != 0)
    }

    @Test
    fun updateWithExistId() {
        val comment = Comments(
            5
        )
        val like = Likes(5, true, true, true)
        val reposts = Reposts(5, true)
        val post = Post(
            123,
            1,
            1,
            1,
            1122,
            "text",
            1,
            1,
            comments = comment,
            like = like,
            reposts = reposts,
            postType = "",
            signerId = 2,
            postponedId = 1,
            attachments = emptyArray(),
            copyHistory = emptyArray(),
            copyright = null,
            donut = null,
            geo = null,
            views = null
        )
        WallService.posts = arrayOf(post)
        assertTrue(WallService.update(post))
    }

    @Test
    fun updateWithNotExistId() {
        val comment = Comments(
            5
        )
        val like = Likes(5, true, true, true)
        val reposts = Reposts(5, true)
        val post = Post(
            123,
            1,
            1,
            1,
            1122,
            "text",
            1,
            1,
            comments = comment,
            like = like,
            reposts = reposts,
            postType = "",
            signerId = 2,
            postponedId = 1,
            attachments = emptyArray(),
            copyHistory = emptyArray(),
            copyright = null,
            donut = null,
            geo = null,
            views = null
        )

        val post2 = Post(
            1,
            1,
            1,
            1,
            1122,
            "text",
            1,
            1,
            comments = comment,
            like = like,
            reposts = reposts,
            postType = "",
            signerId = 2,
            postponedId = 1,
            attachments = emptyArray(),
            copyHistory = emptyArray(),
            copyright = null,
            donut = null,
            geo = null,
            views = null
        )
        WallService.posts = arrayOf(post)
        assertFalse(WallService.update(post2))
    }
}