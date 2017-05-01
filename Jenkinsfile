pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package -U -P build-executable-jar -DskipTests=true'
      }
    }
    stage('Docker') {
      steps {
        sh 'mvn docker:build docker:push'
      }
    }
    stage('Deploy') {
      steps {
        sh 'redeploy-docker-image market-data-lookup -p 8383:9090'
      }
    }
    stage('Archive Artefacts') {
      steps {
        archiveArtifacts(artifacts: 'target/*.jar')
      }
    }
  }
  tools {
    maven 'Maven 3.3'
    jdk 'JDK 1.8'
  }
}
