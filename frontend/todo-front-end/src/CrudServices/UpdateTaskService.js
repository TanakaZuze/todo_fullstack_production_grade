import axios from "axios";

const UPDATE_TODO_URL = 'http://localhost:8080/update-task';

export const updateTodo = (id, todo) => {
    return axios.put(`${UPDATE_TODO_URL}/${id}`, todo);
}
