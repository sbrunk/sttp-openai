package sttp.openai.requests.fineTunes

import sttp.openai.json.SnakePickle

object FineTunesResponseData {

  case class FineTunesData(
      id: String,
      `object`: String,
      model: Option[String],
      createdAt: Int,
      fineTunedModel: Option[String],
      hyperparams: Hyperparams,
      organizationId: String,
      resultFiles: Seq[File],
      status: String,
      validationFiles: Seq[File],
      trainingFiles: Seq[File],
      updatedAt: Int
  )

  object FineTunesData {
    implicit def fineTunesDataRW: SnakePickle.ReadWriter[FineTunesData] = SnakePickle.macroRW[FineTunesData]
  }
  case class Hyperparams(
      batchSize: Int,
      learningRateMultiplier: Double,
      nEpochs: Int,
      promptLossWeight: Double
  )

  object Hyperparams {
    implicit def hyperparamsRW: SnakePickle.ReadWriter[Hyperparams] = SnakePickle.macroRW[Hyperparams]
  }

  case class File(
      id: String,
      `object`: String,
      bytes: Int,
      createdAt: Int,
      filename: String,
      purpose: String
  )

  object File {
    implicit def fileRW: SnakePickle.ReadWriter[File] = SnakePickle.macroRW[File]
  }

  case class FineTunesResponse(
      `object`: String,
      data: Seq[FineTunesData]
  )

  object FineTunesResponse {
    implicit def fineTunesResponse: SnakePickle.ReadWriter[FineTunesResponse] = SnakePickle.macroRW[FineTunesResponse]
  }

}
