pipeline{
    agent any
    tools{
        maven 'maven-3.8.7'
    }
    stages{
        stage('Source'){
            steps{
                git branch: 'main', url: 'https://github.com/FamaCoundoul/groupe1.git'
            }
        }
        stage('Build'){

            steps{
                sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
        }
        stage("SonarQube analysis") {
            agent any
                steps {
                    withSonarQubeEnv('My SonarQube Server') {
                        sh 'mvn clean package sonar:sonar'
                    }
                }
       }
    }
}