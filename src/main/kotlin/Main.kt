import kotlinx.browser.document
import react.*
import emotion.react.css
import csstype.Position
import csstype.px
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.img
import react.dom.client.createRoot
import kotlinx.serialization.Serializable

//https://kotlinlang.org/docs/js-react.html#design-app-components CONTINUE HERE
fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find root container!")
    createRoot(container).render(Fragment.create {
        h1 {
            +"KotlinConf Explorer"
        }
        div {
            h3 {
                +"Videos to watch"
            }
            for (video in unwatchedVideos) {
                p {
                    +"${video.speaker}: ${video.title}"
                }
            }
            h3 {
                +"Videos watched"
            }
            for (video in watchedVideos) {
                p {
                    +"${video.speaker}: ${video.title}"
                }
            }
            div {
                css {
                    position = Position.absolute
                    top = 10.px
                    right = 10.px
                }
                h3 {
                    +"John Doe: Building and breaking things"
                }
                img {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
    })
}

data class Video(
    val id: Int, val title: String, val speaker: String, val videoUrl: String
)

val unwatchedVideos = listOf(
    Video(1, "Opening Keynote", "Andrey Breslav", "https://youtu.be/PsaFVLr8t4E"),
    Video(2, "Dissecting the stdlib", "Huyen Tue Dao", "https://youtu.be/Fzt_9I733Yg"),
    Video(3, "Kotlin and Spring Boot", "Nicolas Frankel", "https://youtu.be/pSiZVAeReeg")
)

val watchedVideos = listOf(
    Video(4, "Creating Internal DSLs in Kotlin", "Venkat Subramaniam", "https://youtu.be/JzTeAM8N1-o")
)

