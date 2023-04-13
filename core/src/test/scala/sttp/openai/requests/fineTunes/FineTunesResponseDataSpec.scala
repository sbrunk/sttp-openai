package sttp.openai.requests.fineTunes

import org.scalatest.EitherValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import sttp.openai.fixtures
import FineTunesResponseData.{Hyperparams, File, FineTunesData, FineTunesResponse}
import FineTunesResponseData.FineTunesResponse._
import sttp.openai.json.SttpUpickleApiExtension

class FineTunesResponseDataSpec extends AnyFlatSpec with Matchers with EitherValues {

  "Given fine-tunes response as Json" should "be properly deserialized to case class" in {
    val response: String = fixtures.FineTunesGetResponse.responseJson

    val hyperparams: Hyperparams = Hyperparams(
      batchSize = 4,
      learningRateMultiplier = 0.1,
      nEpochs = 4,
      promptLossWeight = 0.1
    )

    val resultFile: File = File(
      id = "file-QQm6ZpqdNwAaVC3aSz5sWwLT",
      `object` = "file",
      bytes = 81509,
      createdAt = 1614807863,
      filename = "compiled_results.csv",
      purpose = "fine-tune-results"
    )

    val validationFile: File = File(
      id = "file-id",
      `object` = "file",
      bytes = 1547276,
      createdAt = 1610062281,
      filename = "file-name",
      purpose = "fine-tune-validation"
    )

    val trainingFile: File = File(
      id = "file-XGinujblHPwGLSztz8cPS8XY",
      `object` = "file",
      bytes = 1547276,
      createdAt = 1610062281,
      filename = "my-data-train.jsonl",
      purpose = "fine-tune-train"
    )

    val fineTunesData: FineTunesData = FineTunesData(
      id = "ft-AF1WoRqd3aJAHsqc9NY7iL8F",
      `object` = "fine-tune",
      model = Some("curie"),
      createdAt = 1614807352,
      fineTunedModel = None,
      hyperparams = hyperparams,
      organizationId = "org-...",
      resultFiles = Seq(resultFile),
      status = "pending",
      validationFiles = Seq(validationFile),
      trainingFiles = Seq(trainingFile),
      updatedAt = 1614807352
    )

    val expectedResponse: FineTunesResponse = FineTunesResponse(`object` = "list", data = Seq(fineTunesData))


    val givenResponse: Either[Exception, FineTunesResponse] = SttpUpickleApiExtension.deserializeJsonSnake.apply(response)

    givenResponse.value shouldBe expectedResponse
  }

}
