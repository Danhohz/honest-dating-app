pipeline {
    agent any  // Запускать на любом доступном агенте

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
    }
}