interface Attachments {
    val type: String
}

open class PhotoAttachment(val photo: Photo) : Attachments {

    override val type: String = "Photo"
}

open class VideoAttachment(val video: Video) : Attachments {

    override val type: String = "Video"

}

data class Photo(var id: Int, val ownerId: Int, val photo: String)

data class Video(var id: Int, val ownerId: Int, val title: String, val duration: Int)
