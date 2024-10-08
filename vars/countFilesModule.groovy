def call(String branch) {
    def moduleUtils = library('jenkins-lib').ModuleUtils.new()
    return moduleUtils.countFilesModule(branch)
}