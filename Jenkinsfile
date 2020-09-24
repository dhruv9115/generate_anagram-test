template{
  node{
    stage("Clone Repo"){
        Git.clone_test_repo()
    }
    stage("Run Test"){
        Maven.runTest()
    }
  }
}