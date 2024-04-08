import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { listQnas } from '../services/QnaServices';
import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import './CssFiles/NextPrevCss.css';

function NextPrev() {
    const { id } = useParams();
    
    const parsedId = parseInt(id, 10);

    const [count, setCount] = useState(parsedId);
    const [data, setData] = useState([])
    const navigator = useNavigate(); 

    useEffect(() => {

        listQnas(count)
          .then((response) => {
            setData(response.data);
            console.log(response.data)
            // setLength(response.data.length)
            navigator("/qna/" + count);

          })
          .catch((error) => {
            console.log(error.response.data);
          });
          navigator("/qna/" + count);

      },[count,navigator]); // Empty dependency array ensures useEffect runs only once after component mounts
    

    function incrementCount() {
        setCount(prevCount => prevCount + 1);
    }

    
    function decrementCount()
    {
        setCount(prevCount => prevCount - 1);        
    }



    return (

      <> 
        <div id="AllQnas" > 
        <center id="qna_container">      
        <div style={{width:"1000px"}}>
          <br/><br/><br/>
          <div id="question"> 
            <b id="topic_text">---  {data.level}  ---</b><br/>
             <b>{data.question}</b><br/>
             <b id="topic_text"> ---  {data.topic}  ---</b><br/>
          </div>
          <br/> 
          <div id="answer"  >
                  <br/>{data.answer}
                  
          </div>
          
              <div className='hel'>
                { count>=2 &&
                  <Button onClick={decrementCount} variant='primary' id="prev">Previous</Button>
                }
                { 
                  <Button onClick={incrementCount} variant='primary' id="next">Next</Button>
                }
              </div>
        </div>
            
      </center> 
        </ div>
        </>
    
      )
}
    

export default NextPrev;
