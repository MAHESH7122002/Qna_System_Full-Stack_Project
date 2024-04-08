import React, { useEffect } from 'react'

import { useNavigate } from 'react-router-dom'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function HeaderComponent() {
    const navigator = useNavigate();
    const authenticate = async () => {
      const response = await fetch(
         "http://localhost:8085" + '/api/v1/qnas',
         { method: 'GET', redirect: "follow",credentials:"include" }
     ).then((response) => response);
     console.log(response)
     if(response.redirected) {
         document.location = response.url;
     }
     // const data = await response.json();
  }
  useEffect(()=>{
    authenticate()
  },[])
  return (
    <div >
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand >QNA</Navbar.Brand>  
          <Nav className="me">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="/upload-file">Upload File</Nav.Link>
            <Nav.Link href="/view/qna/0">View</Nav.Link>            
            <Nav.Link href="/userDetails">User</Nav.Link>
          </Nav>
        </Container>
      </Navbar> 
    </div>
  )
}

export default HeaderComponent