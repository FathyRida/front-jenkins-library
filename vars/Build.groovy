def call() {
  print "${env.BUILD_NUMBER}"
  def dockerImage = docker.build("frontEndImg:${env.BUILD_NUMBER}")
  dockerImage.push()
}
