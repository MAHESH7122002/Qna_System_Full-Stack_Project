import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useParams } from 'react-router-dom';
import { listQnas, listTopics } from '../services/QnaServices';
import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import './CssFiles/Viewcss.css';


function View() 
{
    const [count,setCount]=useState(1)
    const [data,setData] = useState([])
    const [topics,setTopics] = useState([])
    const navigator = useNavigate()

    

    useEffect(() => {

      listTopics()
        .then((response) => {
          console.log(response)
          setTopics(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
  
      listQnas(count)
        .then((response) => {
          setData(response.data);
        })
        .catch((error) => {
          console.log(error.response.data);
        });
    }, []); // Empty dependency array ensures useEffect runs only once after component mounts
  
 
    function incrementCount()
    {
        setCount(prevcount => prevcount+1)
        navigator("/qna/"+count)
    }

    function TopicQnas()
    {
      var x = document.getElementById('topic_select').value
      navigator("/view/qnas/"+x+"/"+0)
    }





  return (
    <div className='view'>
      <center> 
      <div id='x'>
          <div >
              <img id="img_topic" src='https://t3.ftcdn.net/jpg/05/58/64/00/360_F_558640063_sicQxUAwqIIR0Uh4f44RS4CCDQ7jvZt5.jpg'/>
          </div>
          <div id="allQnas_div"> 
              <p style={{textAlign:"center"}}> "Browse through all questions and answers available in our database. Gain insights, learn new topics, and discover valuable information contributed by our community.</p><br/>
              <Button id="QnasBtn" variant='success' onClick={incrementCount}>Explore</Button><br/><br/>
          </div> 
      </div>

 


      <div id='x'>
              <select id='topic_select'  >
                <option value="">Select Topic</option>
                {topics.map((topic,index)=><option key={index}>{topic}</option>)
                }
              </select> 

              <div id="allQnas_div"> 
                  <p style={{textAlign:"center"}}> Explore curated questions and answers by selecting your preferred topic from the dropdown menu. Gain valuable insights tailored to your interests and needs. Start discovering now!</p>
                  <br/>
                  <Button  onClick={TopicQnas} variant="success" id="topicBtn">Explore</Button>
              </div>

              <div >
                  <img id="img_topic" src='https://qph.cf2.quoracdn.net/main-qimg-f57201583d2f3ef4499a5b374de20388-lq'/>
              </div> 
      </div>
 </center>
</div>
  )
}

export default View