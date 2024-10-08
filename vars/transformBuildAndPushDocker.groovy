def call(String branch) {
    def moduleUtils = library('jenkins-lib').ModuleUtils.new()
    def module = moduleUtils.getModuleName(branch)
    return  {
        withCredentials([usernamePassword(
                credentialsId: 'docker-hub',
                usernameVariable: 'DOCKER_HUB_USERNAME_TOKEN',
                passwordVariable: 'DOCKER_HUB_PASSWORD_TOKEN'
        )]) {
            sh 'docker login -u $DOCKER_HUB_USERNAME_TOKEN -p $DOCKER_HUB_PASSWORD_TOKEN'
            def image = docker.build("ivan92k/${module}:${env.BUILD_ID}", "-f ${module}/Dockerfile .")
            image.push()
        }
    }
}