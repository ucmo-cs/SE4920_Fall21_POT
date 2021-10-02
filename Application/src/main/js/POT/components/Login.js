import { Component } from "react";
class Login extends Component{
    render(){
        return(
            <div className="login">

                <div className="login-email">
                    <label title="Email" className="login-email-label">Email: </label>
                    <input type="email" className="login-email-input" title="Email"></input>
                </div>
                <div className="login-pass">
                    <label title="Password" className="login-pass-label">Password: </label>
                    <input type="password" className="login-pass-input" title="Password"></input>
                </div>
                <button type="submit" onClick={this.props.loginFunction}>Submit</button>
            </div>
        )
    }
}

export default Login;