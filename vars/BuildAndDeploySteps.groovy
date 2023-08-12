def call(Map config) {
    pipeline {
        agent any
        stages {
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
