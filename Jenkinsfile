pipeline {
    agent any

    environment {
        // Define environment variables here if needed
        DOCKER_COMPOSE_VERSION = 'docker-compose'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from your repository
                checkout scm
            }
        }

        stage('Build Docker Images') {
            steps {
                // Build the images using docker-compose
                sh 'docker-compose build'
            }
        }

        stage('Deploy Containers') {
            steps {
                // Deploy the containers using docker-compose
                sh 'docker-compose up -d'
            }
        }

        stage('Post-Deploy') {
            steps {
                // Any post-deployment steps like clearing cache, database migrations, etc.
                sh 'docker-compose ps' // Check if containers are running
            }
        }
    }

    post {
        always {
            // Clean up unused resources after the build
            sh 'docker system prune -f'
        }

        success {
            echo 'Deployment successful!'
        }

        failure {
            echo 'Deployment failed.'
        }
    }
}
