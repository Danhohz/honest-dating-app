pipeline {
    agent any  // Запускать на любом доступном агенте

    // Триггеры (опционально)123123
//     triggers {
//         githubPush()  // Автозапуск при пуше в GitHub
//     }

    // Переменные окружения
//     environment {
//         DOCKER_HUB_CREDENTIALS = credentials('docker-hub-creds')  // Пример для Docker Hub
//         GITHUB_TOKEN = credentials('github-token')  // Токен для работы с GitHub API
//     }

    stages {
        // Шаг 1: Забрать код из GitHub
        stage('Checkout') {
            steps {
                checkout scm  // Автоматически использует URL из SCM
            }
        }

        // Шаг 2: Сборка проекта (пример для Java/Gradle)
        stage('Build') {
            steps {
                sh './gradlew --info clean build'
                // Для Maven: sh 'mvn clean package'
            }
        }

        // Шаг 3: Запуск тестов
        stage('Test') {
            steps {
                sh './gradlew --info test'
                junit '**/build/test-results/test/*.xml'  // Публикация результатов
            }
        }

        // Шаг 4: Сборка Docker-образа (пример)
//         stage('Docker Build') {
//             steps {
//                 script {
//                     docker.build("my-app:${env.BUILD_ID}")
//                 }
//             }
//         }

        // Шаг 5: Деплой (пример для Kubernetes)
//         stage('Deploy to Kubernetes') {
//             steps {
//                 sh 'kubectl apply -f k8s/deployment.yaml'
//             }
//         }
    }
}