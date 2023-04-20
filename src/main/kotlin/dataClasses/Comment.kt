package dataClasses

import Attachments

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    var text: String,
    val replyToUser: Int,
    val replyToComment: Int,
    var attachments: Array<Attachments>
)
