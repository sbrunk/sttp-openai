import org.openapitools.client.api.OpenAIApi
import org.openapitools.client.model.{ChatCompletionRequestMessage, ChatCompletionRequestMessageEnums, CreateAnswerRequest, CreateChatCompletionRequest}
import sttp.client3
import sttp.client3.{HttpClientSyncBackend, Response, ResponseException}

object Main extends App {
  val backend = HttpClientSyncBackend()

  val openAi = OpenAIApi()
//  val request = openAi.listModels().auth.bearer("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")
  val seq: Seq[ChatCompletionRequestMessage] = Seq(
    ChatCompletionRequestMessage(ChatCompletionRequestMessageEnums.Role.User.toString, content = "hello, what's the weather in warsaw today?")
  )
  val request = openAi.createChatCompletion(CreateChatCompletionRequest(model = "gpt-3.5-turbo", seq)).auth.bearer("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")
  val response: client3.Identity[Response[Either[ResponseException[String, Exception, CreateChatCompletionResponse]]] = request.send(backend)
  println(response)
  println(response.body.map(res => res.choices.map(inner => inner.message)))
}
