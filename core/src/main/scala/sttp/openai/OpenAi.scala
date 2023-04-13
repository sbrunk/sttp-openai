package sttp.openai

import sttp.client4._
import sttp.model.Uri
import sttp.openai.requests.models.ModelsGetResponseData.ModelsResponse
import sttp.openai.json.SttpUpickleApiExtension.asJsonSnake
import sttp.openai.requests.fineTunes.FineTunesResponseData.FineTunesResponse

class OpenAi(authToken: String) {

  /** Fetches all available models from [[https://platform.openai.com/docs/api-reference/models]] */
  def getModels: Request[Either[ResponseException[String, Exception], ModelsResponse]] =
    openApiAuthRequest
      .get(OpenAIEndpoints.ModelEndpoint)
      .response(asJsonSnake[ModelsResponse])
  def getFineTunes: Request[Either[ResponseException[String, Exception], FineTunesResponse]] =
    openApiAuthRequest
      .get(OpenAIEndpoints.FineTunesEndpoint)
      .response(asJsonSnake[FineTunesResponse])

  private val openApiAuthRequest: PartialRequest[Either[String, String]] = basicRequest.auth
    .bearer(authToken)
}

private object OpenAIEndpoints {
  val ModelEndpoint: Uri = uri"https://api.openai.com/v1/models"
  val FineTunesEndpoint: Uri = uri"https://api.openai.com/v1/fine-tunes"
}
