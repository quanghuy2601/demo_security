pipeline {
    agent any

    environment {
        // Define environment variables here if needed
        DOCKER_COMPOSE_VERSION = 'docker-compose'
    }

    stages {
        stage("Verify tolling") {
            steps {
                sh '''
                    docker version
                    docker info
                    docker compose version
                '''
            }
        }
        stage("Prune docker data") {
            steps {
                sh 'docker system prune -a --volumes -f'
            }

        }
        stage("Start container") {
            steps {
                sh 'docker compose up -d'
                sh 'docker compose ps'
            }
        }
    }

    post {
        always {
            sh 'docker compose down --remove-orphans -v'
            sh 'docker compose ps'
        }
    }
}
