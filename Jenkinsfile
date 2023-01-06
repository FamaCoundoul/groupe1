pipeline{
    agent any
    tools{
        maven '3.8.7'
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