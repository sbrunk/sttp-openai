package sttp.openai

import sttp.client4._
import sttp.openai.requests.fineTunes.FineTunesResponseData.FineTunesResponse

object Main extends App {
  val backend: SyncBackend = DefaultSyncBackend()

  val openAi: OpenAi = new OpenAi("test")
  val response: Response[Either[ResponseException[String, Exception], FineTunesResponse]] =
    openAi.getFineTunes.send(backend)


  println(response.code)
  println(response.body)

}
