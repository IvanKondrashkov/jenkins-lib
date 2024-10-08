import java.time.LocalDateTime

class ModuleUtils {

    def getModuleBuildDir(String branch) {
        def baseDir = "build/libs/*.jar"
        switch (branch) {
            case "homework-1": return "hw01-gradle/${baseDir}"
            case "homework-2": return "hw02-gradle/${baseDir}"
            case "homework-3": return "hw03-gradle/${baseDir}"
            case "homework-4": return "hw04-json-gradle/${baseDir}"
            case "homework-6": return "hw06-xlsx-gradle/${baseDir}"
            case "homework-8": return "hw08-dsl-gradle/${baseDir}"
            default: return baseDir
        }
    }

    def getModuleName(String branch) {
        def baseName = "groovy-2024-08"
        switch (branch) {
            case "homework-1": return "hw01-gradle"
            case "homework-2": return "hw02-gradle"
            case "homework-3": return "hw03-gradle"
            case "homework-4": return "hw04-json-gradle"
            case "homework-6": return "hw06-xlsx-gradle"
            case "homework-8": return "hw08-dsl-gradle"
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