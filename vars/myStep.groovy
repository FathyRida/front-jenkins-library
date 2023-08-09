package front.llc.jenkins

def call() {
	def config = readFileFromResources('Resource.txt')
	
	echo "Building with ${config.BUILD_TOOL}"
	echo "Debug mode: ${config.DEBUG_MODE}"
	echo "Environment: ${config.ENVIRONMENT}"
}

def readFileFromResources(String filename) {
	def resourceStream = this.class.classLoader.getResourceAsStream("front/llc/jenkins/resources/${filename}")
	def configFile = new File("${JENKINS_HOME}/mySharedLibraryResources/${filename}")
	configFile.withOutputStream { output ->
		resourceStream.eachByte(4096) { buffer, len ->
			output.write(buffer, 0, len)
		}
	}
	def configText = configFile.text
	def configMap = [:]
	configText.readLines().each { line ->
		def parts = line.split('=')
		if (parts.size() == 2) {
			configMap[parts[0].trim()] = parts[1].trim()
		}
	}
	return configMap
}