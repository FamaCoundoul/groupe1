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
         /*stage('Test') {
            steps {
                sh 'mvn test'
            }
         }*/
        stage('Build'){
            steps{
                sh 'docker build -t formation-demo-groupe1:latest'

                //sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
         }
       stage('Publish') {
           steps {
               //withCredentials([usernamePassword(credentialsId: 'docker_hub_credentials', usernameVariable: 'projetsir2022', passwordVariable: 'ProjetSir2022')]) {
                   sh "docker login -u projetsir2022 -p ProjetSir2022"
                   sh 'docker push formation-demo-groupe1:latest'
               //}
           }
       }
      /*  stage('SonarQube analysis') {

            steps{
                    sh 'mvn clean sonar:sonar'

            }
       } */
       /* stage('Deploy') {
           steps {
               sh 'kubectl apply -f deployment.yaml'
           }
       } */



    }
}