import React from 'react'

function LoginComponent() {
  return (
    <div>login Page 
        <div class="container">
    <h2 class="form-signin-heading">My custom login page</h2><table class="table table-striped">
    <tbody><tr><td><a href="/oauth2/authorization/github">GitHub</a></td></tr>
    <tr><td><a href="/oauth2/authorization/google">Google</a></td></tr>
    </tbody></table>
</div>
    </div>
  )
}

export default LoginComponent