def call(String baseUrl, String branch) {
    def moduleUtils = library('jenkins-lib').ModuleUtils.new()
    def module = moduleUtils.getModuleName(branch)
    def isRootProject = moduleUtils.isRootProject(module)
    return  {
        node  {
            git branch: branch, url: baseUrl
            echo moduleUtils.printSysTime(branch)
            withGradle {
                sh 'chmod +x gradlew'
                if (isRootProject) {
                    sh "./gradlew clean test"
                } else {
                    sh "./gradlew ${module}:clean ${module}:test"
                }
                sleep 10
            }
        }
    }
}