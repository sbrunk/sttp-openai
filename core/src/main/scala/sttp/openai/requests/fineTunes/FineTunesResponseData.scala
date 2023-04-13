package sttp.openai.requests.fineTunes

import sttp.openai.json.SnakePickle

object FineTunesResponseData {

  case class FineTunesData(
      id: String,
      `object`: String,
      model: String,
      created_at: Int,
      fine_tuned_model: String,
      hyperparams: Hyperparams,
      organization_id: String,
      result_files: Seq[File],
      status: String,
      validation_files: Seq[File],
      training_files: Seq[File],
      updated_at: Int
  )

  object FineTunesData {
    implicit def fineTunesDataRW: SnakePickle.ReadWriter[FineTunesData] = SnakePickle.macroRW[FineTunesData]
  }
  case class Hyperparams(
      batch_size: Int,
      learning_rate_multiplier: Double,
      n_epochs: Int,
      prompt_loss_weight: Double
  )

  object Hyperparams {}

  case class File(
      id: String,
      `object`: String,
      bytes: Int,
      created_at: Int,
      filename: String,
      purpose: String
  )

  case class FineTunesResponse(
      `object`: String,
      data: Seq[FineTunesData]
  )

}
