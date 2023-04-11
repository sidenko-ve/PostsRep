interface Attachments {
    val type: String
}

open class PhotoAttachment : Attachments {

    override val type: String = "Photo"
}

open class VideoAttachment : Attachments {

    override val type: String = "Video"

}

data class Photo(var id: Int, val ownerId: Int, val photo: String) : PhotoAttachment()

data class Video(var id: Int, val ownerId: Int, val title: String, val duration: Int) : VideoAttachment()
