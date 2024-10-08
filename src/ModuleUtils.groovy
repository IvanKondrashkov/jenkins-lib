import java.time.LocalDateTime

class ModuleUtils {

    def getModuleBuildDir(String branch) {
        def baseDir = "build/libs/*-all.jar"
        switch (branch) {
            case "project": return "hw09-back/${baseDir}"
            default: return baseDir
        }
    }

    def getModuleName(String branch) {
        def baseName = "groovy-2024-08"
        switch (branch) {
            case "project": return "hw09-back"
            default: return baseName
        }
    }

    def printSysTime(String branch) {
        return "${LocalDateTime.now()} | Build branch ${branch}"
    }

    def isRootProject(String module) {
        return module == 'groovy-2024-08'
    }
}