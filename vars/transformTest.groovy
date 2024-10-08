def call(String baseUrl, String branch) {
    def moduleUtils = library('jenkins-lib').ModuleUtils.new()
    def module = moduleUtils.getModuleName(branch)
    return  {
        node  {
            git branch: branch, url: baseUrl
            moduleUtils.printSysTime(branch)
            withGradle {
                sh 'chmod +x gradlew'
                sh "./gradlew ${module}:clean ${module}:test"
                sleep 10
            }
        }
    }
}