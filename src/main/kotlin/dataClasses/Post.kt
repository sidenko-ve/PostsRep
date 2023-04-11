package dataClasses

import Attachments

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    var text: String,
    val replyOwnerId: Int?,
    val replyPostId: Int,
    var friendsOnly: Boolean = false,
    var comments: Comments,
    var copyright: Copyright?,
    var like: Likes,
    var reposts: Reposts?,
    var views: Views?,
    var postType: String,
    var attachments: Array<Attachments>,
    var geo: Geo?,
    val signerId: Int,
    var copyHistory: Array<Post>?,
    var canPin: Boolean = true,
    var canDelete: Boolean = true,
    var canEdit: Boolean = true,
    var isPinned: Boolean = false,
    var markAsAds: Boolean = false,
    var isFavorite: Boolean = false,
    var donut: Donut?,
    var postponedId: Int
)

//Объект WallService, который хранит посты в массиве.