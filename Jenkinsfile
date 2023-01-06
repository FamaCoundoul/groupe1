pipeline{
    agent any
    tools{
        maven 'maven-3.8.6'
    }
    stages{
        stage('Source'){
            steps{
                git branch: 'main', url: 'https://github.com/FamaCoundoul/groupe1.git'
            }
        }
        stage('Build'){
            steps{
                sh 'mvn clean package'
            }
        }
    }
}