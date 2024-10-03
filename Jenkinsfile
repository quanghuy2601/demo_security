pipeline {
    agent any

    environment {
        // Define environment variables here if needed
        DOCKER_COMPOSE_VERSION = 'docker-compose'
    }

    stages {
        stage("Verify tolling") {
            steps {
                sh 'docker --version'
                sh 'docker info'
            }
        }
        stage("Prune docker data") {
            steps {
                sh 'docker system prune -a --volumes -f'
            }

        }
        stage("Start container") {
            steps {
                sh 'docker compose up --build'
            }
        }
    }

    post {
        always {
            sh 'docker compose down -v'
        }
    }
}
