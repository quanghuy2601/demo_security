pipeline {

    agent any

    parameters {
        choice(name: 'ACTION', choices: ['Build', 'Remove all'], description: 'Pick something')
    }
    stages {
        stage('Building/Deploying') {
            when{
                environment name: 'ACTION', value: 'Build'
            }
            steps {
                withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                    sh 'docker compose up --build'
                    sh 'docker compose push'
                }
            }
        }
        
    }
    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}