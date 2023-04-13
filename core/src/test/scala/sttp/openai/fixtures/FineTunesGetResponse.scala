package sttp.openai.fixtures

object FineTunesGetResponse {
  val responseJson: String =
    """{
      |   "object":"list",
      |   "data":[
      |      {
      |         "id":"ft-AF1WoRqd3aJAHsqc9NY7iL8F",
      |         "object":"fine-tune",
      |         "model":"curie",
      |         "created_at":1614807352,
      |         "fine_tuned_model":null,
      |         "hyperparams":{
      |            "batch_size":4,
      |            "learning_rate_multiplier":0.1,
      |            "n_epochs":4,
      |            "prompt_loss_weight":0.1
      |         },
      |         "organization_id":"org-...",
      |         "result_files":[
      |              {
      |               "id":"file-QQm6ZpqdNwAaVC3aSz5sWwLT",
      |               "object":"file",
      |               "bytes":81509,
      |               "created_at":1614807863,
      |               "filename":"compiled_results.csv",
      |               "purpose":"fine-tune-results"
      |            }
      |         ],
      |         "status":"pending",
      |         "validation_files":[
      |           {
      |            "id": "file-id",
      |            "object": "file",
      |            "bytes": 1547276,
      |            "created_at": 1610062281,
      |            "filename": "file-name",
      |            "purpose": "fine-tune-validation"
      |          }
      |         ],
      |         "training_files":[
      |            {
      |               "id":"file-XGinujblHPwGLSztz8cPS8XY",
      |               "object":"file",
      |               "bytes":1547276,
      |               "created_at":1610062281,
      |               "filename":"my-data-train.jsonl",
      |               "purpose":"fine-tune-train"
      |            }
      |         ],
      |         "updated_at":1614807352
      |      }
      |   ]
      |}
      |""".stripMargin
}
