def call(Map config) {
    pipeline {
        agent any
        stages {
            stage('Test Docker Availability') {
            steps {
                sh 'env'
                sh 'echo $PATH'
                sh 'which docker'
            }
        }
            stage('Checkout') {
                steps {
                    sh "pwd"
                    sh "ls -ltro"
                }
            }

            stage('Build') {
                steps {
                    script {
                        Build()
                    }
                }
            }

            stage('Test') {
                steps {
                    script {
                       Test()
                    }
                }
            }

            stage('Deploy to K8S') {
                steps {
                    script {
                         echo "Test"
                    }
                }
            }

            stage('ArgoCD Sync') {
                steps {
                    script {
                        echo "ArgoCD Sync"
                    }
                }
            }
        }
    }
}
