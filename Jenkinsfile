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
            sh "mvn sonar:sonar"
       }
//    def scannerHome = tool 'SonarScanner 4.0';
           // steps{
            //withSonarQubeEnv('sonarqube-9.8') {
            // If you have configured more than one global server connection, you can specify its name
    //      sh "${scannerHome}/bin/sonar-scanner"
            //sh "mvn sonar:sonar"
          //}
           // }
        //}

    }
}