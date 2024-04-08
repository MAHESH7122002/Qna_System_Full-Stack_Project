import axios from "axios";

const QNA_API_BASE_URL = "http://localhost:8085/api/v1"

export const createUser = (user) => axios.post(QNA_API_BASE_URL+"/register",user,{
    withCredentials:true
});



export const createQna = (qna) => axios.post(QNA_API_BASE_URL+"/qna",qna,{
    withCredentials:true
});

export const listQnas = (qna_id) =>
{
    return axios.get(QNA_API_BASE_URL+"/"+qna_id,{
        withCredentials:true
    })
}
export const listTopics = () =>
{
    return axios.get(QNA_API_BASE_URL+"/qna/topics",{
        withCredentials:true
    })
}

export const listTopicQnas = (topic_name) =>
{
    return axios.get(QNA_API_BASE_URL+"/qnas/topic/"+topic_name,{
        withCredentials:true
    })
}

export const getuserDetails =()=>
{
    return axios.get(QNA_API_BASE_URL+"/user/details",{
        withCredentials:true
    });
}