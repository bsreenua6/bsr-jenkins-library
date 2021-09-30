package com.bsrtech.devops


/*********************************************************************************
* FunctionName: constructGitUrl
* Parameters: Its take project code and repo name to construct Git url
*  - projectCode : GitHub projectcode: ex:bsreenua6
*  - repoName    : GitHUb repo name: ex: CounterWebapp   
* Usage:
* constructGitUrl("bsreenua6","CounterWebapp")
* return git url ex: ssh://git@github.com:bsreenua6/CounterWebapp.git  

**********************************************************************************/

String constructGitUrl(String projectCode, String repoName){
	def prefixUrl = constants.GITHUB_CLONE_PREFIX_URL
	return prefixUrl + ":" + projectCode.toLowerCase().trim() + "/" + repoName.toLowerCase().trim() + ".git"
}