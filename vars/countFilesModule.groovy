def call(String branch) {
    def moduleUtils = library('jenkins-lib').ModuleUtils.new()
    def module = moduleUtils.getModuleName(branch)
    def isRootProject = moduleUtils.isRootProject(module)
    def countDir = isRootProject ? '' : "${module}/"
    return {
        node {
            dir(countDir) {
                def files = findFiles(glob: '**')
                sh "echo Files module - ${files[0].length}"
            }
        }
    }
}