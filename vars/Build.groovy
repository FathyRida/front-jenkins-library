def call() {
    steps {
       script {
        def dockerImage = docker.build("frontEndImg:${env.BUILD_NUMBER}")
            dockerImage.push()
    }
   }
}
