import dataClasses.Comment
import dataClasses.Likes
import dataClasses.Post
import dataClasses.Reposts
import org.junit.Test
import org.junit.Before
import org.junit.Assert

class WallServiceTest {

    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test(expected = PostNotFountException::class)
    fun shouldThrow() {
        val comments = emptyArray<Comment>()
        val like = Likes(5, true, true, true)
        val reposts = Reposts(5, true)
        val photo = Photo(1, 1, "somePhoto")
        val video = Video(12, 1, "videoTitle", 50)
        val photoAttachment = PhotoAttachment(photo)
        val videoAttachment = VideoAttachment(video)
        val attachm = arrayOf(photoAttachment, videoAttachment)
        val post = Post(
            0,
            1,
            1,
            1,
            1122,
            "text",
            1,
            1,
            comments = comments,
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

        val comment = Comment(1, 2, 3, "Некий текст", 5, 6, emptyArray())
        WallService.add(post)
        WallService.add(post)
        WallService.createComment(12, comment)
    }

    @Test()
    fun shouldNotThrow() {
        val comments = emptyArray<Comment>()
        val like = Likes(5, true, true, true)
        val reposts = Reposts(5, true)
        val photo = Photo(1, 1, "somePhoto")
        val video = Video(12, 1, "videoTitle", 50)
        val photoAttachment = PhotoAttachment(photo)
        val videoAttachment = VideoAttachment(video)
        val attachm = arrayOf(photoAttachment, videoAttachment)
        val post = Post(
            1,
            1,
            1,
            1,
            1122,
            "text",
            1,
            1,
            comments = comments,
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
        val comment = Comment(1, 2, 3, "Некий текст", 5, 6, emptyArray())
        WallService.add(post)
        WallService.createComment(WallService.posts[WallService.posts.lastIndex].id, comment)
    }

    @Test
    fun add() {
        val comment = emptyArray<Comment>()
        val like = Likes(5, true, true, true)
        val reposts = Reposts(5, true)
        val photo = Photo(1, 1, "somePhoto")
        val video = Video(12, 1, "videoTitle", 50)
        val photoAttachment = PhotoAttachment(photo)
        val videoAttachment = VideoAttachment(video)
        val attachm = arrayOf(photoAttachment, videoAttachment)
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
        Assert.assertTrue(post.id != 0)
    }

    @Test
    fun updateWithExistId() {
        val comment = emptyArray<Comment>()
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
        Assert.assertTrue(WallService.update(post))
    }

    @Test
    fun updateWithNotExistId() {
        val comment = emptyArray<Comment>()
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
        Assert.assertFalse(WallService.update(post2))
    }
}