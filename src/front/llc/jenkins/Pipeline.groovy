package front.llc.jenkins

def call(Map config) {
	pipeline {
		agent any

		stages {
			stage('Checkout') {
				steps {
					echo "just a step"
				}
			}
			
			stage('Build') {
				steps {
					script {
						myStep.build()
					}
				}
			}
		}
	}
}