import React, { useEffect, useState } from 'react'
import { getuserDetails } from '../services/QnaServices'
import './CssFiles/userDetailsCss.css'

function UserDetails() 
{
    const [userDetails,setUserDetails]= useState([])
    useEffect(()=>{


        getuserDetails().then((response)=>{
            console.log(response.data)
            setUserDetails(response.data)
        }).catch((error)=>{
            console.log(error) 
        })

    },[])
  return (
    
    <div id='useDetails'>
        <br/><br/><br/><br/>
        <center>
         

        <div id='card'>
          <div >
          <img class="profile" src='https://t4.ftcdn.net/jpg/00/97/00/09/360_F_97000908_wwH2goIihwrMoeV9QF3BW6HtpsVFaNVM.jpg'/> 
          </div>
          <div id="details"> 
         <b> UserName:</b><p> {userDetails.userName}</p> 
         <b>Email Id:</b><p> {userDetails.email}</p> 
         <b>Role:</b> <p> {userDetails.role }</p>
         </div>
      </div>

        </center>
    </div>
  )
}

export default UserDetails