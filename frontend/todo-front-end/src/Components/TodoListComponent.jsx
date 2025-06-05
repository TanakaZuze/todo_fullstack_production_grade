import React, { useEffect, useState } from 'react'
import { listOfTodos } from '../CrudServices/ReadEmployee'
import { useNavigate } from 'react-router-dom';
import { deleteTodo } from '../CrudServices/DeleteTaskService';
import { toggleComplete } from '../CrudServices/CompleteToDoservice';

function TodoListComponent() {
    const navigate = useNavigate();
    const [todo, setTodo] = useState([]);

    useEffect(() => {
        listOfTodos()
            .then((response) => {
                setTodo(response.data);
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);


    // deleting todo
    const handleDelete = (id) => {
        deleteTodo(id)
            .then((response) => {
                console.log(response.data);

                // Remove the deleted employee from state
                setTodo((prevEmployees) => prevEmployees.filter(emp => emp.id !== id));
            })
            .catch(err => console.error(err));

    }

    // check if task is complete or nay
    const handleToggleComplete = (id) => {
        toggleComplete(id)
            .then(() => {
                setTodo(prev =>
                    prev.map(t => t.id === id ? { ...t, todoComplete: !t.todoComplete } : t)
                );
            })
            .catch(err => console.error("Toggle failed:", err));
    }


    return (
        <div className='container mt-4'>
            <h2 className='text-center'>Todo List</h2>
            <button className='btn btn-primary mb-3' onClick={() => navigate('/add-todo')}>Add Todo</button>

            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Todo Title</th>
                        <th>Todo Description</th>
                        <th>Todo Completed</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        todo.map(t =>
                            <tr key={t.id}>
                                <td>{t.id}</td>
                                <td>{t.todoTitle}</td>
                                <td>{t.todoDescription}</td>
                                <td>{t.todoComplete ? "Yes" : "No"}</td>
                                <td>
                                    <button className='btn btn-primary' onClick={() => navigate(`/update-todo/${t.id}`)}>Update</button>
                                    <button className='btn btn-danger mx-2' onClick={() => handleDelete(t.id)}>Delete</button>
                                    <button
                                        className={`btn ${t.todoComplete ? 'btn-info' : 'btn-success'} me-2`}
                                        onClick={() => handleToggleComplete(t.id)}
                                    >
                                        {t.todoComplete ? 'Mark Incomplete' : 'Mark Complete'}
                                    </button>

                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default TodoListComponent
