import axios from "axios";

const GET_BY_ID = 'http://localhost:8080/get-task-by-id';

export const getById = (id) => {
  return axios.get(`${GET_BY_ID}/${id}`);
};
