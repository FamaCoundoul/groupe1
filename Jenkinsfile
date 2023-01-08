pipeline{
    agent {label "docker-build-node"}
    tools{
        maven '3.8.7'
    }
    environment{
        DOCKERHUB_CREDENTIALS= credentials('docker-hub-jenkins')
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
                sh 'docker build -t projetsir2022/groupe1:$BUILD_NUMBER .'

                //sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
        }
        stage('login to dockerhub'){
                    steps{
                        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login DOCKERHUB_CREDENTIALS_USR --password-stdin'

                        //sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
                    }
        }
      /* stage('Publish') {
           steps {

                        sh 'docker push projetsir2022/groupe1:$BUILD_NUMBER '

               //withCredentials([usernamePassword(credentialsId: 'docker_hub_credentials', usernameVariable: 'projetsir2022', passwordVariable: 'ProjetSir2022')]) {
                   //sh "docker login -u projetsir2022 -p ProjetSir2022"
                   //sh 'docker push formation-demo-groupe1:latest'
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