pipeline{
    agent any

    tools{
        maven '3.8.7'
    }
    environment{
       dockerimagename="projetsir2022/groupe1"
       dockerImage=""
    }

    stages{
       stage('Source'){
            steps{
                git branch: 'main', url: 'https://github.com/FamaCoundoul/groupe1.git'
            }
         }
         /* stage('Maven install') {
                     steps {
                         sh 'mvn install'
                     }
         }*/

        /* stage('Test') {
            steps {
                sh 'mvn test'
            }
         }*/
        /*stage('Build'){
            steps{
               sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
        }*/

        stage('Build docker image'){

            steps{
                script{
                 dockerImage=docker.build dockerimagename
                }
            }
        }/*
        stage('login to dockerhub'){
                    steps{
                        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login DOCKERHUB_CREDENTIALS_USR --password-stdin'

                        //sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
                    }
        }
       stage('Publish') {
           steps {
               withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'projetsir2022', passwordVariable: 'ProjetSir2022')]) {

                   sh 'docker push projetsir2022/projetsir2022:groupe1'
               }
           }
       }

       stage('SonarQube analysis') {

            steps{
                    sh 'mvn clean sonar:sonar'

            }
       }
       stage('Deploy') {
           steps {
                script{
                 sh 'kubectl apply -f deployment.yaml'
                }

           }
       }*/



    }

}