// Requires https://plugins.jenkins.io/mask-passwords to run

/**
 * Runs code with secret environment variables and hides the values.
 *
 * @param varAndPasswordList - A list of Maps with a 'var' and 'password' key.  Example: `[[var: 'TOKEN', password: 'sekret']]`
 * @param Closure - The code to run in
 * @return {void}
 */
def withSecretEnv(List<Map> varAndPasswordList, Closure closure) {
  wrap([$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: varAndPasswordList]) {
    withEnv(varAndPasswordList.collect { "${it.var}=${it.password}" }) {
      closure()
    }
  }
}