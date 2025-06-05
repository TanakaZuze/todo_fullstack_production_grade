import axios from "axios"

const ADD_TASK_URL='http://localhost:8080/create-task'

export const addToDo = (task) =>{
    return axios.post(ADD_TASK_URL,task);
}