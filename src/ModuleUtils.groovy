import java.time.LocalDateTime

class ModuleUtils {

    def getModuleBuildDir(branch) {
        def baseDir = "build/libs/*.jar"
        switch (branch) {
            case "homework-1": return "hw01-gradle/${baseDir}"
            case "homework-2": return "hw02-gradle/${baseDir}"
            case "homework-3": return "hw03-gradle/${baseDir}"
            case "homework-4": return "hw04-json-gradle/${baseDir}"
            case "homework-6": return "hw06-xlsx-gradle/${baseDir}"
            case "homework-8": return "hw08-dsl-gradle/${baseDir}"
        }
    }

    def getModuleName(branch) {
        switch (branch) {
            case "homework-1": return "hw01-gradle"
            case "homework-2": return "hw02-gradle"
            case "homework-3": return "hw03-gradle"
            case "homework-4": return "hw04-json-gradle"
            case "homework-6": return "hw06-xlsx-gradle"
            case "homework-8": return "hw08-dsl-gradle"
        }
    }

    def printSysTime(branch) {
        return {
            echo "${LocalDateTime.now()} | Build branch ${branch}}"
        }
    }

   def countFilesModule(branch) {
        return dir("${getModuleName(branch)}/") {
            def files = findFiles(glob: '**')
            echo "Files module - ${files[0].length}"
        }
    }
}