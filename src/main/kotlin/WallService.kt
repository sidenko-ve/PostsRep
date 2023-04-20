import dataClasses.Comment
import dataClasses.Post

object WallService {

    var posts: Array<Post> = emptyArray()

    fun createComment(postId: Int, comment: Comment): Comment {
        var n = 0
        val post: Post? = posts.find { it.id == postId }
        if (post == null) {
            throw PostNotFountException("Не найден пост с id $postId")
        } else {
            val index = posts.indexOf(post)
            val array = arrayOfNulls<Comment>(posts[index].comments.size + 1)
            System.arraycopy(posts[index].comments, 0, array, 0, posts[index].comments.size)
            array[posts[index].comments.size] = comment
            n = index
            posts[n].comments = array.requireNoNulls()
        }
        return posts[n].comments.last()
    }

    fun add(post: Post): Post {
        if (posts.isEmpty()) {
            post.id = 1
        } else post.id = posts.last().id + 1
        val array = arrayOfNulls<Post>(posts.size + 1)
        System.arraycopy(posts, 0, array, 0, posts.size)
        array[posts.size] = post
        posts = array.requireNoNulls()
        return post
    }

    fun update(post: Post): Boolean {

        var isUpdate = false

        for (n in 0..posts.lastIndex) {
            if (posts[n].id == post.id) {
                posts[n] = post
                isUpdate = true
            }
        }
        return isUpdate
    }

    fun clear() {
        posts = emptyArray()
    }
}