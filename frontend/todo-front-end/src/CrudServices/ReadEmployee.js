import axios from "axios";

const READ_EMPLOYEE_URL='http://localhost:8080/get-all-tasks';

export const listOfTodos = () =>{
    return axios.get(READ_EMPLOYEE_URL);
}