import axios from "axios";

const DELETE_TODO_URL = 'http://localhost:8080/delete-tasks';

export const deleteTodo = (id) => {
    return axios.delete(`${DELETE_TODO_URL}/${id}`);
}
