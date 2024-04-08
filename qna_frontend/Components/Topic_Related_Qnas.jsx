import React, { useEffect, useState } from 'react'
import { listTopicQnas } from '../services/QnaServices'
import { useNavigate, useParams } from 'react-router-dom'
import './CssFiles/topic.css'
import 'bootstrap/dist/css/bootstrap.min.css';

import Button from 'react-bootstrap/Button';

function Topic_Related_Qnas() 
{
    const [topic_data,setTopic_data] = useState([])
    const {topic} = useParams()  
    const {id} = useParams()
    const [length,setLength] = useState(1)
    const [count,setCount] = useState(parseInt(id,10))
    const navigator = useNavigate()
    // console.log(topic)
    // console.log(id)
    

    useEffect(() => { 
 

        

        listTopicQnas(topic)
          .then((response) => {
  
            setTopic_data(response.data[count]);
            setLength(response.data.length)
            console.log("response data "+response.data)

          })
          .catch((error) => {
            console.log(error);
          });

      },[count]); // Empty dependency array ensures useEffect runs only once after component mounts


      useEffect(() => {
        console.log(count)
        var count_int = parseInt(count,10)
        navigator("/view/qnas/"+topic+"/"+count_int)
      },[count,navigator]); // Empty dependency array ensures useEffect runs only once after component mounts
    

    function incrementCount() 
    {
        setCount(prevCount => prevCount + 1);
    }


    function decrementCount()
    {
        setCount(prevCount => prevCount - 1);        
    }

  return (
    <div id="TopicQnas"> 
        
       <center id="qna_container">
        <br/><br/><br/>
       <div style={{width:"1000px"}}>
          <div id="question">
          <b id="topic_text"> ---  {topic_data.level}  ---</b> 

            <br/> <b>{topic_data.question}</b>  

        </div>
 
        <br/>
                <div id="answer"  >
            <br/>{topic_data.answer}<br/><br/>
        </div>
        <div className='hel' >
          { count>0 &&
            <button id="prev" onClick={decrementCount} class="btn btn-primary" >Previous</button>
          }
          {( (count==0)|| (count<length-1) )&&
            <button id="next" onClick={incrementCount} class="btn btn-primary" >Next</button>
          }
        </div>
        </div>
        </center>
    
    </div>
  )

}

export default Topic_Related_Qnas