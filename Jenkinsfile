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
                sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
         }
       stage('SonarQube analysis') {

            steps{
                withSonarQubeEnv(installationName: 'sql'){
                    sh 'mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.8.0.2131:sonar'
                }

            }
       }


    }
}