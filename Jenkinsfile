node {
    stage("checkout"){
		 git url: 'https://github.com/Bibek-Sutradhar/user-mgmt-service.git',branch: 'master' 
	}
	stage("build"){
		bat "mvn clean install"
	}
	
}