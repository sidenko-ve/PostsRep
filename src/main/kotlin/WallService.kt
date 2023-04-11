import dataClasses.Post

object WallService {

    var posts: Array<Post> = emptyArray()

    fun add(post: Post): Post {
        if (posts.size < 1) {
            post.id = 1
        } else post.id = posts.last().id + 1
        posts.plus(post)
        return post
    }

    fun update(post: Post): Boolean {

        var isUpdate = false

        for (n in 0..posts.lastIndex) {
            if (posts[n].id == post.id) {
                posts.set(n, post)
                isUpdate = true
            }
        }
        return isUpdate
    }

    fun clear() {
        posts = emptyArray()
    }
}