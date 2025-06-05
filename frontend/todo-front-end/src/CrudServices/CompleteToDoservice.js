import axios from 'axios';

const COMPLETE_TODO_URL = 'http://localhost:8080/is-complete';

export const toggleComplete = (id) => {
    return axios.patch(`${COMPLETE_TODO_URL}/${id}`);
}
