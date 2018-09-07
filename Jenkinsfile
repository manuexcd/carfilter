#!groovy

node {
	environment {
		DOCKER_HOST='tcp://127.0.0.1:4243'
	}

	stage 'Docker image'
	sh 'mvn clean package docker:build'
	
	stage 'Docker tag'
	sh 'docker tag carfilter manuexcd/carfilter'
	
	stage 'Docker push'
	withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
		sh 'docker login -u $USER -p $PASS'
	}
	sh 'docker push manuexcd/carfilter'
	sh 'docker rmi carfilter:latest manuexcd/carfilter:latest'
}