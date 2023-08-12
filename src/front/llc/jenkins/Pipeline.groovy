def RunFrontAppPipeline(Map config) {
	stage('Unit-Test') {
		myStep()
	}
	
	stage('Build') {
		 echo "deply stage"
	}
	stage('Deploy') {
		 echo "deply stage"
	}
}
