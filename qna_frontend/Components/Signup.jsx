import React, { useState } from 'react'
import { createUser } from '../services/QnaServices';
import { useNavigate } from 'react-router-dom';

function Signup() {

    const [userName,setUserName ] =  useState("")
    const [email,setEmail] = useState("")
    const [password,setPassword] = useState("")
    
    const navigator = useNavigate();

    function saveUserDetails(event)
    {
        event.preventDefault();
        const userDetails = {userName,email,password}
        console.log(userDetails);
        createUser(userDetails).then((response)=>
        {
            console.log(response.data)
            navigator('/')
        }).catch((error)=>console.log(error))
    }


  return (
    <div>
        <center>
            <form>

            <input type="text" value={userName} onChange={(event)=>setUserName(event.target.value)} placeholder='UserName'></input><br />
            <input type="email" value={email} onChange={(event)=>setEmail(event.target.value)} placeholder='Email'></input><br />
            <input type="password" value={password} onChange={(event)=>setPassword(event.target.value)} placeholder='Password'></input><br />
            <br />
            <button onClick={saveUserDetails}>Save</button>

            </form>

        </center>
    </div>
  )
}

export default Signup